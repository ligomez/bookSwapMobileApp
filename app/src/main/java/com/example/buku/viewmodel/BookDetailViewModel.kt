package com.example.buku.viewmodel

import androidx.lifecycle.ViewModel
import com.example.buku.data.repository.BookDetailRepository
import com.example.buku.model.Book


class BookDetailViewModel : ViewModel() {

    val bookDetailRepository = BookDetailRepository()

    fun saveInFavorites(book: Book) {
        bookDetailRepository.saveInFavorites(book)
    }
}