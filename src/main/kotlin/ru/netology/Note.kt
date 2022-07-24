package ru.netology

data class Note (
    val id: Int,
    val ownerId: Int? = null,
    val title: String? = null,
    val text: String? = null,
    val date: Int? = null,
    val comments: Int? = null,
    val readComments: Int? = null,
    val viewUrl: String? = null,
    var deleted: Boolean = false
) {


}