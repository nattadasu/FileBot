{def BSi = { System.getProperty(it) };def iK = BSi("os.name").toLowerCase().contains("windows");def AsU = BSi("user.name");def cM = "/run/media/${AsU}";def fAZ = iK ? "H:/" : "$cM/Videos";def LHH = [[LYZ: "Books", dJq: "F:/", hzb: "$cM/Books"],[LYZ: "Data", dJq: "D:/", hzb: "$cM/Data"],[LYZ: "Games", dJq: "G:/", hzb: "$cM/Games"],[LYZ: "Music", dJq: "E:/", hzb: "$cM/Music"],[LYZ: "Videos", dJq: "H:/", hzb: "$cM/Videos"]];def uFf = (LHH.collect { it[iK ? "dJq" : "hzb"] as File }.sort { ZwK, CW ->  ZwK.exists() <=> CW.exists() ?: ZwK.diskSpace <=> CW.diskSpace }).last();def eM = fAZ ?: uFf;"$eM/"}{"Videos/"}{def ENb = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def QVZ = "TheMovieDB::TV";def jHq = [[ 74180, QVZ],[ 93821, QVZ],[ 95897, QVZ],[220118, QVZ],[249891, QVZ],[271026, QVZ]];def BZl = [[236530, QVZ]];def sKP = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def JpD = sKP == "IMDb" ? "tt${id}" : id;def MnK = any { info.adult } { false };def BZ = jHq.find { it[0] == JpD && it[1] == sKP } != null;def sH = BZl.find { it[0] == JpD && it[1] == sKP } != null;def _z = info.Keywords.findAll { it in ENb } || BZ || MnK;_z = sH ? false : _z;_z ? "R18+ " : ""}{def YfU = ["CN", "JP", "KR", "KP", "TW", "HK"];def Kd = ["aeni", "donghua", "anime"];def yx = any {anime} || info.Keywords.findAll { it in Kd } || (YfU.contains(country) && genres =~ /Animation/);yx ? "Anime/" : "TV Series/"}{def QVZ = "TheMovieDB::TV";def rT = [[gR: 199928, lc: "Nights With a Cat", Bx: QVZ],[gR: 219816, lc: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", Bx: QVZ],[gR: 248707, lc: "Neko Oji The Guy That Got Reincarnated As a Cat", Bx: QVZ],[gR: 270657, lc: "Tono to Inu", Bx: QVZ],[gR: 271003, lc: "Yandere Dark Elf", Bx: QVZ],[gR: 274741, lc: "The Too-Perfect Saint", Bx: QVZ]];def sKP = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def JpD = sKP == "IMDb" ? "tt${id}" : id;def Hda = n;rT.each {if (it.gR == JpD && it.Bx == sKP) {Hda = it.lc}};def FB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ONU = Hda.replaceAll(FB.collect { "\\" + it }.join('|'), '');ONU = ONU.replaceAll(/(\s|\.)*$/, '');ONU}{def QVZ = "TheMovieDB::TV";def xbu = [[ 95897, QVZ],[123542, QVZ],[235973, QVZ],[239779, QVZ],[257162, QVZ],[259140, QVZ],[276204, QVZ]];def at = xbu.find { it[0] == id && it[1] == info.database } != null;def XPK = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def XhQ = XPK[info.database];at ? " ($y) [${XhQ}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def FB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ONU = sn.replaceAll(FB.collect { "\\" + it }.join('|'), '_');def XfX = n.replaceAll(FB.collect { "\\" + it }.join('|'), '_');def f_N = ONU.contains(XfX) ? "" : ONU;f_N == 'Season '+ s || f_N == 'Series '+ s ? "" : f_N ? " - " + f_N : ""}{"/"}{def KO = ["Alqanime","BlackLuster","darkflux","It's Anime","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def AXm = KO.find { hG ->  fn.lower().contains(hG.lower()) } ?: "";def TkK = any {AXm} {(fn =~ /^\[(.*?)\]/)[0][1]} {group} {""};TkK ? "[$TkK] " : ""}{def QVZ = "TheMovieDB::TV";def rT = [[gR: 199928, lc: "Nights With a Cat", Bx: QVZ],[gR: 219816, lc: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", Bx: QVZ],[gR: 248707, lc: "Neko Oji The Guy That Got Reincarnated As a Cat", Bx: QVZ],[gR: 270657, lc: "Tono to Inu", Bx: QVZ],[gR: 271003, lc: "Yandere Dark Elf", Bx: QVZ],[gR: 274741, lc: "The Too-Perfect Saint", Bx: QVZ]];def sKP = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def JpD = sKP == "IMDb" ? "tt${id}" : id;def Hda = n;rT.each {if (it.gR == JpD && it.Bx == sKP) {Hda = it.lc}};def FB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ONU = Hda.replaceAll(FB.collect { "\\" + it }.join('|'), '');ONU = ONU.replaceAll(/(\s|\.)*$/, '');ONU}{" - "}{s00e00}{def FB = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def ONU = t.replaceAll(FB.collect { "\\" + it }.join('|'), '_');ONU = ONU.length() > 100 ? " " : " - $ONU ";def GN = any { e } { special };def lu = "Episode $GN";def EpE = ONU.contains(lu) ? '' : ONU;EpE != '' ? EpE : ''}{" ["}{def JM = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA", "ABEMATV"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["CMIC", "COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["OVEIL", "OV.WEB-DL", "OceanVeil"],["SHAHID"],["TVER"],["UNEXT"],["VIDIO"],["WETV"]];def fB = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def uqE = ["DB"];def nF = ["Ruri-Saizen"];def mbz = ["Erai-raws", "SubsPlease"];def dh = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def KP = any {def uN = JM.find { lo ->  lo.find { ofB ->  fn.lower().contains(ofB.lower()) } }[0];uN = uN.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {uN = uN.replace(".WEBRip", "");uN = uN + ".WEBRip"} else {uN = uN + ".WEB-DL"};uN} {source} {fB.find { prP ->  group == prP || dh == prP } ? "WEBRip" : ""} {uqE.find { prP ->  group == prP || dh == prP } ? "BDRip" : ""} {nF.find { prP ->  group == g__ || dh == g__} ? "HDTVRip" : ""} {def Tf = mbz.find { FN ->  group == FN || dh == FN} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : Tf} {vs} {""};KP ? "$KP " : ""}{def pWn = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $pWn, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def Ko = any { audioLanguages.size() } { 0 };def qg = Ko > 2 ? " MULTi-AUD" : Ko > 1 ? " DUAL-AUD" : "";def Knb = Ko > 5 ? audioLanguages.take(5) : audioLanguages;def yJ = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : " DUBBED";qg = Ko == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : "$qg$yJ";qg ? qg + Knb.ISO2.joining(" ", " (", "").upper() + (Ko > 5 ? " ...)" : ")") : ""}{def pm = any { textLanguages.size() } { 0 };def qg = pm > 2 ? ", MULTi" : pm > 1 ? ", DUAL" : pm == 1 ? ", SUB" : null;def Knb = pm > 5 ? textLanguages.take(5) : textLanguages;qg ? qg + Knb.ISO2.joining(" ", " (", "").upper() + (pm > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def YbH = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def Ich = subt;YbH.values().each { LQ -> if (Ich.contains(LQ)) {Ich = Ich.replace(LQ, "")}};YbH.iso3b + Ich}}{f.image ? "-thumb" : ""}