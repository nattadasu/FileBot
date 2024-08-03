{
    // check Country of Origin
    def cjk_countries = /(CN|JP|KR|KP|TW|HK)/
    def cjkani_tags = /(aeni|donghua|anime)/
    def is_anime = anime || info.Keywords =~ cjkani_tags || (genres =~ /Animation/ && country =~ cjk_countries) ? true : false

    // Categorized path
    def cust_cat = is_anime ? "Videos/Anime " : "Videos/"
    "$cust_cat" + "Movies/"
}
@./medianame.groovy
{" ("}{y}{") [tmdbid-"}{tmdbid}{"]/"}
@./filename_movie.groovy