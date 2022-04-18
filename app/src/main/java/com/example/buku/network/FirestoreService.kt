package com.example.buku.network

import com.example.buku.model.Book
import com.google.firebase.firestore.FirebaseFirestore

const val BOOKS_COLLECTION_NAME = "books"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    fun getBooks(callback: Callback<List<Book>>){
        firebaseFirestore.collection(BOOKS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Book::class.java)
                    callback.onSuccess(list)
                    break
                }
        }
    }
}