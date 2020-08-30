package com.adlagar.data.source

import com.adlagar.domain.model.Contact

interface CompanyRemoteDataSource {
    suspend fun getContactInfo(): List<Contact>
    suspend fun getAboutCompany(): String
}