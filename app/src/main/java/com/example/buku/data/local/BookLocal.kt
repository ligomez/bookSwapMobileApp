package com.example.buku.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "table_book")
data class BookLocal (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name= "id") val id: Int,
    @ColumnInfo(name= "name")val name: String = "",
    @ColumnInfo(name= "author")val author: String = "",
    @ColumnInfo(name= "imageUrl")val imageUrl: String = "",
    @ColumnInfo(name= "details")val details: String = "",
    @ColumnInfo(name= "condition")val condition: String = "",
    @ColumnInfo(name= "location")val location: String = "",
    @ColumnInfo(name= "postedBy")val postedBy: String = "",
    @ColumnInfo(name= "category")val category: String = "",
    @ColumnInfo(name= "latitude")val latitude: Double = 0.0,
    @ColumnInfo(name= "longitude")val longitude: Double = 0.0,
        )