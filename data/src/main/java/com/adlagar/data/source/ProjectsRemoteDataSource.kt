package com.adlagar.data.source

import com.adlagar.domain.model.Project

interface ProjectsRemoteDataSource {
    suspend fun getProjects(): List<Project>
    suspend fun createProject(project: Project)
}