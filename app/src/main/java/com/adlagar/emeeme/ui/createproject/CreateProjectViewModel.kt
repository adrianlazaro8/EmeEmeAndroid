package com.adlagar.emeeme.ui.createproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.Project
import com.adlagar.usecases.CreateProjectUseCase
import com.adlagar.usecases.UploadImageUseCase
import kotlinx.coroutines.launch
import java.io.File

class CreateProjectViewModel(
    private val createProjectUseCase: CreateProjectUseCase,
    private val uploadImageUseCase: UploadImageUseCase
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            return _model
        }

    fun createProject(project: Project) = viewModelScope.launch {
        createProjectUseCase.invoke(project)
    }

    fun uploadImage(fileToUpload: File?) {
        if (fileToUpload != null) {
            viewModelScope.launch {
                _model.value = UiModel.Loading
                uploadImageUseCase.invoke(fileToUpload,
                    onSuccess = {
                        _model.value = UiModel.ImageUploaded(it)
                    },
                    onFailure = {

                    },
                    progressListener = { bytesTransferred, totalBytes ->  }
                )
            }
        }
    }


    sealed class UiModel {
        object Loading : UiModel()
        class Created(val project: Project) : UiModel()
        class ImageUploaded(val url: String) : UiModel()
    }

}