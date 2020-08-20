package com.adlagar.emeeme.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface EmeEmeApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): EmeEmeApplicationComponent
    }
}