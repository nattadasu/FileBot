{def DXd = { System.getProperty(it) };def FE = DXd("os.name").toLowerCase().contains("windows");def Ba = DXd("user.name");def lEC = "/run/media/${Ba}";def U_ = FE ? "H:/" : "$lEC/Videos";def ktb = [[aa: "Books", CP: "F:/", Ml: "$lEC/Books"],[aa: "Data", CP: "D:/", Ml: "$lEC/Data"],[aa: "Games", CP: "G:/", Ml: "$lEC/Games"],[aa: "Music", CP: "E:/", Ml: "$lEC/Music"],[aa: "Videos", CP: "H:/", Ml: "$lEC/Videos"]];def QQA = (ktb.collect { it[FE ? "CP" : "Ml"] as File }.sort { ZE, Alg ->  ZE.exists() <=> Alg.exists() ?: ZE.diskSpace <=> Alg.diskSpace }).last();def QU = U_ ?: QQA;"$QU/"}{"Videos/"}{def ck_ = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity"];def Rc = "TheMovieDB::TV";def RD = [[ 74180, Rc],[ 93821, Rc],[ 95897, Rc],[220118, Rc],[271026, Rc]];def KMT = [[236530, Rc]];def jn = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def n_ = jn == "IMDb" ? "tt${id}" : id;def uhK = any { info.adult } { false };def lA = RD.find { it[0] == n_ && it[1] == jn } != null;def aq = KMT.find { it[0] == n_ && it[1] == jn } != null;def Xt = info.Keywords.findAll { it in ck_ } || lA || uhK;Xt = aq ? false : Xt;Xt ? "R18+ " : ""}{def vOq = ["CN", "JP", "KR", "KP", "TW", "HK"];def WJU = ["aeni", "donghua", "anime"];def JZO = any {anime} || info.Keywords.findAll { it in WJU } || (vOq.contains(country) && genres =~ /Animation/);JZO ? "Anime Movies/" : "Movies/"}{def Rc = "TheMovieDB::TV";def QNO = [[XU: 68854, uZ: "From Me to You", Ix: Rc],[XU: 219816, uZ: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", Ix: Rc],[XU: 259559, uZ: "Headhunted to Another World", Ix: Rc],[XU: 276204, uZ: "Bogus Skill Fruitmaster", Ix: Rc]];def jn = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def n_ = jn == "IMDb" ? "tt${id}" : id;def nKh = n;QNO.each {if (it.XU == n_ && it.Ix == jn) {nKh = it.uZ}};def _K = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def lhG = nKh.replaceAll(_K.collect { "\\" + it }.join('|'), '');lhG = lhG.replaceAll(/(\s|\.)*$/, '');lhG}{" ("}{y}{")"}{"/"}{def om_ = ["Alqanime","BlackLuster","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","Samehadaku"];def KFX = om_.find { vv ->  fn.lower().contains(vv.lower()) } ?: "";def oe = any {(fn =~ /^\[(.*?)\]/)[0][1]} {KFX} {group} {""};oe ? "[$oe] " : ""}{def Rc = "TheMovieDB::TV";def QNO = [[XU: 68854, uZ: "From Me to You", Ix: Rc],[XU: 219816, uZ: "Fate/Grand Order: Fujimaru Ritsuka Doesn't Get It", Ix: Rc],[XU: 259559, uZ: "Headhunted to Another World", Ix: Rc],[XU: 276204, uZ: "Bogus Skill Fruitmaster", Ix: Rc]];def jn = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def n_ = jn == "IMDb" ? "tt${id}" : id;def nKh = n;QNO.each {if (it.XU == n_ && it.Ix == jn) {nKh = it.uZ}};def _K = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def lhG = nKh.replaceAll(_K.collect { "\\" + it }.join('|'), '');lhG = lhG.replaceAll(/(\s|\.)*$/, '');lhG}{" ("}{y}{")"}{" ["}{def wPT = [["ABEMA"],["ADN"],["BBC"],["BILI", "B-Global", "BiliIntl", "B-Site", "BiliCN"],["COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["SHAHID"],["TVER"],["UNEXT"],["WETV"],["YTB", "YT.WEB-DL", "YOUTUBE"]];def GGM = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs", "SAMEHADAKU"];def RH = ["Erai-raws", "SubsPlease"];def FwT = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def NV = any {def FXA = wPT.find { xp ->  xp.find { NEE ->  fn.lower().contains(NEE.lower()) } }[0];FXA = FXA.replace(".WEB-DL", "");FXA ? "${FXA}.WEB-DL" : ""} {source} {GGM.find { nsy ->  group == nsy || FwT == nsy } ? "WEBRip" : ""} {def KM = RH.find { jVQ ->  group == jVQ || FwT == jVQ} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : KM} {vs} {""};NV ? "$NV " : ""}{def em = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $em, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def gp = " Dub";def yw = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : gp;yw = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : yw;yw}{def gv = any { audioLanguages.size() } { 0 };def yw = gv > 2 ? " MAud" : gv > 1 ? " DAud" : null;def oXr = gv > 5 ? audioLanguages.take(5) : audioLanguages;yw ? yw + oXr.joining(" ", " (", "").upper() + (gv > 5 ? " ...)" : ")") : ""}{def UO = any { textLanguages.size() } { 0 };def yw = UO > 2 ? ", MSub" : UO > 1 ? ", DSub" : null;def oXr = UO > 5 ? textLanguages.take(5) : textLanguages;yw ? yw + oXr.joining(" ", " (", "").upper() + (UO > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def qmS = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def ig = subt;qmS.values().each { YBq -> if (ig.contains(YBq)) {ig = ig.replace(YBq, "")}};qmS.iso3b + ig}}{f.image ? "-thumb" : ""}