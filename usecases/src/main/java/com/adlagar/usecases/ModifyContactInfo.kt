package com.adlagar.usecases

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Contact

class ModifyContactInfo(private val companyRemoteDataSource: CompanyRemoteDataSource){
    suspend fun invoke(contact: Contact) = companyRemoteDataSource.modifyContactInfo(contact)
}