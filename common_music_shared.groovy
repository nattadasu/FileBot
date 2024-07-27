{ext.upper()}/
{y}/
[
{d.format("yyyy.MM.dd")}
] {album} - {n} [
{ext.upper()}
{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ""}
]
{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}/
{dc? di + "-": ""}{pi.pad(2)} {t}
{media.ISRC ? " [" + media.ISRC + "]" : ""}