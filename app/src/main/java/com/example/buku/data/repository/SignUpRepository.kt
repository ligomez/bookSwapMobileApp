package com.example.buku.data.repository

import com.example.buku.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class SignUpRepository {

    private lateinit var auth: FirebaseAuth

    suspend fun createUser(email: String, password: String): Any {
        auth = Firebase.auth
        val result = auth.createUserWithEmailAndPassword(email, password).await()
        return result

    }

    suspend fun createUserInDataBase(email: String, name: String): Any {
        val db = Firebase.firestore

        val idUserDoc = db.collection("users").document()
        val user = User(id = idUserDoc.id, email = email, name = name)

        val result = db.collection("users")
            .document(idUserDoc.id)
            .set(user)
            .await()
        return result
    }
}