package com.adlagar.data

import com.adlagar.domain.model.Project

interface ProjectsRemoteDataSource {
    suspend fun getProjects(): List<Project>
}