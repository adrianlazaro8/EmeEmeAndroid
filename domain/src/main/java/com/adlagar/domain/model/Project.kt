package com.adlagar.domain.model

data class Project(
    val id: String = "0",
    val title: String = "",
    val description: String = "",
    val createdDateMillis: Long = 0,
    var thumbnail: String = "",
    val featured: Boolean = false,
    val city: String = "",
    var images: List<ProjectImage> = mutableListOf(),
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)