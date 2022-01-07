class Note(
    id: Int,
    private val title: String = "",
    private val text: String = "",
    val comments: MutableList<NoteComment> = mutableListOf()
) : Node(id) {
    override fun toString(): String {
        return if (!deleted) {
            "Note id$id named '$title' with '$text' and comments: $comments"
        } else {
            "Note has been deleted"
        }
    }
}