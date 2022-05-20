package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.data.local.BookLocal
import com.example.buku.data.repository.FavoritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {

    private val favoritesRepository = FavoritesRepository()

    private var booksLoad : MutableLiveData<ArrayList<BookLocal>> = MutableLiveData()
    val onBooksLoaded: LiveData<ArrayList<BookLocal>> = booksLoad


    fun getFavoriteBooks() {
        GlobalScope.launch(Dispatchers.IO){
            booksLoad.postValue(favoritesRepository.getFavoriteBooks())
        }
    }
}