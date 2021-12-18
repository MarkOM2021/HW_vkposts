abstract class Photo : Attachment {
    override val type = "photo"
    abstract val photoFile: Array<PhotoFile>
}