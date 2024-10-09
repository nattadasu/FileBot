{
    def customRelease = [
        "AMZN",
        "B-Global",
        "UNEXT",
        "ABEMA",
        "HULU",
        "SHAHID"
    ]

    def finalRelease = customRelease.find { releaseName -> fn.contains(releaseName) } ?: ""

    def release_ = any {
      fn.contains("BiliIntl") || fn.contains("BILI") ? "B-Global.WEB-DL" : ""
    } {
        finalRelease ? finalRelease + ".WEB-DL" : ""
    } {
        source
    } {
        ""
    }

    release_ ? "$release_ " : ""
}
