package com.adlagar.emeeme.di

import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.emeeme.data.FirestoreCompanyDataSource
import com.adlagar.emeeme.data.fake.FakeCompanyDataSource
import com.adlagar.emeeme.data.fake.FakeRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideFirestoreInstance(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    fun provideCompanyDataSource(): CompanyRemoteDataSource =
        FirestoreCompanyDataSource()

    @Provides
    fun provideRemoteDataSource(): ProjectsRemoteDataSource =
        FakeRemoteDataSource()

    @Provides
    fun provideProjectsRepository(projectsRemoteDataSource: ProjectsRemoteDataSource) =
        ProjectsRepository(projectsRemoteDataSource)
}