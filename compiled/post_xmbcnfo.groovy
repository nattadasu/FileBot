{ source, target, metadata ->  if (type.toString() != "Episode" && !f.video) {return null};def iIq = target.dir;def ku = any{ s } { 0 };def dPK = any{ e } { special };def Bbg = 0;def HCZ = null;try {if (db.TheTVDB?.id) {def ZZ = "https://api.tvmaze.com";def MuC = curl "$ZZ/lookup/shows?thetvdb=${db.TheTVDB.id}";def Wx = MuC.id;HCZ = curl "$ZZ/shows/$Wx/episodebynumber?season=$ku&number=$dPK";Bbg = HCZ.id}} catch (Exception err) {};def tWW = "";def Vg = "en-US";def Lxg = null;def Pc = new File("$home/.filebotsecrets.json");if (Pc.exists()) {def KLS = new groovy.json.JsonSlurper().parseText(Pc.text);tWW = KLS.tWW;Vg = KLS.language;Lxg = KLS.person_info_dir};def oGb = "https://api.themoviedb.org/3/tv/$id/season/$ku/episode/$dPK";def DgV = ["accept": "application/json"];def iA = curl(DgV, "$oGb?language=$Vg&api_key=$tWW");def yMI = curl(DgV, "$oGb/external_ids?api_key=$tWW");def cAg = curl(DgV, "$oGb/credits?language=$Vg&api_key=$tWW");def shN = curl(DgV, "$oGb/images?include_image_language=en%2Cnull&api_key=$tWW");def np = (iIq / target.nameWithoutExtension + "-thumb.jpg").toString();def uFG = new File(np);def Rwz = new File(np.replace("-thumb",""));if (!(uFG.exists() || Rwz.exists()) && shN.stills.size() > 0) {def pGs = "https://image.tmdb.org/t/p/original${shN.stills[0].file_path}";system "curl", "-o", iIq / target.nameWithoutExtension + "-thumb.jpg", pGs};def QoC = [];(cAg.cast + cAg.guest_stars).eachWithIndex { xp, Yg ->  def Fds = "$Lxg/${xp.name[0]}/${xp.name}";def JIs = xp.order ?: Yg + QoC.size();QoC << [vF: xp.name, ymx: xp.character, MXo: JIs, Fds: "${Fds}/folder.jpg"];if (Lxg) {def iSt = new File(Fds);if (!iSt.exists()) {iSt.mkdirs();system "curl", "-o", "${Fds}/folder.jpg", "https://image.tmdb.org/t/p/original${xp.profile_path}"}}};def zX = iIq / target.nameWithoutExtension + ".nfo";XML(zX) {mkp.xmlDeclaration(version: "1.0", encoding: "utf-8", standalone: "yes");episodedetails {plot(iA.overview);lockdata("false");dateadded(new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")));title(t);originaltitle(localize."${languages[0]}".t);rating(rating);try {year(airdate.format("yyyy"))} catch (Exception err) {};uniqueid(type: "tmdb", value: episode.id, 'default': "true", episode.id);tmdbid(episode.id);if (yMI?.imdb_id) {uniqueid(type: "imdb", value: yMI.imdb_id, yMI.imdb_id);imdbid(yMI.imdb_id)};if (yMI?.tvdb_id) {uniqueid(type: "tvdb", value: yMI.tvdb_id, yMI.tvdb_id);tvdbid(yMI.tvdb_id)};try {runtime(runtime)} catch (Exception err) {runtime(minutes)};try {if (db.AniDB?.episode?.id) {uniqueid(type: "anidb", value: db.AniDB.episode.id, db.AniDB.episode.id);anidbid(db.AniDB.episode.id)}} catch (Exception err) {};try {if (Bbg) {uniqueid(type: "tvmaze", value: Bbg, Bbg);tvmazeid(Bbg)}} catch (Exception err) {};if (uFG.exists()) {art {poster(np)}};QoC.each { FtH ->  actor {name(FtH.vF);role(FtH.ymx);sortorder(FtH.MXo);if (Lxg) { thumb(FtH.Fds) }}};showtitle(n);episode(dPK);season(ku);try {aired(airdate.format("yyyy-MM-dd"))} catch (Exception err) {};fileinfo {streamdetails {target.mediaInfo.Video.each { MK ->  video {def GUv = Float.parseFloat(MK.'Duration');codec(MK.'Format');micodec(MK.'Format');bitrate(MK.'BitRate');width(MK.'Width');height(MK.'Height');aspect(MK.'DisplayAspectRatio/String');aspectratio(MK.'DisplayAspectRatio/String');framerate(MK.'FrameRate');'default'(MK.'Default' == "Yes" ? "True" : "False");forced(MK.'Forced' == "Yes" ? "True" : "False");duration(MK.'Duration' ? (int) Math.floor(GUv / 60000) : 0);durationinseconds(MK.'Duration' ? (int) Math.floor(GUv / 1000) : 0)}};target.mediaInfo.Audio.each { JIs ->  audio {codec(JIs.'Format');micodec(JIs.'Format');language(JIs.'Language/String3');channels(JIs.'Channel(s)');samplingrate(JIs.'SamplingRate');'default'(JIs.'Default' == "Yes" ? "True" : "False");forced(JIs.'Forced' == "Yes" ? "True" : "False")}};target.mediaInfo.Text.each { fnQ ->  subtitle {codec(fnQ.'Format');micodec(fnQ.'Format');width('0');height('0');language(fnQ.'Language/String3');'default'(fnQ.'Default' == "Yes" ? "True" : "False");forced(fnQ.'Forced' == "Yes" ? "True" : "False")}}}}}}}