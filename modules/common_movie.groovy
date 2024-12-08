{"Videos/"}
@./r18_checker.groovy
{
    // check Country of Origin
    def cjk_countries = ["CN", "JP", "KR", "KP", "TW", "HK"]
    def cjkani_tags = ["aeni", "donghua", "anime"]
    def is_anime = any {anime} || info.Keywords.findAll { it in cjkani_tags } || (cjk_countries.contains(country) && genres =~ /Animation/)
    // Categorized path
    is_anime ? "Anime Movies/" : "Movies/"
}
@./medianame.groovy
{" ("}{y}{")"}
{
    def db_name = id == tmdbid ? "TheMovieDB" : "IMDb"
    def db_map = [
        "TheMovieDB": "tmdbid",
        "IMDb": "imdbid"
    ]
    def db_src = db_map[db_name]
    def fixed_id = db_name == "IMDb" ? "tt${id}" : id
    " [${db_src}-${fixed_id}]/"
}
@./filename_movie.groovy