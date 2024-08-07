{
	def show_id = [
		239779, 112888
	]
	def is_id_matches = show_id.find { curr_id -> tmdbid == curr_id } ?: ""
    is_id_matches ? " ($y) [tmdbid-$is_id_matches]" : ""
}
