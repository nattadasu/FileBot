{
    //! OVERRIDE THIS PATH IF NEEDED, ELSE, BLANK IT ("")
    def override = "H:/"

    def guess = [
        home,
        "D:/",
        "E:/",
        "F:/",
        "G:/",
        "H:/",
    ].collect { it as File }.sort { first, second -> first.exists() <=> second.exists() ?: first.diskSpace <=> second.diskSpace }.last()
    def final_ = override ? override : guess
    "$final_/"
}
