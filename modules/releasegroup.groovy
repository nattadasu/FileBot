{
    def customGroups = [
        "Alqanime",
        "BlackLuster",
        "Kuramanime",
        "NanDesuKa",
        "ToonsHub",
        "Tsundere-Raws",
        "Samehadaku",
    ]

    def finalGroup = customGroups.find { groupName -> fn.lower().contains(groupName.lower()) } ?: ""

    def group_ = any {
        (fn =~ /^\[(.*?)\]/)[0][1]
    } {
        finalGroup
    } {
        group
    } {
        ""
    }

    group_ ? "[$group_] " : ""
}
