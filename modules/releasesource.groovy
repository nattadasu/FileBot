{
    def custom_releases = [
        // Platform name is for internal use only, aliases are used to match the filename
        ["YTB", "YT.WEB-DL", "YOUTUBE"], // https://www.youtube.com
        ["ABEMA", "ABEMATV"], // https://abema.tv/
        ["ADN"], // https://animationdigitalnetwork.com
        ["BILI", "B-Global", "BiliIntl"], // https://www.bilibili.tv
        ["BSITE", "BILICN"], // https://www.bilibili.com
        ["BUMP"], // https://lp.bump.studio
        ["CMIC", "COOLMIC"], // https://coolmic.com
        ["CTHP"], // https://catchplay.com
        ["FOD"], // https://fod.fujitv.co.jp
        ["HIDIVE", "HIDI.WEB-DL"], // https://hidive.com
        ["IQIYI", "IQ.WEB-DL"], // https://www.iq.com
        ["JFFP"], // https://www.jff.jfp.go.jp
        ["LFTL", "LAFTEL"], // https://laftel.tv
        ["MDON", "MANGADON"], // https://mangadon.me
        ["MW.WEB-DL"], // https://www.mewatch.sg
        ["NBLA.WEB-DL", "Nebula"], // https://nebula.tv
        ["NF.WEB-DL", "NF WEB"], // https://www.netflix.com
        ["OVEIL", "OV.WEB-DL", "OceanVeil"], // https://oceanveil.net
        ["SHAHID"], // https://shahid.mbc.net
        ["TVER"], // https://tver.jp
        ["UNEXT"], // https://video.unext.jp
        ["VIDIO"], // https://vidio.com
        ["VIU"], // https://viu.com
        ["WETV"], // https://wetv.vip
        ["INSTA", "INSTAGRAM"], // https://instagram.com
        ["ANIMENOTANE"], // https://animenotane.jp
        ["TWTR"], // https://twitter.com / https://x.com
    ]

    // List of groups that re-encode or modified even further the video from specific source
    def reencode_group = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU", "Kusonime"]
    def bdreencode_group = ["DB"]
    def tvreencode_group = ["Ruri-Saizen"]
    // List of groups that directly rip the video from specific source
    def release_group = ["Erai-raws", "SubsPlease"]
    def unlisted_group = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""}

    // Find the release source from the custom releases list on filename (fn)
    def release_ = any {
        def platform = custom_releases.find { idx -> idx.find { known -> fn.lower().contains(known.lower()) } }[0]
        platform = platform.replace(".WEB-DL", "")
        // Some file may have additional "WEBRip" tag, consider it to new logic
        if (fn.contains("WEBRip")) {
            platform = platform.replace(".WEBRip", "")
            platform = platform + ".WEBRip"
        } else {
            platform = platform + ".WEB-DL"
        }
        platform
    } {
        source.replace("_", "-")
    } {
        reencode_group.find { g_ -> group == g_ || unlisted_group == g_ } ? "WEBRip" : ""
    } {
        bdreencode_group.find { g_ -> group == g_ || unlisted_group == g_ } ? "BDRip" : ""
    } {
        tvreencode_group.find { g_ -> group == g_ || unlisted_group == g_ } ? "HDTVRip" : ""
    } {
        def mtag = release_group.find { r_ -> group == r_ || unlisted_group == r_} ? "WEB-DL" : ""
        (source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : mtag
    } {
        vs.replace("_", "-")
    } {
        ""
    }

    release_ ? "$release_ " : ""
}
