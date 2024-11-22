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
        [platform: "Netflix", aliases: ["NF.WEB-DL", "NF WEB"]],
    ]

    // List of groups that re-encode or modified even further the video from specific source
    def reencode_group = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"]
    // List of groups that directly rip the video from specific source
    def release_group = ["Erai-raws", "SubsPlease"]
    def unlisted_group = (fn =~ /^\[(.*?)\]/)[0][1]

    // Find the release source from the custom releases list on filename (fn)

    def release_ = any {
        def allas = custom_releases.find { crate -> crate.aliases.find { aka -> fn.contains(aka) } }?.aliases.first() ?: ""
        allas = allas.replace(".WEB-DL", "")
        allas ? "${allas}.WEB-DL" : ""
    } {
        source
    } {
        reencode_group.find { g_ -> group == g_ || unlisted_group == g_ } ? "WEBRip" : ""
    } {
        def mtag = release_group.find { r_ -> group == r_ || unlisted_group == r_} ? "WEB-DL" : ""
        (source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : mtag
    } {
        vs
    } {
    	""
    }

    release_ ? "$release_ " : ""
}
