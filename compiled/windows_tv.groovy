{def YGg = "H:/";def yGV = [home,"D:/","E:/","F:/","G:/","H:/"].collect { it as File }.sort { ol, URQ ->  ol.exists() <=> URQ.exists() ?: ol.diskSpace <=> URQ.diskSpace }.last();def PJ = YGg ? YGg : yGV;"$PJ/"}{"Videos/"}{def _eG = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","hentai", "sex", "lgbt", "explicit", "adult animation", "adult content"];def rzR = "TheMovieDB::TV";def Wpt = [[271026, rzR],[220118, rzR]];def bb = [[236530, rzR]];def zg = any { info.adult } { false };def ix = Wpt.find { it[0] == id && it[1] == info.eCm } != null;def Cc = bb.find { it[0] == id && it[1] == info.eCm } != null;ix = Cc ? false : ix;def aF = info.Keywords.findAll { it in _eG } || ix || zg;aF ? "R18+ " : ""}{def Gch = ["CN", "JP", "KR", "KP", "TW", "HK"];def Eil = ["aeni", "donghua", "anime"];def hCB = any {anime} || info.Keywords.findAll { it in Eil } || (Gch.contains(country) && genres =~ /Animation/);hCB ? "Anime/" : "TV Series/"}{def rzR = "TheMovieDB::TV";def _MX = [[wNw: 68854, AYr: "From Me to You", bC: rzR],[wNw: 229743, AYr: "VTuber Legend", bC: rzR],[wNw: 234538, AYr: "Demon Lord 2099", bC: rzR],[wNw: 237045, AYr: "Cherry Magic!", bC: rzR],[wNw: 240633, AYr: "A Journey Through Another World", bC: rzR],[wNw: 245285, AYr: "Failure Frame", bC: rzR],[wNw: 271026, AYr: "Taisho Era Contract Marriage", bC: rzR]];def eCm = any { info.eCm } { "IMDb" };def huc = n;_MX.each {if (it.wNw == id && it.bC == eCm) {huc = it.AYr}};def xkU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Wds = huc.replaceAll(xkU.collect { "\\" + it }.join('|'), '');Wds = Wds.replaceAll(/(\s|\.)*$/, '');Wds}{def rzR = "TheMovieDB::TV";def zL = [[ 68854, rzR],[123542, rzR],[204098, rzR],[235973, rzR],[239779, rzR],[240125, rzR],[257162, rzR],[259140, rzR],[262295, rzR],[271026, rzR],[273190, rzR],[275695, rzR]];def cUJ = zL.find { it[0] == id && it[1] == info.eCm } != null;def _N = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def ad = _N[info.eCm];cUJ ? " ($y) [${ad}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def xkU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Wds = sn.replaceAll(xkU.collect { "\\" + it }.join('|'), '_');def Kg = n.replaceAll(xkU.collect { "\\" + it }.join('|'), '_');def lvj = Wds.contains(Kg) ? "" : Wds;lvj == 'Season '+ s ? "" : lvj ? " - " + lvj : ""}{"/"}{def UZ = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def ND = UZ.find { Zm ->  fn.contains(Zm) } ?: "";def jeZ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {ND} {group} {""};jeZ ? "[$jeZ] " : ""}{def rzR = "TheMovieDB::TV";def _MX = [[wNw: 68854, AYr: "From Me to You", bC: rzR],[wNw: 229743, AYr: "VTuber Legend", bC: rzR],[wNw: 234538, AYr: "Demon Lord 2099", bC: rzR],[wNw: 237045, AYr: "Cherry Magic!", bC: rzR],[wNw: 240633, AYr: "A Journey Through Another World", bC: rzR],[wNw: 245285, AYr: "Failure Frame", bC: rzR],[wNw: 271026, AYr: "Taisho Era Contract Marriage", bC: rzR]];def eCm = any { info.eCm } { "IMDb" };def huc = n;_MX.each {if (it.wNw == id && it.bC == eCm) {huc = it.AYr}};def xkU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Wds = huc.replaceAll(xkU.collect { "\\" + it }.join('|'), '');Wds = Wds.replaceAll(/(\s|\.)*$/, '');Wds}{" - "}{s00e00}{def xkU = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Wds = t.replaceAll(xkU.collect { "\\" + it }.join('|'), '_');def Uj = any { e } { special };Wds = Wds.length() > 100 ? " " : " - $Wds ";Wds == " - Episode $Uj " ? " " : Wds}{" ["}{def PE = [[mS: "ABEMA", lp: ["ABEMA"]],[mS: "Bilibili.tv", lp: ["B-Global", "BiliIntl", "BILI"]],[mS: "Hulu", lp: ["HULU"]],[mS: "MeWatch", lp: ["MW.WEB-DL"]],[mS: "Netflix", lp: ["NF.WEB-DL", "NF WEB"]],[mS: "Prime Video", lp: ["AMZN"]],[mS: "TVer", lp: ["TVER"]],[mS: "Shahid", lp: ["SHAHID"]],[mS: "U-NEXT", lp: ["UNEXT"]],[mS: "YouTube", lp: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def _WH = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def eTQ = ["Erai-raws", "SubsPlease"];def QZE = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def Os = any {def GTS = PE.find { yv ->  yv.lp.find { EMg ->  fn.contains(EMg) } }?.lp.first() ?: "";GTS = GTS.replace(".WEB-DL", "");GTS ? "${GTS}.WEB-DL" : ""} {source} {_WH.find { DT ->  group == DT || QZE == DT } ? "WEBRip" : ""} {def ym = eTQ.find { Su ->  group == Su || QZE == Su} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : ym} {vs} {""};Os ? "$Os " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def NQt = " Dub";def UA = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : NQt;UA = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : UA;UA}{def Vfk = any { audioLanguages.size() } { 0 };def UA = Vfk > 2 ? " MAud" : Vfk > 1 ? " DAud" : null;def hsU = Vfk > 5 ? audioLanguages.take(5) : audioLanguages;UA ? UA + hsU.joining(" ", " (", "").upper() + (Vfk > 5 ? " ...)" : ")") : ""}{def uNC = any { textLanguages.size() } { 0 };def UA = uNC > 2 ? ", MSub" : uNC > 1 ? ", DSub" : null;def hsU = uNC > 5 ? textLanguages.take(5) : textLanguages;UA ? UA + hsU.joining(" ", " (", "").upper() + (uNC > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}