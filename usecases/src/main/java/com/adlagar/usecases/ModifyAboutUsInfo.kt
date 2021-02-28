package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource
import java.io.File

class ModifyAboutUsInfo(
    private val companyRemoteDataSource: CompanyRemoteDataSource
){
    suspend fun invoke(file: File?, description: String) = companyRemoteDataSource.modifyAboutCompany(file, description)
}