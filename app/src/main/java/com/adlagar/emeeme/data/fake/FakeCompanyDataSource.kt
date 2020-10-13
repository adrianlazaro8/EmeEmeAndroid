package com.adlagar.emeeme.data.fake

import com.adlagar.data.source.CompanyRemoteDataSource
import com.adlagar.domain.model.Contact

class FakeCompanyDataSource: CompanyRemoteDataSource{

    override suspend fun getContactInfo(): Contact {
        TODO("Not yet implemented")
    }

    override suspend fun getAboutCompany(): String {
        TODO("Not yet implemented")
    }
}