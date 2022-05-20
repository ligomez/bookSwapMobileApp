package com.example.buku.data.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BookDao {

    @Insert
    fun createBook(bookLocal: BookLocal)
}