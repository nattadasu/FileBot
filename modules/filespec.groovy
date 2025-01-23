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
    def dub = " Dub"
    // if audioLanguages contains language, blank out dub
    def substat = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : dub
    substat = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : substat
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
