package com.adlagar.emeeme.data.fake

import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.data.fake.fakeProjects

class FakeRemoteDataSource: ProjectsRemoteDataSource{

    override suspend fun createProject(project: Project) {
        TODO("Not yet implemented")
    }

    override suspend fun getProjects(): List<Project> {
        return fakeProjects
    }
}