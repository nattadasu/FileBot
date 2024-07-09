 [{source ? "$source " : ""}
{resolution} {vcf} {bitdepth}Bit, {ac}
 {af.format(
    8: 'DD+ 7.1',
    7: '6.1',
    6: 'DD 5.1',
    5: '5.0',
    3: '2.1',
    2: '2.0',
    1: '1.0',
)}
{def n = any{audioLanguages.size()}{0}
    def substat = n > 2 ? " Multi-Audio" : n > 1 ? " Dual-Audio" : null
    def langs_ = audioLanguages
    // if langs_ more than 3, return as empty, this is to avoid long filenames
    if (langs_.size() > 3) {
        langs_ = []
    }
    substat ? substat + langs_.joining(" ", " (", ")").upper(): ""}
{def n = any{textLanguages.size()}{0}
    def substat = n > 2 ? ", Multi-Subs" : n > 1 ? ", Dual-Subs" : null
    def langs_ = textLanguages
    // if langs_ more than 3, return as empty
    if (langs_.size() > 3) {
        langs_ = []
    }
    substat ? substat + langs_.joining(" ", " (", ")").upper(): ""}
][{crc32.upper()}]
{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B: ""}
{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}