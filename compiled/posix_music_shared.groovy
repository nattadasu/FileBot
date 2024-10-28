{
def user = System.getProperty("user.name")
def mntp = "/run/media/$user"
def override = "$mntp/Videos"
def guess = [home,"$mntp/Data","$mntp/Music","$mntp/Videos","$mntp/Games","$mntp/Books"].collect { it as File }.sort { a, b -> a.exists() <=> b.exists() ?: a.diskSpace <=> b.diskSpace }.last()
def final_ = override ? override : guess
"$final_/"
}
{"Torrent Uploads/"}
{ext.upper()}{"/"}
{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}
{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}
{dc > 1 ? "Disc " + di + "/" : ""}
{dc? di + "-": ""}{pi.pad(2)}{" "}{t}