package com.adlagar.emeeme.ui.about

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.adlagar.domain.model.AboutUs
import com.adlagar.emeeme.data.ImageSelector
import com.adlagar.emeeme.databinding.FragmentAboutUsBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory
import com.adlagar.emeeme.ui.extensions.loadImage

class AboutUsFragment : Fragment() {

    private var binding: FragmentAboutUsBinding? = null

    private var aboutUs: AboutUs? = null

    private val imageSelector: ImageSelector by lazy {
        ImageSelector(requireContext(), this)
    }

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
                viewModel.modifyAboutCompany(imageSelector.file, binding.etAboutus.text.toString())
            }

            binding.ivAboutUs.setOnClickListener {

                if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                    == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ), 0);
                } else {
                    takePhoto()
                }
            }
        }
    }

    private fun takePhoto() {
        imageSelector.selectImage()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageSelector.handleResult(requestCode, resultCode, data){
            binding?.ivAboutUs?.loadImage(it?.absolutePath.toString())
        }

    }

    private fun updateUI(uiState: AboutUsViewModel.UiState) {
        when (uiState) {
            is AboutUsViewModel.UiState.Loading -> Log.d("", "")
            is AboutUsViewModel.UiState.AboutUsInfo -> showAboutUsInfo(uiState.aboutUs)
            is AboutUsViewModel.UiState.Error -> TODO()
        }
    }

    private fun showAboutUsInfo(aboutUs: AboutUs) {
        this.aboutUs = aboutUs
        binding?.ivAboutUs?.loadImage(aboutUs.image)
        binding?.etAboutus?.setText(aboutUs.description)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}