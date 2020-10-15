package com.adlagar.emeeme.data

import android.util.Log
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Contact
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirestoreCompanyDataSource : CompanyRemoteDataSource {

    private val TAG = "FirestoreCompanyDS"


    override suspend fun getContactInfo(): Contact = suspendCancellableCoroutine { continuation ->
        val db = FirebaseFirestore.getInstance()
        val projects = db.collection("company").document("contact")
        projects.get().addOnSuccessListener {
            if (it.exists()) {
                val contact = it.toObject(Contact::class.java)
                continuation.resume(contact ?: Contact())
            } else {
                continuation.resume(Contact())
            }
        }
    }

    override suspend fun getAboutCompany(): String = suspendCancellableCoroutine { continuation ->
        val db = FirebaseFirestore.getInstance()
        val projects = db.collection("company").document("about_us")
        projects.get().addOnSuccessListener {
            if (it.exists()) {
                val textCompany: String = it.data?.get("description") as String? ?: ""
                continuation.resume(textCompany)
            } else {
                continuation.resume("")
            }
        }
    }

    override suspend fun modifyAboutCompany(text: String): Boolean = suspendCancellableCoroutine { continuation ->
        val db = FirebaseFirestore.getInstance()

        val aboutUsInfo = hashMapOf(
            "description" to text
        )

        db.collection("company").document("about_us")
            .set(aboutUsInfo)
            .addOnSuccessListener { continuation.resume(true) }
            .addOnFailureListener { continuation.resume(false) }
    }
}