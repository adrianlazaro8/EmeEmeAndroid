package com.adlagar.data.sources

import com.adlagar.domain.model.Contact

interface ContactRemoteDataSource {
    suspend fun getContactInfo(): List<Contact>
}