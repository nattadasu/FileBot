{def Nb = System.getProperty("user.name");def wNy = "/run/media/${Nb}";def PJ = "$wNy/Videos";def ag = [home,"$wNy/Data","$wNy/Music","$wNy/Videos","$wNy/Games","$wNy/Books"].collect { it as File }.sort { SPR, EAR ->  SPR.exists() <=> EAR.exists() ?: SPR.diskSpace <=> EAR.diskSpace }.last();def jEB = PJ ? PJ : ag;"$jEB/"}{"Torrent Uploads/"}{ext.upper()}/{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album} - {n} [{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}]{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}/{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)} {t}