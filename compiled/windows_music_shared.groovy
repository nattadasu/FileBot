{def vyS = System.getProperty("user.name");def Yyi = "/run/media/${vyS}";def _RO = "$Yyi/Videos";def XnM = [home,"$Yyi/Data","$Yyi/Music","$Yyi/Videos","$Yyi/Games","$Yyi/Books"].collect { it as File }.sort { NU, lE_ ->  NU.exists() <=> lE_.exists() ?: NU.diskSpace <=> lE_.diskSpace }.last();def Ic = _RO ? _RO : XnM;"$Ic/"}{"Torrent Uploads/"}{ext.upper()}/{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album} - {n} [{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}]{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}/{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)} {t}