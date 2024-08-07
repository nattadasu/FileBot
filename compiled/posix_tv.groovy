{
    def user = System.getProperty("user.name")
    def mntp = "/run/media/$user"
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
        [series_id: 237045, title: "Chery Magic!"],
        [series_id: 260840, title: "Whimsical Wish"]
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
		239779, 112888
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
    fixed_name == 'Season '+ s ? "" : fixed_name ? " - " + fixed_name : ""
}
{"/"}{
    def customGroups = [
        "NanDesuKa",
        "ToonsHub",
        "Tsundere-Raws",
        "BlackLuster"
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
    group_ ? "[$group_]" : ""
}
{" "}
{
    def short_title = [
        [series_id: 229743, title: "VTuber Legend"],
        [series_id: 240633, title: "A Journey Through Another World"],
        [series_id: 245285, title: "Failure Frame"],
        [series_id: 237045, title: "Chery Magic!"],
        [series_id: 260840, title: "Whimsical Wish"]
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
{" - "}{s00e00}{" - "}
{
    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = t.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name
}
{" ["}
{
    def customRelease = [
        "AMZN",
        "B-Global",
        "UNEXT",
        "ABEMA",
        "HULU",
        "iQ",
        "YT"
    ]
    def finalRelease = customRelease.find { releaseName -> fn.contains(releaseName) } ?: ""
    def release_ = any {
        finalRelease ? finalRelease + ".WEB-DL" : ""
    } {
        source
    } {
        ""
    }
    release_ ? "$release_ " : ""
}
{resolution} {vcf} {bitdepth}Bit, {ac}
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
    def n = any{audioLanguages.size()}{0}
    def substat = n > 2 ? " Multi-Audio" : n > 1 ? " Dual-Audio" : null
    def langs_ = audioLanguages.size() > 5 ? audioLanguages.take(5) : audioLanguages
    substat ? substat + langs_.joining(" ", " (", "").upper() + {audioLanguages.size() > 5 ? " ...)" : ")"}: ""
}
{
    def n = any{textLanguages.size()}{0}
    def substat = n > 2 ? ", Multi-Subs" : n > 1 ? ", Dual-Subs" : null
    def langs_ = textLanguages.size() > 5 ? textLanguages.take(5) : textLanguages
    substat ? substat + langs_.joining(" ", " (", "").upper() + {textLanguages.size() > 5 ? " ...)" : ")"}: ""
}
{"]["}{crc32.upper()}{"]"}
{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B: ""}
{
    ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""
}