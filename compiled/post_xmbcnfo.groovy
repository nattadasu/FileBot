{ source, target, metadata ->  if (type.toString() != "Episode" && !f.video) {return null};def vIO = target.dir;def rtp = any{ s } { 0 };def kC = any{ e } { special };def OqH = 0;def yW = null;try {if (db.TheTVDB?.id) {def yS = "https://api.tvmaze.com";def war = curl "$yS/lookup/shows?thetvdb=${db.TheTVDB.id}";def mlh = war.id;yW = curl "$yS/shows/$mlh/episodebynumber?season=$rtp&number=$kC";OqH = yW.id}} catch (Exception err) {};def Fix = "";def sb = "en-US";def JW = null;def of = new File("$home/.filebotsecrets.json");if (of.exists()) {def YG = new groovy.json.JsonSlurper().parseText(of.text);Fix = YG.Fix;sb = YG.language;JW = YG.person_info_dir};def Of = "https://api.themoviedb.org/3/tv/$id/season/$rtp/episode/$kC";def sfQ = ["accept": "application/json"];def ntg = curl(sfQ, "$Of?language=$sb&api_key=$Fix");def Nj = curl(sfQ, "$Of/external_ids?api_key=$Fix");def wGl = curl(sfQ, "$Of/credits?language=$sb&api_key=$Fix");def yX = curl(sfQ, "$Of/images?include_image_language=en%2Cnull&api_key=$Fix");def kfY = (vIO / target.nameWithoutExtension + "-thumb.jpg").toString();def Eh = new File(kfY);def FCu = new File(kfY.replace("-thumb",""));if (!(Eh.exists() || FCu.exists()) && yX.stills.size() > 0) {def jgI = "https://image.tmdb.org/t/p/original${yX.stills[0].file_path}";system "curl", "-o", vIO / target.nameWithoutExtension + "-thumb.jpg", jgI};def MF = [];(wGl.cast + wGl.guest_stars).eachWithIndex { Ht, pfn ->  def BL = "$JW/${Ht.name[0]}/${Ht.name}";def hpM = Ht.order ?: pfn + MF.size();MF << [lH: Ht.name, Lo: Ht.character, cK: hpM, BL: "${BL}/folder.jpg"];if (JW) {def ruv = new File(BL);if (!ruv.exists()) {ruv.mkdirs();system "curl", "-o", "${BL}/folder.jpg", "https://image.tmdb.org/t/p/original${Ht.profile_path}"}}};def rd = vIO / target.nameWithoutExtension + ".nfo";XML(rd) {mkp.xmlDeclaration(version: "1.0", encoding: "utf-8", standalone: "yes");episodedetails {plot(ntg.overview);lockdata("false");dateadded(new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")));title(t);originaltitle(localize."${languages[0]}".t);rating(rating);year(airdate.format("yyyy"));uniqueid(type: "tmdb", value: episode.id, 'default': "true", episode.id);tmdbid(episode.id);if (Nj?.imdb_id) {uniqueid(type: "imdb", value: Nj.imdb_id, Nj.imdb_id);imdbid(Nj.imdb_id)};if (Nj?.tvdb_id) {uniqueid(type: "tvdb", value: Nj.tvdb_id, Nj.tvdb_id);tvdbid(Nj.tvdb_id)};try {runtime(runtime)} catch (Exception err) {runtime(minutes)};try {if (db.AniDB?.episode?.id) {uniqueid(type: "anidb", value: db.AniDB.episode.id, db.AniDB.episode.id);anidbid(db.AniDB.episode.id)}} catch (Exception err) {};try {if (OqH) {uniqueid(type: "tvmaze", value: OqH, OqH);tvmazeid(OqH)}} catch (Exception err) {};if (Eh.exists()) {art {poster(kfY)}};MF.each { qT ->  actor {name(qT.lH);role(qT.Lo);sortorder(qT.cK);if (JW) { thumb(qT.BL) }}};showtitle(n);episode(kC);season(rtp);aired(airdate.format("yyyy-MM-dd"));fileinfo {streamdetails {target.mediaInfo.Video.each { xNZ ->  video {def DIA = Float.parseFloat(xNZ.'Duration');codec(xNZ.'Format');micodec(xNZ.'Format');bitrate(xNZ.'BitRate');width(xNZ.'Width');height(xNZ.'Height');aspect(xNZ.'DisplayAspectRatio/String');aspectratio(xNZ.'DisplayAspectRatio/String');framerate(xNZ.'FrameRate');'default'(xNZ.'Default' == "Yes" ? "True" : "False");forced(xNZ.'Forced' == "Yes" ? "True" : "False");duration(xNZ.'Duration' ? (int) Math.floor(DIA / 60000) : 0);durationinseconds(xNZ.'Duration' ? (int) Math.floor(DIA / 1000) : 0)}};target.mediaInfo.Audio.each { zDQ ->  audio {codec(zDQ.'Format');micodec(zDQ.'Format');language(zDQ.'Language/String3');channels(zDQ.'Channel(s)');samplingrate(zDQ.'SamplingRate');'default'(zDQ.'Default' == "Yes" ? "True" : "False");forced(zDQ.'Forced' == "Yes" ? "True" : "False")}};target.mediaInfo.Text.each { orG ->  subtitle {codec(orG.'Format');micodec(orG.'Format');width('0');height('0');language(orG.'Language/String3');'default'(orG.'Default' == "Yes" ? "True" : "False");forced(orG.'Forced' == "Yes" ? "True" : "False")}}}}}}}