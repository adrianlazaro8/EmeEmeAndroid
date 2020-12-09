package com.adlagar.emeeme.data.remote

import com.adlagar.data.ImageUploader
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.AboutUs
import com.adlagar.domain.model.Contact
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.File
import kotlin.coroutines.resume

class FirestoreCompanyDataSource(
    private val firebaseFirestore: FirebaseFirestore,
    private val imageUploader: ImageUploader
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

    override suspend fun getAboutCompany(): AboutUs = suspendCancellableCoroutine { continuation ->
        val projects = firebaseFirestore.collection("company").document("about_us")
        projects.get().addOnSuccessListener {
            if (it.exists()) {
                val description: String = it.data?.get("description") as String? ?: ""
                val image: String = it.data?.get("image") as String? ?: ""
                val aboutUs = AboutUs(image, description)
                continuation.resume(aboutUs)
            } else {
                continuation.resume(AboutUs())
            }
        }
    }

    override suspend fun modifyAboutCompany(file: File?, description: String): Boolean =
        suspendCancellableCoroutine { continuation ->
            val db = FirebaseFirestore.getInstance()


            imageUploader.upload(file, onSuccess = {
                val aboutUsInfo = hashMapOf(
                    "image" to it,
                    "description" to description
                )

                db.collection("company").document("about_us")
                    .set(aboutUsInfo)
                    .addOnSuccessListener { continuation.resume(true) }
                    .addOnFailureListener { continuation.resume(false) }
            },
            onFailure = {

            },
            progressListener = { l: Long, l1: Long ->

            })


        }
}