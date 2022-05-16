package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.data.repository.SignUpRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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