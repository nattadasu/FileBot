{def tVN = { System.getProperty(it) };def tWI = tVN("os.name").toLowerCase().contains("windows");def yxJ = tVN("user.name");def qZb = "/run/media/${yxJ}";def wp = tWI ? "H:/" : "$qZb/Videos";def Cw = [[ynX: "Books", BO: "F:/", Ptn: "$qZb/Books"],[ynX: "Data", BO: "D:/", Ptn: "$qZb/Data"],[ynX: "Games", BO: "G:/", Ptn: "$qZb/Games"],[ynX: "Music", BO: "E:/", Ptn: "$qZb/Music"],[ynX: "Videos", BO: "H:/", Ptn: "$qZb/Videos"]];def yS = (Cw.collect { it[tWI ? "BO" : "Ptn"] as File }.sort { EUq, YZ ->  EUq.exists() <=> YZ.exists() ?: EUq.diskSpace <=> YZ.diskSpace }).last();def wK = wp ?: yS;"$wK/"}{"Videos/"}{def GEX = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def PmB = "TheMovieDB::TV";def Jn = [[ 74180, PmB],[ 93821, PmB],[ 95897, PmB],[220118, PmB],[249891, PmB],[271026, PmB]];def kxP = [[236530, PmB]];def OrI = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def QG = OrI == "IMDb" ? "tt${id}" : id;def HGc = any { info.adult } { false };def fWP = Jn.find { it[0] == QG && it[1] == OrI } != null;def Xrl = kxP.find { it[0] == QG && it[1] == OrI } != null;def yY = info.Keywords.findAll { it in GEX } || fWP || HGc;yY = Xrl ? false : yY;yY ? "R18+ " : ""}{def lMN = ["CN", "JP", "KR", "KP", "TW", "HK"];def ZH = ["aeni", "donghua", "anime"];def qWk = any {anime} || info.Keywords.findAll { it in ZH } || (lMN.contains(country) && genres =~ /Animation/);qWk ? "Anime Movies/" : "Movies/"}{def PmB = "TheMovieDB::TV";def Tp = [[kH: 68854, XNx: "From Me to You", wW: PmB],[kH: 100937, XNx: "Crazy Over His Fingers", wW: PmB],[kH: 199928, XNx: "Nights With a Cat", wW: PmB],[kH: 219816, XNx: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", wW: PmB],[kH: 245561, XNx: "Okitsura", wW: PmB],[kH: 248707, XNx: "Neko Oji The Guy That Got Reincarnated As a Cat", wW: PmB],[kH: 259559, XNx: "Headhunted to Another World", wW: PmB],[kH: 261301, XNx: "Botsuraku Kizoku", wW: PmB],[kH: 262141, XNx: "Can You Keep a Secret", wW: PmB],[kH: 270657, XNx: "Tono to Inu", wW: PmB],[kH: 276204, XNx: "Bogus Skill Fruitmaster", wW: PmB]];def OrI = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def QG = OrI == "IMDb" ? "tt${id}" : id;def NO = n;Tp.each {if (it.kH == QG && it.wW == OrI) {NO = it.XNx}};def HK = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Wk = NO.replaceAll(HK.collect { "\\" + it }.join('|'), '');Wk = Wk.replaceAll(/(\s|\.)*$/, '');Wk}{" ("}{y}{")"}{"/"}{def dTp = ["Alqanime","BlackLuster","darkflux","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def wVS = dTp.find { wLY ->  fn.lower().contains(wLY.lower()) } ?: "";def GO = any {(fn =~ /^\[(.*?)\]/)[0][1]} {wVS} {group} {""};GO ? "[$GO] " : ""}{def PmB = "TheMovieDB::TV";def Tp = [[kH: 68854, XNx: "From Me to You", wW: PmB],[kH: 100937, XNx: "Crazy Over His Fingers", wW: PmB],[kH: 199928, XNx: "Nights With a Cat", wW: PmB],[kH: 219816, XNx: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", wW: PmB],[kH: 245561, XNx: "Okitsura", wW: PmB],[kH: 248707, XNx: "Neko Oji The Guy That Got Reincarnated As a Cat", wW: PmB],[kH: 259559, XNx: "Headhunted to Another World", wW: PmB],[kH: 261301, XNx: "Botsuraku Kizoku", wW: PmB],[kH: 262141, XNx: "Can You Keep a Secret", wW: PmB],[kH: 270657, XNx: "Tono to Inu", wW: PmB],[kH: 276204, XNx: "Bogus Skill Fruitmaster", wW: PmB]];def OrI = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def QG = OrI == "IMDb" ? "tt${id}" : id;def NO = n;Tp.each {if (it.kH == QG && it.wW == OrI) {NO = it.XNx}};def HK = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Wk = NO.replaceAll(HK.collect { "\\" + it }.join('|'), '');Wk = Wk.replaceAll(/(\s|\.)*$/, '');Wk}{" ("}{y}{") ["}{def F_k = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["CMIC", "COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["OVEIL", "OceanVeil"],["SHAHID"],["TVER"],["UNEXT"],["WETV"]];def Dc = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def jq = ["DB"];def uC = ["Ruri-Saizen"];def sgX = ["Erai-raws", "SubsPlease"];def Vi = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def My = any {def ZU = F_k.find { PzL ->  PzL.find { WZk ->  fn.lower().contains(WZk.lower()) } }[0];ZU = ZU.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {ZU = ZU.replace(".WEBRip", "");ZU = ZU + ".WEBRip"} else {ZU = ZU + ".WEB-DL"};ZU} {source} {Dc.find { TY ->  group == TY || Vi == TY } ? "WEBRip" : ""} {jq.find { TY ->  group == TY || Vi == TY } ? "BDRip" : ""} {uC.find { TY ->  group == g__ || Vi == g__} ? "HDTVRip" : ""} {def iMU = sgX.find { lRK ->  group == lRK || Vi == lRK} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : iMU} {vs} {""};My ? "$My " : ""}{def qUV = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $qUV, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def fz = any { audioLanguages.size() } { 0 };def JL = fz > 2 ? " MULTi-AUD" : fz > 1 ? " DUAL-AUD" : null;def ZrS = fz > 5 ? audioLanguages.take(5) : audioLanguages;JL ? JL + ZrS.ISO2.joining(" ", " (", "").upper() + (fz > 5 ? " ...)" : ")") : ""}{def aYh = " DUBBED";def JL = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : aYh;JL = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : JL;JL}{def wn = any { textLanguages.size() } { 0 };def JL = wn > 2 ? ", MULTi" : wn > 1 ? ", DUAL" : wn == 1 ? ", SUB" : null;def ZrS = wn > 5 ? textLanguages.take(5) : textLanguages;JL ? JL + ZrS.ISO2.joining(" ", " (", "").upper() + (wn > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def hiW = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def CXn = subt;hiW.values().each { NEO -> if (CXn.contains(NEO)) {CXn = CXn.replace(NEO, "")}};hiW.iso3b + CXn}}{f.image ? "-thumb" : ""}