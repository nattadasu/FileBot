{def Abj = { System.getProperty(it) };def CwN = Abj("os.name").toLowerCase().contains("windows");def gW = Abj("user.name");def SbI = "/run/media/${gW}";def paK = CwN ? "H:/" : "$SbI/Videos";def TSq = [[Lw: "Books", ywC: "F:/", dMT: "$SbI/Books"],[Lw: "Data", ywC: "D:/", dMT: "$SbI/Data"],[Lw: "Games", ywC: "G:/", dMT: "$SbI/Games"],[Lw: "Music", ywC: "E:/", dMT: "$SbI/Music"],[Lw: "Videos", ywC: "H:/", dMT: "$SbI/Videos"]];def Vnb = (TSq.collect { it[CwN ? "ywC" : "dMT"] as File }.sort { uh, Av ->  uh.exists() <=> Av.exists() ?: uh.diskSpace <=> Av.diskSpace }).last();def Nc = paK ?: Vnb;"$Nc/"}{"Videos/"}{def Pu = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def zY = "TheMovieDB::TV";def gx = [[ 74180, zY],[ 93821, zY],[ 95897, zY],[220118, zY],[249891, zY],[271026, zY]];def fQG = [[236530, zY]];def wl = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def ssm = wl == "IMDb" ? "tt${id}" : id;def sA = any { info.adult } { false };def ym = gx.find { it[0] == ssm && it[1] == wl } != null;def h_ = fQG.find { it[0] == ssm && it[1] == wl } != null;def nM = info.Keywords.findAll { it in Pu } || ym || sA;nM = h_ ? false : nM;nM ? "R18+ " : ""}{def Hsg = ["CN", "JP", "KR", "KP", "TW", "HK"];def HK = ["aeni", "donghua", "anime"];def hO = any {anime} || info.Keywords.findAll { it in HK } || (Hsg.contains(country) && genres =~ /Animation/);hO ? "Anime Movies/" : "Movies/"}{def zY = "TheMovieDB::TV";def UP = [[led: 68854, kyA: "From Me to You", MJw: zY],[led: 100937, kyA: "Crazy Over His Fingers", MJw: zY],[led: 199928, kyA: "Nights With a Cat", MJw: zY],[led: 219816, kyA: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", MJw: zY],[led: 245561, kyA: "Okitsura", MJw: zY],[led: 248707, kyA: "Neko Oji The Guy That Got Reincarnated As a Cat", MJw: zY],[led: 259559, kyA: "Headhunted to Another World", MJw: zY],[led: 261301, kyA: "Botsuraku Kizoku", MJw: zY],[led: 262141, kyA: "Can You Keep a Secret", MJw: zY],[led: 270657, kyA: "Tono to Inu", MJw: zY],[led: 276204, kyA: "Bogus Skill Fruitmaster", MJw: zY]];def wl = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def ssm = wl == "IMDb" ? "tt${id}" : id;def aJA = n;UP.each {if (it.led == ssm && it.MJw == wl) {aJA = it.kyA}};def jGm = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def PK = aJA.replaceAll(jGm.collect { "\\" + it }.join('|'), '');PK = PK.replaceAll(/(\s|\.)*$/, '');PK}{" ("}{y}{")"}{"/"}{def Lpy = ["Alqanime","BlackLuster","darkflux","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def AvJ = Lpy.find { Ppt ->  fn.lower().contains(Ppt.lower()) } ?: "";def aQ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {AvJ} {group} {""};aQ ? "[$aQ] " : ""}{def zY = "TheMovieDB::TV";def UP = [[led: 68854, kyA: "From Me to You", MJw: zY],[led: 100937, kyA: "Crazy Over His Fingers", MJw: zY],[led: 199928, kyA: "Nights With a Cat", MJw: zY],[led: 219816, kyA: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", MJw: zY],[led: 245561, kyA: "Okitsura", MJw: zY],[led: 248707, kyA: "Neko Oji The Guy That Got Reincarnated As a Cat", MJw: zY],[led: 259559, kyA: "Headhunted to Another World", MJw: zY],[led: 261301, kyA: "Botsuraku Kizoku", MJw: zY],[led: 262141, kyA: "Can You Keep a Secret", MJw: zY],[led: 270657, kyA: "Tono to Inu", MJw: zY],[led: 276204, kyA: "Bogus Skill Fruitmaster", MJw: zY]];def wl = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def ssm = wl == "IMDb" ? "tt${id}" : id;def aJA = n;UP.each {if (it.led == ssm && it.MJw == wl) {aJA = it.kyA}};def jGm = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def PK = aJA.replaceAll(jGm.collect { "\\" + it }.join('|'), '');PK = PK.replaceAll(/(\s|\.)*$/, '');PK}{" ("}{y}{") ["}{def rih = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["CMIC", "COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["OVEIL", "OV.WEB-DL", "OceanVeil"],["SHAHID"],["TVER"],["UNEXT"],["WETV"]];def _a = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def XEO = ["DB"];def Cr = ["Ruri-Saizen"];def gT = ["Erai-raws", "SubsPlease"];def cA = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def ViI = any {def wDd = rih.find { AMz ->  AMz.find { ryT ->  fn.lower().contains(ryT.lower()) } }[0];wDd = wDd.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {wDd = wDd.replace(".WEBRip", "");wDd = wDd + ".WEBRip"} else {wDd = wDd + ".WEB-DL"};wDd} {source} {_a.find { Xgn ->  group == Xgn || cA == Xgn } ? "WEBRip" : ""} {XEO.find { Xgn ->  group == Xgn || cA == Xgn } ? "BDRip" : ""} {Cr.find { Xgn ->  group == g__ || cA == g__} ? "HDTVRip" : ""} {def CAC = gT.find { Ab ->  group == Ab || cA == Ab} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : CAC} {vs} {""};ViI ? "$ViI " : ""}{def li = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $li, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def HXm = any { audioLanguages.size() } { 0 };def Db = HXm > 2 ? " MULTi-AUD" : HXm > 1 ? " DUAL-AUD" : null;def IOS = HXm > 5 ? audioLanguages.take(5) : audioLanguages;Db ? Db + IOS.ISO2.joining(" ", " (", "").upper() + (HXm > 5 ? " ...)" : ")") : ""}{def nm = " DUBBED";def Db = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : nm;Db = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : Db;Db}{def KxZ = any { textLanguages.size() } { 0 };def Db = KxZ > 2 ? ", MULTi" : KxZ > 1 ? ", DUAL" : KxZ == 1 ? ", SUB" : null;def IOS = KxZ > 5 ? textLanguages.take(5) : textLanguages;Db ? Db + IOS.ISO2.joining(" ", " (", "").upper() + (KxZ > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def WaO = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def YL = subt;WaO.values().each { dJk -> if (YL.contains(dJk)) {YL = YL.replace(dJk, "")}};WaO.iso3b + YL}}{f.image ? "-thumb" : ""}