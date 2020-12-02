package com.adlagar.emeeme.ui.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.Project
import com.adlagar.domain.model.ProjectImage
import com.adlagar.usecases.GetAllProjectsUseCase
import kotlinx.coroutines.launch

class PortfolioViewModel(
    private val getAllProjectsUseCase: GetAllProjectsUseCase
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) getProjects()
            return _model
        }

    private fun getProjects() {
        viewModelScope.launch {
            val projects = getAllProjectsUseCase.invoke()
            projects.map { fillProject(it) }
            _model.value = UiModel.Content(projects)
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val projects: List<Project>) : UiModel()
    }

    private fun fillProject(project: Project) {
        project.thumbnail = "https://picsum.photos/200/300"
        project.images = mutableListOf(
            ProjectImage(1, "test", "https://picsum.photos/200/300"),
            ProjectImage(2, "test2", "https://picsum.photos/200/300"),
            ProjectImage(3, "test3", "https://picsum.photos/200/300")
        )
    }
}