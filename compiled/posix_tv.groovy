{def ajU = System.getProperty("user.name");def vM = "/run/media/${ajU}";def KA = "$vM/Videos";def iLx = [home,"$vM/Data","$vM/Music","$vM/Videos","$vM/Games","$vM/Books"].collect { it as File }.sort { kX, BVk ->  kX.exists() <=> BVk.exists() ?: kX.diskSpace <=> BVk.diskSpace }.last();def gQb = KA ? KA : iLx;"$gQb/"}{def Lj = /(CN|JP|KR|KP|TW|HK)/;def hl = /(aeni|donghua|anime)/;def Zub = anime || info.Keywords =~ hl || (genres =~ /Animation/ && country =~ Lj) ? true : false;Zub ? "Videos/Anime/" : "Videos/TV Series/"}{def kEZ = [[pmr: 229743, Bt: "VTuber Legend"],[pmr: 240633, Bt: "A Journey Through Another World"],[pmr: 245285, Bt: "Failure Frame"],[pmr: 237045, Bt: "Cherry Magic!"],[pmr: 68854, Bt: "From Me to You"],[pmr: 271026, Bt: "Taisho Era Contract Marriage"],[pmr: 234538, Bt: "Demon Lord 2099"]];def ks = n;kEZ.each {if (it.pmr == tmdbid && type.toString() != "Movie") {ks = it.Bt}};def HT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def KK = ks.replaceAll(HT.collect { "\\" + it }.join('|'), '');KK = KK.replaceAll(/(\s|\.)*$/, '');KK}{def AYp = [68854,235973,262295,259140,204098,239779,273190,271026,240125,275695,123542,257162];def ZG = AYp.find { YD ->  tmdbid == YD } ?: "";ZG ? " ($y) [tmdbid-$ZG]" : ""}/{episode.special ? 'Specials' : 'Season '+s}{def HT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def KK = sn.replaceAll(HT.collect { "\\" + it }.join('|'), '_');def _kx = n.replaceAll(HT.collect { "\\" + it }.join('|'), '_');def JB = KK.contains(_kx) ? "" : KK;JB == 'Season '+ s ? "" : JB ? " - " + JB : ""}/{def cwT = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def QUs = cwT.find { pxh ->  fn.contains(pxh) } ?: "";def ms = any {(fn =~ /^\[(.*?)\]/)[0][1]} {QUs} {group} {""};ms ? "[$ms] " : ""}{def kEZ = [[pmr: 229743, Bt: "VTuber Legend"],[pmr: 240633, Bt: "A Journey Through Another World"],[pmr: 245285, Bt: "Failure Frame"],[pmr: 237045, Bt: "Cherry Magic!"],[pmr: 68854, Bt: "From Me to You"],[pmr: 271026, Bt: "Taisho Era Contract Marriage"],[pmr: 234538, Bt: "Demon Lord 2099"]];def ks = n;kEZ.each {if (it.pmr == tmdbid && type.toString() != "Movie") {ks = it.Bt}};def HT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def KK = ks.replaceAll(HT.collect { "\\" + it }.join('|'), '');KK = KK.replaceAll(/(\s|\.)*$/, '');KK} - {s00e00}{def HT = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def KK = t.replaceAll(HT.collect { "\\" + it }.join('|'), '_');KK.length() > 100 ? " " : " - $KK "} [{def zjc = [[rE: "Bilibili.tv", lCG: ["B-Global", "BiliIntl", "BILI"]],[rE: "Prime Video", lCG: ["AMZN"]],[rE: "U-NEXT", lCG: ["UNEXT"]],[rE: "ABEMA", lCG: ["ABEMA"]],[rE: "Hulu", lCG: ["HULU"]],[rE: "Shahid", lCG: ["SHAHID"]],[rE: "YouTube", lCG: ["YT.WEB-DL", "YOUTUBE", "YTB"]],[rE: "Netflix", lCG: ["NF.WEB-DL", "NF WEB"]]];def PC = ["ASW", "Judas", "JRx7", "EMBER", "KawaSubs", "GuodongSubs"];def _Pt = ["Erai-raws", "SubsPlease"];def eqc = any {(fn =~ /^\[(.*?)\]/)[0][1]} {""};def Oto = any {def AL = zjc.find { ltj ->  ltj.lCG.find { _r ->  fn.contains(_r) } }?.lCG.first() ?: "";AL = AL.replace(".WEB-DL", "");AL ? "${AL}.WEB-DL" : ""} {source} {PC.find { gDc ->  group == gDc || eqc == gDc } ? "WEBRip" : ""} {def MO = _Pt.find { WcT ->  group == WcT || eqc == WcT} ? "WEB-DL" : "";(source == "Erai-raws" && vcf.upper() == "HEVC") ? "WEBRip" : MO} {vs} {""};Oto ? "$Oto " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac} {af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def nzH = " Dub";def XyR = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : nzH;XyR = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "und" } ? "" : XyR;XyR}{def Gv = any { audioLanguages.size() } { 0 };def XyR = Gv > 2 ? " MAud" : Gv > 1 ? " DAud" : null;def hKn = Gv > 5 ? audioLanguages.take(5) : audioLanguages;XyR ? XyR + hKn.joining(" ", " (", "").upper() + (Gv > 5 ? " ...)" : ")") : ""}{def R_ = any { textLanguages.size() } { 0 };def XyR = R_ > 2 ? ", MSub" : R_ > 1 ? ", DSub" : null;def hKn = R_ > 5 ? textLanguages.take(5) : textLanguages;XyR ? XyR + hKn.joining(" ", " (", "").upper() + (R_ > 5 ? " ...)" : ")") : ""}][{crc32.upper()}]{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}