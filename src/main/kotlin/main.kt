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

/*fun main() {
val post1 = Post(578, 600, 101, 0, postSource = PostSource(),
geo = Geo(place = Place()), copyHistory = null,
comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
parentsStack = null, attachment = null, thread = Thread()),
copyright = Copyright(), likes = Likes(), reposts = Reposts(),
views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null)

val post2 = Post(
579, 605, 101, 0, postSource = PostSource(),
geo = Geo(place = Place()), copyHistory = null,
comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
parentsStack = null, attachment = null, thread = Thread()),
copyright = Copyright(), likes = Likes(), reposts = Reposts(),
views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
)

var service = WallService()
    println(service.add(post1))
    println(service.add(post2))
}*/