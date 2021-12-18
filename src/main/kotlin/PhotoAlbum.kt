data class PhotoAlbum(
    val id: Int = 0,
    val thumb: PhotoFile,
    val ownerID: Int = 0,
    val title: String? = null,
    val description: String? = null,
    val created: Int = 0,
    val updated: Int = 0,
    val size: Int = 0
)