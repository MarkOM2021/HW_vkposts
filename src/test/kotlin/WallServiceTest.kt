import junit.framework.TestCase.*

import org.junit.Test

class WallServiceTest {

    @Test
    fun addedPostIDIsNotZero() {
        val service = WallService()
        val post = Post(
                0, 589, 101, 5656, 11, "hello all!", 0,
                0, true, "text", 679, true, true,
                true, false, false, true, 397,
                Comments(1, true, true, true, true),
                Copyright(12, "https://vk.com/natgeoru", "nat_geo", "publication"),
                likes = Likes(0, true, canLike = true, canPublish = true),
                reposts = Reposts(0, true), Views(1),
                Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
            )

        val result = service.add(post)
        assertEquals(post, result)
    }

    @Test
    fun updateDone() {
        val service = WallService()
        service.add(
            Post(
                354, 456, 111, 376, 9, "hello!", 1,
                0, true, "text", 679, true, true,
                true, false, false, true, 397,
                Comments(1, true, true, true, true),
                Copyright(12, "https://vk.com/natgeoru?w=wall-24565142_1665129", "nat_geo_ru", "publication"),
                likes = Likes(0, true, canLike = true, canPublish = true),
                reposts = Reposts(0, true), Views(1),
                Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
            )
        )
        service.add(
            Post(
                543, 589, 101, 5656, 11, "hello all!", 0,
                0, true, "text", 679, true, true,
                true, false, false, true, 397,
                Comments(1, true, true, true, true),
                Copyright(12, "https://vk.com/natgeoru", "nat_geo", "publication"),
                likes = Likes(0, true, canLike = true, canPublish = true),
                reposts = Reposts(0, true), Views(1),
                Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
            )
        )
        val updateSuccessfull = Post(
            2, 600, 102, 5656, 11, "hello all!", 0,
            0, true, "text", 679, true, true,
            true, false, false, true, 397,
            Comments(1, true, true, true, true),
            Copyright(12, "https://vk.com/natgeoru", "nat_geo", "publication"),
            likes = Likes(0, true, canLike = true, canPublish = true),
            reposts = Reposts(0, true), Views(1),
            Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
        )

        val resultSuccess = service.update(updateSuccessfull)

        assertTrue(resultSuccess)
    }

    @Test
    fun updateFailed() {
        val service = WallService()
        service.add(
            Post(
                354, 456, 111, 376, 9, "hello!", 1,
                0, true, "text", 679, true, true,
                true, false, false, true, 397,
                Comments(1, true, true, true, true),
                Copyright(12, "https://vk.com/natgeoru?w=wall-24565142_1665129", "nat_geo_ru", "publication"),
                likes = Likes(0, true, canLike = true, canPublish = true),
                reposts = Reposts(0, true), Views(1),
                Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
            )
        )
        service.add(
            Post(
                543, 589, 101, 5656, 11, "hello all!", 0,
                0, true, "text", 679, true, true,
                true, false, false, true, 397,
                Comments(1, true, true, true, true),
                Copyright(12, "https://vk.com/natgeoru", "nat_geo", "publication"),
                likes = Likes(0, true, canLike = true, canPublish = true),
                reposts = Reposts(0, true), Views(1),
                Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
            )
        )

        val updateFailing = Post(
            543, 600, 102, 5656, 11, "hello all!", 0,
            0, true, "text", 679, true, true,
            true, false, false, true, 397,
            Comments(1, true, true, true, true),
            Copyright(12, "https://vk.com/natgeoru", "nat_geo", "publication"),
            likes = Likes(0, true, canLike = true, canPublish = true),
            reposts = Reposts(0, true), Views(1),
            Donut(false, 0, PlaceHolder("Is not in VK Donut system"), true, "all")
        )

        val resultFail = service.update(updateFailing)

        assertFalse(resultFail)
    }
}