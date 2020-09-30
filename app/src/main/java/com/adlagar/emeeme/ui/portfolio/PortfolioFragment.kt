package com.adlagar.emeeme.ui.portfolio

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.FragmentPortfolioBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.contact.ContactViewModel
import com.adlagar.emeeme.ui.extensions.getViewModelFactory

class PortfolioFragment : Fragment() {

    private var binding: FragmentPortfolioBinding? = null

    private val viewModel: PortfolioViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.porfolioViewModel }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPortfolioBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.model.observe(viewLifecycleOwner, Observer (::updateUi))
    }

    private fun updateUi(uiModel: PortfolioViewModel.UiModel) {
        when (uiModel) {
            is PortfolioViewModel.UiModel.Content -> Log.d("","")
            is PortfolioViewModel.UiModel.Loading -> Log.d("","")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PortfolioFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}