package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Project

class ModifyAboutUsInfo(
    private val companyRemoteDataSource: CompanyRemoteDataSource
){
    suspend fun invoke(text: String) = companyRemoteDataSource.modifyAboutCompany(text)
}