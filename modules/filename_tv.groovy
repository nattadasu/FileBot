@./releasegroup.groovy
@./medianame.groovy
{" - "}{s00e00}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    def epnum = any { e } { special }
    // check if fixed name length is more than 100, if so, empty it
    fixed_name = fixed_name.length() > 100 ? " " : " - $fixed_name "
    fixed_name == " - Episode $epnum " ? " " : fixed_name
}
@./filespec.groovy
