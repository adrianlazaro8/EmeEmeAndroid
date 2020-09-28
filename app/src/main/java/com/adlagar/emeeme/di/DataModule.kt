package com.adlagar.emeeme.di

import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.emeeme.data.FakeCompanyDataSource
import com.adlagar.emeeme.data.FakeRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideFirestoreInstance(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    fun provideCompanyDataSource(): CompanyRemoteDataSource = FakeCompanyDataSource()

    @Provides
    fun provideRemoteDataSource(): ProjectsRemoteDataSource = FakeRemoteDataSource()

    @Provides
    fun provideProjectsRepository(projectsRemoteDataSource: ProjectsRemoteDataSource) =
        ProjectsRepository(projectsRemoteDataSource)
}