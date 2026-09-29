{
    def tmdb_tv = "TheMovieDB::TV"
    def show_id = [
        [123542, tmdb_tv], // LINK CLICK (2021) (时光代理人), ZH, Donghua
        [257162, tmdb_tv], // LINK CLICK (2024) (时光代理人), ZH, Live Action
        [336630, tmdb_tv], // Uunyan (2026), JP
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
