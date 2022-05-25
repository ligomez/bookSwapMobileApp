package com.example.buku.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.data.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var userLogin : MutableLiveData<String> = MutableLiveData()
    val onUserLoggedin : LiveData<String> = userLogin

    private var checkUserLogin : MutableLiveData<Boolean> = MutableLiveData()
    val onUserLoginChecked : LiveData<Boolean> = checkUserLogin

    private val loginRepository = LoginRepository()

    fun login(email: String, password: String) {
        GlobalScope.launch(Dispatchers.IO){
            userLogin.postValue(loginRepository.signInUser(email, password))
        }
    }

    fun checkUserLoggedin() {
        checkUserLogin.value = loginRepository.checkUserLoggedin()
    }
}