{
    def tmdb_tv = "TheMovieDB::TV"
    def short_title = [
        // Media ID, target name, database
        [mid: 136342, title: "Disney Twisted-Wonderland", src: tmdb_tv],
        [mid: 262453, title: "The Fated Magical Princess", src: tmdb_tv],
        [mid: 270660, title: "Pochars", src: tmdb_tv],
        [mid: 280405, title: "Fudanshi Shoukan", src: tmdb_tv],
        [mid: 281161, title: "Noble Reincarnation", src: tmdb_tv],
        [mid: 284495, title: "Isekai Office Worker", src: tmdb_tv],
        [mid: 285260, title: "Kaijyu Sekai Seifuku", src: tmdb_tv],
        [mid: 287704, title: "Muzik Tiger In the Forest", src: tmdb_tv],
        [mid: 295366, title: "Yuukawa", src: tmdb_tv],
        [mid: 295625, title: "Marie Antoinette ni Tensei Shita", src: tmdb_tv],
        [mid: 296047, title: "Shuukan Ranobe Anime", src: tmdb_tv],
        [mid: 302169, title: "Anila and Cocora", src: tmdb_tv],
    ]

    // Replace title from short_title if series_id matches "series" from filebot
    // Otherwise, use the original name
    def db_name = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" }
    def fixed_id = db_name == "IMDb" ? "tt${id}" : id
    def name_ = n
    short_title.each {
        if (it.mid == fixed_id && it.src == db_name) {
            name_ = it.title
        }
    }

    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = name_.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '')
    // trim . and whitespace at the end
    fixed_name = fixed_name.replaceAll(/(\s|\.)*$/, '')
    fixed_name
}
