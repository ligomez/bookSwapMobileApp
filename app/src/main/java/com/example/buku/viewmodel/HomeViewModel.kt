package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.data.BooksRepository
import com.example.buku.model.Book
import com.example.buku.model.BookList
import com.example.buku.model.Category
import com.example.buku.model.CategoryList
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class HomeViewModel: ViewModel() {

    private val booksLoad: MutableLiveData<ArrayList<Book>> = MutableLiveData()
    val onBooksLoaded: LiveData<ArrayList<Book>> = booksLoad

    private val categoriesLoad: MutableLiveData<ArrayList<Category>> = MutableLiveData()
    val onCategoriesLoaded: LiveData<ArrayList<Category>> = categoriesLoad

    private val repository = BooksRepository()

    fun getBooksFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            booksLoad.postValue(repository.getBooks())
        }
    }


    fun loadMockBooksFromJason(booksString: InputStream?) {
        val booksString = booksString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        booksLoad.value = gson.fromJson(booksString, BookList::class.java)
    }


    fun loadMockCategoriesFromJason(categoriesString: InputStream) {
        val categoriesString = categoriesString.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        categoriesLoad.value = gson.fromJson(categoriesString, CategoryList::class.java)
    }

}