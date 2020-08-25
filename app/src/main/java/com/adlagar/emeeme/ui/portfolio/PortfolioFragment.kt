package com.adlagar.emeeme.ui.portfolio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.FragmentPortfolioBinding

class PortfolioFragment : Fragment() {

    private var binding: FragmentPortfolioBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPortfolioBinding.inflate(inflater)
        return binding?.root
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