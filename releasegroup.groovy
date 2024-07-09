{
    def group_ = any{
        (fn =~ /^\[(.*?)\]/)[0][1]
    }{
        (fn =~ /(NanDesuKa|ToonsHub)/)[0][1]
    }
    {
        (fn =~ /\[(BiliIntl|BiliBili|B\-Global)\]/)[0]
    }{
        group
    }{
        ""
    }
    group_ ? "[$group_]" : ""
}