import kotlin.collections.last

class WallService {
    private var posts = emptyArray<Post>()

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
}