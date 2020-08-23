package com.adlagar.data

import com.adlagar.domain.model.Contact

interface ContactRemoteDataSource {
    suspend fun getContactInfo(): List<Contact>
}