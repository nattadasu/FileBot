{ source, target, metadata ->
    // sanity check, fail when its not an episode and video file
    if (type.toString() != "Episode" || !vf || ext =~ /(ass|srt|ssa|vtt)/) {
        return null
    }
    def tdir = target.dir
    def tvmapi = 0
    def epl = null
    try {
        if (db.TheTVDB?.id) {
            def c1 = curl "https://api.tvmaze.com/lookup/shows?thetvdb=${db.TheTVDB.id}"
            def s1 = c1.id
            epl = curl "https://api.tvmaze.com/shows/$s1/episodebynumber?season=$s&number=$e"
            tvmapi = epl.id
        }
    } catch (Exception e) {
        // ignore
    }

    // load ~/.filebotsecrets.json and set tmdb_key
    def tmdb_key = ""
    def tmdb_lang = "en-US"
    def personal = null
    def secrets = new File("$home/.filebotsecrets.json")
    if (secrets.exists()) {
        def udata = new groovy.json.JsonSlurper().parseText(secrets.text)
        tmdb_key = udata.tmdb_key
        tmdb_lang = udata.language
        personal = udata.person_info_dir
    }

    // get episode info from TMDB
    def tmdb_url = "https://api.themoviedb.org/3/tv/$id/season/$s/episode/$e"
    def ep_info = curl(["accept": "application/json"], "$tmdb_url?language=$tmdb_lang&api_key=$tmdb_key")

    def ext_ids = curl(["accept": "application/json"], "$tmdb_url/external_ids?api_key=$tmdb_key")
    def tcred = curl(["accept": "application/json"], "$tmdb_url/credits?language=$tmdb_lang&api_key=$tmdb_key")
    def imgs = curl(["accept": "application/json"], "$tmdb_url/images?include_image_language=en%2Cnull&api_key=$tmdb_key")

    // get image url
    def img_path = (tdir / target.nameWithoutExtension + "-thumb.jpg").toString()
    def img_obj = new File(img_path)
    def r_img_obj = new File(img_path.replace("-thumb",""))
    if (!(img_obj.exists() || r_img_obj.exists()) && imgs.stills.size() > 0) {
        def img_url = "https://image.tmdb.org/t/p/original${imgs.stills[0].file_path}"
        system "curl", "-o", tdir / target.nameWithoutExtension + "-thumb.jpg", img_url
    }

    def cactors = []

    (tcred.cast + tcred.guest_stars).eachWithIndex { c, index ->
        def download_path = "$personal/${c.name[0]}/${c.name}"
        def sord = c.order ?: index + cactors.size()
        cactors << [person_name: c.name, crole: c.character, ford: sord, download_path: "${download_path}/folder.jpg"]
        if (personal) {
            def download_obj = new File(download_path)
            if (!download_obj.exists()) {
                download_obj.mkdirs()
                system "curl", "-o", "${download_path}/folder.jpg", "https://image.tmdb.org/t/p/original${c.profile_path}"
            }
        }
    }

    def nfo_path = tdir / target.nameWithoutExtension + ".nfo"
    XML(nfo_path) {
        mkp.xmlDeclaration(version: "1.0", encoding: "utf-8", standalone: "yes")
        episodedetails {
            plot(ep_info.overview)
            lockdata("false")
            // today date on UTC
            dateadded(new Date().format("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("UTC")))
            title(t)
            originaltitle(localize."${languages[0]}".t)
            rating(rating)
            year(airdate.format("yyyy"))
            uniqueid(type: "tmdb", value: episode.id, 'default': "true", episode.id)
            tmdbid(episode.id)
            if (ext_ids?.imdb_id) {
                uniqueid(type: "imdb", value: ext_ids.imdb_id, ext_ids.imdb_id)
                imdbid(ext_ids.imdb_id)
            }
            if (ext_ids?.tvdb_id) {
                uniqueid(type: "tvdb", value: ext_ids.tvdb_id, ext_ids.tvdb_id)
                tvdbid(ext_ids.tvdb_id)
            }
            try {
                runtime(runtime)
            } catch (Exception e) {
                // Use local runtime
                runtime(minutes)
            }
            try {
                if (db.AniDB?.episode?.id) {
                    uniqueid(type: "anidb", value: db.AniDB.episode.id, db.AniDB.episode.id)
                    anidbid(db.AniDB.episode.id)
                }
            } catch (Exception e) {
                // ignore
            }
            try {
                if (tvmapi) {
                    uniqueid(type: "tvmaze", value: tvmapi, tvmapi)
                    tvmazeid(tvmapi)
                }
            } catch (Exception e) {
                // ignore
            }
            if (img_obj.exists()) {
                art {
                    poster(img_path)
                }
            }
            // create list of actors
            cactors.each { person -> actor {
                name(person.person_name)
                role(person.crole)
                sortorder(person.ford)
                if (personal) { thumb(person.download_path) }
            }}
            showtitle(n)
            episode(e)
            season(s)
            aired(airdate.format("yyyy-MM-dd"))
            fileinfo {
                streamdetails {
                    target.mediaInfo.Video.each { vid -> video {
                        def dur = Float.parseFloat(vid.'Duration')
                        codec(vid.'Format')
                        micodec(vid.'Format')
                        bitrate(vid.'BitRate')
                        width(vid.'Width')
                        height(vid.'Height')
                        aspect(vid.'DisplayAspectRatio/String')
                        aspectratio(vid.'DisplayAspectRatio/String')
                        framerate(vid.'FrameRate')
                        'default'(vid.'Default' == "Yes" ? "True" : "False")
                        forced(vid.'Forced' == "Yes" ? "True" : "False")
                        duration(vid.'Duration' ? (int) Math.floor(dur / 60000) : 0)
                        durationinseconds(vid.'Duration' ? (int) Math.floor(dur / 1000) : 0)
                    }}
                    target.mediaInfo.Audio.each { aud -> audio {
                        codec(aud.'Format')
                        micodec(aud.'Format')
                        language(aud.'Language/String3')
                        channels(aud.'Channel(s)')
                        samplingrate(aud.'SamplingRate')
                        'default'(aud.'Default' == "Yes" ? "True" : "False")
                        forced(aud.'Forced' == "Yes" ? "True" : "False")
                    }}
                    target.mediaInfo.Text.each { sbt -> subtitle {
                        codec(sbt.'Format')
                        micodec(sbt.'Format')
                        width('0')
                        height('0')
                        language(sbt.'Language/String3')
                        'default'(sbt.'Default' == "Yes" ? "True" : "False")
                        forced(sbt.'Forced' == "Yes" ? "True" : "False")
                    }}
                }
            }
        }
    }
}
