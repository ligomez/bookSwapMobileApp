package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.data.repository.HomeRepository
import com.example.buku.model.Book
import com.example.buku.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = HomeRepository()

    private val booksLoad: MutableLiveData<ArrayList<Book>> = MutableLiveData()
    val onBooksLoaded: LiveData<ArrayList<Book>> = booksLoad

    private val categoriesLoad: MutableLiveData<ArrayList<Category>> = MutableLiveData()
    val onCategoriesLoaded: LiveData<ArrayList<Category>> = categoriesLoad

    fun getCategoriesFromFirebase() {
        GlobalScope.launch(Dispatchers.IO) {
            categoriesLoad.postValue(repository.getCategoriesFromFirebase())
        }
    }

    fun getBooksFromFirebase() {
        GlobalScope.launch(Dispatchers.IO) {
            booksLoad.postValue(repository.getBooksFromFirebase())
        }
    }
}