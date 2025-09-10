@./releasesource.groovy
{
    def bdepth = bitdepth ? " ${bitdepth}bit" : ""
    "$resolution $vcf $bdepth, $ac"
}
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
    def audioLangCount = any { audioLanguages.size() } { 0 }
    def substat = audioLangCount > 2 ? " MULTi-AUD" : audioLangCount > 1 ? " DUAL-AUD" : ""
    def langs_ = audioLangCount > 5 ? audioLanguages.take(5) : audioLanguages
    def dub = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : " DUBBED"
    substat = audioLangCount == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : "$substat$dub"
    substat ? substat + langs_.ISO2.joining(" ", " (", "").upper() + (audioLangCount > 5 ? " ...)" : ")") : ""
    // substat
}
{
    def text_arr = text.language.collect {
        ['zh-Hans': 'ZH-S',
         'zh-Hant': 'ZH-T',
         'ar-001': 'AR-MSA',
        ].get(it,it).toUpperCase()
    }.unique()
    def textLangCount = any { text_arr.size() } { 0 }
    def substat = textLangCount > 2 ? ", MULTi" : textLangCount > 1 ? ", DUAL" : textLangCount == 1 ? ", SUB" : null
    def langs_ = textLangCount > 5 ? text_arr.take(5) : text_arr
    substat ? substat + langs_.joining(" ", " (", "").upper() + (textLangCount > 6 ? " ...)" : ")") : ""
    // substat
}
{"]["}{crc32.upper()}{"]"}
{
    if (f.subtitle) {
        def langcode = [
            "name": "." + lang.name,
            "iso3b": "." + lang.ISO3B,
            "iso3": "." +lang.ISO3,
            "iso2": "." + lang.ISO2,
        ]
        // Clean subt variable if any on langcode exists
        def cleanedSubt = subt
        langcode.values().each { code ->
            if (cleanedSubt.contains(code)) {
                cleanedSubt = cleanedSubt.replace(code, "")
            }
        }
        langcode.iso3b + cleanedSubt
    }
}
{
    // Jellyfin >=10.9 default thumbnail name
    f.image ? "-thumb" : ""
}
