package com.adlagar.emeeme.ui.screens.createproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.BottomSheetMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SelectLocationBottomSheet(private val location: (LatLng) -> Unit): BottomSheetDialogFragment() {

    var binding : BottomSheetMapBinding? = null

    private lateinit var googleMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetMapBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment
        mapFragment.getMapAsync { map ->
            googleMap = map
        }

        binding?.btAccept?.setOnClickListener {
            location.invoke(googleMap.cameraPosition.target)
            dismiss()
        }

        binding?.btCancel?.setOnClickListener {
            dismiss()
        }
    }
}