{"Videos/"}
@./r18_checker.groovy
{
    // check Country of Origin
    def cjk_countries = /(CN|JP|KR|KP|TW|HK)/
    def cjkani_tags = /(aeni|donghua|anime)/
    def is_anime = anime || info.Keywords =~ cjkani_tags || any {(genres =~ /Animation/ && country =~ cjk_countries)}{false} ? true : false

    // Categorized path
    is_anime ? "Anime Movies/" : "Movies/"
}
@./medianame.groovy
{" ("}{y}{") [tmdbid-"}{tmdbid}{"]/"}
@./filename_movie.groovy