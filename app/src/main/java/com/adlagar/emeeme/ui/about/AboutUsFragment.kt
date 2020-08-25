package com.adlagar.emeeme.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.FragmentAboutUsBinding

class AboutUsFragment : Fragment() {

    private var binding: FragmentAboutUsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutUsBinding.inflate(inflater)
        return binding?.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AboutUsFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}