{" ["}
@./releasesource.groovy
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
][{crc32.upper()}]
{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B: ""}
{
    // Jellyfin 10.9.* default thumbnail name
    ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""
}
