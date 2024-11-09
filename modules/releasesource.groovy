{
    def custom_releases = [
        // Platform name is for internal use only, aliases are used to match the filename
        [platform: "Bilibili.tv", aliases: ["B-Global", "BiliIntl", "BILI"]],
        [platform: "Prime Video", aliases: ["AMZN"]],
        [platform: "U-NEXT", aliases: ["UNEXT"]],
        [platform: "ABEMA", aliases: ["ABEMA"]],
        [platform: "Hulu", aliases: ["HULU"]],
        [platform: "Shahid", aliases: ["SHAHID"]],
        [platform: "YouTube", aliases: ["YT.WEB-DL", "YOUTUBE", "YTB"]],
    ]

    // List of groups that re-encode the video from specific source
    def reencode_group = ["ASW", "Judas"]
    // List of groups that directly rip the video from specific source
    def release_group = ["Erai-raws", "SubsPlease", "JRx7"]

    // Find the release source from the custom releases list on filename (fn)

    def release_ = any {
        def allas = custom_releases.find { crate -> crate.aliases.find { aka -> fn.contains(aka) } }?.aliases.first() ?: ""
        allas = allas.replace("YT.WEB-DL", "YT")
        allas ? "${allas}.WEB-DL" : ""
    } {
        source
    } {
        reencode_group.find { g_ -> group == g_ } ? "WEBRip" : ""
    } {
        release_group.find { r_ -> group == r_ } ? "WEB-DL" : ""
    } {
        ""
    }

    release_ ? "$release_ " : ""
}
