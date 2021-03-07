package com.adlagar.usecases

import com.adlagar.data.repository.ImageRepository
import java.io.File

class UploadImageUseCase(
    private val imageRepository: ImageRepository
) {
    suspend fun invoke(
        filePath: File,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit,
        progressListener: (Long, Long) -> Unit
    ) = imageRepository.uploadImage(
        filePath,
        onSuccess,
        onFailure,
        progressListener
    )
}