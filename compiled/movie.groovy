{def Bc = { System.getProperty(it) };def Ng = Bc("os.name").toLowerCase().contains("windows");def hx = Bc("user.name");def sLu = "/run/media/${hx}";def Io = Ng ? "H:/" : "$sLu/Videos";def miu = [[pE: "Books", UVL: "F:/", ut: "$sLu/Books"],[pE: "Data", UVL: "D:/", ut: "$sLu/Data"],[pE: "Games", UVL: "G:/", ut: "$sLu/Games"],[pE: "Music", UVL: "E:/", ut: "$sLu/Music"],[pE: "Videos", UVL: "H:/", ut: "$sLu/Videos"]];def syc = (miu.collect { it[Ng ? "UVL" : "ut"] as File }.sort { _S, TlB ->  _S.exists() <=> TlB.exists() ?: _S.diskSpace <=> TlB.diskSpace }).last();def zrU = Io ?: syc;"$zrU/"}{"Videos/"}{def stz = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def PiF = "TheMovieDB::TV";def Leo = [[ 74180, PiF],[ 93821, PiF],[ 95897, PiF],[220118, PiF],[249891, PiF],[271026, PiF]];def LB = [[236530, PiF]];def iq = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def gID = iq == "IMDb" ? "tt${id}" : id;def MM = any { info.adult } { false };def emI = Leo.find { it[0] == gID && it[1] == iq } != null;def nO = LB.find { it[0] == gID && it[1] == iq } != null;def DnE = info.Keywords.findAll { it in stz } || emI || MM;DnE = nO ? false : DnE;DnE ? "R18+ " : ""}{def TnI = ["CN", "JP", "KR", "KP", "TW", "HK"];def yfo = ["aeni", "donghua", "anime"];def bXs = any {anime} || info.Keywords.findAll { it in yfo } || (TnI.contains(country) && genres =~ /Animation/);bXs ? "Anime Movies/" : "Movies/"}{def PiF = "TheMovieDB::TV";def EwE = [[hc: 68854, f_: "From Me to You", wV: PiF],[hc: 100937, f_: "Crazy Over His Fingers", wV: PiF],[hc: 199928, f_: "Nights With a Cat", wV: PiF],[hc: 219816, f_: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", wV: PiF],[hc: 245561, f_: "Okitsura", wV: PiF],[hc: 248707, f_: "Neko Oji The Guy That Got Reincarnated As a Cat", wV: PiF],[hc: 259559, f_: "Headhunted to Another World", wV: PiF],[hc: 261301, f_: "Botsuraku Kizoku", wV: PiF],[hc: 262141, f_: "Can You Keep a Secret", wV: PiF],[hc: 270657, f_: "Tono to Inu", wV: PiF],[hc: 276204, f_: "Bogus Skill Fruitmaster", wV: PiF]];def iq = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def gID = iq == "IMDb" ? "tt${id}" : id;def XW = n;EwE.each {if (it.hc == gID && it.wV == iq) {XW = it.f_}};def Fy = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def mwJ = XW.replaceAll(Fy.collect { "\\" + it }.join('|'), '');mwJ = mwJ.replaceAll(/(\s|\.)*$/, '');mwJ}{" ("}{y}{")"}{"/"}{def wg = ["Alqanime","BlackLuster","darkflux","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def In = wg.find { kfJ ->  fn.lower().contains(kfJ.lower()) } ?: "";def Xd = any {(fn =~ /^\[(.*?)\]/)[0][1]} {In} {group} {""};Xd ? "[$Xd] " : ""}{def PiF = "TheMovieDB::TV";def EwE = [[hc: 68854, f_: "From Me to You", wV: PiF],[hc: 100937, f_: "Crazy Over His Fingers", wV: PiF],[hc: 199928, f_: "Nights With a Cat", wV: PiF],[hc: 219816, f_: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", wV: PiF],[hc: 245561, f_: "Okitsura", wV: PiF],[hc: 248707, f_: "Neko Oji The Guy That Got Reincarnated As a Cat", wV: PiF],[hc: 259559, f_: "Headhunted to Another World", wV: PiF],[hc: 261301, f_: "Botsuraku Kizoku", wV: PiF],[hc: 262141, f_: "Can You Keep a Secret", wV: PiF],[hc: 270657, f_: "Tono to Inu", wV: PiF],[hc: 276204, f_: "Bogus Skill Fruitmaster", wV: PiF]];def iq = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def gID = iq == "IMDb" ? "tt${id}" : id;def XW = n;EwE.each {if (it.hc == gID && it.wV == iq) {XW = it.f_}};def Fy = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def mwJ = XW.replaceAll(Fy.collect { "\\" + it }.join('|'), '');mwJ = mwJ.replaceAll(/(\s|\.)*$/, '');mwJ}{" ("}{y}{") ["}{def cqN = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["SHAHID"],["TVER"],["UNEXT"],["WETV"]];def kij = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def iK = ["DB"];def uw = ["Ruri-Saizen"];def Cxd = ["Erai-raws", "SubsPlease"];def BxD = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def yoy = any {def pht = cqN.find { mg ->  mg.find { YP ->  fn.lower().contains(YP.lower()) } }[0];pht = pht.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {pht = pht.replace(".WEBRip", "");pht = pht + ".WEBRip"} else {pht = pht + ".WEB-DL"};pht} {source} {kij.find { oXz ->  group == oXz || BxD == oXz } ? "WEBRip" : ""} {iK.find { oXz ->  group == oXz || BxD == oXz } ? "BDRip" : ""} {uw.find { oXz ->  group == g__ || BxD == g__} ? "HDTVRip" : ""} {def pV = Cxd.find { YR ->  group == YR || BxD == YR} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : pV} {vs} {""};yoy ? "$yoy " : ""}{def YSp = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $YSp, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def gWq = any { audioLanguages.size() } { 0 };def xZT = gWq > 2 ? " MULTi-AUD" : gWq > 1 ? " DUAL-AUD" : null;def oxY = gWq > 5 ? audioLanguages.take(5) : audioLanguages;xZT ? xZT + oxY.ISO2.joining(" ", " (", "").upper() + (gWq > 5 ? " ...)" : ")") : ""}{def Wd = " DUBBED";def xZT = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : Wd;xZT = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : xZT;xZT}{def QOR = any { textLanguages.size() } { 0 };def xZT = QOR > 2 ? ", MULTi" : QOR > 1 ? ", DUAL" : QOR == 1 ? ", SUB" : null;def oxY = QOR > 5 ? textLanguages.take(5) : textLanguages;xZT ? xZT + oxY.ISO2.joining(" ", " (", "").upper() + (QOR > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def LU = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def Ai = subt;LU.values().each { co -> if (Ai.contains(co)) {Ai = Ai.replace(co, "")}};LU.iso3b + Ai}}{f.image ? "-thumb" : ""}