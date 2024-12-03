{"Videos/"}
@./r18_checker.groovy
{
    // check Country of Origin
    def cjk_countries = ["CN", "JP", "KR", "KP", "TW", "HK"]
    def cjkani_tags = ["aeni", "donghua", "anime"]
    def is_cjk = any { anime } { info.Keywords.findAll { it in cjkani_tags } } { cjk_countries.contains(country) } { false }
    // Categorized path
    is_cjk && genres =~ /Animation/ ? "Anime Movies/" : "Movies/"
}
@./medianame.groovy
{" ("}{y}{") [tmdbid-"}{tmdbid}{"]/"}
@./filename_movie.groovy