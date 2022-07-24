package ru.netology

data class Comment (
    val id: Int? = null,
    val idOfNote: Int? = null,
    val message: String? = null,
    var deleted: Boolean = false
) {
}