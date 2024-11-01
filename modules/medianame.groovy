{
    def short_title = [
        [series_id: 229743, title: "VTuber Legend"],
        [series_id: 240633, title: "A Journey Through Another World"],
        [series_id: 245285, title: "Failure Frame"],
        [series_id: 237045, title: "Cherry Magic!"],
        [series_id:  68854, title: "From Me to You"],
        [series_id: 240411, title: "DAN DA DAN"],
        [series_id: 271026, title: "Taisho Era Contract Marriage"],
        [series_id: 234538, title: "Demon Lord 2099"],
    ]

    // Replace title from short_title if series_id matches "series" from filebot
    // Otherwise, use the original name
    def name_ = n
    short_title.each {
        name_ = it.series_id == tmdbid && type.toString() != "Movie" ? it.title : n
    }

    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = name_.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '')
    // trim . and whitespace at the end
    fixed_name = fixed_name.replaceAll(/(\s|\.)*$/, '')
    fixed_name
}
