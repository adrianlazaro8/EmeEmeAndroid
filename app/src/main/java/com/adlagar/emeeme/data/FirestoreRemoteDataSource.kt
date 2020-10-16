package com.adlagar.emeeme.data

import android.util.Log
import com.adlagar.data.source.ProjectsRemoteDataSource
import com.adlagar.domain.model.Project
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirestoreRemoteDataSource(
    private val firebaseFirestore: FirebaseFirestore
) : ProjectsRemoteDataSource {

    private val TAG = "FirestoreRemoteDS"

    override suspend fun createProject(project: Project) {
        val city = hashMapOf(
            "id" to project.id,
            "title" to project.title,
            "description" to project.description,
            "createdDate" to project.createdDate,
            "thumbnail" to project.thumbnail,
            "featured" to project.createdDate,
            "city" to project.city,
            "images" to project.images,
            "latitude" to project.latitude,
            "longitude" to project.longitude
        )

        firebaseFirestore.collection("projects").document(project.id.toString())
            .set(city)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

    }

    override suspend fun getProjects(): List<Project> = suspendCancellableCoroutine {continuation ->
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