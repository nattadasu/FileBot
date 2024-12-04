{
    def show_id = [
        [ 68854, "TheMovieDB::TV"], // Kimi ni Todoke (2009) (君に届け), JP
        [123542, "TheMovieDB::TV"], // LINK CLICK (2021) (时光代理人), ZH, Donghua
        [204098, "TheMovieDB::TV"], // Murai in Love (2024) (村井の恋), JP
        [235973, "TheMovieDB::TV"], // Tom and Jerry (2022) (とむとじぇりー), JP
        [239779, "TheMovieDB::TV"], // True Beauty (2024) (여신강림), KR
        [240125, "TheMovieDB::TV"], // Trillion Game (2024) (トリリオンゲーム), JP
        [257162, "TheMovieDB::TV"], // LINK CLICK (2024) (时光代理人), ZH, Live Action
        [259140, "TheMovieDB::TV"], // Ranma 1/2 (2024) (らんま1/2), JP
        [262295, "TheMovieDB::TV"], // Roommates (2024) (戏精宿舍), ZH
        [271026, "TheMovieDB::TV"], // Taisho Era Contact Marriage (2024) (大正偽りブラヰダル～身代わり花嫁と軍服の猛愛), JP
        [273190, "TheMovieDB::TV"], // Ya She/Silent House (2024) (哑舍), ZH
        [275695, "TheMovieDB::TV"], // No Home (2024) (집이 없어), KR
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
