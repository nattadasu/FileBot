{def upL = "H:/";def tM = [home,"D:/","E:/","F:/","G:/","H:/"].collect { it as File }.sort { gvj, XIX ->  gvj.exists() <=> XIX.exists() ?: gvj.diskSpace <=> XIX.diskSpace }.last();def gw = upL ? upL : tM;"$gw/"}{"Videos/"}{def wK = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","hentai", "sex", "lgbt", "explicit", "adult animation", "adult content"];def Xge = [271026,220118];def cEy = any { info.adult } { false };def Ej = any { info.Keywords.findAll { it in wK } } { id in Xge } { cEy };Ej ? "R18+ " : ""}{def SvQ = /(CN|JP|KR|KP|TW|HK)/;def xj = /(aeni|donghua|anime)/;def Lfz = anime || info.Keywords =~ xj || (genres =~ /Animation/ && country =~ SvQ) ? true : false;Lfz ? "Anime/" : "TV Series/"}{def mS = [[ad: 229743, GRc: "VTuber Legend"],[ad: 240633, GRc: "A Journey Through Another World"],[ad: 245285, GRc: "Failure Frame"],[ad: 237045, GRc: "Cherry Magic!"],[ad: 68854, GRc: "From Me to You"],[ad: 271026, GRc: "Taisho Era Contract Marriage"],[ad: 234538, GRc: "Demon Lord 2099"]];def UJO = n;mS.each {if (it.ad == tmdbid && type.toString() != "Movie") {UJO = it.GRc}};def wjB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def al = UJO.replaceAll(wjB.collect { "\\" + it }.join('|'), '');al = al.replaceAll(/(\s|\.)*$/, '');al}{def ni = [68854,235973,262295,259140,204098,239779,273190,271026,240125,275695,123542,257162];def wDW = ni.find { Kch ->  tmdbid == Kch } ?: "";wDW ? " ($y) [tmdbid-$wDW]" : ""}/{episode.special ? 'Specials' : 'Season '+s}{def wjB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def al = sn.replaceAll(wjB.collect { "\\" + it }.join('|'), '_');def xh = n.replaceAll(wjB.collect { "\\" + it }.join('|'), '_');def Tz = al.contains(xh) ? "" : al;Tz == 'Season '+ s ? "" : Tz ? " - " + Tz : ""}/{def fxB = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def QL = fxB.find { mC ->  fn.contains(mC) } ?: "";def zns = any {(fn =~ /^\[(.*?)\]/)[0][1]} {QL} {group} {""};zns ? "[$zns] " : ""}{def mS = [[ad: 229743, GRc: "VTuber Legend"],[ad: 240633, GRc: "A Journey Through Another World"],[ad: 245285, GRc: "Failure Frame"],[ad: 237045, GRc: "Cherry Magic!"],[ad: 68854, GRc: "From Me to You"],[ad: 271026, GRc: "Taisho Era Contract Marriage"],[ad: 234538, GRc: "Demon Lord 2099"]];def UJO = n;mS.each {if (it.ad == tmdbid && type.toString() != "Movie") {UJO = it.GRc}};def wjB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def al = UJO.replaceAll(wjB.collect { "\\" + it }.join('|'), '');al = al.replaceAll(/(\s|\.)*$/, '');al} - {s00e00}{def wjB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def al = t.replaceAll(wjB.collect { "\\" + it }.join('|'), '_');def ls = any { e } { special };al = al.length() > 100 ? " " : " - $al ";al == " - Episode $ls " ? " " : al} [{def cC = [[utA: "ABEMA", bx: ["ABEMA"]],[utA: "Bilibili.tv", bx: ["B-Global", "BiliIntl", "BILI"]],[utA: "Hulu", bx: ["HULU"]],[utA: "MeWatch", bx: ["MW.WEB-DL"]],[utA: "Netflix", bx: ["NF.WEB-DL", "NF WEB"]],[utA: "Prime Video", bx: ["AMZN"]],[utA: "TVer", bx: ["TVER"]],[utA: "Shahid", bx: ["SHAHID"]],[utA: "U-NEXT", bx: ["UNEXT"]],[utA: "YouTube", bx: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def _e = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def Wwc = ["Erai-raws", "SubsPlease"];def xcj = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def EIP = any {def XK = cC.find { VS ->  VS.bx.find { khC ->  fn.contains(khC) } }?.bx.first() ?: "";XK = XK.replace(".WEB-DL", "");XK ? "${XK}.WEB-DL" : ""} {source} {_e.find { br ->  group == br || xcj == br } ? "WEBRip" : ""} {def yS = Wwc.find { Um ->  group == Um || xcj == Um} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : yS} {vs} {""};EIP ? "$EIP " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac} {af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def PT = " Dub";def tS = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : PT;tS = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : tS;tS}{def yo = any { audioLanguages.size() } { 0 };def tS = yo > 2 ? " MAud" : yo > 1 ? " DAud" : null;def Vzi = yo > 5 ? audioLanguages.take(5) : audioLanguages;tS ? tS + Vzi.joining(" ", " (", "").upper() + (yo > 5 ? " ...)" : ")") : ""}{def GPD = any { textLanguages.size() } { 0 };def tS = GPD > 2 ? ", MSub" : GPD > 1 ? ", DSub" : null;def Vzi = GPD > 5 ? textLanguages.take(5) : textLanguages;tS ? tS + Vzi.joining(" ", " (", "").upper() + (GPD > 5 ? " ...)" : ")") : ""}][{crc32.upper()}]{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}