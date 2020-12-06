package com.adlagar.data.source

import com.adlagar.domain.model.AboutUs
import com.adlagar.domain.model.Contact

interface CompanyRemoteDataSource {
    suspend fun getContactInfo(): Contact
    suspend fun modifyContactInfo(contact: Contact): Boolean
    suspend fun getAboutCompany(): AboutUs
    suspend fun modifyAboutCompany(image: String, text: String): Boolean
}