{
    // detect if the system is windows
    def gp_ = {System.getProperty(it)}
    def is_windows = gp_("os.name").toLowerCase().contains("windows")
    // get current username
    def user_ = gp_("user.name")

    // fedora mountpoint
    def mntp = "/run/media/${user_}"

    //! OVERRIDE THIS PATH IF NEEDED, ELSE, BLANK IT ("")
    // def override = is_windows ? "H:/" : "$mntp/Videos"
    def override = ""

    def mounts = [
        [label: "Books", winmnt: "F:/", linmnt: "$mntp/Books"],
        [label: "Data", winmnt: "D:/", linmnt: "$mntp/Data"],
        [label: "Games", winmnt: "G:/", linmnt: "$mntp/Games"],
        [label: "Music", winmnt: "E:/", linmnt: "$mntp/Music"],
        [label: "Videos", winmnt: "H:/", linmnt: "$mntp/Videos"],
    ]

    def guess = (mounts.collect {it[is_windows ? "winmnt" : "linmnt"] as File}
                .sort {first, second ->
                    first.exists() <=> second.exists() ?: first.diskSpace <=> second.diskSpace
                }).last().path
    def final_ = override ?: guess
    "$final_/"
}