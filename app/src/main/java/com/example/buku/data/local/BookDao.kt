package com.example.buku.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {

    @Insert
    fun createBook(bookLocal: BookLocal)

    @Query("SELECT * FROM table_book")
    fun getFavoriteBooks(): ArrayList<BookLocal>


}