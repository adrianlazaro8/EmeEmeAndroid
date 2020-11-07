package com.adlagar.emeeme.di

import com.adlagar.emeeme.ui.about.AboutUsViewModel
import com.adlagar.emeeme.ui.contact.ContactViewModel
import com.adlagar.emeeme.ui.createproject.CreateProjectViewModel
import com.adlagar.emeeme.ui.portfolio.PortfolioViewModel
import com.adlagar.usecases.*
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun porfolioViewModelProvider(
        getAllProjectsUseCase: GetAllProjectsUseCase
    ): PortfolioViewModel {
        return PortfolioViewModel(getAllProjectsUseCase)
    }

    @Provides
    fun createProjectViewModelProvider(
        createProjectUseCase: CreateProjectUseCase
    ): CreateProjectViewModel {
        return CreateProjectViewModel(createProjectUseCase)
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