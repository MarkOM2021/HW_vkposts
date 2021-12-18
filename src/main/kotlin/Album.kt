sealed class Album : Attachment {
    override val type = "album"
    abstract val album: PhotoAlbum
}