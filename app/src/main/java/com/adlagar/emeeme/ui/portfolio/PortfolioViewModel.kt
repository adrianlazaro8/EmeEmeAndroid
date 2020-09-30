package com.adlagar.emeeme.ui.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.adlagar.usecases.CreateProject
import com.adlagar.usecases.GetAllProjects
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PortfolioViewModel(
    private val createProject: CreateProject,
    private val getAllProjects: GetAllProjects
): ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private fun getProjects() =  GlobalScope.launch {
        getAllProjects.invoke()
    }

    private fun createProject(project: Project) = GlobalScope.launch {
        createProject.invoke(project)
    }

    private fun refresh() {
        viewModelScope.launch {
            _model.value = UiModel.Content(getAllProjects.invoke())
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val movies: List<Project>) : UiModel()
    }

}