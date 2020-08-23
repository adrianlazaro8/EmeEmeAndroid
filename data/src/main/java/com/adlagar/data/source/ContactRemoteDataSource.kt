package com.adlagar.data.source

import com.adlagar.domain.model.Contact

interface ContactRemoteDataSource {
    suspend fun getContactInfo(): List<Contact>
}