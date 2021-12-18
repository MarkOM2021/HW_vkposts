data class AudioTrack(
    val id: Int = 0,
    val ownerID: Int = 0,
    val artist: String = "Unknown",
    val title: String = "No name",
    val duration: Int = 0,
    val url: String = "url",
    val lyricsID: Int = 0,
    val albumID: Int = 0,
    val genreID: Int = 0,
    val date: Int = 0,
    val noSearch: Boolean = false,
    val isHQ: Boolean = false
)