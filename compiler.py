import argparse as ap
import os
from pathlib import Path
from re import DOTALL, MULTILINE, match, sub
from typing import Union


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
    # remove inline comments with regex
    lines = [sub(r"(?: +)?//.*", "", line) for line in lines]
    # Remove block comments
    text = "\n".join(lines)
    text = sub(r"/\*.*?\*/", "", text, flags=DOTALL)
    # Remove empty curlied-comment
    text = sub(r"^\{\s*\}", "", text, flags=DOTALL | MULTILINE)
    return text


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
    with open(script_path, "r") as f:
        script = f.read()
    sli = script.splitlines(keepends=True)

    for i, line in enumerate(sli):
        if match(r"^@(.*\.groovy)", line):
            import_path = Path(script_path).parent / match(
                r"^@(.*\.groovy)", line
            ).group(1)
            sli[i] = resolve_imports(import_path)

    return "".join(sli)


def main():
    args = parse_args()
    script = resolve_imports(args.input)
    script = remove_blank_lines(remove_comments(script))
    # test if the output directory exists, if specified, if not create it
    if os.path.dirname(args.output):
        os.makedirs(os.path.dirname(args.output), exist_ok=True)
    with open(args.output, "w") as f:
        f.write(script)


if __name__ == "__main__":
    main()
