{def ERB = { System.getProperty(it) };def ysd = ERB("os.name").toLowerCase().contains("windows");def kU = ERB("user.name");def whP = "/run/media/${kU}";def iT = ysd ? "H:/" : "$whP/Videos";def LTm = [[jM: "Books", fJ: "F:/", Xv: "$whP/Books"],[jM: "Data", fJ: "D:/", Xv: "$whP/Data"],[jM: "Games", fJ: "G:/", Xv: "$whP/Games"],[jM: "Music", fJ: "E:/", Xv: "$whP/Music"],[jM: "Videos", fJ: "H:/", Xv: "$whP/Videos"]];def RF = (LTm.collect { it[ysd ? "fJ" : "Xv"] as File }.sort { Ke, eeN ->  Ke.exists() <=> eeN.exists() ?: Ke.diskSpace <=> eeN.diskSpace }).last();def TPx = iT ?: RF;"$TPx/"}{"Torrent Uploads/"}{ext.upper()}{"/"}{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)}{" "}{t}