data class Thread(
    val count: Int = 0,
    val canPost: Boolean = false,
    val groupsCanPost: Boolean = false,
    val canClose: Boolean = false,
    val showReplyButton: Boolean = false
)