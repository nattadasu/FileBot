{def u_ = System.getProperty("user.name");def mntp = "/run/media/${u_}";def ov_ = "$mntp/Videos";def gs_ = [home,"$mntp/Data","$mntp/Music","$mntp/Videos","$mntp/Games","$mntp/Books"].collect { it as File }.sort { a, b -> a.exists() <=> b.exists() ?: a.diskSpace <=> b.diskSpace }.last();def fn_ = ov_ ? ov_ : gs_;"$fn_/"}{def cc_ = /(CN|JP|KR|KP|TW|HK)/;def ct_ = /(aeni|donghua|anime)/;def ia_ = anime || info.Keywords =~ ct_ || any {(genres =~ /Animation/ && country =~ cc_)}{false} ? true : false;def cct = ia_ ? "Videos/Anime " : "Videos/";"$cct" + "Movies/"}{def st_ = [[si_: 229743, sti: "VTuber Legend"],[si_: 240633, sti: "A Journey Through Another World"],[si_: 245285, sti: "Failure Frame"],[si_: 237045, sti: "Cherry Magic!"],[si_: 68854, sti: "From Me to You"],[si_: 271026, sti: "Taisho Era Contract Marriage"],[si_: 234538, sti: "Demon Lord 2099"]];def n__ = n;st_.each {if (it.si_ == tmdbid && type.toString() != "Movie") {n__ = it.sti}};def ic_ = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def fxn = n__.replaceAll(ic_.collect { "\\" + it }.join('|'), '');fxn = fxn.replaceAll(/(\s|\.)*$/, '');fxn}{" ("}{y}{") [tmdbid-"}{tmdbid}{"]/"}{def cgs = ["Alqanime","BlackLuster","NanDesuKa","ToonsHub","Tsundere-Raws"];def fgr = cgs.find { grn -> fn.contains(grn) } ?: "";def gr_ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {fgr} {group} {""};gr_ ? "[$gr_] " : ""}{def st_ = [[si_: 229743, sti: "VTuber Legend"],[si_: 240633, sti: "A Journey Through Another World"],[si_: 245285, sti: "Failure Frame"],[si_: 237045, sti: "Cherry Magic!"],[si_: 68854, sti: "From Me to You"],[si_: 271026, sti: "Taisho Era Contract Marriage"],[si_: 234538, sti: "Demon Lord 2099"]];def n__ = n;st_.each {if (it.si_ == tmdbid && type.toString() != "Movie") {n__ = it.sti}};def ic_ = ['\\', '/', ':', '*', '?', '"', '<', '>', '|'];def fxn = n__.replaceAll(ic_.collect { "\\" + it }.join('|'), '');fxn = fxn.replaceAll(/(\s|\.)*$/, '');fxn}{" ("}{y}{")"}{" ["}{def crs = [[pfm: "Bilibili.tv", als: ["B-Global", "BiliIntl", "BILI"]],[pfm: "Prime Video", als: ["AMZN"]],[pfm: "U-NEXT", als: ["UNEXT"]],[pfm: "ABEMA", als: ["ABEMA"]],[pfm: "Hulu", als: ["HULU"]],[pfm: "Shahid", als: ["SHAHID"]],[pfm: "YouTube", als: ["YT.WEB-DL", "YOUTUBE", "YTB"]]];def rng = ["ASW", "Judas"];def rlg = ["Erai-raws", "SubsPlease"];def rl_ = any {def al_ = crs.find { ctr -> ctr.als.find { aka -> fn.contains(aka) } }?.als.first() ?: "";al_ = al_.replace("YT.WEB-DL", "YT");al_ ? "${al_}.WEB-DL" : ""} {source} {rng.find { g_ -> group == g_ } ? "WEBRip" : ""} {rlg.find { r_ -> group == r_ } ? "WEB-DL" : ""} {""};rl_ ? "$rl_ " : ""}{resolution} {vcf.upper()}{bitdepth ? " ${bitdepth}bit" : ""}, {ac}{" "}{af.format(8: 'DD+ 7.1',7: '6.1',6: 'DD 5.1',5: '5.0',3: '2.1',2: '2.0',1: '1.0',)}{def dub = " Dub";def sst = audioLanguages.any { it.ISO3B == language.ISO3B } ? "" : dub;sst = audioLanguages.size() == 1 && audioLanguages.any { it.ISO3B == "UND" } ? "" : sst;sst}{def alc = any { audioLanguages.size() } { 0 };def sst = alc > 2 ? " MAud" : alc > 1 ? " DAud" : null;def lg_ = alc > 5 ? audioLanguages.take(5) : audioLanguages;sst ? sst + lg_.joining(" ", " (", "").upper() + (alc > 5 ? " ...)" : ")") : ""}{def tlc = any { textLanguages.size() } { 0 };def sst = tlc > 2 ? ", MSub" : tlc > 1 ? ", DSub" : null;def lg_ = tlc > 5 ? textLanguages.take(5) : textLanguages;sst ? sst + lg_.joining(" ", " (", "").upper() + (tlc > 5 ? " ...)" : ")") : ""}{"]["}{crc32.upper()}{"]"}{ext =~ /(ass|srt|ssa|vtt)/ ? '.' + lang.ISO3B : ""}{ext =~ /jp(?:e)?g|png/ ? "-thumb" : ""}