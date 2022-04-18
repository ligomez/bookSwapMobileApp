package com.example.buku.view.adapter

import com.example.buku.model.Book

interface BooksListener {
    fun onBooksClick(book: Book, position: Int)
}