package com.adlagar.emeeme.di

import com.adlagar.emeeme.ui.about.AboutUsViewModel
import com.adlagar.emeeme.ui.contact.ContactViewModel
import com.adlagar.emeeme.ui.portfolio.PortfolioViewModel
import com.adlagar.usecases.*
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
        contactInfo: GetContactInfo,
        modifyContactInfo: ModifyContactInfo
    ): ContactViewModel {
        return ContactViewModel(contactInfo, modifyContactInfo)
    }

    @Provides
    fun aboutUsViewModelProvider(
        getAboutUsInfo: GetAboutUsInfo,
        modifyAboutUsInfo: ModifyAboutUsInfo
    ): AboutUsViewModel {
        return AboutUsViewModel(
            getAboutUsInfo,
            modifyAboutUsInfo
        )
    }
}