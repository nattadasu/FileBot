{def vn = "H:/";def mgd = [home,"D:/","E:/","F:/","G:/","H:/"].collect { it as File }.sort { Fs, KpE ->  Fs.exists() <=> KpE.exists() ?: Fs.diskSpace <=> KpE.diskSpace }.last();def mDY = vn ? vn : mgd;"$mDY/"}{def Fg = /(CN|JP|KR|KP|TW|HK)/;def Hd = /(aeni|donghua|anime)/;def QA = anime || info.Keywords =~ Hd || any {(genres =~ /Animation/ && country =~ Fg)}{false} ? true : false;def qe = QA ? "Videos/Anime " : "Videos/";"$qe" + "Movies/"}{def pC = [[gg_: 229743, rQM: "VTuber Legend"],[gg_: 240633, rQM: "A Journey Through Another World"],[gg_: 245285, rQM: "Failure Frame"],[gg_: 237045, rQM: "Cherry Magic!"],[gg_: 68854, rQM: "From Me to You"],[gg_: 271026, rQM: "Taisho Era Contract Marriage"],[gg_: 234538, rQM: "Demon Lord 2099"]];def DKp = n;pC.each {if (it.gg_ == tmdbid && type.toString() != "Movie") {DKp = it.rQM}};def oiV = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Ub = DKp.replaceAll(oiV.collect { "\\" + it }.join('|'), '');Ub = Ub.replaceAll(/(\s|\.)*$/, '');Ub}{" ("}{y}{") [tmdbid-"}{tmdbid}{"]/"}{def hX = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def _wz = hX.find { df ->  fn.contains(df) } ?: "";def un = any {(fn =~ /^\[(.*?)\]/)[0][1]} {_wz} {group} {""};un ? "[$un] " : ""}{def pC = [[gg_: 229743, rQM: "VTuber Legend"],[gg_: 240633, rQM: "A Journey Through Another World"],[gg_: 245285, rQM: "Failure Frame"],[gg_: 237045, rQM: "Cherry Magic!"],[gg_: 68854, rQM: "From Me to You"],[gg_: 271026, rQM: "Taisho Era Contract Marriage"],[gg_: 234538, rQM: "Demon Lord 2099"]];def DKp = n;pC.each {if (it.gg_ == tmdbid && type.toString() != "Movie") {DKp = it.rQM}};def oiV = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def Ub = DKp.replaceAll(oiV.collect { "\\" + it }.join('|'), '');Ub = Ub.replaceAll(/(\s|\.)*$/, '');Ub}{" ("}{y}{")"} [{def Fo = [[Zz: "Bilibili.tv", Rv: ["B-Global", "BiliIntl", "BILI"]],[Zz: "Prime Video", Rv: ["AMZN"]],[Zz: "U-NEXT", Rv: ["UNEXT"]],[Zz: "ABEMA", Rv: ["ABEMA"]],[Zz: "Hulu", Rv: ["HULU"]],[Zz: "Shahid", Rv: ["SHAHID"]],[Zz: "YouTube", Rv: ["YT.WEB-DL", "YOUTUBE", "YTB"]],[Zz: "Netflix", Rv: ["NF.WEB-DL", "NF WEB"]]];def OW = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def NxM = ["Erai-raws", "SubsPlease"];def PG = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def ipJ = any {def bcK = Fo.find { wNz ->  wNz.Rv.find { xHe ->  fn.contains(xHe) } }?.Rv.first() ?: "";bcK = bcK.replace(".WEB-DL", "");bcK ? "${bcK}.WEB-DL" : ""} {source} {OW.find { jCH ->  group == jCH || PG == jCH } ? "WEBRip" : ""} {def qF = NxM.find { WDt ->  group == WDt || PG == WDt} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : qF} {vs} {""};ipJ ? "$ipJ " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac} {af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def Pig = " Dub";def DAb = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : Pig;DAb = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : DAb;DAb}{def pVz = any { audioLanguages.size() } { 0 };def DAb = pVz > 2 ? " MAud" : pVz > 1 ? " DAud" : null;def cvg = pVz > 5 ? audioLanguages.take(5) : audioLanguages;DAb ? DAb + cvg.joining(" ", " (", "").upper() + (pVz > 5 ? " ...)" : ")") : ""}{def ll = any { textLanguages.size() } { 0 };def DAb = ll > 2 ? ", MSub" : ll > 1 ? ", DSub" : null;def cvg = ll > 5 ? textLanguages.take(5) : textLanguages;DAb ? DAb + cvg.joining(" ", " (", "").upper() + (ll > 5 ? " ...)" : ")") : ""}][{crc32.upper()}]{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}