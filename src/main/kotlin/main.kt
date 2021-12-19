import kotlin.collections.last

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        post.id = if (posts.isEmpty()) 1 else posts.last().id + 1
        posts += post
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

    fun createComment(comment: Comment) {
        for (i in posts.indices) {
            val id = comment.id
            if (id == posts[i].id) {
                comments += comment
            } else {
                throw PostNotFoundException("no post with id $id exists")
            }
        }
    }
}