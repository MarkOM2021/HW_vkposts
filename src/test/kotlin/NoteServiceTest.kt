import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class NoteServiceTest {

    @Test
    fun addedNoteIsNotZero() {
        val service = NoteService()
        val note = Note(1, "1", "first")
        val result = service.add(note)

        assertEquals(note, result)
    }

    @Test
    fun updateNoteIsDone() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        val result = service.update(Note(1, "New", "first"))

        TestCase.assertTrue(result)
    }

    @Test(expected = NodeNotFoundException::class)
    fun updateNoteIsFailed() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        val result = service.update(Note(3, "New", "first"))

        assertEquals("Note id3 has not been found", result)
    }

    @Test
    fun deleteNoteIsDone() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        val result = service.delete(Note(1, "1", "first"))

        TestCase.assertTrue(result)
    }

    @Test(expected = NodeNotFoundException::class)
    fun deleteNoteIsFailed() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        val result = service.delete(Note(3, "New", "first"))

        assertEquals("Note id3 has not been found", result)
    }

    @Test
    fun updateCommentIsDone() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        service.addComment(2, NoteComment(1, 1, 2, "hello"))
        val result = service.updateComment(2, NoteComment(1, 1, 2, "first edited"))

        TestCase.assertTrue(result)
    }

    @Test
    fun updateCommentIsFailed() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        service.addComment(2, NoteComment(1, 1, 2, "hello"))
        val result = service.updateComment(1, NoteComment(1, 1, 2, "first edited"))

        TestCase.assertFalse(result)
    }

    @Test
    fun deleteCommentIsDone() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.addComment(1, NoteComment(1, 1, 2, "hello"))

        val result = service.deleteComment(1, NoteComment(1))

        TestCase.assertTrue(result)
    }

    @Test
    fun deleteCommentIsFailed() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.addComment(1, NoteComment(2, 1, 2, "hello"))

        val result = service.deleteComment(3, NoteComment(1))

        TestCase.assertFalse(result)
    }

    @Test
    fun restoreCommentIsDone() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        service.addComment(2, NoteComment(1, 1, 2, "hello"))
        service.deleteComment(2, NoteComment(1))
        val result = service.restoreComment(2, NoteComment(1))

        TestCase.assertTrue(result)
    }

    @Test
    fun restoreCommentIsFailed() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        service.addComment(2, NoteComment(1, 1, 2, "hello"))
        service.deleteComment(2, NoteComment(1))
        val result = service.restoreComment(3, NoteComment(1))

        TestCase.assertFalse(result)
    }

    @Test(expected = NodeNotFoundException::class)
    fun getExceptionAtUpdateComment() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        service.addComment(2, NoteComment(1, 1, 2, "hello"))
        val result = service.updateComment(2, NoteComment(2, 1, 2, "first edited"))

        assertEquals("Comment id2 has not been found", result)
    }

    @Test(expected = NodeNotFoundException::class)
    fun getExceptionAtDeleteComment() {
        val service = NoteService()
        service.add(Note(1, "1", "first"))
        service.add(Note(2, "2", "second"))
        service.addComment(2, NoteComment(1, 1, 2, "hello"))
        val result = service.deleteComment(2, NoteComment(2))

        assertEquals("Comment id2 has not been found", result)
    }
}