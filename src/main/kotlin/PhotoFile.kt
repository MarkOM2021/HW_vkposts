data class PhotoFile(
    val id: Int = 0,
    val albumID: Int = 0,
    val ownerID: Int = 0,
    val userID: Int = 0,
    val text: String? = null,
    val date: Long = 0L,
    val sizes: Array<PhotoSizes>,
    val width: Int = 0,
    val height: Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PhotoFile

        if (!sizes.contentEquals(other.sizes)) return false

        return true
    }

    override fun hashCode(): Int {
        return sizes.contentHashCode()
    }
}