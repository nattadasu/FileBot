{"/"}
{
    episode.special ? 'Specials' : 'Season '+s
}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = sn.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    def fixed_title = n.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    // if kv contains Series name from fixed_title (partially or fully), then remove it
    def kv = fixed_name.contains(fixed_title) ? "" : fixed_name
    // Sanitize the season name if it just repeats the "Season" string
    kv == 'Season '+ s ? "" : kv ? " - " + kv : ""
}
{"/"}