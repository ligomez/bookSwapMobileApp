package com.example.buku.model

import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("name")
    var name: String,
    @SerializedName("imageUrl")
    var imageUrl: String
    )