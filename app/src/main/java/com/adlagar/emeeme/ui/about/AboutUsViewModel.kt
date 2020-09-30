package com.adlagar.emeeme.ui.about

import androidx.lifecycle.ViewModel
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.data.FakeRemoteDataSource
import com.adlagar.usecases.GetAboutUsInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AboutUsViewModel(
    private val getAboutUsInfo: GetAboutUsInfo
): ViewModel() {

    fun getAboutCompany() = GlobalScope.launch {
        getAboutUsInfo.invoke()
    }

}