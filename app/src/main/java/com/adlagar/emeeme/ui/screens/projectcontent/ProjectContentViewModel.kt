package com.adlagar.emeeme.ui.screens.projectcontent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.usecases.UploadImageUseCase
import kotlinx.coroutines.launch
import java.io.File

class ProjectContentViewModel(
    private val uploadImageUseCase: UploadImageUseCase
) : ViewModel() {

    fun uploadImage(
        projectImage: File,
        onSuccess: (String) -> Unit,
        onFailure: (String) -> Unit
    ) {
        viewModelScope.launch {
            uploadImageUseCase.invoke(projectImage,
                onSuccess = {
                    onSuccess.invoke(it)
                },
                onFailure = {
                    onFailure.invoke(it)
                },
                progressListener = { bytesTransferred, totalBytes ->

                })
        }
    }

}
