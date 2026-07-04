{
    def tmdb_tv = "TheMovieDB::TV"
    def short_title = [
        // Media ID, target name, database
        [mid: 136342, title: "Disney Twisted-Wonderland", src: tmdb_tv],
        [mid: 280049, title: "Hell Mode", src: tmdb_tv],
        [mid: 280405, title: "Fudanshi Shoukan", src: tmdb_tv],
        [mid: 296256, title: "AOTU WORLD REBORN", src: tmdb_tv],
        [mid: 303460, title: "Kanteishi (Kari)", src: tmdb_tv],
        [mid: 312822, title: "Playing Sister", src: tmdb_tv],
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
