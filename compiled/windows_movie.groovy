{def Pll = "H:/";def dq_ = [home,"D:/","E:/","F:/","G:/","H:/"].collect { it as File }.sort { wU, dX ->  wU.exists() <=> dX.exists() ?: wU.diskSpace <=> dX.diskSpace }.last();def jVr = Pll ? Pll : dq_;"$jVr/"}{"Videos/"}{def DAU = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","hentai", "sex", "lgbt", "explicit", "adult animation", "adult content"];def UD = [[271026, "TheMovieDB::TV"],[220118, "TheMovieDB::TV"]];def Ix = any { info.adult } { false };def jbG = UD.find { it[0] == id && it[1] == info.database } != null;def jBn = info.Keywords.findAll { it in DAU } || jbG || Ix;jBn ? "R18+ " : ""}{def bcg = ["CN", "JP", "KR", "KP", "TW", "HK"];def _hr = ["aeni", "donghua", "anime"];def Uxj = any {anime} || info.Keywords.findAll { it in _hr } || (bcg.contains(country) && genres =~ /Animation/);Uxj ? "Anime Movies/" : "Movies/"}{def VjU = [[Al: 68854, gJd: "From Me to You", PA: "TheMovieDB::TV"],[Al: 229743, gJd: "VTuber Legend", PA: "TheMovieDB::TV"],[Al: 234538, gJd: "Demon Lord 2099", PA: "TheMovieDB::TV"],[Al: 237045, gJd: "Cherry Magic!", PA: "TheMovieDB::TV"],[Al: 240633, gJd: "A Journey Through Another World", PA: "TheMovieDB::TV"],[Al: 245285, gJd: "Failure Frame", PA: "TheMovieDB::TV"],[Al: 271026, gJd: "Taisho Era Contract Marriage", PA: "TheMovieDB::TV"]];def rMa = n;VjU.each {if (it.Al == tmdbid && it.PA == info.database) {rMa = it.gJd}};def cve = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def GD = rMa.replaceAll(cve.collect { "\\" + it }.join('|'), '');GD = GD.replaceAll(/(\s|\.)*$/, '');GD}{" ("}{y}{") [tmdbid-"}{tmdbid}{"]/"}{def dqF = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def dyR = dqF.find { DnK ->  fn.contains(DnK) } ?: "";def Ccs = any {(fn =~ /^\[(.*?)\]/)[0][1]} {dyR} {group} {""};Ccs ? "[$Ccs] " : ""}{def VjU = [[Al: 68854, gJd: "From Me to You", PA: "TheMovieDB::TV"],[Al: 229743, gJd: "VTuber Legend", PA: "TheMovieDB::TV"],[Al: 234538, gJd: "Demon Lord 2099", PA: "TheMovieDB::TV"],[Al: 237045, gJd: "Cherry Magic!", PA: "TheMovieDB::TV"],[Al: 240633, gJd: "A Journey Through Another World", PA: "TheMovieDB::TV"],[Al: 245285, gJd: "Failure Frame", PA: "TheMovieDB::TV"],[Al: 271026, gJd: "Taisho Era Contract Marriage", PA: "TheMovieDB::TV"]];def rMa = n;VjU.each {if (it.Al == tmdbid && it.PA == info.database) {rMa = it.gJd}};def cve = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def GD = rMa.replaceAll(cve.collect { "\\" + it }.join('|'), '');GD = GD.replaceAll(/(\s|\.)*$/, '');GD}{" ("}{y}{")"} [{def QeZ = [[iYu: "ABEMA", YL: ["ABEMA"]],[iYu: "Bilibili.tv", YL: ["B-Global", "BiliIntl", "BILI"]],[iYu: "Hulu", YL: ["HULU"]],[iYu: "MeWatch", YL: ["MW.WEB-DL"]],[iYu: "Netflix", YL: ["NF.WEB-DL", "NF WEB"]],[iYu: "Prime Video", YL: ["AMZN"]],[iYu: "TVer", YL: ["TVER"]],[iYu: "Shahid", YL: ["SHAHID"]],[iYu: "U-NEXT", YL: ["UNEXT"]],[iYu: "YouTube", YL: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def sZF = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def LPy = ["Erai-raws", "SubsPlease"];def Dc = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def gCJ = any {def Cx = QeZ.find { VT ->  VT.YL.find { Cr ->  fn.contains(Cr) } }?.YL.first() ?: "";Cx = Cx.replace(".WEB-DL", "");Cx ? "${Cx}.WEB-DL" : ""} {source} {sZF.find { Od ->  group == Od || Dc == Od } ? "WEBRip" : ""} {def hT = LPy.find { hlU ->  group == hlU || Dc == hlU} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : hT} {vs} {""};gCJ ? "$gCJ " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac} {af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def OVA = " Dub";def bU = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : OVA;bU = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : bU;bU}{def ae = any { audioLanguages.size() } { 0 };def bU = ae > 2 ? " MAud" : ae > 1 ? " DAud" : null;def fS = ae > 5 ? audioLanguages.take(5) : audioLanguages;bU ? bU + fS.joining(" ", " (", "").upper() + (ae > 5 ? " ...)" : ")") : ""}{def dJ = any { textLanguages.size() } { 0 };def bU = dJ > 2 ? ", MSub" : dJ > 1 ? ", DSub" : null;def fS = dJ > 5 ? textLanguages.take(5) : textLanguages;bU ? bU + fS.joining(" ", " (", "").upper() + (dJ > 5 ? " ...)" : ")") : ""}][{crc32.upper()}]{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}