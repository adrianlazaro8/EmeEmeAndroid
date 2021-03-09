package com.adlagar.emeeme.ui.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.Project
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
            if(projects.isNotEmpty()){
                _model.value = UiModel.Content(projects)
            } else {
                _model.value = UiModel.Empty
            }
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        object Empty : UiModel()
        data class Content(val projects: List<Project>) : UiModel()
    }

}