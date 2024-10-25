{
    def show_id = [
        68854,  // Kimi ni Todoke (2009) (君に届け), JP
        235973, // Tom and Jerry (2022) (とむとじぇりー), JP
        262295, // Roommates (2024) (戏精宿舍), ZH
        259140, // Ranma 1/2 (2024) (らんま1/2), JP
        204098, // Murai in Love (2024) (村井の恋), JP
        239779, // True Beauty (2024) (여신강림), KR
        273190, // Ya She/Silent House (2024) (哑舍), ZH
        271026, // Taisho Era Contact Marriage (2024) (大正偽りブラヰダル～身代わり花嫁と軍服の猛愛), JP
        240125, // Trillion Game (2024) (トリリオンゲーム), JP
    ]
    def is_id_matches = show_id.find { curr_id -> tmdbid == curr_id } ?: ""
    is_id_matches ? " ($y) [tmdbid-$is_id_matches]" : ""
}
