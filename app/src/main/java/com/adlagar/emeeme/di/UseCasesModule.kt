package com.adlagar.emeeme.di

import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.usecases.CreateProject
import com.adlagar.usecases.GetAboutUsInfo
import com.adlagar.usecases.GetAllProjects
import com.adlagar.usecases.GetContactInfo
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun createProjectProvider(projectsRepository: ProjectsRepository) =
        CreateProject(projectsRepository)

    @Provides
    fun getAboutUsInfoProvider(companyRemoteDataSource: CompanyRemoteDataSource) =
        GetAboutUsInfo(companyRemoteDataSource)

    @Provides
    fun getAllProjectsProvider(projectsRepository: ProjectsRepository) =
        GetAllProjects(projectsRepository)

    @Provides
    fun getContactInfoProvider(companyRemoteDataSource: CompanyRemoteDataSource) =
        GetContactInfo(companyRemoteDataSource)
}