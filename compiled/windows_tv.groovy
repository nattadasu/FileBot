{def Bos = "H:/";def lXC = [home,"D:/","E:/","F:/","G:/","H:/"].collect { it as File }.sort { QIC, ozs ->  QIC.exists() <=> ozs.exists() ?: QIC.diskSpace <=> ozs.diskSpace }.last();def Fb = Bos ? Bos : lXC;"$Fb/"}{"Videos/"}{def naV = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content"];def Rvx = "TheMovieDB::TV";def CMA = [[271026, Rvx],[220118, Rvx],[ 74180, Rvx]];def IKe = [[236530, Rvx]];def gE = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def GQi = gE == "IMDb" ? "tt${id}" : id;def yKM = any { info.adult } { false };def ulF = CMA.find { it[0] == GQi && it[1] == gE } != null;def mt = IKe.find { it[0] == GQi && it[1] == gE } != null;def OrE = info.Keywords.findAll { it in naV } || ulF || yKM;OrE = mt ? false : OrE;OrE ? "R18+ " : ""}{def PQi = ["CN", "JP", "KR", "KP", "TW", "HK"];def hL = ["aeni", "donghua", "anime"];def ZP = any {anime} || info.Keywords.findAll { it in hL } || (PQi.contains(country) && genres =~ /Animation/);ZP ? "Anime/" : "TV Series/"}{def Rvx = "TheMovieDB::TV";def re = [[zq: 68854, SuX: "From Me to You", Zyd: Rvx],[zq: 94904, SuX: "My Next Life as a Villainess", Zyd: Rvx],[zq: 229743, SuX: "VTuber Legend", Zyd: Rvx],[zq: 234538, SuX: "Demon Lord 2099", Zyd: Rvx],[zq: 237045, SuX: "Cherry Magic!", Zyd: Rvx],[zq: 240633, SuX: "A Journey Through Another World", Zyd: Rvx],[zq: 245285, SuX: "Failure Frame", Zyd: Rvx],[zq: 271026, SuX: "Taisho Era Contract Marriage", Zyd: Rvx]];def gE = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def GQi = gE == "IMDb" ? "tt${id}" : id;def eP = n;re.each {if (it.zq == GQi && it.Zyd == gE) {eP = it.SuX}};def aU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def UX = eP.replaceAll(aU.collect { "\\" + it }.join('|'), '');UX = UX.replaceAll(/(\s|\.)*$/, '');UX}{def Rvx = "TheMovieDB::TV";def olp = [[ 68854, Rvx],[123542, Rvx],[204098, Rvx],[235973, Rvx],[239779, Rvx],[240125, Rvx],[257162, Rvx],[259140, Rvx],[262295, Rvx],[271026, Rvx],[273190, Rvx],[275695, Rvx]];def sr = olp.find { it[0] == id && it[1] == info.database } != null;def FvP = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def Iy = FvP[info.database];sr ? " ($y) [${Iy}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def aU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def UX = sn.replaceAll(aU.collect { "\\" + it }.join('|'), '_');def FFh = n.replaceAll(aU.collect { "\\" + it }.join('|'), '_');def ZUt = UX.contains(FFh) ? "" : UX;ZUt == 'Season '+ s ? "" : ZUt ? " - " + ZUt : ""}{"/"}{def pTK = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def Jgo = pTK.find { ODu ->  fn.contains(ODu) } ?: "";def Eiq = any {(fn =~ /^\[(.*?)\]/)[0][1]} {Jgo} {group} {""};Eiq ? "[$Eiq] " : ""}{def Rvx = "TheMovieDB::TV";def re = [[zq: 68854, SuX: "From Me to You", Zyd: Rvx],[zq: 94904, SuX: "My Next Life as a Villainess", Zyd: Rvx],[zq: 229743, SuX: "VTuber Legend", Zyd: Rvx],[zq: 234538, SuX: "Demon Lord 2099", Zyd: Rvx],[zq: 237045, SuX: "Cherry Magic!", Zyd: Rvx],[zq: 240633, SuX: "A Journey Through Another World", Zyd: Rvx],[zq: 245285, SuX: "Failure Frame", Zyd: Rvx],[zq: 271026, SuX: "Taisho Era Contract Marriage", Zyd: Rvx]];def gE = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def GQi = gE == "IMDb" ? "tt${id}" : id;def eP = n;re.each {if (it.zq == GQi && it.Zyd == gE) {eP = it.SuX}};def aU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def UX = eP.replaceAll(aU.collect { "\\" + it }.join('|'), '');UX = UX.replaceAll(/(\s|\.)*$/, '');UX}{" - "}{s00e00}{def aU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def UX = t.replaceAll(aU.collect { "\\" + it }.join('|'), '_');def Voo = any { e } { special };UX = UX.length() > 100 ? " " : " - $UX ";UX == " - Episode $Voo " ? " " : UX}{" ["}{def cc = [[de: "ABEMA", si: ["ABEMA"]],[de: "Bilibili.tv", si: ["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"]],[de: "Hulu", si: ["HULU"]],[de: "iQIYI", si: ["IQ.WEB-DL", "IQIYI"]],[de: "MeWatch", si: ["MW.WEB-DL"]],[de: "Netflix", si: ["NF.WEB-DL", "NF WEB"]],[de: "Prime Video", si: ["AMZN"]],[de: "Shahid", si: ["SHAHID"]],[de: "TVer", si: ["TVER"]],[de: "U-NEXT", si: ["UNEXT"]],[de: "YouTube", si: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def Is = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def Rq = ["Erai-raws", "SubsPlease"];def Hv = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def HKQ = any {def tpF = cc.find { pz ->  pz.si.find { jsM ->  fn.contains(jsM) } }?.si.QIC() ?: "";tpF = tpF.replace(".WEB-DL", "");tpF ? "${tpF}.WEB-DL" : ""} {source} {Is.find { XI ->  group == XI || Hv == XI } ? "WEBRip" : ""} {def _wS = Rq.find { Nog ->  group == Nog || Hv == Nog} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : _wS} {vs} {""};HKQ ? "$HKQ " : ""}{def lP = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $lP, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def jZP = " Dub";def vI = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : jZP;vI = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : vI;vI}{def eUz = any { audioLanguages.size() } { 0 };def vI = eUz > 2 ? " MAud" : eUz > 1 ? " DAud" : null;def pND = eUz > 5 ? audioLanguages.take(5) : audioLanguages;vI ? vI + pND.joining(" ", " (", "").upper() + (eUz > 5 ? " ...)" : ")") : ""}{def yK = any { textLanguages.size() } { 0 };def vI = yK > 2 ? ", MSub" : yK > 1 ? ", DSub" : null;def pND = yK > 5 ? textLanguages.take(5) : textLanguages;vI ? vI + pND.joining(" ", " (", "").upper() + (yK > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{def qdu = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def aI = subt;qdu.values().each { hA -> if (aI.contains(hA)) {aI = aI.replace(hA, "")}};f.subtitle ? qdu.iso3b + aI : ""}{f.image ? "-thumb" : ""}