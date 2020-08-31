package com.adlagar.data.source

import com.adlagar.domain.model.Contact

interface CompanyRemoteDataSource {
    suspend fun getContactInfo(): Contact
    suspend fun getAboutCompany(): String
}