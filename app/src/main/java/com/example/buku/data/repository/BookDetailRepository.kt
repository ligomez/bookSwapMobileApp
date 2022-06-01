package com.example.buku.data.repository

import androidx.lifecycle.LiveData
import com.example.buku.Buku
import com.example.buku.data.local.BookDao
import com.example.buku.data.local.BookLocal
import com.example.buku.model.Book
import java.sql.Types

class BookDetailRepository {

    val bookDao: BookDao = Buku.database.BookDao()

    fun saveInFavorites(book: Book) {
        val bookLocal = BookLocal(
            idLocal = Types.NULL,
            id = book.id,
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
        bookDao.createBook(bookLocal)
    }

    fun checkIsFavorite(book: Book) : BookLocal {
        val bookIdFirebase: String = book.id
        return bookDao.checkIsFavorite(bookIdFirebase)
    }

    fun deleteInFavorite(book: Book) {
        val bookLocal = BookLocal(
            idLocal = Types.NULL,
            id = book.id,
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
        bookDao.deleteBook(bookLocal)
    }
}