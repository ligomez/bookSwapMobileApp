package com.example.buku.data.repository

import com.example.buku.model.Book
import com.example.buku.model.Category
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class HomeRepository {

    suspend fun getBooksFromFirebase(): ArrayList<Book> {
        val db = Firebase.firestore
        val result = db.collection("books").get().await()

        val listBooks: ArrayList<Book> = arrayListOf()
        for (book in result)
            listBooks.add(book.toObject<Book>())

        return listBooks
    }

    suspend fun getCategoriesFromFirebase(): ArrayList<Category> {
        val db = Firebase.firestore
        val result = db.collection("categories").get().await()

        val listCategories: ArrayList<Category> = arrayListOf()
        for (category in result)
            listCategories.add(category.toObject<Category>())

        return listCategories
    }
}