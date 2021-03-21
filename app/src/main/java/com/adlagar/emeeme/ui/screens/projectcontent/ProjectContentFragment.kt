package com.adlagar.emeeme.ui.screens.projectcontent

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
import androidx.navigation.fragment.navArgs
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.data.ImageSelector
import com.adlagar.emeeme.databinding.FragmentProjectContentBinding
import com.adlagar.emeeme.ui.common.extensions.getViewModelFactory
import com.adlagar.emeeme.ui.screens.MainActivity

class ProjectContentFragment : Fragment() {

    private val args: ProjectContentFragmentArgs by navArgs()

    private lateinit var imageSelector: ImageSelector

    private lateinit var binding: FragmentProjectContentBinding

    private lateinit var project: Project

    private val viewModel: ProjectContentViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.projectContentViewModel }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProjectContentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        project = args.project

        viewModel.uiState.observe(viewLifecycleOwner){
            when(it){
                is ProjectContentViewModel.UiState.ProjectUpdated -> {
                    Log.d("","")
                }
                is ProjectContentViewModel.UiState.Error -> {
                    Log.d("","")
                }
            }
        }

        binding.fabAddImage.setOnClickListener {
            imageSelector = ImageSelector(requireContext(), this, false)
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(), arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    ), 0
                )
            } else {
                takePhoto()
            }
        }
    }

    private fun takePhoto() {
        imageSelector.selectImage()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageSelector.handleResult(requestCode, resultCode, data) {
            it?.let {
                viewModel.uploadImage(project, it)
            }
        }
    }
}