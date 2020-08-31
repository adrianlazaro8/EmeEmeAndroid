package com.adlagar.emeeme.data

import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project

class FakeRemoteDataSource: ProjectsRemoteDataSource{

    override suspend fun createProject(project: Project) {
        TODO("Not yet implemented")
    }

    override suspend fun getProjects(): List<Project> {
        return fakeProjects
    }
}