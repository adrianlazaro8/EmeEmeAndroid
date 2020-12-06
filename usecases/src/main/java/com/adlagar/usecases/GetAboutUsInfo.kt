package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.AboutUs

class GetAboutUsInfo(private val companyRemoteDataSource: CompanyRemoteDataSource){
    suspend fun invoke(): AboutUs = companyRemoteDataSource.getAboutCompany()
}