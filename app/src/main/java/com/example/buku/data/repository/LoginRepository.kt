package com.example.buku.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class LoginRepository {

    private lateinit var auth: FirebaseAuth

    fun checkUserLoggedin(): Boolean {
        auth = Firebase.auth
        val currentUser = auth.currentUser
        return currentUser != null
    }


    suspend fun signInUser(email: String, password: String): String? {
        return try {
            auth = Firebase.auth
            auth.signInWithEmailAndPassword(email, password).await()
            "Welcome"
        } catch (e: FirebaseAuthException) {
            return e.message.toString()
        }
    }
}