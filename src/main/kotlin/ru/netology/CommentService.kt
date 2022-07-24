package ru.netology

object CommentService:Service<Comment> {

    private var comments :MutableList <Comment> = mutableListOf()

    override fun add(comment: Comment): Comment {
        comments.add(comment)
        return comments.last()
    }

    override fun read(commentId: Int): List<Comment> {
        comments.forEach { comment ->
            if (comment.idOfNote == commentId) return comments
        }
        throw CommentNotFoundException("Комментарий не найден")
    }

    override fun edit(id: Int, editComment: Comment): Boolean {
        for ((index, comment) in comments.withIndex()) {
            if (!comment.deleted) {
                if (id == comment.id) {
                    comments[index] = comment.copy(
                        idOfNote = comment.idOfNote, id = comment.id,
                        deleted = false, message = comment.message
                    )
                    return true
                }
            }
        }
        throw CommentNotFoundException("Комментарий не найден")
    }


    override fun delete(id: Int) {
        comments.forEach { comment ->
            if (id == comment.id) comment.deleted = true
        }
    }

    override fun recovery(id: Int) {
        comments.forEach { comment ->
            if (comment.id == id && comment.deleted) comment.deleted = false
        }
        throw CommentNotFoundException("Комментарий не найден")
    }

    override fun getById(id: Int): Comment {
        comments.forEach { comment ->
            if (comment.id == id) return comment
        }
        throw CommentNotFoundException("Комментарий не найден")
    }





}