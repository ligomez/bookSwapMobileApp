package com.example.buku.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Message(
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("userName")
    val userName: String,
    @SerializedName("bookName")
    val bookName: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("date")
    val date: String,
) : Serializable
