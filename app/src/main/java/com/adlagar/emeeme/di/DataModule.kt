package com.adlagar.emeeme.di

import com.adlagar.data.ImageUploader
import com.adlagar.data.repository.ProjectsRepository
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.emeeme.data.images.FirestoreImageUploader
import com.adlagar.emeeme.data.remote.FirestoreCompanyDataSource
import com.adlagar.emeeme.data.remote.FirestoreRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideFirestoreInstance(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Singleton
    @Provides
    fun provideFirestoreStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    fun provideImageUploader(firebaseStorage: FirebaseStorage): ImageUploader = FirestoreImageUploader(
        firebaseStorage
    )

    @Provides
    fun provideCompanyDataSource(firebaseFirestore: FirebaseFirestore, imageUploader: ImageUploader): CompanyRemoteDataSource =
        FirestoreCompanyDataSource(
            firebaseFirestore,
            imageUploader
        )

    @Provides
    fun provideRemoteDataSource(firebaseFirestore: FirebaseFirestore): ProjectsRemoteDataSource =
        FirestoreRemoteDataSource(
            firebaseFirestore
        )

    @Provides
    fun provideProjectsRepository(projectsRemoteDataSource: ProjectsRemoteDataSource) =
        ProjectsRepository(projectsRemoteDataSource)
}