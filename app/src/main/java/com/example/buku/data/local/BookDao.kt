package com.example.buku.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.buku.model.Book

@Dao
interface BookDao {

    @Insert
    fun createBook(bookLocal: BookLocal)

    @Query("SELECT * FROM table_book")
    fun getFavoriteBooks(): MutableList<BookLocal>

    @Delete
    fun deleteBook(book: BookLocal)


}