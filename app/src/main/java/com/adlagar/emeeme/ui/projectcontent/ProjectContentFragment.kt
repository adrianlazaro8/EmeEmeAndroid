package com.adlagar.emeeme.ui.projectcontent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adlagar.emeeme.databinding.FragmentProjectContentBinding

class ProjectContentFragment : Fragment() {

    private lateinit var binding: FragmentProjectContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProjectContentBinding.inflate(inflater)
        return binding.root
    }
}