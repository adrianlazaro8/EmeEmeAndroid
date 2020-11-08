package com.adlagar.emeeme.ui.createproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.Project
import com.adlagar.usecases.CreateProjectUseCase
import kotlinx.coroutines.launch

class CreateProjectViewModel(
    private val createProjectUseCase: CreateProjectUseCase
): ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            return _model
        }

    fun createProject(project: Project) = viewModelScope.launch {
        createProjectUseCase.invoke(project)
    }

    sealed class UiModel {
        object Loading : UiModel()
        class Created(val project: Project) : UiModel()
    }

}