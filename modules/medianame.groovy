{
    def tmdb_tv = "TheMovieDB::TV"
    def short_title = [
        // Media ID, target name, database
        [mid:  68854, title: "From Me to You", src: tmdb_tv],
        [mid: 219816, title: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", src: tmdb_tv],
        [mid: 245561, title: "Okitsura", src: tmdb_tv],
        [mid: 248707, title: "Neko Oji The Guy That Got Reincarnated As a Cat", src: tmdb_tv],
        [mid: 259559, title: "Headhunted to Another World", src: tmdb_tv],
        [mid: 262141, title: "Can You Keep a Secret", src: tmdb_tv],
        [mid: 276204, title: "Bogus Skill Fruitmaster", src: tmdb_tv],
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
