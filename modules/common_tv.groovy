{"Videos/"}
@./r18_checker.groovy
{
    // check Country of Origin
    def cjk_countries = /(CN|JP|KR|KP|TW|HK)/
    def cjkani_tags = /(aeni|donghua|anime)/
    def is_anime = anime || info.Keywords =~ cjkani_tags || (genres =~ /Animation/ && country =~ cjk_countries) ? true : false

    // Categorized path
    is_anime ? "Anime/" : "TV Series/"
}
@./medianame.groovy
@./forceshowid_tv.groovy
@./season.groovy
@./filename_tv.groovy
