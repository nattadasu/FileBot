{def Dq = { System.getProperty(it) };def oYS = Dq("os.name").toLowerCase().contains("windows");def tV = Dq("user.name");def gO = "/run/media/${tV}";def xI = oYS ? "H:/" : "$gO/Videos";def iI = [[eH: "Books", QC: "F:/", vkP: "$gO/Books"],[eH: "Data", QC: "D:/", vkP: "$gO/Data"],[eH: "Games", QC: "G:/", vkP: "$gO/Games"],[eH: "Music", QC: "E:/", vkP: "$gO/Music"],[eH: "Videos", QC: "H:/", vkP: "$gO/Videos"]];def iR = (iI.collect { it[oYS ? "QC" : "vkP"] as File }.sort { Ll, HD ->  Ll.exists() <=> HD.exists() ?: Ll.diskSpace <=> HD.diskSpace }).last();def Kyg = xI ?: iR;"$Kyg/"}{"Videos/"}{def LYo = ["boys' love (bl)", "gay theme", "yaoi", "yuri", "lesbian", "hentai","sex", "lgbt", "explicit", "adult animation", "adult content","nudity", "animefesta"];def rg = "TheMovieDB::TV";def Omp = [[ 74180, rg],[ 93821, rg],[ 95897, rg],[220118, rg],[249891, rg],[271026, rg]];def Axf = [[236530, rg]];def Nje = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def Mk = Nje == "IMDb" ? "tt${id}" : id;def pH = any { info.adult } { false };def XI = Omp.find { it[0] == Mk && it[1] == Nje } != null;def Ya = Axf.find { it[0] == Mk && it[1] == Nje } != null;def KQv = info.Keywords.findAll { it in LYo } || XI || pH;KQv = Ya ? false : KQv;KQv ? "R18+ " : ""}{def euU = ["CN", "JP", "KR", "KP", "TW", "HK"];def eZs = ["aeni", "donghua", "anime"];def ldA = any {anime} || info.Keywords.findAll { it in eZs } || (euU.contains(country) && genres =~ /Animation/);ldA ? "Anime/" : "TV Series/"}{def rg = "TheMovieDB::TV";def fnq = [[co: 68854, oaR: "From Me to You", Nn: rg],[co: 199928, oaR: "Nights With a Cat", Nn: rg],[co: 219816, oaR: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", Nn: rg],[co: 245561, oaR: "Okitsura", Nn: rg],[co: 248707, oaR: "Neko Oji The Guy That Got Reincarnated As a Cat", Nn: rg],[co: 259559, oaR: "Headhunted to Another World", Nn: rg],[co: 261301, oaR: "Botsuraku Kizoku", Nn: rg],[co: 262141, oaR: "Can You Keep a Secret", Nn: rg],[co: 270657, oaR: "Tono to Inu", Nn: rg],[co: 276204, oaR: "Bogus Skill Fruitmaster", Nn: rg]];def Nje = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def Mk = Nje == "IMDb" ? "tt${id}" : id;def eBR = n;fnq.each {if (it.co == Mk && it.Nn == Nje) {eBR = it.oaR}};def eNK = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def rS = eBR.replaceAll(eNK.collect { "\\" + it }.join('|'), '');rS = rS.replaceAll(/(\s|\.)*$/, '');rS}{def rg = "TheMovieDB::TV";def mJL = [[ 95897, rg],[123542, rg],[235973, rg],[239779, rg],[257162, rg],[259140, rg],[276204, rg]];def RmI = mJL.find { it[0] == id && it[1] == info.database } != null;def HSK = ["TheMovieDB::TV": "tmdbid","AniDB": "anidbid","TheTVDB": "tvdbid","TVmaze": "tvmazeid"];def zuP = HSK[info.database];RmI ? " ($y) [${zuP}-${id}]" : ""}{"/"}{episode.special ? 'Specials' : 'Season '+s}{def eNK = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def rS = sn.replaceAll(eNK.collect { "\\" + it }.join('|'), '_');def Iw = n.replaceAll(eNK.collect { "\\" + it }.join('|'), '_');def wOS = rS.contains(Iw) ? "" : rS;wOS == 'Season '+ s || wOS == 'Series '+ s ? "" : wOS ? " - " + wOS : ""}{"/"}{def eI = ["Alqanime","BlackLuster","darkflux","Kuramanime","NanDesuKa","ToonsHub","Tsundere-Raws","S1PH3R","Samehadaku"];def VL = eI.find { tR ->  fn.lower().contains(tR.lower()) } ?: "";def nm = any {(fn =~ /^\[(.*?)\]/)[0][1]} {VL} {group} {""};nm ? "[$nm] " : ""}{def rg = "TheMovieDB::TV";def fnq = [[co: 68854, oaR: "From Me to You", Nn: rg],[co: 199928, oaR: "Nights With a Cat", Nn: rg],[co: 219816, oaR: "Fate Grand Order Fujimaru Ritsuka Doesn't Get It", Nn: rg],[co: 245561, oaR: "Okitsura", Nn: rg],[co: 248707, oaR: "Neko Oji The Guy That Got Reincarnated As a Cat", Nn: rg],[co: 259559, oaR: "Headhunted to Another World", Nn: rg],[co: 261301, oaR: "Botsuraku Kizoku", Nn: rg],[co: 262141, oaR: "Can You Keep a Secret", Nn: rg],[co: 270657, oaR: "Tono to Inu", Nn: rg],[co: 276204, oaR: "Bogus Skill Fruitmaster", Nn: rg]];def Nje = any { info.database } { id == tmdbid ? "TheMovieDB" : "IMDb" };def Mk = Nje == "IMDb" ? "tt${id}" : id;def eBR = n;fnq.each {if (it.co == Mk && it.Nn == Nje) {eBR = it.oaR}};def eNK = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def rS = eBR.replaceAll(eNK.collect { "\\" + it }.join('|'), '');rS = rS.replaceAll(/(\s|\.)*$/, '');rS}{" - "}{s00e00}{def eNK = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def rS = t.replaceAll(eNK.collect { "\\" + it }.join('|'), '_');rS = rS.length() > 100 ? " " : " - $rS ";def omD = any { e } { special };def qw = "Episode $omD";def Yp = rS.contains(qw) ? '' : rS;Yp != '' ? Yp : ''}{" ["}{def ZYz = [["YTB", "YT.WEB-DL", "YOUTUBE"],["ABEMA"],["ADN"],["BILI", "B-Global", "BiliIntl"],["BSITE", "BILICN"],["COOLMIC"],["HIDIVE", "HIDI.WEB-DL"],["IQIYI", "IQ.WEB-DL"],["JFFP"],["LAFTEL", "LFTL"],["MDON", "MANGADON"],["MW.WEB-DL"],["NF.WEB-DL", "NF WEB"],["SHAHID"],["TVER"],["UNEXT"],["WETV"]];def uXz = ["ASW", "Judas", "JRx7", "EMBER", "GuodongSubs", "SAMEHADAKU"];def ir = ["DB"];def UbG = ["Ruri-Saizen"];def FH = ["Erai-raws", "SubsPlease"];def jK = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def iQj = any {def qq = ZYz.find { Gt ->  Gt.find { JQC ->  fn.lower().contains(JQC.lower()) } }[0];qq = qq.replace(".WEB-DL", "");if (fn.contains("WEBRip")) {qq = qq.replace(".WEBRip", "");qq = qq + ".WEBRip"} else {qq = qq + ".WEB-DL"};qq} {source} {uXz.find { XQF ->  group == XQF || jK == XQF } ? "WEBRip" : ""} {ir.find { XQF ->  group == XQF || jK == XQF } ? "BDRip" : ""} {UbG.find { XQF ->  group == g__ || jK == g__} ? "HDTVRip" : ""} {def Pd = FH.find { pX ->  group == pX || jK == pX} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : Pd} {vs} {""};iQj ? "$iQj " : ""}{def dK = bitdepth ? " ${bitdepth}bit" : "";"$resolution $vcf $dK, $ac"}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0')}{def gfn = any { audioLanguages.size() } { 0 };def Ks = gfn > 2 ? " MULTi-AUD" : gfn > 1 ? " DUAL-AUD" : null;def zyX = gfn > 5 ? audioLanguages.take(5) : audioLanguages;Ks ? Ks + zyX.ISO2.joining(" ", " (", "").upper() + (gfn > 5 ? " ...)" : ")") : ""}{def lZ = " DUBBED";def Ks = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : lZ;Ks = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : Ks;Ks}{def np = any { textLanguages.size() } { 0 };def Ks = np > 2 ? ", MULTi" : np > 1 ? ", DUAL" : np == 1 ? ", SUB" : null;def zyX = np > 5 ? textLanguages.take(5) : textLanguages;Ks ? Ks + zyX.ISO2.joining(" ", " (", "").upper() + (np > 6 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{if (f.subtitle) {def Mt = ["name": "." + lang.name,"iso3b": "." + lang.ISO3B,"iso3": "." +lang.ISO3,"iso2": "." + lang.ISO2];def sre = subt;Mt.values().each { Li -> if (sre.contains(Li)) {sre = sre.replace(Li, "")}};Mt.iso3b + sre}}{f.image ? "-thumb" : ""}