package com.example.buku.data.repository

import com.example.buku.Buku
import com.example.buku.data.local.BookDao
import com.example.buku.data.local.BookLocal
import com.example.buku.model.Book
import java.sql.Types

class BookDetailRepository {
    fun saveInFavorites(book: Book) {

        val bookLocal = BookLocal(
            id = Types.NULL,
            name = book.name,
            author = book.author,
            imageUrl = book.imageUrl,
            details = book.details,
            condition = book.condition,
            location = book.location,
            postedBy = book.postedBy,
            category = book.category,
            latitude = book.latitude,
            longitude = book.longitude
        )
        val bookDao : BookDao = Buku.database.BookDao()
        bookDao.createBook(bookLocal)
    }

    fun deleteInFavorite(book: Book) {

        val bookLocal = BookLocal(
            id = Types.NULL,
            name = book.name,
            author = book.author,
            imageUrl = book.imageUrl,
            details = book.details,
            condition = book.condition,
            location = book.location,
            postedBy = book.postedBy,
            category = book.category,
            latitude = book.latitude,
            longitude = book.longitude
        )
        val bookDao: BookDao = Buku.database.BookDao()
        bookDao.deleteBook(bookLocal)

    }
}