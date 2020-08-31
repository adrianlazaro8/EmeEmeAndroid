package com.adlagar.domain.model

data class Project(
    val id: Int,
    val title: String,
    val description: String,
    val createdDate: Long,
    val thumbnail: String,
    val featured: Boolean,
    val city: String,
    val images: List<ProjectImage>,
    val latitude: Double,
    val longitude: Double
)