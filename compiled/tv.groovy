{def ZMA = { System.getProperty(it) };def Khj = ZMA("os.name").toLowerCase().contains("windows");def dDv = ZMA("user.name");def iA = "/run/media/${dDv}";def Go = Khj ? "H:/" : "$iA/Videos";def pW = [[MW: "Books", Isl: "F:/", Hi: "$iA/Books"],[MW: "Data", Isl: "D:/", Hi: "$iA/Data"],[MW: "Games", Isl: "G:/", Hi: "$iA/Games"],[MW: "Music", Isl: "E:/", Hi: "$iA/Music"],[MW: "Videos", Isl: "H:/", Hi: "$iA/Videos"]];def jZp = (pW.collect { it[Khj ? "Isl" : "Hi"] as File }.sort { oj, Op ->  oj.exists() <=> Op.exists() ?: oj.diskSpace <=> Op.diskSpace }).last();def Vnj = Go ?: jZp;"$Vnj/"}{"Videos/"}{def tC = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity"];def bo = "TheMovieDB::TV";def Wc = [[ 74180, bo],[ 93821, bo],[ 95897, bo],[220118, bo],[271026, bo]];def AVQ = [[236530, bo]];def Rky = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def GT = Rky == "IMDb" ? "tt${id}" : id;def wY = any { info.adult } { false };def mSL = Wc.find { it[0] == GT && it[1] == Rky } != null;def QA = AVQ.find { it[0] == GT && it[1] == Rky } != null;def tQ = info.Keywords.findAll { it in tC } || mSL || wY;tQ = QA ? false : tQ;tQ ? "R18+ " : ""}{def gUh = ["CN", "JP", "KR", "KP", "TW", "HK"];def Md = ["aeni", "donghua", "anime"];def is = any {anime} || info.Keywords.findAll { it in Md } || (gUh.contains(country) && genres =~ /Animation/);is ? "Anime/" : "TV Series/"}{def bo = "TheMovieDB::TV";def rQI = [[KF: 68854, dq: "From Me to You", YR: bo],[KF: 219816, dq: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", YR: bo],[KF: 276204, dq: "Bogus Skill Fruitmaster", YR: bo]];def Rky = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def GT = Rky == "IMDb" ? "tt${id}" : id;def aR = n;rQI.each {if (it.KF == GT && it.YR == Rky) {aR = it.dq}};def bKT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def CW = aR.replaceAll(bKT.collect { "\\" + it }.join('|'), '');CW = CW.replaceAll(/(\s|\.)*$/, '');CW}{def bo = "TheMovieDB::TV";def fa = [[ 95897, bo],[123542, bo],[235973, bo],[239779, bo],[257162, bo],[259140, bo],[276204, bo]];def fhi = fa.find { it[0] == id && it[1] == info.database } != null;def jsd = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def Dw = jsd[info.database];fhi ? " ($y) [${Dw}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def bKT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def CW = sn.replaceAll(bKT.collect { "\\" + it }.join('|'), '_');def vTT = n.replaceAll(bKT.collect { "\\" + it }.join('|'), '_');def Ymi = CW.contains(vTT) ? "" : CW;Ymi == 'Season '+ s ? "" : Ymi ? " - " + Ymi : ""}{"/"}{def JN = ["Alqanime","BlackLuster","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws"];def EB = JN.find { WqZ ->  fn.contains(WqZ) } ?: "";def YQ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {EB} {group} {""};YQ ? "[$YQ] " : ""}{def bo = "TheMovieDB::TV";def rQI = [[KF: 68854, dq: "From Me to You", YR: bo],[KF: 219816, dq: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", YR: bo],[KF: 276204, dq: "Bogus Skill Fruitmaster", YR: bo]];def Rky = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def GT = Rky == "IMDb" ? "tt${id}" : id;def aR = n;rQI.each {if (it.KF == GT && it.YR == Rky) {aR = it.dq}};def bKT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def CW = aR.replaceAll(bKT.collect { "\\" + it }.join('|'), '');CW = CW.replaceAll(/(\s|\.)*$/, '');CW}{" - "}{s00e00}{def bKT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def CW = t.replaceAll(bKT.collect { "\\" + it }.join('|'), '_');def tt = any { e } { special };CW = CW.length() > 100 ? " " : " - $CW ";CW == " - Episode $tt " ? " " : CW}{" ["}{def gN = [["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"],["COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["SHAHID"],["TVER"],["UNEXT"],["WETV"],["YT.WEB-DL", "YOUTUBE", "YTB"]];def gl = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def Tl = ["Erai-raws", "SubsPlease"];def zLw = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def spy = any {def xTB = gN.find { VBJ ->  VBJ.find { R_ ->  fn.lower().contains(R_.lower()) } }[0];xTB = xTB.replace(".WEB-DL", "");def nj = source.contains("WEB-DL");def pAR = source ? ".${source}" : "";nj ? "${xTB}.WEB-DL" : xTB ? "${xTB}${pAR}" : ""} {} {source} {gl.find { qLq ->  group == qLq || zLw == qLq } ? "WEBRip" : ""} {def nW = Tl.find { YfR ->  group == YfR || zLw == YfR} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : nW} {vs} {""};spy ? "$spy " : ""}{def XQk = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $XQk, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def uRH = " Dub";def IT = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : uRH;IT = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : IT;IT}{def Xz = any { audioLanguages.size() } { 0 };def IT = Xz > 2 ? " MAud" : Xz > 1 ? " DAud" : null;def pU = Xz > 5 ? audioLanguages.take(5) : audioLanguages;IT ? IT + pU.joining(" ", " (", "").upper() + (Xz > 5 ? " ...)" : ")") : ""}{def UN = any { textLanguages.size() } { 0 };def IT = UN > 2 ? ", MSub" : UN > 1 ? ", DSub" : null;def pU = UN > 5 ? textLanguages.take(5) : textLanguages;IT ? IT + pU.joining(" ", " (", "").upper() + (UN > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def TkK = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def BrL = subt;TkK.values().each { cUR -> if (BrL.contains(cUR)) {BrL = BrL.replace(cUR, "")}};TkK.iso3b + BrL}}{f.image ? "-thumb" : ""}