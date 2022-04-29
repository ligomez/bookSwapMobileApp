package com.example.buku.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category (
    @SerializedName("name")
    var name: String,
    @SerializedName("imageUrl")
    var imageUrl: String,
    ) : Serializable