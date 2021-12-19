data class Comment(
    var id: Int = 0,
    val fromID: Int = 0,
    val date: Long = 0L,
    val text: String = "write a text here",
    val donut: Donut,
    val replyToUser: Int = 0,
    val replyToComment: Int = 0,
    val attachment: Attachment?,
    val parentsStack: Array<ParentsStack>?,
    val thread: Thread
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Comment

        if (!parentsStack.contentEquals(other.parentsStack)) return false

        return true
    }

    override fun hashCode(): Int {
        return parentsStack.contentHashCode()
    }
}