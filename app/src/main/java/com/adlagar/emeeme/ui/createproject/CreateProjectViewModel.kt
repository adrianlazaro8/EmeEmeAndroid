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

    fun createProject(project: Project, projectImage: File? = null) = viewModelScope.launch {
        _model.value = UiModel.Loading
        if (project.latitude == 0.toDouble() || project.longitude == 0.toDouble()) {
            _model.value = UiModel.InvalidLatLng
        } else if (projectImage != null && project.thumbnail.isEmpty()) {
            uploadImage(projectImage, project)
        } else {
            val createdProject = createProjectUseCase.invoke(project)
            _model.value = UiModel.Created(createdProject)
        }
    }

    private fun uploadImage(fileToUpload: File, project: Project) {
        viewModelScope.launch {
            _model.value = UiModel.Loading
            uploadImageUseCase.invoke(fileToUpload,
                onSuccess = {
                    project.thumbnail = it
                    createProject(project, fileToUpload)
                },
                onFailure = {
                    _model.value = UiModel.ImageErrorUpload
                },
                progressListener = { bytesTransferred, totalBytes -> }
            )
        }
    }


    sealed class UiModel {
        object Loading : UiModel()
        object Error : UiModel()
        object InvalidLatLng : UiModel()
        object ImageErrorUpload : UiModel()
        class Created(val project: Project) : UiModel()
    }

}