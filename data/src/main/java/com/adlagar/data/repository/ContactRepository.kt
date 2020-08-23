package com.adlagar.data.repository

import com.adlagar.data.source.ContactRemoteDataSource

class ContactRepository(
    private val contactRemoteDataSource: ContactRemoteDataSource
)