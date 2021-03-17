package com.adlagar.emeeme.ui.screens.portfolio

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.FragmentPortfolioBinding
import com.adlagar.emeeme.ui.common.RecyclerPorfolioDecorator
import com.adlagar.emeeme.ui.common.extensions.getViewModelFactory
import com.adlagar.emeeme.ui.screens.MainActivity

class PortfolioFragment : Fragment() {

    private var binding: FragmentPortfolioBinding? = null

    private val viewModel: PortfolioViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.porfolioViewModel }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceStatfe: Bundle?
    ): View? {
        binding = FragmentPortfolioBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.model.observe(viewLifecycleOwner, Observer(::updateUi))
        binding?.fabCreateProject?.setOnClickListener {
            findNavController().navigate(PortfolioFragmentDirections.actionPortfolioToCreateProjectFragment())
        }
    }

    private fun updateUi(uiModel: PortfolioViewModel.UiModel) {
        when (uiModel) {
            is PortfolioViewModel.UiModel.Content -> showProjects(uiModel.projects)
            is PortfolioViewModel.UiModel.Loading -> Log.d("", "")
            PortfolioViewModel.UiModel.Empty -> Log.d("", "")
        }
    }

    private fun showProjects(projects: List<Project>) {
        binding?.let {
            it.rvProjects.addItemDecoration(
                RecyclerPorfolioDecorator(resources.getDimension(R.dimen.recycler_margin).toInt())
            )
            it.rvProjects.adapter = PortfolioAdapter(projects){ project ->
                findNavController().navigate(PortfolioFragmentDirections.actionPortfolioToProjectContentFragment(project))
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}