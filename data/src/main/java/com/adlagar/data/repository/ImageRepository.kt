package com.adlagar.data.repository

import com.adlagar.data.ImageUploader
import java.io.File

class ImageRepository(
    private val imageUploader: ImageUploader
) {
    suspend fun uploadImage(
        filePath: File,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit,
        progressListener: (Long, Long) -> Unit
    ) {
        return imageUploader.upload(
            filePath,
            onSuccess,
            onFailure,
            progressListener
        )
    }

}