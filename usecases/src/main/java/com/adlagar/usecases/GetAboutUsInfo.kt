package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Project

class GetAboutUsInfo(private val companyRemoteDataSource: CompanyRemoteDataSource){
    suspend fun invoke(): String = companyRemoteDataSource.getAboutCompany()
}