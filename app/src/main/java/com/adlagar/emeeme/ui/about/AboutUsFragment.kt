package com.adlagar.emeeme.ui.about

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.adlagar.emeeme.databinding.FragmentAboutUsBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory

class AboutUsFragment : Fragment() {

    private var binding: FragmentAboutUsBinding? = null

    private val viewModel: AboutUsViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.aboutUsViewModel }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutUsBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.aboutUs.observe(viewLifecycleOwner, Observer(::updateUI))
        binding?.let { binding ->
            binding.btAboutusContinue.setOnClickListener {
                viewModel.modifyAboutCompany(binding.etAboutus.text.toString())
            }
        }
    }

    private fun updateUI(uiState: AboutUsViewModel.UiState) {
        when (uiState) {
            is AboutUsViewModel.UiState.Loading -> Log.d("", "")
            is AboutUsViewModel.UiState.AboutUsInfo -> showAboutUsInfo(uiState.string)
        }
    }

    private fun showAboutUsInfo(string: String) {
        binding?.etAboutus?.setText(string)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}