{def kyl = { System.getProperty(it) };def nnE = kyl("os.name").toLowerCase().contains("windows");def _p = kyl("user.name");def msy = "/run/media/${_p}";def Ab = nnE ? "H:/" : "$msy/Videos";def UZ = [[inO: "Books", DA: "F:/", Cl: "$msy/Books"],[inO: "Data", DA: "D:/", Cl: "$msy/Data"],[inO: "Games", DA: "G:/", Cl: "$msy/Games"],[inO: "Music", DA: "E:/", Cl: "$msy/Music"],[inO: "Videos", DA: "H:/", Cl: "$msy/Videos"]];def CFd = (UZ.collect { it[nnE ? "DA" : "Cl"] as File }.sort { jev, Yi ->  jev.exists() <=> Yi.exists() ?: jev.diskSpace <=> Yi.diskSpace }).last();def UQ = Ab ?: CFd;"$UQ/"}{"Torrent Uploads/"}{ext.upper()}{"/"}{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)}{" "}{t}