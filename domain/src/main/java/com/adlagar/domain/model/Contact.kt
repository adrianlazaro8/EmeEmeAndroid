package com.adlagar.domain.model

data class Contact (
    val name: String = "",
    val latitude: Float = 0F,
    val longitude: Float = 0F,
    val contactPersons: List<ContactPerson> = listOf()
)
