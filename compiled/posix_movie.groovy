{def tJ = System.getProperty("user.name");def mOJ = "/run/media/${tJ}";def KAJ = "$mOJ/Videos";def qJu = [home,"$mOJ/Data","$mOJ/Music","$mOJ/Videos","$mOJ/Games","$mOJ/Books"].collect { it as File }.sort { Aqo, Plg ->  Aqo.exists() <=> Plg.exists() ?: Aqo.diskSpace <=> Plg.diskSpace }.last();def vP = KAJ ? KAJ : qJu;"$vP/"}{"Videos/"}{def jKb = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","hentai", "sex", "lgbt", "explicit", "adult animation", "adult content"];def GZW = "TheMovieDB::TV";def cu = [[271026, GZW],[220118, GZW]];def rCE = [[236530, GZW]];def NG = any { info.database } { "IMDb" };def FgU = NG == "IMDb" ? "tt${id}" : id;def Tij = any { info.adult } { false };def ByE = cu.find { it[0] == FgU && it[1] == NG } != null;def ttx = rCE.find { it[0] == FgU && it[1] == NG } != null;def hq = info.Keywords.findAll { it in jKb } || ByE || Tij;hq = ttx ? false : hq;hq ? "R18+ " : ""}{def Lu = ["CN", "JP", "KR", "KP", "TW", "HK"];def zcq = ["aeni", "donghua", "anime"];def BZ = any {anime} || info.Keywords.findAll { it in zcq } || (Lu.contains(country) && genres =~ /Animation/);BZ ? "Anime Movies/" : "Movies/"}{def GZW = "TheMovieDB::TV";def ZLh = [[YeM: 68854, b_: "From Me to You", LtK: GZW],[YeM: 229743, b_: "VTuber Legend", LtK: GZW],[YeM: 234538, b_: "Demon Lord 2099", LtK: GZW],[YeM: 237045, b_: "Cherry Magic!", LtK: GZW],[YeM: 240633, b_: "A Journey Through Another World", LtK: GZW],[YeM: 245285, b_: "Failure Frame", LtK: GZW],[YeM: 271026, b_: "Taisho Era Contract Marriage", LtK: GZW]];def NG = any { info.database } { "IMDb" };def FgU = NG == "IMDb" ? "tt${id}" : id;def QY = n;ZLh.each {if (it.YeM == FgU && it.LtK == NG) {QY = it.b_}};def hO = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def elG = QY.replaceAll(hO.collect { "\\" + it }.join('|'), '');elG = elG.replaceAll(/(\s|\.)*$/, '');elG}{" ("}{y}{")"}{def NG = any { info.database } { "IMDb" };def Nnj = ["TheMovieDB": "tmdbid","TheTVDB::Movie": "tvdbid","IMDb": "imdbid"];def zLS = Nnj[NG];def FgU = NG == "IMDb" ? "tt${id}" : id;" [${zLS}-${FgU}]/"}{def Uk = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def qqz = Uk.find { Ds ->  fn.contains(Ds) } ?: "";def tY = any {(fn =~ /^\[(.*?)\]/)[0][1]} {qqz} {group} {""};tY ? "[$tY] " : ""}{def GZW = "TheMovieDB::TV";def ZLh = [[YeM: 68854, b_: "From Me to You", LtK: GZW],[YeM: 229743, b_: "VTuber Legend", LtK: GZW],[YeM: 234538, b_: "Demon Lord 2099", LtK: GZW],[YeM: 237045, b_: "Cherry Magic!", LtK: GZW],[YeM: 240633, b_: "A Journey Through Another World", LtK: GZW],[YeM: 245285, b_: "Failure Frame", LtK: GZW],[YeM: 271026, b_: "Taisho Era Contract Marriage", LtK: GZW]];def NG = any { info.database } { "IMDb" };def FgU = NG == "IMDb" ? "tt${id}" : id;def QY = n;ZLh.each {if (it.YeM == FgU && it.LtK == NG) {QY = it.b_}};def hO = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def elG = QY.replaceAll(hO.collect { "\\" + it }.join('|'), '');elG = elG.replaceAll(/(\s|\.)*$/, '');elG}{" ("}{y}{")"}{" ["}{def j_q = [[iE: "ABEMA", GpJ: ["ABEMA"]],[iE: "Bilibili.tv", GpJ: ["B-Global", "BiliIntl", "BILI"]],[iE: "Hulu", GpJ: ["HULU"]],[iE: "MeWatch", GpJ: ["MW.WEB-DL"]],[iE: "Netflix", GpJ: ["NF.WEB-DL", "NF WEB"]],[iE: "Prime Video", GpJ: ["AMZN"]],[iE: "TVer", GpJ: ["TVER"]],[iE: "Shahid", GpJ: ["SHAHID"]],[iE: "U-NEXT", GpJ: ["UNEXT"]],[iE: "YouTube", GpJ: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def Xs = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def yvI = ["Erai-raws", "SubsPlease"];def JC = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def kDh = any {def Wwu = j_q.find { vAw ->  vAw.GpJ.find { rk ->  fn.contains(rk) } }?.GpJ.first() ?: "";Wwu = Wwu.replace(".WEB-DL", "");Wwu ? "${Wwu}.WEB-DL" : ""} {source} {Xs.find { VB ->  group == VB || JC == VB } ? "WEBRip" : ""} {def lOQ = yvI.find { egW ->  group == egW || JC == egW} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : lOQ} {vs} {""};kDh ? "$kDh " : ""}{def xVH = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $xVH, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def Pb = " Dub";def tIa = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : Pb;tIa = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : tIa;tIa}{def tp = any { audioLanguages.size() } { 0 };def tIa = tp > 2 ? " MAud" : tp > 1 ? " DAud" : null;def Om = tp > 5 ? audioLanguages.take(5) : audioLanguages;tIa ? tIa + Om.joining(" ", " (", "").upper() + (tp > 5 ? " ...)" : ")") : ""}{def AF = any { textLanguages.size() } { 0 };def tIa = AF > 2 ? ", MSub" : AF > 1 ? ", DSub" : null;def Om = AF > 5 ? textLanguages.take(5) : textLanguages;tIa ? tIa + Om.joining(" ", " (", "").upper() + (AF > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{def uxw = ["ass", "srt", "ssa", "vtt", "ttml"];def xCm = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def DE_ = subt;xCm.values().each { fmV -> if (DE_.contains(fmV)) {DE_ = DE_.replace(fmV, "")}};uxw.contains(ext) ? xCm.iso3b + DE_ : ""}{def uxw = ["jpg", "jpeg", "png", "bmp"];uxw.contains(ext) ? "-thumb" : ""}