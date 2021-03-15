package com.adlagar.emeeme.di

import com.adlagar.emeeme.ui.screens.about.AboutUsViewModel
import com.adlagar.emeeme.ui.screens.contact.ContactViewModel
import com.adlagar.emeeme.ui.screens.createproject.CreateProjectViewModel
import com.adlagar.emeeme.ui.screens.portfolio.PortfolioViewModel
import com.adlagar.emeeme.ui.screens.projectcontent.ProjectContentViewModel
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
        createProjectUseCase: CreateProjectUseCase,
        uploadImageUseCase: UploadImageUseCase
    ): CreateProjectViewModel {
        return CreateProjectViewModel(createProjectUseCase, uploadImageUseCase)
    }

    @Provides
    fun projectContentViewModelProvider(
        uploadImageUseCase: UploadImageUseCase
    ): ProjectContentViewModel {
        return ProjectContentViewModel(uploadImageUseCase)
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