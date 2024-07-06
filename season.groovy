/
{
    episode.special ? 'Specials' : 'Season '+s
}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = sn.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name == 'Season '+ s ? "" : fixed_name ? " - " + fixed_name : ""
}
/