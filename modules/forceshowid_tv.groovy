{
    def tmdb_tv = "TheMovieDB::TV"
    def show_id = [
        [ 78474, tmdb_tv], // You Don't Know Gunma Yet (2018) (お前はまだグンマを知らない), JP
    	[ 95897, tmdb_tv], // Overflow (2020) (おーばーふろぉ), JP
        [123542, tmdb_tv], // LINK CLICK (2021) (时光代理人), ZH, Donghua
        [129633, tmdb_tv], // Super Secret (2020) (슈퍼 시크릿), KR, Aeni
        //[235973, tmdb_tv], // Tom and Jerry (2022) (とむとじぇりー), JP
        [257162, tmdb_tv], // LINK CLICK (2024) (时光代理人), ZH, Live Action
        [295366, tmdb_tv], // Yuukawa (2026) (勇者パーティーにかわいい子がいたので、告白してみた。), JP
        [296287, tmdb_tv], // Plus-sized Misadventures in Love! (2025) (デブとラブと過ちと!), JP
        [259140, tmdb_tv], // Ranma 1/2 (2024) (らんま1/2), JP
        [254492, tmdb_tv], // Hana-Kimi (2026) (花ざかりの君たちへ), JP
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
