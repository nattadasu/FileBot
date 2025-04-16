{
    def tmdb_tv = "TheMovieDB::TV"
    def short_title = [
        // Media ID, target name, database
        [mid: 199928, title: "Nights With a Cat", src: tmdb_tv],
        [mid: 219816, title: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", src: tmdb_tv],
        [mid: 248707, title: "Neko Oji The Guy That Got Reincarnated As a Cat", src: tmdb_tv],
        [mid: 271003, title: "Yandere Dark Elf", src: tmdb_tv],
        [mid: 274741, title: "The Too-Perfect Saint", src: tmdb_tv],
        [mid: 275623, title: "Chuzenji-sensei", src: tmdb_tv],
        [mid: 281623, title: "SHIROHIYO", src: tmdb_tv],
        [mid: 288419, title: "Chikuwa Senki", src: tmdb_tv],
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
