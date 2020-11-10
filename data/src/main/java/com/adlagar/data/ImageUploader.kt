package com.adlagar.data

interface ImageUploader {
    fun upload(filePath: String,
               onSuccess: () -> Unit,
               onFailure: (String) -> Unit,
               progressListener: (Long, Long) -> Unit
    )
}