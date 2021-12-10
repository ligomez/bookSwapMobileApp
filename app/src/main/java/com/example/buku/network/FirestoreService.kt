package com.example.buku.network

import com.example.buku.model.Books
import com.google.firebase.firestore.FirebaseFirestore

const val BOOKS_COLLECTION_NAME = "books"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    fun getBooks(callback: Callback<List<Books>>){
        firebaseFirestore.collection(BOOKS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Books::class.java)
                    callback.onSuccess(list)
                    break
                }
        }
    }
}