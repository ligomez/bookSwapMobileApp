package com.example.buku.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookLocal::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun BookDao(): BookDao
}