package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Project

class GetContactInfo(private val companyRemoteDataSource: CompanyRemoteDataSource){
    suspend fun invoke() = companyRemoteDataSource.getContactInfo()
}