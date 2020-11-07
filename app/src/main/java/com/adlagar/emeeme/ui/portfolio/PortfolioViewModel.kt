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
): ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    private fun getProjects() =  viewModelScope.launch {
        getAllProjectsUseCase.invoke()
    }

    private fun refresh() {
        viewModelScope.launch {
            _model.value = UiModel.Content(getAllProjectsUseCase.invoke())
        }
    }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val movies: List<Project>) : UiModel()
    }

}