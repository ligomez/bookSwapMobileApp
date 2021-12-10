package com.example.buku.view.adapter

import com.example.buku.model.Books

interface BooksListener {
    fun onBooksClick(book: Books, position: Int)
}