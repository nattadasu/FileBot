{
    def group_ = any{
        (fn =~ /^\[(.*?)\]/)[0][1]
    }{
        (folder =~ "Bilibili")[0]
    }{
        (fn =~ /\[(BiliIntl|BiliBili|B\-Global)\]/)[0]
    }{
        group
    }{
        ""
    }
    group_ ? "[$group_] " : ""
}
@./medianame.groovy
 ({y})
@./filespec.groovy
