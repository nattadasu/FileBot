{def Kr = System.getProperty("user.name");def HXA = "/run/media/${Kr}";def tnX = "$HXA/Videos";def kY = [home,"$HXA/Data","$HXA/Music","$HXA/Videos","$HXA/Games","$HXA/Books"].collect { it as File }.sort { XR, BFy ->  XR.exists() <=> BFy.exists() ?: XR.diskSpace <=> BFy.diskSpace }.last();def PuJ = tnX ? tnX : kY;"$PuJ/"}{"Torrent Uploads/"}{ext.upper()}{"/"}{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album}{" - "}{n}{" ["}{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}{"]"}{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}{"/"}{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)}{" "}{t}