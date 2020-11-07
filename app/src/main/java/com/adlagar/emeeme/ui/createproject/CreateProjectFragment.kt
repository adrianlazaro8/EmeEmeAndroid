package com.adlagar.emeeme.ui.createproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.adlagar.emeeme.databinding.FragmentCreateProjectBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory

class CreateProjectFragment : Fragment() {

    private var binding: FragmentCreateProjectBinding? = null

    private val viewModel: CreateProjectViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.createProjectViewModel }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateProjectBinding.inflate(inflater, container, false)
        return binding?.root
    }
}