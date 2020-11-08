package com.adlagar.emeeme.ui.createproject

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.databinding.FragmentCreateProjectBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory
import java.util.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        createProjectButton()
    }

    private fun createProjectButton() {
        binding?.let {
            it.btCreateProject.setOnClickListener {_ ->

                val latitude = it.tvLatitude.text.toString().toDouble()
                val longitude = it.tvLongitude.text.toString().toDouble()

                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(
                    latitude,
                    longitude,
                    2
                )

                val city = try{
                    addresses.get(0).getAddressLine(0)
                } catch (exception: IndexOutOfBoundsException){
                    "Unknown"
                }

                val project = Project(
                    title = it.tietProjectName.editableText.toString(),
                    description = it.tietProjectDescription.editableText.toString(),
                    createdDateMillis = System.currentTimeMillis(),
                    thumbnail = String(),
                    featured = it.cbFeaturedProject.isChecked,
                    city = city,
                    images = listOf(),
                    latitude = latitude,
                    longitude = longitude
                )
                viewModel.createProject(project)
            }

        }
    }
}