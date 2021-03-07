package com.adlagar.data.source

import com.adlagar.domain.model.AboutUs
import com.adlagar.domain.model.Contact
import java.io.File

interface CompanyRemoteDataSource {
    suspend fun getContactInfo(): Contact
    suspend fun modifyContactInfo(contact: Contact): Boolean
    suspend fun getAboutCompany(): AboutUs
    suspend fun modifyAboutCompany(file: File, description: String): Boolean
}