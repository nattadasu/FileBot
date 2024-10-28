@./releasegroup.groovy
@./medianame.groovy
{" - "}{s00e00}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    // check if fixed name length is more than 100, if so, empty it
    fixed_name.length() > 100 ? " " : " - $fixed_name "
}
@./filespec.groovy
