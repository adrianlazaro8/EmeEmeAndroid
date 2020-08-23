package com.adlagar.domain.model

data class Contact (
    val name: String,
    val latitude: Float,
    val longitude: Float,
    val contactPersons: List<ContactPerson>
)
