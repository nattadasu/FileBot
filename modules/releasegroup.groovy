{
    def customGroups = [
        "Alqanime",
        "BlackLuster",
        "Kuramanime",
        "NanDesuKa",
        "ToonsHub",
        "Tsundere-Raws",
    ]

    def fgr_ = customGroups.find {groupName -> fn.contains(groupName)} ?: ""

    def group_ = any {(fn =~ /^\[(.*?)\]/)[0][1]} {fgr_} {group} {""}

    group_ ? "[$group_] " : ""
}
