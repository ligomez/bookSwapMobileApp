package com.example.buku.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginRepository {

    private lateinit var auth: FirebaseAuth

    fun checkUserLoggedin(): Boolean {
        auth = Firebase.auth
        val currentUser = auth.currentUser
        return currentUser != null
    }
}