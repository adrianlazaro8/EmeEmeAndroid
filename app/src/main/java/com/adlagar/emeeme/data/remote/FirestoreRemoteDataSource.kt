package com.adlagar.emeeme.data.remote

import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import java.util.*
import kotlin.coroutines.resume

class FirestoreRemoteDataSource(
    private val firebaseFirestore: FirebaseFirestore
) : ProjectsRemoteDataSource {

    override suspend fun createProject(project: Project): Project {
        val randomId = UUID.randomUUID().toString()
        val projectHash = hashMapOf(
            "id" to randomId,
            "title" to project.title,
            "description" to project.description,
            "createdDate" to project.createdDateMillis,
            "thumbnail" to project.thumbnail,
            "featured" to project.featured,
            "city" to project.city,
            "images" to project.images,
            "latitude" to project.latitude,
            "longitude" to project.longitude
        )

        return try {
            firebaseFirestore
                .collection("projects")
                .document(randomId)
                .set(projectHash)
                .await()
            project
        } catch (exception: CancellationException) {
            project
        }
    }

    override suspend fun updateProject(project: Project): Project {
        val projectHash = hashMapOf(
            "id" to project.id,
            "title" to project.title,
            "description" to project.description,
            "createdDate" to project.createdDateMillis,
            "thumbnail" to project.thumbnail,
            "featured" to project.featured,
            "city" to project.city,
            "images" to project.images,
            "latitude" to project.latitude,
            "longitude" to project.longitude
        )

        return try {
            firebaseFirestore
                .collection("projects")
                .document(project.id)
                .update(projectHash)
                .await()
            project
        } catch (exception: CancellationException) {
            project
        }
    }

    override suspend fun getProjects(): List<Project> =
        suspendCancellableCoroutine { continuation ->
            val projects = firebaseFirestore.collection("projects")
            projects.get().addOnSuccessListener {
                if (it.isEmpty) {
                    continuation.resume(listOf())
                } else {
                    val projects = it.toObjects(Project::class.java)
                    continuation.resume(projects)
                }
            }
        }
}