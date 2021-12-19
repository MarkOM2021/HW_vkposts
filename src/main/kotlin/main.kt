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