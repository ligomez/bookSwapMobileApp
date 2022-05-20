package com.example.buku.viewmodel

import androidx.lifecycle.ViewModel
import com.example.buku.data.repository.BookDetailRepository
import com.example.buku.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class BookDetailViewModel : ViewModel() {

    val bookDetailRepository = BookDetailRepository()

    fun saveInFavorites(book: Book) {
        GlobalScope.launch(Dispatchers.IO){
            bookDetailRepository.saveInFavorites(book)
        }
    }

    fun deleteInFavorite(book: Book) {
        GlobalScope.launch(Dispatchers.IO){
            bookDetailRepository.deleteInFavorite(book)
        }

    }
}