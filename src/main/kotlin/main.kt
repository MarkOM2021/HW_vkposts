import kotlin.collections.last

data class Post(
    var id: Int = 0,
    var ownerID: Int,
    var fromID: Int,
    var createdBy: Int,
    var date: Int,
    var text: String,
    var replyBy: Int,
    var replyOwnerID: Int,
    var friendsOnly: Boolean,
    var postType: String,
    var signerID: Int,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isPinned: Boolean,
    var markAsAbs: Boolean,
    var isFavourite: Boolean,
    var postponedID: Int,
    var comments: Comments,
    var copyright: Copyright,
    var likes: Likes,
    var reposts: Reposts,
    var views: Views,
    var donut: Donut
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Copyright(
    val id: Int,
    val link: String,
    val name: String,
    val type: String
)

data class Likes(val count: Int, val userLikes: Boolean, val canLike: Boolean, val canPublish: Boolean)

data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

data class Views(
    val count: Int
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val placeHolder: PlaceHolder,
    val canPublishFreeCopy: Boolean,
    val editMode: String
)

data class PlaceHolder(
    val reportIDNotInVKDonut: String
)

class WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        post.id = if (posts.isEmpty()) 1 else posts.last().id + 1
        posts += post
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var afterUpdate = false

        for (i in posts.indices) {
            if (posts[i].id != post.id) {
                continue
            } else {
                posts[i].fromID = post.fromID
                posts[i].createdBy = post.createdBy
                posts[i].text = post.text
                posts[i].replyBy = post.replyBy
                posts[i].replyOwnerID = post.replyOwnerID
                posts[i].postType = post.postType
                posts[i].signerID = post.signerID
                posts[i].canPin = post.canPin
                posts[i].canDelete = post.canDelete
                posts[i].canEdit = post.canEdit
                posts[i].isPinned = post.isPinned
                posts[i].markAsAbs = post.markAsAbs
                posts[i].isFavourite = post.isFavourite
                posts[i].postponedID = post.postponedID
                posts[i].comments = post.comments
                posts[i].copyright = post.copyright
                posts[i].likes = post.likes
                posts[i].reposts = post.reposts
                posts[i].views = post.views
                posts[i].donut = post.donut
                afterUpdate = true
            }
        }
        return afterUpdate
    }
}