package com.example.buku.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.buku.model.Book
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SignUpViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    private var createUser : MutableLiveData<Boolean> = MutableLiveData()
    val onUserCreated : LiveData<Boolean> = createUser

    fun signUp(email: String, password: String) {

        auth = Firebase.auth

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    createUser.value = true
                    Log.d("SignUp", "createUserWithEmail:success")


                } else {
                    createUser.value = false
                     Log.w("SignUp", "createUserWithEmail:failure", task.exception)

                }
            }

    }
}