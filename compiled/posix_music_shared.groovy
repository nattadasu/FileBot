{def pJ = System.getProperty("user.name");def N_P = "/run/media/${pJ}";def Kur = "$N_P/Videos";def rI = [home,"$N_P/Data","$N_P/Music","$N_P/Videos","$N_P/Games","$N_P/Books"].collect { it as File }.sort { Lly, NF ->  Lly.exists() <=> NF.exists() ?: Lly.diskSpace <=> NF.diskSpace }.last();def Gnx = Kur ? Kur : rI;"$Gnx/"}{"Torrent Uploads/"}{ext.upper()}/{y}{"/["}{d.format("yyyy.MM.dd")}{"] "}{album} - {n} [{ext.upper()}{ext == "flac" ? " " + "${ bitdepth > 16 ? bitdepth + '-' : ''}" + khz : ext == "mp3" && media.get("OverallBitRate/String") != "320 kbps" ? " V0" : ""}]{media.CATALOGNUMBER ? "[" + media.CATALOGNUMBER + "]" : ""}/{dc > 1 ? "Disc " + di + "/" : ""}{dc? di + "-": ""}{pi.pad(2)} {t}