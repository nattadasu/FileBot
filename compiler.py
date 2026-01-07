#!/usr/bin/env python3

import argparse as ap
import json
from pathlib import Path
from random import choice
from typing import Union

from regex import DOTALL, MULTILINE, findall, match, sub


def parse_args():
    """
    Parse command line arguments

    Returns:
        argparse.Namespace: Parsed arguments
    """
    parser = ap.ArgumentParser(
        description='Groovy Script "Compiler" for FileBot File Format'
    )
    parser.add_argument("input", type=str, help="Input Groovy Script")
    parser.add_argument("output", type=str, help="Output FileBot File")
    parser.add_argument(
        "--forget",
        action="store_true",
        help="Do not use or save keyword mapping from .compiler.keywords.json",
    )
    return parser.parse_args()


def remove_comments(text: str) -> str:
    """
    Remove comment contents from output file

    Args:
        text (str): Text to sanitize

    Returns:
        str: Sanitized text
    """
    lines = text.splitlines()
    # remove inline comments with regex, UNLESS IT'S PART OF URL
    lines = [sub(r"(?: +)?(?<!http:|https:)//.*", "", line) for line in lines]
    # Remove block comments
    text = "\n".join(lines)
    text = sub(r"/\*.*?\*/", "", text, flags=DOTALL)
    # Remove empty curlied-comment
    text = sub(r"^\{\s*\}", "", text, flags=DOTALL | MULTILINE)
    return text


def append_semicolon(text: str) -> str:
    """
    Append semicolons at the end of statements.

    How it works:
        1. Split the text into lines
        2. Strip each line of leading and trailing whitespace
        3. Append a semicolon to each line, do not append if:
            - Line is empty
            - Line already ends with a semicolon
            - Line ends with a closing bracket
            - Line ends with a closing parenthesis
            - Line is an array or dictionary element
        4. Join the lines back together

    Args:
        text (str): Text to append

    Returns:
        str: Formatted text
    """
    lines = text.splitlines()
    lines = [line.strip() for line in lines]
    lines = [
        line + ";"
        if line
        and not line.endswith(";")
        and not line.startswith("[")
        and not line.startswith("{")
        and not line.endswith("(")
        else line
        for line in lines
    ]
    return "\n".join(lines)


def remove_blank_lines(text: str) -> str:
    """
    Remove multiple blank lines from the input text, ensuring only single blank lines remain.

    Args:
        text (str): Text to sanitize

    Returns:
        str: Sanitized text
    """
    # Remove lines that contain only whitespace
    lines = [line for line in text.splitlines() if line.strip() != ""]

    # Join lines and replace multiple newlines with a single newline
    text = "\n".join(lines)
    text = sub(r"\n{2,}", "\n", text)

    # Remove a leading newline if present
    text = text.lstrip("\n")

    return text


def resolve_imports(script_path: Union[str, Path]) -> str:
    """
    Resolve imports in Groovy script, by replacing string statement for import (@**.groovy)
    to script content

    Args:
        script_path (Union[str, Path]): Path to Groovy script

    Returns:
        str: Script with resolved imports
    """
    script_path = Path(script_path)
    with open(script_path, "r", encoding="utf8") as f:
        script = f.read()
    sli = script.splitlines(keepends=True)

    for i, line in enumerate(sli):
        if match(r"^@(.*\.groovy)", line):
            import_path = Path(script_path).parent / match(
                r"^@(.*\.groovy)", line
            ).group(1)
            print(f"    @ {script_path}:{i + 1} <- {import_path.absolute()}")
            sli[i] = resolve_imports(import_path)

    return "".join(sli)


def remove_leading_whitespace(text: str) -> str:
    """
    Remove leading whitespace from each line in the input text.

    Args:
        text (str): Text to sanitize

    Returns:
        str: Sanitized text
    """
    return sub(r"^\s+", "", text, flags=MULTILINE)


def array_stringify(text: str) -> str:
    """
    Convert multiline array into a single line of array, removing trailing commas.
    FIX: This function is not perfect, it can't process nested arrays.

    Args:
        text (str): Text to sanitize

    Returns:
        str: Sanitized text
    """
    # Step 1: Minify arrays by replacing newline characters inside brackets with spaces
    # This captures nested arrays and dictionary-like structures in Groovy
    text = sub(r"\[([^\[\]]*)\]", lambda m: m.group(0).replace("\n", ""), text)

    # Step 2: Remove trailing commas before closing brackets for cleaner output
    text = sub(r",\s*([\]\}])", r"\1", text)

    return text


def clean_characters(text: str) -> str:
    """
    Fix characters at weird places

    Args:
        text (str): Text to sanitize

    Returns:
        str: Sanitized text
    """
    # fmt: off
    replacements = [
        (r",\s*;", ","), (r"{\s*;", "{"), (r";\s*}", "}"), (r"};\n{", "}\n{"),
        (r";\s*$", ""), (r"\[\s*;", "["), (r";\s*\]", "]"), (r",\s+\)", ")"),
        (r",\s*\]", "]"), (r"(\s)*", "\\1"), (r"->;", "->"), (r"->", "-> "),
        (r"\r", ""), (r"\n", ""),
    ]
    # fmt: on

    for pattern, replacement in replacements:
        text = sub(pattern, replacement, text)

    return text


