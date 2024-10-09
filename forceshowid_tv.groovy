{
    def show_id = [
        68854,  // Kimi ni Todoke (2009) (君に届け), JP
        235973, // Tom and Jerry (2022) (とむとじぇりー), JP
        262295, // Roommates (2024) (戏精宿舍), CN
        259140, // Ranma 1/2 (2024), JP
    ]
    def is_id_matches = show_id.find { curr_id -> tmdbid == curr_id } ?: ""
    is_id_matches ? " ($y) [tmdbid-$is_id_matches]" : ""
}
