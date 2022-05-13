package com.example.buku.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Book(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("author")
    val author: String = "",
    @SerializedName("imageUrl")
    val imageUrl: String = "",
    @SerializedName("details")
    val details: String = "",
    @SerializedName("condition")
    val condition: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("postedBy")
    val postedBy: String = "",
    @SerializedName("category")
    val category: String = "",
    @SerializedName("latitude")
    val latitude: Double = 0.0,
    @SerializedName("longitude")
    val longitude: Double = 0.0,
) : Serializable
