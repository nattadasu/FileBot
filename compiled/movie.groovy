{def DR = { System.getProperty(it) };def ysx = DR("os.name").toLowerCase().contains("windows");def fG = DR("user.name");def Rr = "/run/media/${fG}";def yf = ysx ? "H:/" : "$Rr/Videos";def CK = [[Oe: "Books", StO: "F:/", via: "$Rr/Books"],[Oe: "Data", StO: "D:/", via: "$Rr/Data"],[Oe: "Games", StO: "G:/", via: "$Rr/Games"],[Oe: "Music", StO: "E:/", via: "$Rr/Music"],[Oe: "Videos", StO: "H:/", via: "$Rr/Videos"]];def rt = (CK.collect { it[ysx ? "StO" : "via"] as File }.sort { qCV, DBv ->  qCV.exists() <=> DBv.exists() ?: qCV.diskSpace <=> DBv.diskSpace }).last();def djM = yf ?: rt;"$djM/"}{"Videos/"}{def mD = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def LpY = "TheMovieDB::TV";def Vq = [[ 74180, LpY],[ 93821, LpY],[ 95897, LpY],[220118, LpY],[249891, LpY],[271026, LpY]];def MB = [[236530, LpY]];def VkA = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def ZrI = VkA == "IMDb" ? "tt${id}" : id;def MXk = any { info.adult } { false };def qNr = Vq.find { it[0] == ZrI && it[1] == VkA } != null;def TV = MB.find { it[0] == ZrI && it[1] == VkA } != null;def swj = info.Keywords.findAll { it in mD } || qNr || MXk;swj = TV ? false : swj;swj ? "R18+ " : ""}{def CPe = ["CN", "JP", "KR", "KP", "TW", "HK"];def xXO = ["aeni", "donghua", "anime"];def sWR = any {anime} || info.Keywords.findAll { it in xXO } || (CPe.contains(country) && genres =~ /Animation/);sWR ? "Anime Movies/" : "Movies/"}{def LpY = "TheMovieDB::TV";def duq = [[zuL: 68854, FNF: "From Me to You", Pj: LpY],[zuL: 100937, FNF: "Crazy Over His Fingers", Pj: LpY],[zuL: 199928, FNF: "Nights With a Cat", Pj: LpY],[zuL: 219816, FNF: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", Pj: LpY],[zuL: 245561, FNF: "Okitsura", Pj: LpY],[zuL: 248707, FNF: "Neko Oji The Guy That Got Reincarnated As a Cat", Pj: LpY],[zuL: 259559, FNF: "Headhunted to Another World", Pj: LpY],[zuL: 261301, FNF: "Botsuraku Kizoku", Pj: LpY],[zuL: 262141, FNF: "Can You Keep a Secret", Pj: LpY],[zuL: 270657, FNF: "Tono to Inu", Pj: LpY],[zuL: 276204, FNF: "Bogus Skill Fruitmaster", Pj: LpY]];def VkA = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def ZrI = VkA == "IMDb" ? "tt${id}" : id;def xL = n;duq.each {if (it.zuL == ZrI && it.Pj == VkA) {xL = it.FNF}};def Is = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def vA = xL.replaceAll(Is.collect { "\\" + it }.join('|'), '');vA = vA.replaceAll(/(\s|\.)*$/, '');vA}{" ("}{y}{")"}{"/"}{def Ob = ["Alqanime","BlackLuster","darkflux","It's Anime","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def GIp = Ob.find { SPz ->  fn.lower().contains(SPz.lower()) } ?: "";def mR = any {GIp} {(fn =~ /^\[(.*?)\]/)[0][1]} {group} {""};mR ? "[$mR] " : ""}{def LpY = "TheMovieDB::TV";def duq = [[zuL: 68854, FNF: "From Me to You", Pj: LpY],[zuL: 100937, FNF: "Crazy Over His Fingers", Pj: LpY],[zuL: 199928, FNF: "Nights With a Cat", Pj: LpY],[zuL: 219816, FNF: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", Pj: LpY],[zuL: 245561, FNF: "Okitsura", Pj: LpY],[zuL: 248707, FNF: "Neko Oji The Guy That Got Reincarnated As a Cat", Pj: LpY],[zuL: 259559, FNF: "Headhunted to Another World", Pj: LpY],[zuL: 261301, FNF: "Botsuraku Kizoku", Pj: LpY],[zuL: 262141, FNF: "Can You Keep a Secret", Pj: LpY],[zuL: 270657, FNF: "Tono to Inu", Pj: LpY],[zuL: 276204, FNF: "Bogus Skill Fruitmaster", Pj: LpY]];def VkA = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def ZrI = VkA == "IMDb" ? "tt${id}" : id;def xL = n;duq.each {if (it.zuL == ZrI && it.Pj == VkA) {xL = it.FNF}};def Is = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def vA = xL.replaceAll(Is.collect { "\\" + it }.join('|'), '');vA = vA.replaceAll(/(\s|\.)*$/, '');vA}{" ("}{y}{") ["}{def ZN = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["CMIC", "COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["OVEIL", "OV.WEB-DL", "OceanVeil"],["SHAHID"],["TVER"],["UNEXT"],["WETV"]];def uEx = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def ErV = ["DB"];def Qf = ["Ruri-Saizen"];def qLW = ["Erai-raws", "SubsPlease"];def PV = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def hD = any {def Oi = ZN.find { FY ->  FY.find { tJ ->  fn.lower().contains(tJ.lower()) } }[0];Oi = Oi.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {Oi = Oi.replace(".WEBRip", "");Oi = Oi + ".WEBRip"} else {Oi = Oi + ".WEB-DL"};Oi} {source} {uEx.find { cqW ->  group == cqW || PV == cqW } ? "WEBRip" : ""} {ErV.find { cqW ->  group == cqW || PV == cqW } ? "BDRip" : ""} {Qf.find { cqW ->  group == g__ || PV == g__} ? "HDTVRip" : ""} {def uI = qLW.find { ijW ->  group == ijW || PV == ijW} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : uI} {vs} {""};hD ? "$hD " : ""}{def dDn = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $dDn, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def Ehf = any { audioLanguages.size() } { 0 };def aS = Ehf > 2 ? " MULTi-AUD" : Ehf > 1 ? " DUAL-AUD" : null;def qRZ = Ehf > 5 ? audioLanguages.take(5) : audioLanguages;aS ? aS + qRZ.ISO2.joining(" ", " (", "").upper() + (Ehf > 5 ? " ...)" : ")") : ""}{def MyJ = " DUBBED";def aS = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : MyJ;aS = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : aS;aS}{def jh = any { textLanguages.size() } { 0 };def aS = jh > 2 ? ", MULTi" : jh > 1 ? ", DUAL" : jh == 1 ? ", SUB" : null;def qRZ = jh > 5 ? textLanguages.take(5) : textLanguages;aS ? aS + qRZ.ISO2.joining(" ", " (", "").upper() + (jh > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def GG = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def fxq = subt;GG.values().each { Gz -> if (fxq.contains(Gz)) {fxq = fxq.replace(Gz, "")}};GG.iso3b + fxq}}{f.image ? "-thumb" : ""}