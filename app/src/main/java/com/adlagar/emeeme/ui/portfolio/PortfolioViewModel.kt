package com.adlagar.emeeme.ui.portfolio

import androidx.lifecycle.ViewModel
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

    private fun getProjects() =  GlobalScope.launch {
        getAllProjects.invoke()
    }

    private fun createProject(project: Project) = GlobalScope.launch {
        createProject.invoke(project)
    }

}