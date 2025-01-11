{" - "}{s00e00}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name = fixed_name.length() > 100 ? " " : " - $fixed_name "
    def epnum = any { e } { special }
    def def_ep = "Episode $epnum"
    // if fixed_name contains default episode name, blank it out
    def epname = fixed_name.contains(def_ep) ? '' : fixed_name
    epname != '' ? epname : ''
}