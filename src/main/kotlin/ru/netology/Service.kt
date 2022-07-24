package ru.netology

interface Service <T> {

    fun add(entity: T): T

    fun read(id: Int): List<T>

    fun edit(id: Int, entity: T): Boolean

    fun delete(id: Int)

    fun getById(i: Int): T

    fun recovery(i: Int)
}