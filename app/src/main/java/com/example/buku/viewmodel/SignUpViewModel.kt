package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.buku.data.repository.SignUpRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private var userSignUp: MutableLiveData<String> = MutableLiveData()
    val onUserSignedUp: LiveData<String> = userSignUp

    private var createUser : MutableLiveData<String> = MutableLiveData()
    val onUserCreated : LiveData<String> = createUser

    private val signUpRepository = SignUpRepository()

    fun signUp(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO){
            userSignUp.postValue(signUpRepository.createUser(email, password))
        }
    }

    fun createUserAccount(email: String, name: String) {
        viewModelScope.launch(Dispatchers.IO){
            createUser.postValue(signUpRepository.createUserInDataBase(email, name))
        }
    }
}