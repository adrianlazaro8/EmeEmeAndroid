package com.adlagar.emeeme.di

import com.adlagar.emeeme.data.FakeCompanyDataSource
import com.adlagar.emeeme.data.FakeRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideFirestoreInstance() = FirebaseFirestore.getInstance()

    @Provides
    fun provideCompanyDataSource() = FakeCompanyDataSource()

    @Provides
    fun provideRemoteDataSource() = FakeRemoteDataSource()
}