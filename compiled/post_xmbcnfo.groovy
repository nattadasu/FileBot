{ source, target, metadata ->  if (type.toString() != "Episode" && !f.video) {return null};def RF = target.dir;def KPN = any{ s } { 0 };def GRn = any{ e } { special };def bq_ = 0;def cA = null;try {if (db.TheTVDB?.id) {def ns = "https://api.tvmaze.com";def BG = curl "$ns/lookup/shows?thetvdb=${db.TheTVDB.id}";def kbD = BG.id;cA = curl "$ns/shows/$kbD/episodebynumber?season=$KPN&number=$GRn";bq_ = cA.id}} catch (Exception err) {};def gfS = "";def YX = "en-US";def yb = null;def Ck = new File("$home/.filebotsecrets.json");if (Ck.exists()) {def Vl = new groovy.json.JsonSlurper().parseText(Ck.text);gfS = Vl.gfS;YX = Vl.language;yb = Vl.person_info_dir};def aP = "https://api.themoviedb.org/3/tv/$id/season/$KPN/episode/$GRn";def eI = ["accept": "application/json"];def UDr = curl(eI, "$aP?language=$YX&api_key=$gfS");def Br = curl(eI, "$aP/external_ids?api_key=$gfS");def AJU = curl(eI, "$aP/credits?language=$YX&api_key=$gfS");def IY = curl(eI, "$aP/images?include_image_language=en%2Cnull&api_key=$gfS");def wSp = (RF / target.nameWithoutExtension + "-thumb.jpg").toString();def PWd = new File(wSp);def QrK = new File(wSp.replace("-thumb",""));if (!(PWd.exists() || QrK.exists()) && IY.stills.size() > 0) {def trX = "https://image.tmdb.org/t/p/original${IY.stills[0].file_path}";system "curl", "-o", RF / target.nameWithoutExtension + "-thumb.jpg", trX};def wY = [];(AJU.cast + AJU.guest_stars).eachWithIndex { BSO, hLU ->  def nXq = "$yb/${BSO.name[0]}/${BSO.name}";def vfa = BSO.order ?: hLU + wY.size();wY << [GtN: BSO.name, dm: BSO.character, Wi: vfa, nXq: "${nXq}/folder.jpg"];if (yb) {def Skg = new File(nXq);if (!Skg.exists()) {Skg.mkdirs();system "curl", "-o", "${nXq}/folder.jpg", "https://image.tmdb.org/t/p/original${BSO.profile_path}"}}};def dmk = RF / target.nameWithoutExtension + ".nfo";XML(dmk) {mkp.xmlDeclaration(version: "1.0", encoding: "utf-8", standalone: "yes");episodedetails {plot(UDr.overview);lockdata("false");dateadded(new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")));title(t);originaltitle(localize."${languages[0]}".t);rating(rating);try {year(airdate.format("yyyy"))} catch (Exception err) {};uniqueid(type: "tmdb", value: episode.id, 'default': "true", episode.id);tmdbid(episode.id);if (Br?.imdb_id) {uniqueid(type: "imdb", value: Br.imdb_id, Br.imdb_id);imdbid(Br.imdb_id)};if (Br?.tvdb_id) {uniqueid(type: "tvdb", value: Br.tvdb_id, Br.tvdb_id);tvdbid(Br.tvdb_id)};try {runtime(runtime)} catch (Exception err) {runtime(minutes)};try {if (db.AniDB?.episode?.id) {uniqueid(type: "anidb", value: db.AniDB.episode.id, db.AniDB.episode.id);anidbid(db.AniDB.episode.id)}} catch (Exception err) {};try {if (bq_) {uniqueid(type: "tvmaze", value: bq_, bq_);tvmazeid(bq_)}} catch (Exception err) {};if (PWd.exists()) {art {poster(wSp)}};wY.each { Tqs ->  actor {name(Tqs.GtN);role(Tqs.dm);sortorder(Tqs.Wi);if (yb) { thumb(Tqs.nXq) }}};showtitle(n);episode(GRn);season(KPN);try {aired(airdate.format("yyyy-MM-dd"))} catch (Exception err) {};fileinfo {streamdetails {target.mediaInfo.Video.each { sLn ->  video {def IZQ = Float.parseFloat(sLn.'Duration');codec(sLn.'Format');micodec(sLn.'Format');bitrate(sLn.'BitRate');width(sLn.'Width');height(sLn.'Height');aspect(sLn.'DisplayAspectRatio/String');aspectratio(sLn.'DisplayAspectRatio/String');framerate(sLn.'FrameRate');'default'(sLn.'Default' == "Yes" ? "True" : "False");forced(sLn.'Forced' == "Yes" ? "True" : "False");duration(sLn.'Duration' ? (int) Math.floor(IZQ / 60000) : 0);durationinseconds(sLn.'Duration' ? (int) Math.floor(IZQ / 1000) : 0)}};target.mediaInfo.Audio.each { aS ->  audio {codec(aS.'Format');micodec(aS.'Format');language(aS.'Language/String3');channels(aS.'Channel(s)');samplingrate(aS.'SamplingRate');'default'(aS.'Default' == "Yes" ? "True" : "False");forced(aS.'Forced' == "Yes" ? "True" : "False")}};target.mediaInfo.Text.each { IdO ->  subtitle {codec(IdO.'Format');micodec(IdO.'Format');width('0');height('0');language(IdO.'Language/String3');'default'(IdO.'Default' == "Yes" ? "True" : "False");forced(IdO.'Forced' == "Yes" ? "True" : "False")}}}}}}}