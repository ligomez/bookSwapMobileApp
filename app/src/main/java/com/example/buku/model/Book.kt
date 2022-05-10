package com.example.buku.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Book(
    @SerializedName("name")
    val name: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("condition")
    val condition: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("postedBy")
    val postedBy: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
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
