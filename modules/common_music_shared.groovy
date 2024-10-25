{"Torrent Uploads/"}
{ext.upper()}{"/"}
{y}{"/["}
{d.format("yyyy.MM.dd")}
{"] "}{album}{" - "}{n}{" ["}
{ext.upper()}
{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}
{"]"}
{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}
{dc > 1 ? "Disc " + di + "/" : ""}
{dc? di + "-": ""}{pi.pad(2)}{" "}{t}
