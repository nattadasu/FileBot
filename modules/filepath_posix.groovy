{
    // get current username
    def user_ = System.getProperty("user.name")
    // fedora mountpoint
    def mntp = "/run/media/${user_}"

    //! OVERRIDE THIS PATH IF NEEDED, ELSE, BLANK IT ("")
    def override = "$mntp/Videos"

    def guess = [
        home,
        "$mntp/Data",
        "$mntp/Music",
        "$mntp/Videos",
        "$mntp/Games",
        "$mntp/Books"
    ].collect { it as File }.sort { a, b -> a.exists() <=> b.exists() ?: a.diskSpace <=> b.diskSpace }.last()
    def final_ = override ? override : guess
    "$final_/"
}
