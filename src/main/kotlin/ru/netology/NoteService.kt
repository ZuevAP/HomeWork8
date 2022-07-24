package ru.netology

object NoteService : Service<Note> {


    private var notes = mutableListOf<Note>()


    override fun add(note: Note): Note {

        notes.add(note.copy(id = if (notes.isEmpty()) 1 else notes.last().id + 1))

        return notes.last()
    }

    override fun read(ownerId: Int): List<Note> {
        notes.forEach { note ->
            if (note.ownerId == ownerId) return notes
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    override fun edit(noteId: Int, editNote: Note): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (noteId == note.id) {
                notes[index] = note.copy(
                    id = note.id, ownerId = note.ownerId, title = editNote.title,
                    text = editNote.text
                )
                return true
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    override fun getById(id: Int): Note {
        notes.forEach { note ->
            if (note.id == id) return note
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    override fun delete(id: Int) {
        notes.forEach { note ->
            if (id == note.id) note.deleted = true
        }
    }


    override fun recovery(id: Int) {
        notes.forEach { note ->
            if (note.id == id && note.deleted) note.deleted = false
        }
        throw NoteNotFoundException("Заметка не найдена")
    }
}






