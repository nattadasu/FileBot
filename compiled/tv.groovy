{def LMq = { System.getProperty(it) };def Jf = LMq("os.name").toLowerCase().contains("windows");def eV = LMq("user.name");def Bn = "/run/media/${eV}";def XpF = Jf ? "H:/" : "$Bn/Videos";def WL = [[Hul: "Books", rd: "F:/", sW: "$Bn/Books"],[Hul: "Data", rd: "D:/", sW: "$Bn/Data"],[Hul: "Games", rd: "G:/", sW: "$Bn/Games"],[Hul: "Music", rd: "E:/", sW: "$Bn/Music"],[Hul: "Videos", rd: "H:/", sW: "$Bn/Videos"]];def UoH = (WL.collect { it[Jf ? "rd" : "sW"] as File }.sort { Yk, dA ->  Yk.exists() <=> dA.exists() ?: Yk.diskSpace <=> dA.diskSpace }).last();def lr = XpF ?: UoH;"$lr/"}{"Videos/"}{def Pp = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity"];def JvW = "TheMovieDB::TV";def YG = [[ 74180, JvW],[ 93821, JvW],[ 95897, JvW],[220118, JvW],[271026, JvW]];def kPM = [[236530, JvW]];def ggF = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def Gh = ggF == "IMDb" ? "tt${id}" : id;def qyZ = any { info.adult } { false };def Gy = YG.find { it[0] == Gh && it[1] == ggF } != null;def AjU = kPM.find { it[0] == Gh && it[1] == ggF } != null;def Tf = info.Keywords.findAll { it in Pp } || Gy || qyZ;Tf = AjU ? false : Tf;Tf ? "R18+ " : ""}{def wfT = ["CN", "JP", "KR", "KP", "TW", "HK"];def XpB = ["aeni", "donghua", "anime"];def re = any {anime} || info.Keywords.findAll { it in XpB } || (wfT.contains(country) && genres =~ /Animation/);re ? "Anime/" : "TV Series/"}{def JvW = "TheMovieDB::TV";def ap = [[Ni: 68854, api: "From Me to You", MhD: JvW],[Ni: 219816, api: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", MhD: JvW],[Ni: 245561, api: "Okitsura", MhD: JvW],[Ni: 248707, api: "Neko Oji The Guy That Got Reincarnated As a Cat", MhD: JvW],[Ni: 259559, api: "Headhunted to Another World", MhD: JvW],[Ni: 261301, api: "Botsuraku Kizoku", MhD: JvW],[Ni: 262141, api: "Can You Keep a Secret", MhD: JvW],[Ni: 270657, api: "Tono to Inu", MhD: JvW],[Ni: 276204, api: "Bogus Skill Fruitmaster", MhD: JvW]];def ggF = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def Gh = ggF == "IMDb" ? "tt${id}" : id;def UF = n;ap.each {if (it.Ni == Gh && it.MhD == ggF) {UF = it.api}};def AVM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ZwJ = UF.replaceAll(AVM.collect { "\\" + it }.join('|'), '');ZwJ = ZwJ.replaceAll(/(\s|\.)*$/, '');ZwJ}{def JvW = "TheMovieDB::TV";def Mw = [[ 95897, JvW],[123542, JvW],[235973, JvW],[239779, JvW],[257162, JvW],[259140, JvW],[276204, JvW]];def Oks = Mw.find { it[0] == id && it[1] == info.database } != null;def vA = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def bk = vA[info.database];Oks ? " ($y) [${bk}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def AVM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ZwJ = sn.replaceAll(AVM.collect { "\\" + it }.join('|'), '_');def uY = n.replaceAll(AVM.collect { "\\" + it }.join('|'), '_');def Bgb = ZwJ.contains(uY) ? "" : ZwJ;Bgb == 'Season '+ s ? "" : Bgb ? " - " + Bgb : ""}{"/"}{def vd = ["Alqanime","BlackLuster","darkflux","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def yU = vd.find { nZ ->  fn.lower().contains(nZ.lower()) } ?: "";def iL = any {(fn =~ /^\[(.*?)\]/)[0][1]} {yU} {group} {""};iL ? "[$iL] " : ""}{def JvW = "TheMovieDB::TV";def ap = [[Ni: 68854, api: "From Me to You", MhD: JvW],[Ni: 219816, api: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", MhD: JvW],[Ni: 245561, api: "Okitsura", MhD: JvW],[Ni: 248707, api: "Neko Oji The Guy That Got Reincarnated As a Cat", MhD: JvW],[Ni: 259559, api: "Headhunted to Another World", MhD: JvW],[Ni: 261301, api: "Botsuraku Kizoku", MhD: JvW],[Ni: 262141, api: "Can You Keep a Secret", MhD: JvW],[Ni: 270657, api: "Tono to Inu", MhD: JvW],[Ni: 276204, api: "Bogus Skill Fruitmaster", MhD: JvW]];def ggF = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def Gh = ggF == "IMDb" ? "tt${id}" : id;def UF = n;ap.each {if (it.Ni == Gh && it.MhD == ggF) {UF = it.api}};def AVM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ZwJ = UF.replaceAll(AVM.collect { "\\" + it }.join('|'), '');ZwJ = ZwJ.replaceAll(/(\s|\.)*$/, '');ZwJ}{" - "}{s00e00}{def AVM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ZwJ = t.replaceAll(AVM.collect { "\\" + it }.join('|'), '_');ZwJ = ZwJ.length() > 100 ? " " : " - $ZwJ ";def Nxa = any { e } { special };def TK = "Episode $Nxa";def exF = ZwJ.contains(TK) ? '' : ZwJ;exF != '' ? exF : ''}{" ["}{def VcG = [["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"],["COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["SHAHID"],["TVER"],["UNEXT"],["WETV"],["YTB", "YT.WEB-DL", "YOUTUBE"]];def Nzo = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def JEf = ["Erai-raws", "SubsPlease"];def XP = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def QF = any {def JUz = VcG.find { OA ->  OA.find { iJ ->  fn.lower().contains(iJ.lower()) } }[0];JUz = JUz.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {JUz = JUz.replace(".WEBRip", "");JUz = JUz + ".WEBRip"} else {JUz = JUz + ".WEB-DL"};JUz} {source} {Nzo.find { g_q ->  group == g_q || XP == g_q } ? "WEBRip" : ""} {def YQg = JEf.find { hhv ->  group == hhv || XP == hhv} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : YQg} {vs} {""};QF ? "$QF " : ""}{def RgF = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $RgF, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def LzN = " Dub";def pF = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : LzN;pF = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : pF;pF}{def VBA = any { audioLanguages.size() } { 0 };def pF = VBA > 2 ? " MAud" : VBA > 1 ? " DAud" : null;def cK = VBA > 5 ? audioLanguages.take(5) : audioLanguages;pF ? pF + cK.joining(" ", " (", "").upper() + (VBA > 5 ? " ...)" : ")") : ""}{def ALe = any { textLanguages.size() } { 0 };def pF = ALe > 2 ? ", MSub" : ALe > 1 ? ", DSub" : null;def cK = ALe > 5 ? textLanguages.take(5) : textLanguages;pF ? pF + cK.joining(" ", " (", "").upper() + (ALe > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def GDz = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def vkX = subt;GDz.values().each { iu -> if (vkX.contains(iu)) {vkX = vkX.replace(iu, "")}};GDz.iso3b + vkX}}{f.image ? "-thumb" : ""}