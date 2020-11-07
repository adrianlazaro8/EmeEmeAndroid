package com.adlagar.usecases

import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.domain.model.Project

class GetAllProjectsUseCase(private val projectsRepository: ProjectsRepository){
    suspend fun invoke(): List<Project> = projectsRepository.getAllProjects()
}