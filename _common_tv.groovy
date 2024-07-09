{
    // check Country of Origin
    def cjk_countries = /(CN|KR|JP|TW|HK)/
    def cjkani_tags = /(Aeni|Donghua|Anime)/
    def isAnime = genres =~ cjkani_tags || (genres =~ /Animation/ && country =~ cjk_countries) || anime ? true : false

    // Categorized path
    def cust_cat = isAnime ? "Videos/Anime" : "Videos/TV Series"
    "$cust_cat/"
}
@./medianame.groovy
@./season.groovy
@./filename_tv.groovy