def load_keyword_mapping(json_path: Path) -> dict[str, str]:
    """
    Load keyword mapping from JSON file

    Args:
        json_path (Path): Path to JSON file

    Returns:
        dict[str, str]: Keyword mapping
    """
    if json_path.exists():
        with open(json_path, "r", encoding="utf8") as f:
            return json.load(f)
    return {}


def save_keyword_mapping(json_path: Path, mapping: dict[str, str]) -> None:
    """
    Save keyword mapping to JSON file

    Args:
        json_path (Path): Path to JSON file
        mapping (dict[str, str]): Keyword mapping to save
    """
    with open(json_path, "w", encoding="utf8") as f:
        json.dump(mapping, f, ensure_ascii=False)


def obfuscate_variables(text: str, use_json: bool = True) -> str:
    """
    Obfuscate variables in the input text, replacing them with 1-3 character strings.

    Args:
        text (str): Text to sanitize
        use_json (bool): Whether to use external keyword mapping file

    Returns:
        str: Sanitized text
    """
    json_path = Path(".compiler.keywords.json")

    if use_json:
        variables = load_keyword_mapping(json_path)
    else:
        variables = {}

    # Find all variables in the text, excluding function definitions
    # fmt: off
    banned = [
        "abr", "abstract", "ac", "acf", "aco", "af", "age", "all", "any", "ar",
        "as", "az", "break", "case", "cf", "ci", "class", "continue", "ct",
        "curl", "cy", "d", "db", "dc", "def", "di", "dt", "e", "else",
        "encoding", "episode", "es", "ext", "f", "false", "final", "fn", "for",
        "fps", "hd", "hdr", "hpi", "id", "if", "import", "instanceof", "it",
        "khz", "metadata", "n", "native", "new", "none", "none", "null", "ny",
        "package", "pc", "pi", "private", "protected", "public", "return", "s",
        "sc", "scheme", "season", "source", "standalone", "static", "super",
        "switch", "sxe", "sy", "t", "target", "this", "true", "value", "vbr",
        "vc", "vcf", "vf", "void", "vs", "while", "ws", "xem", "XEM", "XML",
        "y",
    ]
    # fmt: on
    pattens = [
        r"\bdef\s([a-zA-Z_]\w*)\b",  # def var
        r"(?:,\s+|\[)([a-zA-Z_]\w*):",  # array key, [key: value]
        r"\{\s+([a-zA-Z_]\w*(?:,\s+[a-zA-Z_]\w*)*)\s*->",  # map key, {key -> value}
    ]
    for pattern in pattens:
        for var in findall(pattern, text):
            for key in var.split(", "):
                if key not in variables:
                    obf = key_finder(banned, variables)
                    variables[key] = obf

    print("Obfuscated variables:")
    for var, obf in variables.items():
        print(f"    {var} -> {obf}{' (may be skipped)' if var in banned else ''}")
    for var, obf in variables.items():
        if var in banned:
            continue
        text = sub(rf"\b{var}\b", obf, text)

    if use_json:
        save_keyword_mapping(json_path, variables)

    return text


def key_finder(banned_list: list[str], known_keys: dict[str, str]) -> str:
    """
    Generate a unique key for a variable

    Args:
        banned_list (list[str]): List of banned keys
        known_keys (dict[str, str]): Dictionary of known keys

    Returns:
        str: Unique key
    """
    char = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_"
    while True:
        key = "".join(choice(char) for _ in range(1, choice([2, 3]) + 1))
        if key not in banned_list and key not in known_keys.values():
            break
    return key


def dequoter(text: str) -> str:
    """Strip safe quotes from the text"""
    lookup = [" ", "/", " - ", " [", "][", "]"]
    for key in lookup:
        fx = r'{"' + key + r'"}'
        text = text.replace(fx, key)
    return text


def reformat_array(text: str) -> str:
    """
    Remove spaces between array elements, or between hash keys and values
    DO NOT remove spaces in {".+"} outside of array or hash
    """
    #
    text = sub(r"(?<=\S),\s(?=\S|[^\"\}])", ",", text)
    text = sub(r"(?<=\S):\s(?=\S)", ":", text)
    return text


def main():
    args = parse_args()
    inp = Path(args.input)
    out = Path(args.output)
    print(f"Compiling {inp} to {out}")

    script = resolve_imports(inp)
    script = remove_comments(script)
    script = append_semicolon(script)
    script = remove_blank_lines(script)
    script = array_stringify(remove_leading_whitespace(script))
    script = clean_characters(script)
    script = obfuscate_variables(script, use_json=not args.forget)
    # script = reformat_array(script)
    # script = dequoter(script)

    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_text(script, encoding="utf8")

    print(f'Done! Use "@{out.absolute()}" in FileBot\n')


if __name__ == "__main__":
    main()
