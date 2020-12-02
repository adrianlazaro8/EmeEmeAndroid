package com.adlagar.emeeme.ui.portfolio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.databinding.ItemPortfolioBinding

class PortfolioAdapter(private val projects: List<Project>) :
    RecyclerView.Adapter<PortfolioAdapter.ProjectsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectsViewHolder {
        val itemPortfolioBinding = ItemPortfolioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProjectsViewHolder(itemPortfolioBinding)
    }

    override fun onBindViewHolder(holder: ProjectsViewHolder, position: Int) {
        val currentProject = projects[0]
        with(currentProject){
            holder.tvName.text = title
        }
    }

    override fun getItemCount(): Int {
        return projects.size
    }

    class ProjectsViewHolder(private val itemPortfolioBinding: ItemPortfolioBinding)
        : RecyclerView.ViewHolder(itemPortfolioBinding.root) {

        val tvName = itemPortfolioBinding.tvProjectName
        val llNew = itemPortfolioBinding.llTagNew
        val ivProject = itemPortfolioBinding.ivPortfolioItem
    }
}