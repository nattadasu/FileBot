{
    def tmdb_tv = "TheMovieDB::TV"
    def show_id = [
        [ 68854, tmdb_tv], // Kimi ni Todoke (2009) (君に届け), JP
        [123542, tmdb_tv], // LINK CLICK (2021) (时光代理人), ZH, Donghua
        [204098, tmdb_tv], // Murai in Love (2024) (村井の恋), JP
        [235973, tmdb_tv], // Tom and Jerry (2022) (とむとじぇりー), JP
        [239779, tmdb_tv], // True Beauty (2024) (여신강림), KR
        [240125, tmdb_tv], // Trillion Game (2024) (トリリオンゲーム), JP
        [257162, tmdb_tv], // LINK CLICK (2024) (时光代理人), ZH, Live Action
        [259140, tmdb_tv], // Ranma 1/2 (2024) (らんま1/2), JP
        [262295, tmdb_tv], // Roommates (2024) (戏精宿舍), ZH
        [271026, tmdb_tv], // Taisho Era Contact Marriage (2024) (大正偽りブラヰダル～身代わり花嫁と軍服の猛愛), JP
        [273190, tmdb_tv], // Ya She/Silent House (2024) (哑舍), ZH
        [275695, tmdb_tv], // No Home (2024) (집이 없어), KR
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
