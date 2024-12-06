{
    def tmdb_tv = "TheMovieDB::TV"
    def short_title = [
        // Media ID, target name, database
        [mid:  68854, title: "From Me to You", src: tmdb_tv],
        [mid: 229743, title: "VTuber Legend", src: tmdb_tv],
        [mid: 234538, title: "Demon Lord 2099", src: tmdb_tv],
        [mid: 237045, title: "Cherry Magic!", src: tmdb_tv],
        [mid: 240633, title: "A Journey Through Another World", src: tmdb_tv],
        [mid: 245285, title: "Failure Frame", src: tmdb_tv],
        [mid: 271026, title: "Taisho Era Contract Marriage", src: tmdb_tv],
    ]

    // Replace title from short_title if series_id matches "series" from filebot
    // Otherwise, use the original name
    def database = any { info.database } { "IMDb" }
    def fixed_id = database == "IMDb" ? "tt${id}" : id
    def name_ = n
    short_title.each {
        if (it.mid == fixed_id && it.src == database) {
            name_ = it.title
        }
    }

    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = name_.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '')
    // trim . and whitespace at the end
    fixed_name = fixed_name.replaceAll(/(\s|\.)*$/, '')
    fixed_name
}
