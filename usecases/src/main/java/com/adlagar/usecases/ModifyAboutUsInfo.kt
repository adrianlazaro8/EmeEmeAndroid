package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource

class ModifyAboutUsInfo(
    private val companyRemoteDataSource: CompanyRemoteDataSource
){
    suspend fun invoke(image: String, text: String) = companyRemoteDataSource.modifyAboutCompany(image, text)
}