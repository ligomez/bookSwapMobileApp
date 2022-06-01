package com.example.buku.data

import com.example.buku.model.BookList
import retrofit2.http.GET

interface ApiService {

    @GET("ligomezm/bookSwapMobileApp/books")
    suspend fun getBooks(): BookList

}