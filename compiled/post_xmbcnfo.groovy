{ source, target, metadata -> if (type.toString() != "Episode" || !vf || ext =~ /(ass|srt|ssa|vtt)/) {return null};def Xj = target.dir;def RbF = any{ s } { 0 };def JaD = any{ e } { special };def Uk = 0;def oZ = null;try {if (db.TheTVDB?.id) {def ik = curl "https://api.tvmaze.com/lookup/shows?thetvdb=${db.TheTVDB.id}";def Pwd = ik.id;oZ = curl "https://api.tvmaze.com/shows/$Pwd/episodebynumber?season=$RbF&number=$JaD";Uk = oZ.id}} catch (Exception err) {};def DXD = "";def lI = "en-US";def qIU = null;def ze = new File("$home/.filebotsecrets.json");if (ze.exists()) {def LHy = new groovy.json.JsonSlurper().parseText(ze.text);DXD = LHy.DXD;lI = LHy.language;qIU = LHy.person_info_dir};def SB = "https://api.themoviedb.org/3/tv/$id/season/$RbF/episode/$JaD";def Wz = curl(["accept": "application/json"], "$SB?language=$lI&api_key=$DXD");def Bn = curl(["accept": "application/json"], "$SB/external_ids?api_key=$DXD");def ps = curl(["accept": "application/json"], "$SB/credits?language=$lI&api_key=$DXD");def fmI = curl(["accept": "application/json"], "$SB/images?include_image_language=en%2Cnull&api_key=$DXD");def YM = (Xj / target.nameWithoutExtension + "-thumb.jpg").toString();def wfR = new File(YM);def oF = new File(YM.replace("-thumb",""));if (!(wfR.exists() || oF.exists()) && fmI.stills.size() > 0) {def XPV = "https://image.tmdb.org/t/p/original${fmI.stills[0].file_path}";system "curl", "-o", Xj / target.nameWithoutExtension + "-thumb.jpg", XPV};def KeG = [];(ps.cast + ps.guest_stars).eachWithIndex { qdi, DD -> def vjK = "$qIU/${qdi.name[0]}/${qdi.name}";def BaX = qdi.order ?: DD + KeG.size();KeG << [Dpw: qdi.name, vZ: qdi.character, QNY: BaX, vjK: "${vjK}/folder.jpg"];if (qIU) {def ts = new File(vjK);if (!ts.exists()) {ts.mkdirs();system "curl", "-o", "${vjK}/folder.jpg", "https://image.tmdb.org/t/p/original${qdi.profile_path}"}}};def RD = Xj / target.nameWithoutExtension + ".nfo";XML(RD) {mkp.xmlDeclaration(version: "1.0", encoding: "utf-8", standalone: "yes");episodedetails {plot(Wz.overview);lockdata("false");dateadded(new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")));title(t);originaltitle(localize."${languages[0]}".t);rating(rating);year(airdate.format("yyyy"));uniqueid(type: "tmdb", value: episode.id, 'default': "true", episode.id);tmdbid(episode.id);if (Bn?.imdb_id) {uniqueid(type: "imdb", value: Bn.imdb_id, Bn.imdb_id);imdbid(Bn.imdb_id)};if (Bn?.tvdb_id) {uniqueid(type: "tvdb", value: Bn.tvdb_id, Bn.tvdb_id);tvdbid(Bn.tvdb_id)};try {runtime(runtime)} catch (Exception err) {runtime(minutes)};try {if (db.AniDB?.episode?.id) {uniqueid(type: "anidb", value: db.AniDB.episode.id, db.AniDB.episode.id);anidbid(db.AniDB.episode.id)}} catch (Exception err) {};try {if (Uk) {uniqueid(type: "tvmaze", value: Uk, Uk);tvmazeid(Uk)}} catch (Exception err) {};if (wfR.exists()) {art {poster(YM)}};KeG.each { MwW ->  actor {name(MwW.Dpw);role(MwW.vZ);sortorder(MwW.QNY);if (qIU) { thumb(MwW.vjK) }}};showtitle(n);episode(JaD);season(RbF);aired(airdate.format("yyyy-MM-dd"));fileinfo {streamdetails {target.mediaInfo.Video.each { tqU ->  video {def XC = Float.parseFloat(tqU.'Duration');codec(tqU.'Format');micodec(tqU.'Format');bitrate(tqU.'BitRate');width(tqU.'Width');height(tqU.'Height');aspect(tqU.'DisplayAspectRatio/String');aspectratio(tqU.'DisplayAspectRatio/String');framerate(tqU.'FrameRate');'default'(tqU.'Default' == "Yes" ? "True" : "False");forced(tqU.'Forced' == "Yes" ? "True" : "False");duration(tqU.'Duration' ? (int) Math.floor(XC / 60000) : 0);durationinseconds(tqU.'Duration' ? (int) Math.floor(XC / 1000) : 0)}};target.mediaInfo.Audio.each { JOj ->  audio {codec(JOj.'Format');micodec(JOj.'Format');language(JOj.'Language/String3');channels(JOj.'Channel(s)');samplingrate(JOj.'SamplingRate');'default'(JOj.'Default' == "Yes" ? "True" : "False");forced(JOj.'Forced' == "Yes" ? "True" : "False")}};target.mediaInfo.Text.each { mnE ->  subtitle {codec(mnE.'Format');micodec(mnE.'Format');width('0');height('0');language(mnE.'Language/String3');'default'(mnE.'Default' == "Yes" ? "True" : "False");forced(mnE.'Forced' == "Yes" ? "True" : "False")}}}}}}}