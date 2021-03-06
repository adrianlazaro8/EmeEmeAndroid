package com.adlagar.emeeme.ui.screens.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.databinding.ItemPortfolioBinding
import com.adlagar.emeeme.ui.common.extensions.loadImage

class PortfolioAdapter(
    private val projects: List<Project>,
    private val itemClick: (Project) -> Unit) :
    RecyclerView.Adapter<PortfolioAdapter.ProjectsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val itemPortfolioBinding = ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectsViewHolder(itemPortfolioBinding)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val currentProject = projects[position]
        with(currentProject){
            holder.ivProject.loadImage(currentProject.thumbnail)
            holder.tvName.text = title
            holder.itemView.setOnClickListener {
                itemClick.invoke(currentProject)
            }
        }
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    class ProjectsViewHolder(itemPortfolioBinding: ItemPortfolioBinding)
        : RecyclerView.ViewHolder(itemPortfolioBinding.root) {

        val tvName = itemPortfolioBinding.tvProjectName
        val llNew = itemPortfolioBinding.llTagNew
        val ivProject = itemPortfolioBinding.ivPortfolioItem
    }
}