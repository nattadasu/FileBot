{
    def custom_releases = [
        // Platform name is for internal use only, aliases are used to match the filename
        [platform: "ABEMA", aliases: ["ABEMA"]], // https://abema.tv/
        [platform: "Bilibili.tv", aliases: ["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"]], // https://www.bilibili.tv and https://www.bilibili.com
        [platform: "Hulu", aliases: ["HULU"]], // https://www.hulu.com and https://www.hulu.jp
        [platform: "iQIYI", aliases: ["IQ.WEB-DL", "IQIYI"]], // https://www.iq.com
        [platform: "MeWatch", aliases: ["MW.WEB-DL"]], // https://www.mewatch.sg
        [platform: "Netflix", aliases: ["NF.WEB-DL", "NF WEB"]], // https://www.netflix.com
        [platform: "Prime Video", aliases: ["AMZN"]], // https://www.primevideo.com
        [platform: "Shahid", aliases: ["SHAHID"]], // https://shahid.mbc.net
        [platform: "TVer", aliases: ["TVER"]], // https://tver.jp
        [platform: "U-NEXT", aliases: ["UNEXT"]], // https://video.unext.jp
        [platform: "YouTube", aliases: ["YT.WEB-DL", "YOUTUBE", "YTB"]], // https://www.youtube.com
    ]

    // List of groups that re-encode or modified even further the video from specific source
    def reencode_group = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"]
    // List of groups that directly rip the video from specific source
    def release_group = ["Erai-raws", "SubsPlease"]
    def unlisted_group = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""}

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
