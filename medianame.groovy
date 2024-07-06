{
    // Only grab left side if the name has :
    def name_ = n.split(':').first()

    def invalid_chars = ['\\', '/', ':', '*', '?', '"', '<', '>', '|']
    def fixed_name = name_.replaceAll(invalid_chars.collect { "\\" + it }.join('|'), '_')
    fixed_name
}