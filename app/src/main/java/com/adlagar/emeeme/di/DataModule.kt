package com.adlagar.emeeme.di

import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.emeeme.data.FirestoreCompanyDataSource
import com.adlagar.emeeme.data.FirestoreRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideFirestoreInstance(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    fun provideCompanyDataSource(firebaseFirestore: FirebaseFirestore): CompanyRemoteDataSource =
        FirestoreCompanyDataSource(firebaseFirestore)

    @Provides
    fun provideRemoteDataSource(firebaseFirestore: FirebaseFirestore): ProjectsRemoteDataSource =
        FirestoreRemoteDataSource(firebaseFirestore)

    @Provides
    fun provideProjectsRepository(projectsRemoteDataSource: ProjectsRemoteDataSource) =
        ProjectsRepository(projectsRemoteDataSource)
}