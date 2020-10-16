package com.adlagar.emeeme.data

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Contact
import com.adlagar.domain.model.ContactPerson
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirestoreCompanyDataSource(
    private val firebaseFirestore: FirebaseFirestore
) : CompanyRemoteDataSource {

    private val TAG = "FirestoreCompanyDS"

    override suspend fun getContactInfo(): Contact = suspendCancellableCoroutine { continuation ->
        val projects = firebaseFirestore.collection("company").document("contact")
        projects.get().addOnSuccessListener {
            if (it.exists()) {
                val contact = it.toObject(Contact::class.java)
                continuation.resume(contact ?: Contact())
            } else {
                continuation.resume(Contact())
            }
        }
    }

    override suspend fun modifyContactInfo(contact: Contact): Boolean =
        suspendCancellableCoroutine { continuation ->
            val contactInfo = hashMapOf(
                "name" to contact.name,
                "latitude" to contact.latitude,
                "longitude" to contact.longitude,
                "contactPerson" to contact.contactPerson
            )

            firebaseFirestore.collection("company").document("contact")
                .set(contactInfo)
                .addOnSuccessListener { continuation.resume(true) }
                .addOnFailureListener { continuation.resume(false) }
        }

    override suspend fun getAboutCompany(): String = suspendCancellableCoroutine { continuation ->
        val projects = firebaseFirestore.collection("company").document("about_us")
        projects.get().addOnSuccessListener {
            if (it.exists()) {
                val textCompany: String = it.data?.get("description") as String? ?: ""
                continuation.resume(textCompany)
            } else {
                continuation.resume("")
            }
        }
    }

    override suspend fun modifyAboutCompany(text: String): Boolean =
        suspendCancellableCoroutine { continuation ->
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