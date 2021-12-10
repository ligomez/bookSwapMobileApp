package com.example.buku.model

import java.io.Serializable

class Books: Serializable {
    lateinit var name: String
    lateinit var author: String
    lateinit var imageUrl: String
    var score: Int = 0
    var available: Boolean = true
    lateinit var location: String

    fun bookToLowerCase(): String{
        return name.toLowerCase()
    }
}