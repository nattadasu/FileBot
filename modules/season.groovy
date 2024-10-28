{"/"}
{
    episode.special ? 'Specials' : 'Season '+s
}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = sn.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    def fixed_title = n.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    def kv = fixed_name == fixed_title ? "" : fixed_name
    kv == 'Season '+ s ? "" : kv ? " - " + kv : ""
}
{"/"}