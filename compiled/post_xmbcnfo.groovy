{ source, target, metadata -> if (type.toString() != "Episode" || !vf || ext =~ /(ass|srt|ssa|vtt)/) {return null};def suJ = target.dir;def hA = any{ s } { 0 };def so = any{ e } { special };def ME = 0;def Jxj = null;try {if (db.TheTVDB?.id) {def xYA = curl "https://api.tvmaze.com/lookup/shows?thetvdb=${db.TheTVDB.id}";def Vd = xYA.id;Jxj = curl "https://api.tvmaze.com/shows/$Vd/episodebynumber?season=$hA&number=$so";ME = Jxj.id}} catch (Exception err) {};def exK = "";def hD = "en-US";def LI = null;def td = new File("$home/.filebotsecrets.json");if (td.exists()) {def mB = new groovy.json.JsonSlurper().parseText(td.text);exK = mB.exK;hD = mB.language;LI = mB.person_info_dir};def bTb = "https://api.themoviedb.org/3/tv/$id/season/$hA/episode/$so";def nU = curl(["accept": "application/json"], "$bTb?language=$hD&api_key=$exK");def VC = curl(["accept": "application/json"], "$bTb/external_ids?api_key=$exK");def sR = curl(["accept": "application/json"], "$bTb/credits?language=$hD&api_key=$exK");def La = curl(["accept": "application/json"], "$bTb/images?include_image_language=en%2Cnull&api_key=$exK");def _mk = (suJ / target.nameWithoutExtension + "-thumb.jpg").toString();def Bcd = new File(_mk);def iR = new File(_mk.replace("-thumb",""));if (!(Bcd.exists() || iR.exists()) && La.stills.size() > 0) {def PQY = "https://image.tmdb.org/t/p/original${La.stills[0].file_path}";system "curl", "-o", suJ / target.nameWithoutExtension + "-thumb.jpg", PQY};def Lh = [];(sR.cast + sR.guest_stars).eachWithIndex { sHS, g_ -> def fjz = "$LI/${sHS.name[0]}/${sHS.name}";def BG = sHS.order ?: g_ + Lh.size();Lh << [Wq: sHS.name, tL: sHS.character, tC: BG, fjz: "${fjz}/folder.jpg"];if (LI) {def cO = new File(fjz);if (!cO.exists()) {cO.mkdirs();system "curl", "-o", "${fjz}/folder.jpg", "https://image.tmdb.org/t/p/original${sHS.profile_path}"}}};def vso = suJ / target.nameWithoutExtension + ".nfo";XML(vso) {mkp.xmlDeclaration(version: "1.0", encoding: "utf-8", standalone: "yes");episodedetails {plot(nU.overview);lockdata("false");dateadded(new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")));title(t);originaltitle(localize."${languages[0]}".t);rating(rating);year(airdate.format("yyyy"));uniqueid(type: "tmdb", value: episode.id, 'default': "true", episode.id);tmdbid(episode.id);if (VC?.imdb_id) {uniqueid(type: "imdb", value: VC.imdb_id, VC.imdb_id);imdbid(VC.imdb_id)};if (VC?.tvdb_id) {uniqueid(type: "tvdb", value: VC.tvdb_id, VC.tvdb_id);tvdbid(VC.tvdb_id)};try {runtime(runtime)} catch (Exception err) {runtime(minutes)};try {if (db.AniDB?.episode?.id) {uniqueid(type: "anidb", value: db.AniDB.episode.id, db.AniDB.episode.id);anidbid(db.AniDB.episode.id)}} catch (Exception err) {};try {if (ME) {uniqueid(type: "tvmaze", value: ME, ME);tvmazeid(ME)}} catch (Exception err) {};if (Bcd.exists()) {art {poster(_mk)}};Lh.each { co ->  actor {name(co.Wq);role(co.tL);sortorder(co.tC);if (LI) { thumb(co.fjz) }}};showtitle(n);episode(so);season(hA);aired(airdate.format("yyyy-MM-dd"));fileinfo {streamdetails {target.mediaInfo.Video.each { dd_ ->  video {def Jpu = Float.parseFloat(dd_.'Duration');codec(dd_.'Format');micodec(dd_.'Format');bitrate(dd_.'BitRate');width(dd_.'Width');height(dd_.'Height');aspect(dd_.'DisplayAspectRatio/String');aspectratio(dd_.'DisplayAspectRatio/String');framerate(dd_.'FrameRate');'default'(dd_.'Default' == "Yes" ? "True" : "False");forced(dd_.'Forced' == "Yes" ? "True" : "False");duration(dd_.'Duration' ? (int) Math.floor(Jpu / 60000) : 0);durationinseconds(dd_.'Duration' ? (int) Math.floor(Jpu / 1000) : 0)}};target.mediaInfo.Audio.each { Ip ->  audio {codec(Ip.'Format');micodec(Ip.'Format');language(Ip.'Language/String3');channels(Ip.'Channel(s)');samplingrate(Ip.'SamplingRate');'default'(Ip.'Default' == "Yes" ? "True" : "False");forced(Ip.'Forced' == "Yes" ? "True" : "False")}};target.mediaInfo.Text.each { FC ->  subtitle {codec(FC.'Format');micodec(FC.'Format');width('0');height('0');language(FC.'Language/String3');'default'(FC.'Default' == "Yes" ? "True" : "False");forced(FC.'Forced' == "Yes" ? "True" : "False")}}}}}}}