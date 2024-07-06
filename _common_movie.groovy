{
    // check Country of Origin
    def cjk_countries = ["CN", "KR", "JP"]
    def cjkani_tags = ["Aeni", "Donghua", "Anime"]
    def isAnime = genres =~ cjkani_tags || (genres =~ /Animation/ && country =~ cjk_countries) || anime ? true : false

    // Categorized path
    def cust_cat = isAnime ? "Videos/Anime " : "Videos/"
    "$cust_cat" + "Movies/"
}
@./medianame.groovy
 ({y}) [tmdbid-{tmdbid}]/
@./filename_movie.groovy