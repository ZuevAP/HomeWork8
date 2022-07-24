package ru.netology

import org.junit.Assert.*
import org.junit.Test

class MainKtTest{

    @Test
    fun addNote() {
        val note = Note(id = 55)
        val expected = 1
        val result = NoteService.add(note).id

        assertEquals(expected, result)
    }
    @Test(expected = NoteNotFoundException::class)
    fun readNoteException() {
        val note = Note(id = 0, ownerId = 1, text = "Test")
        NoteService.add(note).id
        NoteService.read(6)

    }

    @Test
    fun readNote() {
        val note = Note(id = 1, ownerId = 1, text = "Test")
        NoteService.add(note).id
        val result = NoteService.read(ownerId = 1)

        assertEquals(note.ownerId, result[1].ownerId)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editNoteNoNote() {
        val note = Note(id = 56, title = "Title Test")
        NoteService.add(note)

        NoteService.edit(5, note)
    }

    @Test
    fun editNote() {
        val note = Note(id = 56, title = "Title Test")
        NoteService.add(note)
        val expected = true
        val result = NoteService.edit(1, note)

        assertEquals(expected, result)
    }


    @Test(expected = NoteNotFoundException::class)
    fun restoreNoteNoNote() {
        val noteEdit = Note(id = 6, text = "Test")
        NoteService.add(noteEdit)
        NoteService.edit(8, noteEdit)
    }






    @Test
    fun addComment() {
        val comment = Comment(id = 3)
        val expected = 3
        val result = CommentService.add(comment).id

        assertEquals(expected, result)
    }


    @Test(expected = CommentNotFoundException::class)
    fun editCommentNoComment() {
        val commentEdit = Comment(id = 6, idOfNote = 1, message = "Test")
        CommentService.add(commentEdit)
        CommentService.edit(7, commentEdit)
    }


    @Test
    fun editComment() {
        val comment = Comment(id = 5, idOfNote = 1)
        val commentEdit = Comment(id = 6, idOfNote = 1, message = "Test")
        CommentService.add(comment)
        val expected = true
        val result = CommentService.edit(5, commentEdit)

        assertEquals(expected, result)
    }



    @Test(expected = CommentNotFoundException::class)
    fun restoreCommentNoComment() {
        val commentEdit = Comment(id = 6, idOfNote = 1, message = "Test")
        CommentService.add(commentEdit)
        CommentService.edit(8, commentEdit)
    }














}