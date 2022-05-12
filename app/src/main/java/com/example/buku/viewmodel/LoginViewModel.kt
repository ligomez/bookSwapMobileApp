package com.example.buku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    private var userLogin : MutableLiveData<Boolean> = MutableLiveData()
    val onUserLoggedin : LiveData<Boolean> = userLogin

    private var checkUserLogin : MutableLiveData<Boolean> = MutableLiveData()
    val onUserLoginChecked : LiveData<Boolean> = checkUserLogin


    fun login(email: String, password: String) {

        auth = Firebase.auth

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    userLogin.value = true
                    Log.d("Login", "signInWithEmail:success")

                } else {
                    userLogin.value = false
                    Log.w("Login", "singInWithEmail:failure", task.exception)
                }

            }

    }

    fun checkUserLoggedin() {

        auth = Firebase.auth

        val currentUser = auth.currentUser
        if (currentUser != null){
            checkUserLogin.value = true
        }
    }
}