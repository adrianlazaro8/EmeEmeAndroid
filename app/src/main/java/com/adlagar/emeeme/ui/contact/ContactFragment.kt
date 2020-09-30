package com.adlagar.emeeme.ui.contact

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.FragmentContactBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.about.AboutUsViewModel
import com.adlagar.emeeme.ui.extensions.getViewModelFactory

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class ContactFragment : Fragment() {

    private var binding: FragmentContactBinding? = null

    private val viewModel: ContactViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.contactViewModel }
    }

    private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContactBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    companion object {
        fun newInstance() = ContactFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}