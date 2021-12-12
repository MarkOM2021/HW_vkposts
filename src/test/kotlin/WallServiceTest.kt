import junit.framework.TestCase.*

import org.junit.Test

class WallServiceTest {

    @Test
    fun addedPostIDIsNotZero() {
        val service = WallService()
        val post = Post(
                0, 589, 101,0, comments = Comments(),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()))

        val result = service.add(post)
        assertEquals(post, result)
    }

    @Test
    fun updateDone() {
        val service = WallService()
        service.add(
            Post(
                578, 600, 101,0, comments = Comments(),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()))
        )
        service.add(
            Post(
                579, 605, 101,0, comments = Comments(),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()))
        )

        val updateSuccess = Post(
            1, 654, 112,1, comments = Comments(),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder())
        )

        val resultSuccess = service.update(updateSuccess)

        assertTrue(resultSuccess)
    }

    @Test
    fun updateFailed() {
        val service = WallService()
        service.add(
            Post(
                578, 600, 101,0, comments = Comments(),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()))
        )
        service.add(
            Post(
                579, 605, 101,0, comments = Comments(),
                copyright = Copyright(), likes = Likes(), reposts = Reposts(),
                views = Views(), donut = Donut(placeHolder = PlaceHolder()))
        )

        val updateFailing = Post(
            3, 654, 112,1, comments = Comments(),
            copyright = Copyright(), likes = Likes(), reposts = Reposts(),
            views = Views(), donut = Donut(placeHolder = PlaceHolder())
        )

        val resultFail = service.update(updateFailing)

        assertFalse(resultFail)
    }
}