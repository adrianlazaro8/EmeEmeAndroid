package com.adlagar.usecases

import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.domain.model.Project

class CreateProjectUseCase(private val projectsRepository: ProjectsRepository){
    suspend fun invoke(project: Project) = projectsRepository.createProject(project)
}