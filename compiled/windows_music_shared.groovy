{def kp = System.getProperty("user.name");def yO = "/run/media/${kp}";def RSr = "$yO/Videos";def ZVZ = [home,"$yO/Data","$yO/Music","$yO/Videos","$yO/Games","$yO/Books"].collect { it as File }.sort { cV, gW ->  cV.exists() <=> gW.exists() ?: cV.diskSpace <=> gW.diskSpace }.last();def LPE = RSr ? RSr : ZVZ;"$LPE/"}{"Torrent Uploads/"}{ext.upper()}/{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album} - {n} [{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}]{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}/{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)} {t}