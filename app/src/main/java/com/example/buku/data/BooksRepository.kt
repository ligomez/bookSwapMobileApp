package com.example.buku.data

class BooksRepository {

    suspend fun getBooks() = ApiFactory.retrofit.getBooks()
}