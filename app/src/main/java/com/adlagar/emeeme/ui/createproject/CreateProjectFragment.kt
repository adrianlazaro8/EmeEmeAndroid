package com.adlagar.emeeme.ui.createproject

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.adlagar.domain.model.Project
import com.adlagar.emeeme.R
import com.adlagar.emeeme.contact.GoogleMapUiSettingsCustomizer
import com.adlagar.emeeme.data.ImageSelector
import com.adlagar.emeeme.databinding.FragmentCreateProjectBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory
import com.adlagar.emeeme.ui.extensions.loadImage
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import java.util.*

class CreateProjectFragment : Fragment() {

    private var binding: FragmentCreateProjectBinding? = null

    private lateinit var mapFragment: SupportMapFragment

    private val viewModel: CreateProjectViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.createProjectViewModel }
    }

    private val imageSelector: ImageSelector by lazy {
        ImageSelector(requireContext(), this)
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

        mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment
        binding?.let {
            mapFragment.getMapAsync { map ->
                map.moveCamera(
                    CameraUpdateFactory.newLatLngZoom(
                        LatLng(
                            DEFAULT_LATITUDE,
                            DEFAULT_LONGITUDE
                        ), 8F
                    )
                )
                GoogleMapUiSettingsCustomizer(
                    map
                )

                map.setOnMapClickListener { _ ->
                    showBottomSheetToSelectLocation(it)
                }
            }
        }

        binding?.ivImagePicker?.setOnClickListener {

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

    private fun takePhoto() {
        imageSelector.selectImage()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        imageSelector.handleResult(requestCode, resultCode, data){
            binding?.ivImagePicker?.loadImage(it?.absolutePath.toString())
        }

    }

    private fun showBottomSheetToSelectLocation(binding: FragmentCreateProjectBinding) {
        val selectLocationBottomSheet = SelectLocationBottomSheet { latLng ->
            binding.let {
                it.tvLatitude.text = getString(R.string.latitude) + " " + latLng.latitude.toString()
                it.tvLongitude.text =
                    getString(R.string.longitude) + " " + latLng.longitude.toString()
            }
        }
        selectLocationBottomSheet.isCancelable = false
        selectLocationBottomSheet.show(childFragmentManager, "location_sheet")
    }


    private fun createProjectButton() {
        binding?.let {
            it.btCreateProject.setOnClickListener { _ ->

                val latitude = it.tvLatitude.text.toString().toDouble()
                val longitude = it.tvLongitude.text.toString().toDouble()

                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(
                    latitude,
                    longitude,
                    2
                )

                val city = try {
                    addresses[0].subAdminArea
                } catch (exception: IndexOutOfBoundsException) {
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



    companion object {
        private const val DEFAULT_LATITUDE = 39.46975
        private const val DEFAULT_LONGITUDE = -0.37739
    }
}