{
    def target_output = "/run/media/nattadasu/Books/Books/"

    // name sanitize function
    def sanitize(def name) {
        if (name == null) { return null }
        try {
            def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|', '\n', '\r', '\t']
            def fixed_name = name.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '')
            // trim . and whitespace at the end
            fixed_name = fixed_name.replaceAll(/(\s|\.)*$/, '')
            fixed_name
        } catch (Exception e) {
            return name
        }
    }

    def html_get = html(folder / "metadata.opf")
    def info = html_get.select("metadata")

    // OPF Spec metadata
    def title = sanitize(info.select("dc\\:title").text())
    def t = title
    def sort_title = sanitize(info.select("meta[name=calibre:title_sort]").attr("content"))
    def st = sort_title
    // select first letter of title in A-Z # range, if its not in range, use #
    def all_authors = info.select("dc\\:creator").collect{ it.text() }
    def authors = sanitize(all_authors.join(" & "))
    def author = any { sanitize(all_authors.first()) } { "Unknown" }
    // get sorted author based on one of dc:creator eleemnt, get text from opf:file-as attribute
    def sort_authors = info.select("dc\\:creator").collect{ it.attr("opf:file-as") }
    sort_authors = any { sanitize(sort_authors.first()) } { "Unknown" }
    def contributor = sanitize(info.select("dc\\:contributor").text())
    def publisher = sanitize(info.select("dc\\:publisher").text())
    def language = sanitize(info.select("dc\\:language").text())
    def lang = language
    def description = sanitize(info.select("dc\\:description").text())
    def rights = sanitize(info.select("dc\\:rights").text())

    // Date metadata
    def date = info.select("dc\\:date").text()
    date = date ? new Date().parse("yyyy-MM-dd'T'HH:mm:ssX", date) : null
    def d = date
    def year = date ? date.format("yyyy") : null
    def y = year
    def decade = year ? year[0..2] + "0" : null

    def genres = info.select("dc\\:subject").collect{ it.text() }
    def genre = sanitize(genres ?: "")

    // Identifiers
    def identifiers = info.select("dc\\:identifier").collect{ [scheme: it.attr("opf:scheme"), value: it.text()] }
    def calibre = sanitize(identifiers.find{ it.scheme == "calibre" }?.value)
    def calibreid = calibre
    def id = calibre
    def isbn = sanitize(identifiers.find{ it.scheme == "ISBN" }?.value)
    def uuid = sanitize(identifiers.find{ it.scheme == "UUID" }?.value)
    def calibreuuid = uuid
    def amazon = sanitize(identifiers.find{ it.scheme == "AMAZON" }?.value)
    def amazon_jp = sanitize(identifiers.find{ it.scheme == "AMAZON_JP" }?.value)
    amazon = amazon ?: amazon_jp
    def asin = amazon
    def amazonid = amazon
    def google = sanitize(identifiers.find{ it.scheme == "GOOGLE" }?.value)
    def googleid = google
    def googlebooks = google
    def googlebooksid = google
    def goodreads = sanitize(identifiers.find{ it.scheme == "GOODREADS" }?.value)
    def goodreadsid = goodreads
    def barnesnoble = sanitize(identifiers.find{ it.scheme == "BARNESNOBLE"}?.value)
    def barnesnobleid = barnesnoble

    def article_particles = [
        "a", "an", "as", "das", "de", "dei", "del", "della", "delle", "dello", "dem", "den", "der", "des", "die", "dos",
        "el", "gli", "i", "il", "la", "las", "le", "les", "lo", "los", "o", "os", "the", "um", "uma", "umas", "un",
        "una", "unas", "une", "unos", "uns", "van", "vom", "von"
    ]

    // Calibre extended metadata
    def series = info.select("meta[name=calibre:series]").attr("content")
    def n = series
    def sn = series
    def series_index = info.select("meta[name=calibre:series_index]").attr("content")
    def si = series_index
    def s = series_index
    def volume = series_index
    def v = series_index
    def tags = info.select("meta[name=calibre:tag]").collect{ it.attr("content") }
    def rating = info.select("meta[name=calibre:rating]").attr("content")
    def timestamp = info.select("meta[name=calibre:timestamp]").attr("content")
    timestamp = timestamp ? new Date().parse("yyyy-MM-dd'T'HH:mm:ssX", timestamp) : null
    timestamp = timestamp ?: date
    def age = timestamp ? (new Date().getTime() - timestamp.getTime()) / 86400000 : null

    // Custom metadata
    def custom = info.select("meta[name^=custom]").collect{ [name: it.attr("name").substring(7), content: it.attr("content")] }

    // Script extended metadata
    def definer(def str_input) {
        def result = str_input[0].toUpperCase()
        result = result >= 'A' && result <= 'Z' ? result : "#"
        result
    }
    //   Title sort
    def az = definer(sort_title)
    def taz = definer(title)
    //   Series sort
    def saz = definer(series)
    def ssaz = series.split(" ").find{ !article_particles.contains(it.toLowerCase()) } ?: series
    ssaz = definer(ssaz)
    //   Author sort
    def aaz = definer(author)
    //def saaz = sort_authors
    //   Genre sort
    def gaz = definer(genre ? genre : "#")
    //   Publisher sort
    def paz = definer(publisher)
    //   Language sort
    def laz = definer(language)
    def ny = year ? "$n ($y)" : n

    // Check extensions
    def images = ['jpg', 'jpeg', 'png', 'gif', 'bmp', 'svg', 'tiff', 'tif', 'ico']
    def books = [
        'azw', 'azw3', 'azw4', 'cbz', 'cbr', 'cb7', 'cbc', 'chm', 'djvu', 'docx', 'epub', 'fb2','fbz', 'html', 'htmlz',
        'lit', 'lrf', 'mobi', 'odt', 'pdf', 'prc', 'pdb', 'pml', 'rb', 'rtf', 'snb', 'tcr', 'txt', 'txtz'
    ]

    // Default path binding
    def jellyfin = "${target_output}/Books/${author}/${title}/${title}.${ext}"

    // EDIT HERE! ------------------------------------------------------------------------------------------------------
    def series_or_title = series ?: title
    def ssot = definer(series_or_title)
    final_name = "$aaz/$author/$ssot/$series/$title - $author.$ext"
    // -----------------------------------------------------------------------------------------------------------------

    // DO NOT EDIT BELOW THIS LINE, USED TO PROPERLY FIX FILEPATH
    // combine final_output and final_name
    def final_output = target_output[0..-2] == '/' ? target_output : target_output + '/'
    def final_path = final_output + final_name

    def parent_directory = new File(final_path).getParent()

    if (ext.toLowerCase() in books) {
        parent_directory / final_name
    } else if (ext.toLowerCase() in images) {
        // Combine parent directory and cover.$ext
        def cover = "cover.$ext"
        parent_directory / cover
    } else if (ext.toLowerCase() == 'opf') {
        parent_directory / 'metadata.opf'
    } else {
        return
    }
}