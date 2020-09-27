package com.adlagar.emeeme.di

import com.adlagar.emeeme.ui.about.AboutUsViewModel
import com.adlagar.emeeme.ui.contact.ContactViewModel
import com.adlagar.emeeme.ui.portfolio.PortfolioViewModel
import com.adlagar.usecases.CreateProject
import com.adlagar.usecases.GetAboutUsInfo
import com.adlagar.usecases.GetAllProjects
import com.adlagar.usecases.GetContactInfo
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun porfolioViewModelProviders(
        createProject: CreateProject,
        getAllProjects: GetAllProjects
    ): PortfolioViewModel {
        return PortfolioViewModel(createProject, getAllProjects)
    }

    @Provides
    fun contactViewModelProvider(
        contactInfo: GetContactInfo
    ): ContactViewModel {
        return ContactViewModel(contactInfo)
    }

    @Provides
    fun aboutUsViewModelProvider(
        getAboutUsInfo: GetAboutUsInfo
    ): AboutUsViewModel {
        return AboutUsViewModel(getAboutUsInfo)
    }
}