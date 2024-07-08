{
    // get current username
    def user = System.getProperty("user.name")

    //! OVERRIDE THIS PATH IF NEEDED
    def override = "H:/Videos"


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