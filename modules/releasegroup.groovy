{
    def customGroups = [
        "Alqanime",
        "BlackLuster",
        "darkflux",
        "It's Anime",
        "Kuramanime",
        "NanDesuKa",
        "ToonsHub",
        "Tsundere-Raws",
        "S1PH3R",
        "Samehadaku",
    ]

    def finalGroup = customGroups.find { groupName -> fn.lower().contains(groupName.lower()) } ?: ""

    def group_ = any {
        finalGroup
    } {
        (fn =~ /^\[(.*?)\]/)[0][1]
    } {
        group
    } {
        ""
    }

    group_ ? "[$group_] " : ""
}
