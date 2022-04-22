package com.example.buku.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Book(
    @SerializedName("name")
    val name: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("imageUrl")
    val imageUrl: String
) : Serializable

//
//data class Book(
//    var name: String,
//    var author: String,
//    var location: String,
//    var imageUrl: String,
////    var score: Int = 0,
////    var available: Boolean = true,
//
//)

//    fun bookToLowerCase(): String{
//        return name.toLowerCase()
//    }
