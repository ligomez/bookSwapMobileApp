package com.example.buku.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.example.buku.model.Book
import com.example.buku.model.BookList
import com.example.buku.model.Category
import com.example.buku.model.CategoryList
import com.example.buku.view.ui.fragments.HomeFragment
import com.example.buku.view.ui.fragments.HomeFragmentDirections
import com.google.gson.Gson
import java.io.InputStream

class HomeViewModel: ViewModel() {

    private val booksLoad: MutableLiveData<ArrayList<Book>> = MutableLiveData()
    val onBooksLoaded: LiveData<ArrayList<Book>> = booksLoad


    fun loadMockBooksFromJason(booksString: InputStream?) {
        val booksString = booksString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        booksLoad.value = gson.fromJson(booksString, BookList::class.java)
    }

    fun loadMockCategoriesFromJason(context: Context): ArrayList<Category> {
        val categoriesString: String =
            context.assets.open("categories.json").bufferedReader()
                .use { it!!.readText() }
        val gson = Gson()
        return gson.fromJson(categoriesString, CategoryList::class.java)
    }

}