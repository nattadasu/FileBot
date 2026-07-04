{
    def tmdb_tv = "TheMovieDB::TV"
    def show_id = [
        [ 35466, tmdb_tv], // Ghost Stories (2000) (学校の怪談), JP
        [123542, tmdb_tv], // LINK CLICK (2021) (时光代理人), ZH, Donghua
        //[235973, tmdb_tv], // Tom and Jerry (2022) (とむとじぇりー), JP
        [254492, tmdb_tv], // Hana-Kimi (2026) (花ざかりの君たちへ), JP
        [257162, tmdb_tv], // LINK CLICK (2024) (时光代理人), ZH, Live Action
        [259140, tmdb_tv], // Ranma 1/2 (2024) (らんま1/2), JP
        [280049, tmdb_tv], // Hell Mode (2026) (ヘルモード), JP
        [303460, tmdb_tv], // Kanteishi (Kari) (2026) (鑑定士（仮）), JP
        [312849, tmdb_tv], // Rich Girl Caretaker (2026) (才女のお世話), JP
    ]
    def is_id_matches = show_id.find { it[0] == id && it[1] == info.database } != null
    // try map TheMovieDB::TV -> tmdbid, AniDB -> anidbid, TheTVDB -> tvdbid
    def db_map = [
        "TheMovieDB::TV": "tmdbid",
        "AniDB": "anidbid",
        "TheTVDB": "tvdbid",
        "TVmaze": "tvmazeid",
    ]
    def db_src = db_map[info.database]
    is_id_matches ? " ($y) [${db_src}-${id}]" : ""
}
