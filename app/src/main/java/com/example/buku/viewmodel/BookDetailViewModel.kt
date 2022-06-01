package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buku.data.local.BookLocal
import com.example.buku.data.repository.BookDetailRepository
import com.example.buku.model.Book
import kotlinx.coroutines.*

class BookDetailViewModel : ViewModel() {

    private val bookDetailRepository = BookDetailRepository()

    private var idFirebaseCheck: MutableLiveData<BookLocal> = MutableLiveData()
    val onIdFirebaseChecked: LiveData<BookLocal> = idFirebaseCheck

    fun saveInFavorites(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            bookDetailRepository.saveInFavorites(book)
        }
    }

    fun checkIsFavorite(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            idFirebaseCheck.postValue(bookDetailRepository.checkIsFavorite(book))
        }
    }

    fun deleteInFavorite(book: Book) {
        viewModelScope.launch(Dispatchers.IO) {
            bookDetailRepository.deleteInFavorite(book)
        }
    }
}