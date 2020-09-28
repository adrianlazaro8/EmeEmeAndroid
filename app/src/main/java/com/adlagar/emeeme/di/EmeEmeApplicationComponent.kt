package com.adlagar.emeeme.di

import android.app.Application
import com.adlagar.emeeme.ui.about.AboutUsViewModel
import com.adlagar.emeeme.ui.contact.ContactViewModel
import com.adlagar.emeeme.ui.portfolio.PortfolioViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, ViewModelsModule::class, UseCasesModule::class])
interface EmeEmeApplicationComponent {

    val porfolioViewModel: PortfolioViewModel
    val aboutUsViewModel: AboutUsViewModel
    val contactViewModel: ContactViewModel

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): EmeEmeApplicationComponent
    }
}