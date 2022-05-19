package com.example.buku

import android.app.Application
import androidx.room.Room
import com.example.buku.data.local.BookDatabase

class Buku : Application(){

    companion object{
        lateinit var database: BookDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            BookDatabase::class.java,
            "book_db"
        ).build()
    }
}