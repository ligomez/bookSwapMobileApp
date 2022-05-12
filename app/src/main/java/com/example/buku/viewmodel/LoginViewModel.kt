package com.example.buku.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginViewModel : ViewModel() {

    private lateinit var auth: FirebaseAuth

    fun login(email: String, password: String) {

        auth = Firebase.auth

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("Login", "signInWithEmail:success")

                } else {
                    Log.w("Login", "singInWithEmail:failure", task.exception)
                }

            }

    }
}