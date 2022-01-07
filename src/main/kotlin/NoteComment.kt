data class NoteComment(
    var id: Int,
    val ownerId: Int = 0,
    val replyTo: Int = 0,
    val message: String = "",
    var deleted: Boolean = false
) {
    override fun toString(): String {
        return if (!deleted) {
            "Reply to $replyTo $message"
        } else {
            "Comment has been deleted"
        }
    }
}