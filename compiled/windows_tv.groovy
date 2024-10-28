{
    def user = System.getProperty("user.name")
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
{
    def cjk_countries = /(CN|JP|KR|KP|TW|HK)/
    def cjkani_tags = /(aeni|donghua|anime)/
    def is_anime = anime || info.Keywords =~ cjkani_tags || (genres =~ /Animation/ && country =~ cjk_countries) ? true : false
    is_anime ? "Videos/Anime/" : "Videos/TV Series/"
}
{
    def short_title = [
        [series_id: 229743, title: "VTuber Legend"],
        [series_id: 240633, title: "A Journey Through Another World"],
        [series_id: 245285, title: "Failure Frame"],
        [series_id: 237045, title: "Cherry Magic!"],
        [series_id:  68854, title: "From Me to You"],
        [series_id: 240411, title: "DAN DA DAN"],
        [series_id: 271026, title: "Taisho Era Contract Marriage"],
        [series_id: 234538, title: "Demon Lord 2099"],
    ]
    def name_ = n
    short_title.each {
        if (it.series_id == tmdbid) {
            name_ = it.title
        }
    }
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = name_.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '')
    fixed_name = fixed_name.replaceAll(/(\s|\.)*$/, '')
    fixed_name
}
{
    def show_id = [
        68854,
        235973,
        262295,
        259140,
        204098,
        239779,
        273190,
        271026,
        240125,
    ]
    def is_id_matches = show_id.find { curr_id -> tmdbid == curr_id } ?: ""
    is_id_matches ? " ($y) [tmdbid-$is_id_matches]" : ""
}
{"/"}
{
    episode.special ? 'Specials' : 'Season '+s
}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = sn.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    def fixed_title = n.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    def kv = fixed_name == fixed_title ? "" : fixed_name
    kv == 'Season '+ s ? "" : kv ? " - " + kv : ""
}
{"/"}{
    def customGroups = [
        "Alqanime",
        "BlackLuster",
        "NanDesuKa",
        "ToonsHub",
        "Tsundere-Raws",
    ]
    def finalGroup = customGroups.find { groupName -> fn.contains(groupName) } ?: ""
    def group_ = any {
        (fn =~ /^\[(.*?)\]/)[0][1]
    } {
        finalGroup
    } {
        group
    } {
        ""
    }
    group_ ? "[$group_] " : ""
}
{
    def short_title = [
        [series_id: 229743, title: "VTuber Legend"],
        [series_id: 240633, title: "A Journey Through Another World"],
        [series_id: 245285, title: "Failure Frame"],
        [series_id: 237045, title: "Cherry Magic!"],
        [series_id:  68854, title: "From Me to You"],
        [series_id: 240411, title: "DAN DA DAN"],
        [series_id: 271026, title: "Taisho Era Contract Marriage"],
        [series_id: 234538, title: "Demon Lord 2099"],
    ]
    def name_ = n
    short_title.each {
        if (it.series_id == tmdbid) {
            name_ = it.title
        }
    }
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = name_.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '')
    fixed_name = fixed_name.replaceAll(/(\s|\.)*$/, '')
    fixed_name
}
{" - "}{s00e00}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name.length() > 100 ? " " : " - $fixed_name "
}
{" ["}
{
    def custom_releases = [
        [platform: "Bilibili.tv", aliases: ["B-Global", "BiliIntl", "BILI"]],
        [platform: "Prime Video", aliases: ["AMZN"]],
        [platform: "U-NEXT", aliases: ["UNEXT"]],
        [platform: "ABEMA", aliases: ["ABEMA"]],
        [platform: "Hulu", aliases: ["HULU"]],
        [platform: "Shahid", aliases: ["SHAHID"]]
    ]
    def reencode_group = ["ASW"]
    def release_group = ["Erai-raws", "SubsPlease"]
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
{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac}
{" "}
{af.format(
    8: 'DD+ 7.1',
    7: '6.1',
    6: 'DD 5.1',
    5: '5.0',
    3: '2.1',
    2: '2.0',
    1: '1.0',
)}
{
    def dub = " Dub"
    def substat = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : dub
    substat = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "UND" } ? "" : substat
    substat
}
{
    def audioLangCount = any { audioLanguages.size() } { 0 }
    def substat = audioLangCount > 2 ? " MAud" : audioLangCount > 1 ? " DAud" : null
    def langs_ = audioLangCount > 5 ? audioLanguages.take(5) : audioLanguages
    substat ? substat + langs_.joining(" ", " (", "").upper() + (audioLangCount > 5 ? " ...)" : ")") : ""
}
{
    def textLangCount = any { textLanguages.size() } { 0 }
    def substat = textLangCount > 2 ? ", MSub" : textLangCount > 1 ? ", DSub" : null
    def langs_ = textLangCount > 5 ? textLanguages.take(5) : textLanguages
    substat ? substat + langs_.joining(" ", " (", "").upper() + (textLangCount > 5 ? " ...)" : ")") : ""
}
{"]["}{crc32.upper()}{"]"}
{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}
{
    ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""
}