abstract class Audio : Attachment {
    override val type = "audio"
    abstract val audioTrack: Array<AudioTrack>
}