package com.example.buku.data.repository

import com.example.buku.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class SignUpRepository {

    private lateinit var auth: FirebaseAuth

    suspend fun createUser(email: String, password: String): String {
        return try {
            auth = Firebase.auth
            auth.createUserWithEmailAndPassword(email, password).await()
            "User successfully registered"
        } catch (e: FirebaseAuthException) {
            return e.message.toString()
        }
    }

    suspend fun createUserInDataBase(email: String, name: String): String {
        val db = Firebase.firestore

        return try {
            val idUserDoc = db.collection("users").document()
            val user = User(id = idUserDoc.id, email = email, name = name)

            db.collection("users")
                .document(idUserDoc.id)
                .set(user)
                .await()
            "User successfully created"
        } catch (e: FirebaseFirestoreException) {
            return e.message.toString()
        }
    }
}