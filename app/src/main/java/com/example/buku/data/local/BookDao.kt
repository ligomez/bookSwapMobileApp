package com.example.buku.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface BookDao {

    @Insert
    fun createBook(bookLocal: BookLocal)

    @Query("SELECT * FROM table_book")
    fun getFavoriteBooks(): MutableList<BookLocal>

    @Query("SELECT * FROM table_book WHERE idFirebase = :bookIdFirebase")
    fun checkIsFavorite(bookIdFirebase: String): BookLocal

    @Delete
    fun deleteBook(bookLocal: BookLocal)


}