{def ehE = System.getProperty("user.name");def dOK = "/run/media/${ehE}";def iJ = "$dOK/Videos";def atw = [home,"$dOK/Data","$dOK/Music","$dOK/Videos","$dOK/Games","$dOK/Books"].collect { it as File }.sort { caN, AEI ->  caN.exists() <=> AEI.exists() ?: caN.diskSpace <=> AEI.diskSpace }.last();def hCl = iJ ? iJ : atw;"$hCl/"}{"Videos/"}{def jFI = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content"];def iw = "TheMovieDB::TV";def pv = [[271026, iw],[220118, iw],[ 74180, iw]];def tkR = [[236530, iw]];def Kg = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def kE = Kg == "IMDb" ? "tt${id}" : id;def ECh = any { info.adult } { false };def NXG = pv.find { it[0] == kE && it[1] == Kg } != null;def nMY = tkR.find { it[0] == kE && it[1] == Kg } != null;def JNZ = info.Keywords.findAll { it in jFI } || NXG || ECh;JNZ = nMY ? false : JNZ;JNZ ? "R18+ " : ""}{def PD = ["CN", "JP", "KR", "KP", "TW", "HK"];def JSD = ["aeni", "donghua", "anime"];def FQ = any {anime} || info.Keywords.findAll { it in JSD } || (PD.contains(country) && genres =~ /Animation/);FQ ? "Anime/" : "TV Series/"}{def iw = "TheMovieDB::TV";def DT = [[aK: 68854, yp: "From Me to You", qDb: iw],[aK: 229743, yp: "VTuber Legend", qDb: iw],[aK: 234538, yp: "Demon Lord 2099", qDb: iw],[aK: 237045, yp: "Cherry Magic!", qDb: iw],[aK: 240633, yp: "A Journey Through Another World", qDb: iw],[aK: 245285, yp: "Failure Frame", qDb: iw],[aK: 271026, yp: "Taisho Era Contract Marriage", qDb: iw]];def Kg = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def kE = Kg == "IMDb" ? "tt${id}" : id;def Ap = n;DT.each {if (it.aK == kE && it.qDb == Kg) {Ap = it.yp}};def AY = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def bD = Ap.replaceAll(AY.collect { "\\" + it }.join('|'), '');bD = bD.replaceAll(/(\s|\.)*$/, '');bD}{def iw = "TheMovieDB::TV";def XA = [[ 68854, iw],[123542, iw],[204098, iw],[235973, iw],[239779, iw],[240125, iw],[257162, iw],[259140, iw],[262295, iw],[271026, iw],[273190, iw],[275695, iw]];def zv = XA.find { it[0] == id && it[1] == info.database } != null;def Gp = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def ZR = Gp[info.database];zv ? " ($y) [${ZR}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def AY = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def bD = sn.replaceAll(AY.collect { "\\" + it }.join('|'), '_');def Rwl = n.replaceAll(AY.collect { "\\" + it }.join('|'), '_');def mCX = bD.contains(Rwl) ? "" : bD;mCX == 'Season '+ s ? "" : mCX ? " - " + mCX : ""}{"/"}{def Bgn = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def cN = Bgn.find { fm ->  fn.contains(fm) } ?: "";def rXZ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {cN} {group} {""};rXZ ? "[$rXZ] " : ""}{def iw = "TheMovieDB::TV";def DT = [[aK: 68854, yp: "From Me to You", qDb: iw],[aK: 229743, yp: "VTuber Legend", qDb: iw],[aK: 234538, yp: "Demon Lord 2099", qDb: iw],[aK: 237045, yp: "Cherry Magic!", qDb: iw],[aK: 240633, yp: "A Journey Through Another World", qDb: iw],[aK: 245285, yp: "Failure Frame", qDb: iw],[aK: 271026, yp: "Taisho Era Contract Marriage", qDb: iw]];def Kg = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def kE = Kg == "IMDb" ? "tt${id}" : id;def Ap = n;DT.each {if (it.aK == kE && it.qDb == Kg) {Ap = it.yp}};def AY = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def bD = Ap.replaceAll(AY.collect { "\\" + it }.join('|'), '');bD = bD.replaceAll(/(\s|\.)*$/, '');bD}{" - "}{s00e00}{def AY = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def bD = t.replaceAll(AY.collect { "\\" + it }.join('|'), '_');def yo = any { e } { special };bD = bD.length() > 100 ? " " : " - $bD ";bD == " - Episode $yo " ? " " : bD}{" ["}{def OaP = [[AbA: "ABEMA", XvG: ["ABEMA"]],[AbA: "Bilibili.tv", XvG: ["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"]],[AbA: "Hulu", XvG: ["HULU"]],[AbA: "iQIYI", XvG: ["IQ.WEB-DL", "IQIYI"]],[AbA: "MeWatch", XvG: ["MW.WEB-DL"]],[AbA: "Netflix", XvG: ["NF.WEB-DL", "NF WEB"]],[AbA: "Prime Video", XvG: ["AMZN"]],[AbA: "Shahid", XvG: ["SHAHID"]],[AbA: "TVer", XvG: ["TVER"]],[AbA: "U-NEXT", XvG: ["UNEXT"]],[AbA: "YouTube", XvG: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def lfz = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def dk = ["Erai-raws", "SubsPlease"];def LrG = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def uIZ = any {def Ars = OaP.find { fg ->  fg.XvG.find { wt ->  fn.contains(wt) } }?.XvG.first() ?: "";Ars = Ars.replace(".WEB-DL", "");Ars ? "${Ars}.WEB-DL" : ""} {source} {lfz.find { UT ->  group == UT || LrG == UT } ? "WEBRip" : ""} {def mp = dk.find { Rj ->  group == Rj || LrG == Rj} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : mp} {vs} {""};uIZ ? "$uIZ " : ""}{def GKO = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $GKO, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def Cf = " Dub";def VR = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : Cf;VR = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : VR;VR}{def TN = any { audioLanguages.size() } { 0 };def VR = TN > 2 ? " MAud" : TN > 1 ? " DAud" : null;def Fa = TN > 5 ? audioLanguages.take(5) : audioLanguages;VR ? VR + Fa.joining(" ", " (", "").upper() + (TN > 5 ? " ...)" : ")") : ""}{def nh = any { textLanguages.size() } { 0 };def VR = nh > 2 ? ", MSub" : nh > 1 ? ", DSub" : null;def Fa = nh > 5 ? textLanguages.take(5) : textLanguages;VR ? VR + Fa.joining(" ", " (", "").upper() + (nh > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{def TA = ["ass", "srt", "ssa", "vtt", "ttml"];def pIw = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def bW = subt;pIw.values().each { TB -> if (bW.contains(TB)) {bW = bW.replace(TB, "")}};TA.contains(ext) ? pIw.iso3b + bW : ""}{def TA = ["jpg", "jpeg", "png", "bmp"];TA.contains(ext) ? "-thumb" : ""}