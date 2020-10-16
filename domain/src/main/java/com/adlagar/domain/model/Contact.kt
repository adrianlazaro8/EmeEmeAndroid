package com.adlagar.domain.model

data class Contact (
    var name: String = "",
    var latitude: Double = 0.0,
    var longitude: Double = 0.0,
    var contactPerson: MutableList<ContactPerson> = mutableListOf()
)
