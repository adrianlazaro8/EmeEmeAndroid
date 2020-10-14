package com.adlagar.emeeme.data

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Contact
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirestoreCompanyDataSource : CompanyRemoteDataSource {

    override suspend fun getContactInfo(): Contact {
        TODO("Not yet implemented")
    }

    override suspend fun getAboutCompany(): String = suspendCancellableCoroutine { continuation ->
        val db = FirebaseFirestore.getInstance()
        val projects = db.collection("about_us")
        projects.get().addOnSuccessListener {
            if (it.isEmpty) {
                continuation.resume("")
            } else {
                val textCompany = it.toString()
                continuation.resume(textCompany)
            }
        }
    }

}