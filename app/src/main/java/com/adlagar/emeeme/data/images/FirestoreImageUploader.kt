package com.adlagar.emeeme.data.images

import android.net.Uri
import com.adlagar.data.ImageUploader
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class FirestoreImageUploader(
    private val firebaseStorage: FirebaseStorage
) : ImageUploader {

    override suspend fun upload(
        fileToUpload: File,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit,
        progressListener: (Long, Long) -> Unit
    ) {
        val filePath = Uri.fromFile(fileToUpload.absoluteFile)
        val imagesRef = firebaseStorage.reference.child("aboutus/${System.currentTimeMillis()}.jpg")
        imagesRef.putFile(filePath)
            .addOnFailureListener {
                onFailure.invoke(it.localizedMessage ?: "Unknown")
            }
            .addOnProgressListener {
                progressListener.invoke(it.bytesTransferred, it.totalByteCount)
            }.addOnCompleteListener {

                if(it.isSuccessful) {
                    it.result?.storage?.downloadUrl?.addOnSuccessListener {uri ->
                        onSuccess.invoke(uri.toString())
                    }
                } else {
                    onSuccess.invoke("")
                }
            }
    }
}