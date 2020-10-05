package com.adlagar.emeeme.ui.contact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.adlagar.domain.model.Contact
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.FragmentContactBinding
import com.adlagar.emeeme.ui.MainActivity
import com.adlagar.emeeme.ui.extensions.getViewModelFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng


class ContactFragment : Fragment() {

    private lateinit var mapFragment: SupportMapFragment

    private var binding: FragmentContactBinding? = null

    private val viewModel: ContactViewModel by viewModels {
        getViewModelFactory { (activity as MainActivity).applicationComponent.contactViewModel }
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
        viewModel.model.observe(viewLifecycleOwner, Observer(::updateUI))
        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    }

    private fun updateUI(uiModel: ContactViewModel.UiModel) {
        when (uiModel) {
            is ContactViewModel.UiModel.Loading -> Log.d("", "")
            is ContactViewModel.UiModel.Content -> showContactInfo(uiModel.contact)
        }
    }

    private fun showContactInfo(contact: Contact) {
        val contactPosition = LatLng(
            contact.latitude.toDouble(),
            contact.longitude.toDouble()
        )
        val cameraPosition = CameraPosition.Builder()
            .target(contactPosition)
            .zoom(20f)
            .build()
        mapFragment.getMapAsync {
            it.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }
    }

    companion object {
        fun newInstance() = ContactFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}