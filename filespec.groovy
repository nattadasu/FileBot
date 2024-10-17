{" ["}
@./releasesource.groovy
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
    def dub = audiolanguages.any { it.ISO3B != language.ISO3B } ? "Dub" : null
    // if theres "und" language, set to null
    dub = audiolanguages.any { it.ISO3B == "und" } ? null : dub
    dub ? " ${dub}" : ""
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
    // Jellyfin 10.9.* default thumbnail name
    ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""
}
