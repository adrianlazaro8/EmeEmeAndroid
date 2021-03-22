package com.adlagar.emeeme.ui.screens.projectcontent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.adlagar.usecases.UploadImageUseCase
import id.zelory.compressor.Compressor
import id.zelory.compressor.constraint.quality
import id.zelory.compressor.constraint.resolution
import kotlinx.coroutines.launch
import java.io.File

class ProjectContentViewModel(
    private val projectsRemoteDataSource: ProjectsRemoteDataSource,
    private val uploadImageUseCase: UploadImageUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    private fun uploadImage(
        project: Project,
        projectImage: File
    ) {
        viewModelScope.launch {
            uploadImageUseCase.invoke(projectImage,
                onSuccess = {
                    project.images.add(it)
                    _uiState.value = UiState.ImageUploaded(project)
                },
                onFailure = {
                    _uiState.value = UiState.Error(it)
                },
                progressListener = { bytesTransferred, totalBytes ->

                })
        }
    }

    fun updateProject(project: Project) {
        viewModelScope.launch {
            _uiState.value = UiState.ProjectUpdated(projectsRemoteDataSource.updateProject(project))
        }
    }

    fun uploadResizedImage(context: Context, project: Project, file: File) = viewModelScope.launch {
        val compressedFile = Compressor.compress(context, file) {
            resolution(720, 480)
            quality(80)
        }
        uploadImage(project, compressedFile)
    }

    sealed class UiState {
        class Error(error: String) : UiState()
        class ImageUploaded(val project: Project) : UiState()
        class ProjectUpdated(project: Project) : UiState()
    }

}
