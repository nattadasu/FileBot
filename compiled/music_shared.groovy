{def JoZ = { System.getProperty(it) };def SWL = JoZ("os.name").toLowerCase().contains("windows");def Wb = JoZ("user.name");def FnB = "/run/media/${Wb}";def Vg = SWL ? "H:/" : "$FnB/Videos";def QZX = [[Gcw: "Books", IRh: "F:/", qWY: "$FnB/Books"],[Gcw: "Data", IRh: "D:/", qWY: "$FnB/Data"],[Gcw: "Games", IRh: "G:/", qWY: "$FnB/Games"],[Gcw: "Music", IRh: "E:/", qWY: "$FnB/Music"],[Gcw: "Videos", IRh: "H:/", qWY: "$FnB/Videos"]];def Jmq = (QZX.collect { it[SWL ? "IRh" : "qWY"] as File }.sort { Phy, HR ->  Phy.exists() <=> HR.exists() ?: Phy.diskSpace <=> HR.diskSpace }).last();def Ns = Vg ?: Jmq;"$Ns/"}{"Torrent Uploads/"}{ext.upper()}{"/"}{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)}{" "}{t}