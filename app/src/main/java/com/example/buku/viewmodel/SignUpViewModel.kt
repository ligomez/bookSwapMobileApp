package com.example.buku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.data.SignUpRepository
import com.example.buku.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.sign


class SignUpViewModel : ViewModel() {

    private var createUser : MutableLiveData<Boolean> = MutableLiveData()
    val onUserCreated : LiveData<Boolean> = createUser

    private val signUpRepository = SignUpRepository()


    fun signUp(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO){
            val result = signUpRepository.createUser(email, password)
        }

    }

    fun createUserAccount(email: String, name: String) {
        GlobalScope.launch(Dispatchers.IO){
            val result = signUpRepository.createUserInDataBase(email, name)
        }
    }
}