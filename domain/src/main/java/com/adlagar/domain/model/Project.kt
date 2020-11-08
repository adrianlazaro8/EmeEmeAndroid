package com.adlagar.domain.model

data class Project(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val createdDateMillis: Long = 0,
    val thumbnail: String = "",
    val featured: Boolean = false,
    val city: String = "",
    val images: List<ProjectImage> = mutableListOf(),
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)