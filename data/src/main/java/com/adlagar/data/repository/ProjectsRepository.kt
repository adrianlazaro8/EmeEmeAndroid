package com.adlagar.data.repository

import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project

class ProjectsRepository(
    private val projectsRemoteDataSource: ProjectsRemoteDataSource
) {
    suspend fun getAllProjects(): List<Project> {
        return projectsRemoteDataSource.getProjects()
    }

    suspend fun createProject(project: Project): Project {
        return projectsRemoteDataSource.createProject(project)
    }
}