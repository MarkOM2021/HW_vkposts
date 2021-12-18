sealed class Video : Attachment {
    override val type = "video"
    abstract val videoFile: Array<VideoFile>
}