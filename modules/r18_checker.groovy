{
    // list of possibly R18+ tags
    def known_tags = [
        "boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai",
        "hentai", "sex", "lgbt", "explicit", "adult animation", "adult content",
    ]

    // Manual list of known R18+ titles, only add if the title is known to be R18+
    // or have a variant that is R18+
    def known_titles = [
        [271026, "TheMovieDB::TV"], // Taisho Era Contract Marriage, 2024
        [220118, "TheMovieDB::TV"], // Sazanami Soushi ni Junketsu wo Sasagu, 2023
    ]

    // REQUIRES USER TO SET ADDITIONAL PROPERTY ON FILEBOT
    // READ: https://www.filebot.net/forums/viewtopic.php?p=58610#p58610
    def is_adult = any { info.adult } { false }

    def is_same_id = known_titles.find { it[0] == id && it[1] == info.database } != null
    def is_r18 = info.Keywords.findAll { it in known_tags } || is_same_id || is_adult
    is_r18 ? "R18+ " : ""
}