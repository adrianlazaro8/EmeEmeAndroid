package com.adlagar.emeeme.data.images

import android.net.Uri
import com.adlagar.data.ImageUploader
import com.google.firebase.storage.FirebaseStorage

class FirestoreImageUploader(private val firebaseStorage: FirebaseStorage): ImageUploader {

    override fun upload(
        filePath: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
        progressListener: (Long, Long) -> Unit
    ) {
        val uri = Uri.parse(filePath)
        firebaseStorage.reference.putFile(uri)
            .addOnSuccessListener {
                onSuccess.invoke()
            }
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage ?: "Unknown")
            }
            .addOnProgressListener {
                progressListener.invoke(it.bytesTransferred, it.totalByteCount)
            }
    }
}