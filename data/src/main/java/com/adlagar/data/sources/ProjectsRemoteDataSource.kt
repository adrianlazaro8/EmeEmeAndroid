package com.adlagar.data.sources

import com.adlagar.domain.model.Project

interface ProjectsRemoteDataSource {
    suspend fun getProjects(): List<Project>
}