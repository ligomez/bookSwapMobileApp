package com.example.buku.data.repository

import com.example.buku.Buku
import com.example.buku.data.local.BookDao
import com.example.buku.data.local.BookLocal


class FavoritesRepository {
    fun getFavoriteBooks(): MutableList<BookLocal>? {
        val bookDao: BookDao = Buku.database.BookDao()
        return bookDao.getFavoriteBooks()
    }
}