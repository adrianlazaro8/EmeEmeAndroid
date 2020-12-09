package com.adlagar.data

import java.io.File

interface ImageUploader {
    fun upload(filePath: File?,
               onSuccess: (String) -> Unit,
               onFailure: (String) -> Unit,
               progressListener: (Long, Long) -> Unit
    )
}