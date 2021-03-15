package com.adlagar.emeeme.di

import android.app.Application
import com.adlagar.emeeme.ui.screens.about.AboutUsViewModel
import com.adlagar.emeeme.ui.screens.contact.ContactViewModel
import com.adlagar.emeeme.ui.screens.createproject.CreateProjectViewModel
import com.adlagar.emeeme.ui.screens.portfolio.PortfolioViewModel
import com.adlagar.emeeme.ui.screens.projectcontent.ProjectContentViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, ViewModelsModule::class, UseCasesModule::class])
interface EmeEmeApplicationComponent {

    val porfolioViewModel: PortfolioViewModel
    val aboutUsViewModel: AboutUsViewModel
    val contactViewModel: ContactViewModel
    val createProjectViewModel: CreateProjectViewModel
    val projectContentViewModel: ProjectContentViewModel

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): EmeEmeApplicationComponent
    }
}