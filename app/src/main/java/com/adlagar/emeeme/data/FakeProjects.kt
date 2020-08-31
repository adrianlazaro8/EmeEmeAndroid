package com.adlagar.emeeme.data

import com.adlagar.domain.model.Project

val url = "https://picsum.photos/id/"
val sufix = "/300/300"

val fakeProjects = createRandomProjects()

private fun createRandomProjects(): List<Project>{
    val numberOfProjects = 20
    val projects = mutableListOf<Project>()
    for(i in 1..numberOfProjects){
        projects.add(createProject(i))
    }
    return projects
}

private fun createProject(id: Int): Project{
    return Project(
        id,
        "Test",
        "Test description",
        System.currentTimeMillis(),
        url + id + sufix,
        false,
        "Valencia",
        listOf(),
        3.14,
        -3.12
    )
}