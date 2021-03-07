package com.adlagar.emeeme.di

import com.adlagar.data.repository.ImageRepository
import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.usecases.*
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun createProjectProvider(projectsRepository: ProjectsRepository) =
        CreateProjectUseCase(projectsRepository)

    @Provides
    fun getAboutUsInfoProvider(companyRemoteDataSource: CompanyRemoteDataSource) =
        GetAboutUsInfo(companyRemoteDataSource)

    @Provides
    fun getAllProjectsProvider(projectsRepository: ProjectsRepository) =
        GetAllProjectsUseCase(projectsRepository)

    @Provides
    fun getContactInfoProvider(companyRemoteDataSource: CompanyRemoteDataSource) =
        GetContactInfo(companyRemoteDataSource)

    @Provides
    fun getModifyContactInfoProvider(companyRemoteDataSource: CompanyRemoteDataSource) =
        ModifyContactInfo(companyRemoteDataSource)

    @Provides
    fun getModifyAboutUsInfoProvider(companyRemoteDataSource: CompanyRemoteDataSource) =
        ModifyAboutUsInfo(companyRemoteDataSource)

    @Provides
    fun getUploadImageUseCaseProvider(imageRepository: ImageRepository) =
        UploadImageUseCase(imageRepository)
}