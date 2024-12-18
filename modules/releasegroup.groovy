{
    def customGroups = [
        "Alqanime",
        "BlackLuster",
        "Kuramanime",
        "NanDesuKa",
        "ToonsHub",
        "Tsundere-Raws",
    ]

    def finalGroup = customGroups.find { groupName -> fn.contains(groupName) } ?: ""

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
