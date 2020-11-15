package com.adlagar.emeeme.ui.portfolio

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.adlagar.emeeme.databinding.FragmentPortfolioBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory

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
            is PortfolioViewModel.UiModel.Content -> Log.d("", "")
            is PortfolioViewModel.UiModel.Loading -> Log.d("", "")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}