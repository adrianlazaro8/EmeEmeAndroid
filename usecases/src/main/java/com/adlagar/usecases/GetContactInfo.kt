package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource

class GetContactInfo(private val companyRemoteDataSource: CompanyRemoteDataSource){
    suspend fun invoke() = companyRemoteDataSource.getContactInfo()
}