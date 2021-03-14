package com.adlagar.domain.model

import java.io.Serializable

data class ProjectImage (
    val id: Int,
    val image: String,
    val name: String
): Serializable
