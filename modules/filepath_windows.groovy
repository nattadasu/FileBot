{
    //! OVERRIDE THIS PATH IF NEEDED, ELSE, BLANK IT ("")
    def override = "H:/"

    def guess = [
        home,
        "D:/",
        "E:/",
        "F:/",
        "G:/",
        "H:/"
    ].collect { it as File }.sort { a, b -> a.exists() <=> b.exists() ?: a.diskSpace <=> b.diskSpace }.last()
    def final_ = override ? override : guess
    "$final_/"
}
