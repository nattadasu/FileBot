{def rn = { System.getProperty(it) };def BVH = rn("os.name").toLowerCase().contains("windows");def luh = rn("user.name");def dIh = "/run/media/${luh}";def wBp = BVH ? "H:/" : "$dIh/Videos";def jeU = [[axE: "Books", JyG: "F:/", wQ: "$dIh/Books"],[axE: "Data", JyG: "D:/", wQ: "$dIh/Data"],[axE: "Games", JyG: "G:/", wQ: "$dIh/Games"],[axE: "Music", JyG: "E:/", wQ: "$dIh/Music"],[axE: "Videos", JyG: "H:/", wQ: "$dIh/Videos"]];def Sa = (jeU.collect { it[BVH ? "JyG" : "wQ"] as File }.sort { zuA, xgc ->  zuA.exists() <=> xgc.exists() ?: zuA.diskSpace <=> xgc.diskSpace }).last();def Ib = wBp ?: Sa;"$Ib/"}{"Videos/"}{def Oj = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def pn = "TheMovieDB::TV";def cXo = [[ 74180, pn],[ 93821, pn],[ 95897, pn],[220118, pn],[249891, pn],[271026, pn]];def GMg = [[236530, pn]];def Vo = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def MxL = Vo == "IMDb" ? "tt${id}" : id;def aO_ = any { info.adult } { false };def NE = cXo.find { it[0] == MxL && it[1] == Vo } != null;def zA = GMg.find { it[0] == MxL && it[1] == Vo } != null;def ep = info.Keywords.findAll { it in Oj } || NE || aO_;ep = zA ? false : ep;ep ? "R18+ " : ""}{def iyF = ["CN", "JP", "KR", "KP", "TW", "HK"];def NTu = ["aeni", "donghua", "anime"];def GZR = any {anime} || info.Keywords.findAll { it in NTu } || (iyF.contains(country) && genres =~ /Animation/);GZR ? "Anime Movies/" : "Movies/"}{def pn = "TheMovieDB::TV";def lBm = [[cfD: 199928, LN: "Nights With a Cat", il: pn],[cfD: 219816, LN: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", il: pn],[cfD: 248707, LN: "Neko Oji The Guy That Got Reincarnated As a Cat", il: pn],[cfD: 271003, LN: "Yandere Dark Elf", il: pn],[cfD: 274741, LN: "The Too-Perfect Saint", il: pn],[cfD: 281623, LN: "SHIROHIYO", il: pn],[cfD: 288419, LN: "Chikuwa Senki", il: pn]];def Vo = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def MxL = Vo == "IMDb" ? "tt${id}" : id;def _Zo = n;lBm.each {if (it.cfD == MxL && it.il == Vo) {_Zo = it.LN}};def RE = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ILI = _Zo.replaceAll(RE.collect { "\\" + it }.join('|'), '');ILI = ILI.replaceAll(/(\s|\.)*$/, '');ILI}{" ("}{y}{")"}{"/"}{def ufF = ["Alqanime","BlackLuster","darkflux","It's Anime","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def dGc = ufF.find { rD ->  fn.lower().contains(rD.lower()) } ?: "";def ng = any {dGc} {(fn =~ /^\[(.*?)\]/)[0][1]} {group} {""};ng ? "[$ng] " : ""}{def pn = "TheMovieDB::TV";def lBm = [[cfD: 199928, LN: "Nights With a Cat", il: pn],[cfD: 219816, LN: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", il: pn],[cfD: 248707, LN: "Neko Oji The Guy That Got Reincarnated As a Cat", il: pn],[cfD: 271003, LN: "Yandere Dark Elf", il: pn],[cfD: 274741, LN: "The Too-Perfect Saint", il: pn],[cfD: 281623, LN: "SHIROHIYO", il: pn],[cfD: 288419, LN: "Chikuwa Senki", il: pn]];def Vo = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def MxL = Vo == "IMDb" ? "tt${id}" : id;def _Zo = n;lBm.each {if (it.cfD == MxL && it.il == Vo) {_Zo = it.LN}};def RE = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ILI = _Zo.replaceAll(RE.collect { "\\" + it }.join('|'), '');ILI = ILI.replaceAll(/(\s|\.)*$/, '');ILI}{" ("}{y}{") ["}{def Z_ = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA", "ABEMATV"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["CMIC", "COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LFTL", "LAFTEL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["OVEIL", "OV.WEB-DL", "OceanVeil"],["SHAHID"],["TVER"],["UNEXT"],["VIDIO"],["VIU"],["WETV"]];def fK = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def th = ["DB"];def CT = ["Ruri-Saizen"];def piF = ["Erai-raws", "SubsPlease"];def MZ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def Ovg = any {def ifd = Z_.find { xk ->  xk.find { Vdh ->  fn.lower().contains(Vdh.lower()) } }[0];ifd = ifd.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {ifd = ifd.replace(".WEBRip", "");ifd = ifd + ".WEBRip"} else {ifd = ifd + ".WEB-DL"};ifd} {source} {fK.find { Gb ->  group == Gb || MZ == Gb } ? "WEBRip" : ""} {th.find { Gb ->  group == Gb || MZ == Gb } ? "BDRip" : ""} {CT.find { Gb ->  group == g__ || MZ == g__} ? "HDTVRip" : ""} {def aVJ = piF.find { Gv ->  group == Gv || MZ == Gv} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : aVJ} {vs} {""};Ovg ? "$Ovg " : ""}{def phy = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $phy, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def Hb = any { audioLanguages.size() } { 0 };def XyH = Hb > 2 ? " MULTi-AUD" : Hb > 1 ? " DUAL-AUD" : "";def Noy = Hb > 5 ? audioLanguages.take(5) : audioLanguages;def Vh = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : " DUBBED";XyH = Hb == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : "$XyH$Vh";XyH ? XyH + Noy.ISO2.joining(" ", " (", "").upper() + (Hb > 5 ? " ...)" : ")") : ""}{def kXs = any { textLanguages.size() } { 0 };def XyH = kXs > 2 ? ", MULTi" : kXs > 1 ? ", DUAL" : kXs == 1 ? ", SUB" : null;def Noy = kXs > 5 ? textLanguages.take(5) : textLanguages;XyH ? XyH + Noy.ISO2.joining(" ", " (", "").upper() + (kXs > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def JFP = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def Jni = subt;JFP.values().each { zTL -> if (Jni.contains(zTL)) {Jni = Jni.replace(zTL, "")}};JFP.iso3b + Jni}}{f.image ? "-thumb" : ""}