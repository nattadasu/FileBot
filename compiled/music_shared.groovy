{def dxs = { System.getProperty(it) };def ieh = dxs("os.name").toLowerCase().contains("windows");def Cg = dxs("user.name");def zV = "/run/media/${Cg}";def MK = ieh ? "H:/" : "$zV/Videos";def fKI = [[rT: "Books", xa: "F:/", WYy: "$zV/Books"],[rT: "Data", xa: "D:/", WYy: "$zV/Data"],[rT: "Games", xa: "G:/", WYy: "$zV/Games"],[rT: "Music", xa: "E:/", WYy: "$zV/Music"],[rT: "Videos", xa: "H:/", WYy: "$zV/Videos"]];def OU = (fKI.collect { it[ieh ? "xa" : "WYy"] as File }.sort { j_, sSS ->  j_.exists() <=> sSS.exists() ?: j_.diskSpace <=> sSS.diskSpace }).last();def omD = MK ?: OU;"$omD/"}{"Torrent Uploads/"}{ext.upper()}{"/"}{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)}{" "}{t}