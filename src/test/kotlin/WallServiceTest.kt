import junit.framework.TestCase.*

import org.junit.Test

class WallServiceTest {

    @Test
    fun addedPostIDIsNotZero() {
        val service = WallService()
        val post = Post(
            0, 589, 101, 0, postSource = PostSource(),
            geo = Geo(place = Place()), copyHistory = null,
            comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                parentsStack = null, attachment = null, thread = Thread()),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
        )

        val result = service.add(post)
        assertEquals(post, result)
    }

    @Test
    fun editionDone() {
        val service = WallService()
        service.add(
            Post(
                578, 600, 101, 0, postSource = PostSource(),
                geo = Geo(place = Place()), copyHistory = null,
                comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                    parentsStack = null, attachment = null, thread = Thread()),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
            )
        )
        service.add(
            Post(
                579, 605, 101, 0, postSource = PostSource(),
                geo = Geo(place = Place()), copyHistory = null,
                comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                    parentsStack = null, attachment = null, thread = Thread()),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
            )
        )

        val updateSuccess = Post(
            1, 654, 112, 1, postSource = PostSource(),
            geo = Geo(place = Place()), copyHistory = null,
            comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                parentsStack = null, attachment = null, thread = Thread()),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
        )

        val resultSuccess = service.edit(updateSuccess)

        assertTrue(resultSuccess)
    }

    @Test
    fun editionFailed() {
        val service = WallService()
        service.add(
            Post(
                578, 600, 101, 0, postSource = PostSource(),
                geo = Geo(place = Place()), copyHistory = null,
                comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                    parentsStack = null, attachment = null, thread = Thread()),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
            )
        )
        service.add(
            Post(
                579, 605, 101, 0, postSource = PostSource(),
                geo = Geo(place = Place()), copyHistory = null,
                comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                    parentsStack = null, attachment = null, thread = Thread()),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
            )
        )

        val updateFailing = Post(
            3, 654, 112, 1, postSource = PostSource(),
            geo = Geo(place = Place()), copyHistory = null,
            comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                parentsStack = null, attachment = null, thread = Thread()),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
        )

        val resultFail = service.edit(updateFailing)

        assertFalse(resultFail)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService()
        val post1 = Post(
            0, 589, 101, 0, postSource = PostSource(),
            geo = Geo(place = Place()), copyHistory = null,
            comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                parentsStack = null, attachment = null, thread = Thread()
            ),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
        )
        val post2 = Post(
            333, 404, 101, 0, postSource = PostSource(),
            geo = Geo(place = Place()), copyHistory = null,
            comments = Comment(donut = Donut(placeHolder = PlaceHolder()),
                parentsStack = null, attachment = null, thread = Thread()
            ),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder()), attachments = null
        )
        val comment1 = Comment(
            id = 4,
            donut = Donut(placeHolder = PlaceHolder()),
            attachment = null,
            parentsStack = null,
            thread = Thread()
        )
        service.add(post1)
        service.add(post2)

        val result = service.createComment(comment1)
        assertEquals("no post with id 4 exists", result)
    }
}