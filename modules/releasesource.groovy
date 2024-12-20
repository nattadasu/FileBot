{
    def custom_releases = [
        // Platform name is for internal use only, aliases are used to match the filename
        ["ABEMA"], // https://abema.tv/
        ["ADN"], // https://animationdigitalnetwork.com
        ["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"], // https://www.bilibili.tv and https://www.bilibili.com
        ["COOLMIC"], // https://coolmic.com
        ["HIDIVE", "HIDI.WEB-DL"], // https://hidive.com
        ["IQIYI", "IQ.WEB-DL"], // https://www.iq.com
        ["JFFP"], // https://www.jff.jfp.go.jp
        ["LAFTEL", "LFTL"], // https://laftel.tv
        ["MDON", "MANGADON"], // https://mangadon.me
        ["MW.WEB-DL"], // https://www.mewatch.sg
        ["NF.WEB-DL", "NF WEB"], // https://www.netflix.com
        ["SHAHID"], // https://shahid.mbc.net
        ["TVER"], // https://tver.jp
        ["UNEXT"], // https://video.unext.jp
        ["WETV"], // https://wetv.vip
        ["YT.WEB-DL", "YOUTUBE", "YTB"], // https://www.youtube.com
    ]

    // List of groups that re-encode or modified even further the video from specific source
    def reencode_group = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"]
    // List of groups that directly rip the video from specific source
    def release_group = ["Erai-raws", "SubsPlease"]
    def unlisted_group = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""}

    // Find the release source from the custom releases list on filename (fn)
    def release_ = any {
        def platform = custom_releases.find { idx -> idx.find { known -> fn.lower().contains(known.lower()) } }[0]
        platform = platform.replace(".WEB-DL", "")
        // sometimes, group may use different keyword like WEBRip instead of WEB-DL
        // when they do a re-encoding or modification. This logic will try to find the
        // correct source if stated explicitly in the filename
        def is_webdl = source.contains("WEB-DL")
        def src_smart = source ? ".${source}" : ""
        is_webdl ? "${platform}.WEB-DL" : platform ? "${platform}${src_smart}" : ""
    } {
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
