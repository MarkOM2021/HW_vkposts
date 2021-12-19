data class Post(
    var id: Int = 0,
    val ownerID: Int = 0,
    val fromID: Int = 0,
    val createdBy: Int = 0,
    val date: Int = 0,
    val text: String = "text",
    val replyBy: Int = 0,
    val replyOwnerID: Int = 0,
    val friendsOnly: Boolean = false,
    val postType: String = "type",
    val postSource: PostSource,
    val geo: Geo,
    val signerID: Int = 0,
    val copyHistory: CopyHistory?,
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markAsAbs: Boolean = false,
    val isFavourite: Boolean = false,
    val postponedID: Int = 0,
    val comments: Comment,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val donut: Donut,
    val attachments: Array<Attachment>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (attachments != null) {
            if (other.attachments == null) return false
            if (!attachments.contentEquals(other.attachments)) return false
        } else if (other.attachments != null) return false

        return true
    }

    override fun hashCode(): Int {
        return attachments?.contentHashCode() ?: 0
    }
}