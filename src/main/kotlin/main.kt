import kotlin.collections.last

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {

        val postCopy = post.copy(id = if (posts.isEmpty()) 1 else posts.last().id + 1)
        posts += postCopy
        return posts.last()
    }

    fun edit(post: Post): Boolean {

        for (i in posts.indices) {
            if (posts[i].id == post.id) {
                posts[i] = post.copy(ownerID = posts[i].ownerID, date = posts[i].date)
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment): Comment {
        for (i in posts.indices) {
            val id = comment.id
            if (id != posts[i].id) {
                throw PostNotFoundException("no post with id $id exists")
            } else {
                comments += comment
            }
        }
        return comments.last()
    }
}

open class CRUDService<T : Node> {
    private var nextID = 1
    private var nextIDDeleted = 1
    val elements = mutableListOf<T>()

    fun add(elem: T): T {
        elem.id = nextID++
        elements.add(elem)
        return elements.last()
    }

    fun update(elem: T): Boolean {
        for ((index, node) in elements.withIndex()) {
            if (node.id == elem.id && !node.deleted) {
                elements[index] = elem
                return true
            } else {
                throw NodeNotFoundException("Note id" + elem.id + " has not been found")
            }
        }
        return false
    }

    fun delete(elem: T): Boolean {
        for (node in elements) {
            if (node.deleted || node.id != elem.id) {
                throw NodeNotFoundException("Note id" + elem.id + " has not been found")
            } else if (node.id == elem.id) {
                node.deleted = true
                println("Note id" + elem.id + " has been deleted successfully")
                return true
            }
        }
        return false
    }

    fun getByID(id: Int) = elements.find { it.id == id }
}

class NoteService : CRUDService<Note>() {

    fun addComment(noteID: Int, comment: NoteComment) {
        getByID(noteID)?.comments?.add(comment)
    }

    fun updateComment(noteID: Int, comment: NoteComment): Boolean {
        val listOfComments = getByID(noteID)?.comments

        if (listOfComments != null) {
            for ((index, node) in listOfComments.withIndex()) {
                if (node.id == comment.id && !node.deleted) {
                    listOfComments[index] = comment
                    return true
                } else {
                    throw NodeNotFoundException("Comment id" + comment.id + "has not been found")
                }
            }
        }
        println("Note id$noteID has no comments yet")
        return false
    }

    fun deleteComment(noteID: Int, comment: NoteComment): Boolean {
        val listOfComments = getByID(noteID)?.comments

        if (listOfComments != null) {
            for (node in listOfComments) {
                if (node.deleted || node.id != comment.id) {
                    throw NodeNotFoundException("Comment id" + comment.id + " has not been found")
                } else if (node.id == comment.id) {
                    node.deleted = true
                    println("Comment has been deleted successfully")
                    return true
                }
            }
        } else {
            println("Note id$noteID has no comments yet")
        }
        return false
    }

    fun restoreComment(noteID: Int, comment: NoteComment): Boolean {
        val listOfComments = getByID(noteID)?.comments

        if (listOfComments != null) {
            for (node in listOfComments) {
                if (node.deleted) {
                    node.deleted = false
                }
                println("Comment id" + comment.id + " has been deleted successfully")
                return true
            }
        } else {
            println("Note id$noteID has no comments yet")
        }
        return false
    }
}

fun main() {
    val service = NoteService()
    /*println(service.elements)
    service.add(Note(1, "1", "first"))
    service.add(Note(2, "1.2", "first"))
    println(service.elements)
    service.addComment(2, NoteComment(1, 1, 2, "hello"))
    println(service.elements)
    service.delete(Note(1))
    println(service.elements)
    service.deleteComment(2, NoteComment(1))
    println(service.elements)
    service.restoreComment(2, NoteComment(1))
    println(service.elements)
    service.updateComment(2, NoteComment(1, 1, 2, "Hello, Peter!"))
    println(service.elements)*/
}