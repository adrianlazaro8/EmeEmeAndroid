package com.adlagar.emeeme.ui.createproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adlagar.emeeme.R

class CreateProjectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_project, container, false)
    }

    companion object {
        fun newInstance(param1: String, param2: String) = CreateProjectFragment()
    }
}