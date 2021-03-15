package com.adlagar.emeeme.ui.screens.projectcontent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.Project
import com.adlagar.usecases.UploadImageUseCase
import kotlinx.coroutines.launch
import java.io.File

class ProjectContentViewModel(
    private val uploadImageUseCase: UploadImageUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    fun uploadImage(
        project: Project,
        projectImage: File
    ) {
        viewModelScope.launch {
            uploadImageUseCase.invoke(projectImage,
                onSuccess = {
                    project.images.add(it)
                    _uiState.value = UiState.ProjectUpdated(project)
                },
                onFailure = {
                    _uiState.value = UiState.Error(it)
                },
                progressListener = { bytesTransferred, totalBytes ->

                })
        }
    }

    sealed class UiState{
        class Error(error: String): UiState()
        class ProjectUpdated(project: Project): UiState()
    }

}
