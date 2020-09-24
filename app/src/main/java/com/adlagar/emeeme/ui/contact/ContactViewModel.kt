package com.adlagar.emeeme.ui.contact

import androidx.lifecycle.ViewModel
import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.data.FakeRemoteDataSource
import com.adlagar.usecases.GetContactInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ContactViewModel(
    private val getContactInfo: GetContactInfo
): ViewModel() {

    private fun getContactInfo() =  GlobalScope.launch {
        getContactInfo.invoke()
    }

}