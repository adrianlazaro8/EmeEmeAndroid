package com.adlagar.emeeme.ui.screens.projectcontent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adlagar.emeeme.databinding.ProjectImageBinding
import com.adlagar.emeeme.ui.common.extensions.loadImage

class ProjectContentAdapter(
    val images: MutableList<String>
) : RecyclerView.Adapter<ProjectContentAdapter.ProjectContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectContentViewHolder {
        val itemPortfolioBinding =
            ProjectImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectContentViewHolder(itemPortfolioBinding)
    }

    override fun onBindViewHolder(holder: ProjectContentViewHolder, position: Int) {
        holder.image.loadImage(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    class ProjectContentViewHolder(projectImageBinding: ProjectImageBinding) :
        RecyclerView.ViewHolder(projectImageBinding.root) {
        val image = projectImageBinding.ivProjectImage
    }
}