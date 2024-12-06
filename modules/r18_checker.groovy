{
    // list of possibly R18+ tags
    def known_tags = [
        "boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai",
        "hentai", "sex", "lgbt", "explicit", "adult animation", "adult content",
    ]

    def tmdb_tv = "TheMovieDB::TV"

    // Manual list of known R18+ titles, only add if the title is known to be R18+
    // or have a variant that is R18+
    def known_titles = [
        [271026, tmdb_tv], // Taisho Era Contract Marriage, 2024
        [220118, tmdb_tv], // Sazanami Soushi ni Junketsu wo Sasagu, 2023
    ]

    // List of known titles that might be misclassified as R18+
    def override_tag = [
        [236530, tmdb_tv] // How I Attended an All-Guy's Mixer, 2024
    ]

    def db_name = any { info.database } { "IMDb" }
    def fixed_id = db_name == "IMDb" ? "tt${id}" : id

    // REQUIRES USER TO SET ADDITIONAL PROPERTY ON FILEBOT
    // READ: https://www.filebot.net/forums/viewtopic.php?p=58610#p58610
    def is_adult = any { info.adult } { false }

    def is_same_id = known_titles.find { it[0] == fixed_id && it[1] == db_name } != null
    def is_adult_override = override_tag.find { it[0] == fixed_id && it[1] == db_name } != null
    def is_r18 = info.Keywords.findAll { it in known_tags } || is_same_id || is_adult

    // Apply R18+ tag to the path name
    is_r18 = is_adult_override ? false : is_r18
    is_r18 ? "R18+ " : ""
}