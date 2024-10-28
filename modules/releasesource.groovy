{
    def custom_releases = [
        // Platform name is for internal use only, aliases are used to match the filename
        [platform: "Bilibili.tv", aliases: ["B-Global", "BiliIntl", "BILI"]],
        [platform: "Prime Video", aliases: ["AMZN"]],
        [platform: "U-NEXT", aliases: ["UNEXT"]],
        [platform: "ABEMA", aliases: ["ABEMA"]],
        [platform: "Hulu", aliases: ["HULU"]],
        [platform: "Shahid", aliases: ["SHAHID"]]
    ]

    // List of groups that re-encode the video from specific source
    def reencode_group = ["ASW"]
    // List of groups that directly rip the video from specific source
    def release_group = ["Erai-raws", "SubsPlease"]

    // Find the release source from the custom releases list on filename (fn)
    def allas = custom_releases.find { crate -> crate.aliases.find { alias -> fn.contains(alias) } }?.aliases.first() ?: ""

    def release_ = any {
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
