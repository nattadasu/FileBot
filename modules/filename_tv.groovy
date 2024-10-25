@./releasegroup.groovy
@./medianame.groovy
{" - "}{s00e00}{" - "}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name
}
@./filespec.groovy
