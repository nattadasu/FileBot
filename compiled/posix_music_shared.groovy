{def EYy = System.getProperty("user.name");def mC = "/run/media/${EYy}";def lCh = "$mC/Videos";def uUV = [home,"$mC/Data","$mC/Music","$mC/Videos","$mC/Games","$mC/Books"].collect { it as File }.sort { VPN, Aei ->  VPN.exists() <=> Aei.exists() ?: VPN.diskSpace <=> Aei.diskSpace }.last();def dg = lCh ? lCh : uUV;"$dg/"}{"Torrent Uploads/"}{ext.upper()}{"/"}{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)}{" "}{t}