{def oJ = System.getProperty("user.name");def qGh = "/run/media/${oJ}";def NLk = "$qGh/Videos";def Mli = [home,"$qGh/Data","$qGh/Music","$qGh/Videos","$qGh/Games","$qGh/Books"].collect { it as File }.sort { pB, eIf ->  pB.exists() <=> eIf.exists() ?: pB.diskSpace <=> eIf.diskSpace }.last();def okJ = NLk ? NLk : Mli;"$okJ/"}{"Videos/"}{def Zh = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","hentai", "sex", "lgbt", "explicit", "adult animation", "adult content"];def hAt = "TheMovieDB::TV";def sPE = [[271026, hAt],[220118, hAt]];def WR = [[236530, hAt]];def tY = any { info.tY } { "IMDb" };def jFs = tY == "IMDb" ? "tt${id}" : id;def kS = any { info.adult } { false };def cZ = sPE.find { it[0] == jFs && it[1] == tY } != null;def ViN = WR.find { it[0] == jFs && it[1] == tY } != null;def NUt = info.Keywords.findAll { it in Zh } || cZ || kS;NUt = ViN ? false : NUt;NUt ? "R18+ " : ""}{def oC = ["CN", "JP", "KR", "KP", "TW", "HK"];def AxJ = ["aeni", "donghua", "anime"];def pzJ = any {anime} || info.Keywords.findAll { it in AxJ } || (oC.contains(country) && genres =~ /Animation/);pzJ ? "Anime/" : "TV Series/"}{def hAt = "TheMovieDB::TV";def Cw = [[ed: 68854, zK: "From Me to You", AKR: hAt],[ed: 229743, zK: "VTuber Legend", AKR: hAt],[ed: 234538, zK: "Demon Lord 2099", AKR: hAt],[ed: 237045, zK: "Cherry Magic!", AKR: hAt],[ed: 240633, zK: "A Journey Through Another World", AKR: hAt],[ed: 245285, zK: "Failure Frame", AKR: hAt],[ed: 271026, zK: "Taisho Era Contract Marriage", AKR: hAt]];def tY = any { info.tY } { "IMDb" };def jFs = tY == "IMDb" ? "tt${id}" : id;def bpj = n;Cw.each {if (it.ed == jFs && it.AKR == tY) {bpj = it.zK}};def uM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def EzC = bpj.replaceAll(uM.collect { "\\" + it }.join('|'), '');EzC = EzC.replaceAll(/(\s|\.)*$/, '');EzC}{def hAt = "TheMovieDB::TV";def DHC = [[ 68854, hAt],[123542, hAt],[204098, hAt],[235973, hAt],[239779, hAt],[240125, hAt],[257162, hAt],[259140, hAt],[262295, hAt],[271026, hAt],[273190, hAt],[275695, hAt]];def rY = DHC.find { it[0] == id && it[1] == info.tY } != null;def sF = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def EX = sF[info.tY];rY ? " ($y) [${EX}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def uM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def EzC = sn.replaceAll(uM.collect { "\\" + it }.join('|'), '_');def RV = n.replaceAll(uM.collect { "\\" + it }.join('|'), '_');def NW = EzC.contains(RV) ? "" : EzC;NW == 'Season '+ s ? "" : NW ? " - " + NW : ""}{"/"}{def BT = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def VR = BT.find { FBz ->  fn.contains(FBz) } ?: "";def IU = any {(fn =~ /^\[(.*?)\]/)[0][1]} {VR} {group} {""};IU ? "[$IU] " : ""}{def hAt = "TheMovieDB::TV";def Cw = [[ed: 68854, zK: "From Me to You", AKR: hAt],[ed: 229743, zK: "VTuber Legend", AKR: hAt],[ed: 234538, zK: "Demon Lord 2099", AKR: hAt],[ed: 237045, zK: "Cherry Magic!", AKR: hAt],[ed: 240633, zK: "A Journey Through Another World", AKR: hAt],[ed: 245285, zK: "Failure Frame", AKR: hAt],[ed: 271026, zK: "Taisho Era Contract Marriage", AKR: hAt]];def tY = any { info.tY } { "IMDb" };def jFs = tY == "IMDb" ? "tt${id}" : id;def bpj = n;Cw.each {if (it.ed == jFs && it.AKR == tY) {bpj = it.zK}};def uM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def EzC = bpj.replaceAll(uM.collect { "\\" + it }.join('|'), '');EzC = EzC.replaceAll(/(\s|\.)*$/, '');EzC}{" - "}{s00e00}{def uM = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def EzC = t.replaceAll(uM.collect { "\\" + it }.join('|'), '_');def QM = any { e } { special };EzC = EzC.length() > 100 ? " " : " - $EzC ";EzC == " - Episode $QM " ? " " : EzC}{" ["}{def fN = [[ZTy: "ABEMA", ax: ["ABEMA"]],[ZTy: "Bilibili.tv", ax: ["B-Global", "BiliIntl", "BILI"]],[ZTy: "Hulu", ax: ["HULU"]],[ZTy: "MeWatch", ax: ["MW.WEB-DL"]],[ZTy: "Netflix", ax: ["NF.WEB-DL", "NF WEB"]],[ZTy: "Prime Video", ax: ["AMZN"]],[ZTy: "TVer", ax: ["TVER"]],[ZTy: "Shahid", ax: ["SHAHID"]],[ZTy: "U-NEXT", ax: ["UNEXT"]],[ZTy: "YouTube", ax: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def Rw = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def oN = ["Erai-raws", "SubsPlease"];def lR = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def XOX = any {def Dk = fN.find { nMx ->  nMx.ax.find { RI ->  fn.contains(RI) } }?.ax.first() ?: "";Dk = Dk.replace(".WEB-DL", "");Dk ? "${Dk}.WEB-DL" : ""} {source} {Rw.find { ySl ->  group == ySl || lR == ySl } ? "WEBRip" : ""} {def Ny = oN.find { Lq ->  group == Lq || lR == Lq} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : Ny} {vs} {""};XOX ? "$XOX " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def Sw = " Dub";def PQ = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : Sw;PQ = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : PQ;PQ}{def jzy = any { audioLanguages.size() } { 0 };def PQ = jzy > 2 ? " MAud" : jzy > 1 ? " DAud" : null;def Fcp = jzy > 5 ? audioLanguages.take(5) : audioLanguages;PQ ? PQ + Fcp.joining(" ", " (", "").upper() + (jzy > 5 ? " ...)" : ")") : ""}{def FLT = any { textLanguages.size() } { 0 };def PQ = FLT > 2 ? ", MSub" : FLT > 1 ? ", DSub" : null;def Fcp = FLT > 5 ? textLanguages.take(5) : textLanguages;PQ ? PQ + Fcp.joining(" ", " (", "").upper() + (FLT > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}