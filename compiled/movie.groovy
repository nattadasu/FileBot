{def _k = { System.getProperty(it) };def VBF = _k("os.name").toLowerCase().contains("windows");def ojB = _k("user.name");def SMV = "/run/media/${ojB}";def GP = VBF ? "H:/" : "$SMV/Videos";def Chr = [[ch: "Books", ht: "F:/", YMf: "$SMV/Books"],[ch: "Data", ht: "D:/", YMf: "$SMV/Data"],[ch: "Games", ht: "G:/", YMf: "$SMV/Games"],[ch: "Music", ht: "E:/", YMf: "$SMV/Music"],[ch: "Videos", ht: "H:/", YMf: "$SMV/Videos"]];def qU = (Chr.collect { it[VBF ? "ht" : "YMf"] as File }.sort { KU, QmK ->  KU.exists() <=> QmK.exists() ?: KU.diskSpace <=> QmK.diskSpace }).last();def LG = GP ?: qU;"$LG/"}{"Videos/"}{def rX = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity"];def jCJ = "TheMovieDB::TV";def TOe = [[ 74180, jCJ],[ 93821, jCJ],[ 95897, jCJ],[220118, jCJ],[271026, jCJ]];def ln = [[236530, jCJ]];def hk = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def vEA = hk == "IMDb" ? "tt${id}" : id;def pyJ = any { info.adult } { false };def TIW = TOe.find { it[0] == vEA && it[1] == hk } != null;def Nlp = ln.find { it[0] == vEA && it[1] == hk } != null;def jEA = info.Keywords.findAll { it in rX } || TIW || pyJ;jEA = Nlp ? false : jEA;jEA ? "R18+ " : ""}{def Tx = ["CN", "JP", "KR", "KP", "TW", "HK"];def MJC = ["aeni", "donghua", "anime"];def Mm = any {anime} || info.Keywords.findAll { it in MJC } || (Tx.contains(country) && genres =~ /Animation/);Mm ? "Anime Movies/" : "Movies/"}{def jCJ = "TheMovieDB::TV";def bdG = [[nZf: 68854, ye: "From Me to You", BYz: jCJ],[nZf: 219816, ye: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", BYz: jCJ],[nZf: 276204, ye: "Bogus Skill Fruitmaster", WE: jCJ]];def hk = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def vEA = hk == "IMDb" ? "tt${id}" : id;def Fx = n;bdG.each {if (it.nZf == vEA && it.BYz == hk) {Fx = it.ye}};def uG = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def WAI = Fx.replaceAll(uG.collect { "\\" + it }.join('|'), '');WAI = WAI.replaceAll(/(\s|\.)*$/, '');WAI}{" ("}{y}{")"}{def hk = id == tmdbid ? "TheMovieDB" : "IMDb";def P_d = ["TheMovieDB": "tmdbid","IMDb": "imdbid"];def mT = P_d[hk];def vEA = hk == "IMDb" ? "tt${id}" : id;" [${mT}-${vEA}]/"}{def mcJ = ["Alqanime","BlackLuster","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws"];def Ddq = mcJ.find { VmB ->  fn.contains(VmB) } ?: "";def xa = any {(fn =~ /^\[(.*?)\]/)[0][1]} {Ddq} {group} {""};xa ? "[$xa] " : ""}{def jCJ = "TheMovieDB::TV";def bdG = [[nZf: 68854, ye: "From Me to You", BYz: jCJ],[nZf: 219816, ye: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", BYz: jCJ],[nZf: 276204, ye: "Bogus Skill Fruitmaster", WE: jCJ]];def hk = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def vEA = hk == "IMDb" ? "tt${id}" : id;def Fx = n;bdG.each {if (it.nZf == vEA && it.BYz == hk) {Fx = it.ye}};def uG = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def WAI = Fx.replaceAll(uG.collect { "\\" + it }.join('|'), '');WAI = WAI.replaceAll(/(\s|\.)*$/, '');WAI}{" ("}{y}{")"}{" ["}{def ix = [["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"],["COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["SHAHID"],["TVER"],["UNEXT"],["WETV"],["YT.WEB-DL", "YOUTUBE", "YTB"]];def uMR = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def iBN = ["Erai-raws", "SubsPlease"];def Efv = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def hj = any {def JwW = ix.find { TIJ ->  TIJ.find { so ->  fn.lower().contains(so.lower()) } }[0];JwW = JwW.replace(".WEB-DL", "");def CI = source.contains("WEB-DL");def MT = source ? ".${source}" : "";CI ? "${JwW}.WEB-DL" : JwW ? "${JwW}${MT}" : ""} {} {source} {uMR.find { uDz ->  group == uDz || Efv == uDz } ? "WEBRip" : ""} {def oE = iBN.find { GY ->  group == GY || Efv == GY} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : oE} {vs} {""};hj ? "$hj " : ""}{def AN = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $AN, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def hXN = " Dub";def rb = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : hXN;rb = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : rb;rb}{def bJ = any { audioLanguages.size() } { 0 };def rb = bJ > 2 ? " MAud" : bJ > 1 ? " DAud" : null;def jn = bJ > 5 ? audioLanguages.take(5) : audioLanguages;rb ? rb + jn.joining(" ", " (", "").upper() + (bJ > 5 ? " ...)" : ")") : ""}{def DH = any { textLanguages.size() } { 0 };def rb = DH > 2 ? ", MSub" : DH > 1 ? ", DSub" : null;def jn = DH > 5 ? textLanguages.take(5) : textLanguages;rb ? rb + jn.joining(" ", " (", "").upper() + (DH > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def xU = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def ap = subt;xU.values().each { e_ -> if (ap.contains(e_)) {ap = ap.replace(e_, "")}};xU.iso3b + ap}}{f.image ? "-thumb" : ""}