data class EventDetails(
    val id: Int = 0,
    val time: Long = 0L,
    val memberStatus: Int = 1,
    val isFavourite: Boolean = false,
    val address: String = "address",
    val text: String = "text",
    val friends: Array<FriendList>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EventDetails

        if (!friends.contentEquals(other.friends)) return false

        return true
    }

    override fun hashCode(): Int {
        return friends.contentHashCode()
    }
}