{
    def customRelease = [
        "AMZN",
        "B-Global",
        "UNEXT",
        "ABEMA",
        "HULU",
        "iQ"
    ]

    def finalRelease = customRelease.find { releaseName -> fn.contains(releaseName) } ?: ""

    def release_ = any {
        finalRelease ? finalRelease + ".WEB-DL" : ""
    } {
        source
    } {
        ""
    }

    release_ ? "$release_ " : ""
}
