{" - "}{s00e00}{
    // find version numbering on file, e.g. v2, v3
    def version = (fn =~ /(?i)(?<![a-zA-Z])v(\d+)/)
    version ? 'v' + version[0][1] : ''
}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name = fixed_name.length() > 100 ? " " : " - $fixed_name "
    def epnum = any { e } { special }
    def def_ep = "Episode $epnum"
    // if fixed_name contains default episode name, blank it out
    def epname = fixed_name.contains(def_ep) ? '' : fixed_name
    special ? epname : ''
}
