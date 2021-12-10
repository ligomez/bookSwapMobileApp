package com.example.buku.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.model.Books
import com.example.buku.network.Callback
import com.example.buku.network.FirestoreService

class OrderViewModel: ViewModel() {
    val firestoreService = FirestoreService()
    val listBooks : MutableLiveData<List<Books>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getBooksFromFirebase()
    }

    private fun getBooksFromFirebase() {
        firestoreService.getBooks(object : Callback<List<Books>>{
            override fun onSuccess(result: List<Books>?) {
                listBooks.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished() {
        isLoading.value = true
    }
}