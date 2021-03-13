package com.adlagar.emeeme.ui.screens.contact

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.adlagar.domain.model.Contact
import com.adlagar.domain.model.ContactPerson
import com.adlagar.emeeme.R
import com.adlagar.emeeme.contact.GoogleMapUiSettingsCustomizer
import com.adlagar.emeeme.databinding.FragmentContactBinding
import com.adlagar.emeeme.ui.screens.MainActivity
import com.adlagar.emeeme.ui.common.extensions.getViewModelFactory
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng


class ContactFragment : Fragment() {

    private lateinit var googleMap: GoogleMap

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
        mapFragment.getMapAsync {
            googleMap = it
            GoogleMapUiSettingsCustomizer(
                googleMap
            )
        }
        saveButton()
    }

    private fun saveButton() {
        binding?.let { binding ->
            binding.btContactSave.setOnClickListener {
                val contact: Contact = createContactFromData(binding)
                viewModel.updateContactInfo(contact)
            }
        }
    }

    private fun createContactFromData(binding: FragmentContactBinding): Contact {
        val contact = Contact()
        contact.name = binding.etContactTitle.text.toString()
        contact.latitude = googleMap.cameraPosition.target.latitude
        contact.longitude = googleMap.cameraPosition.target.longitude
        contact.contactPerson = mutableListOf(
            ContactPerson(
                binding.etContactPersonName.text.toString(),
                binding.etContactPersonSurname.text.toString(),
                binding.etContactPersonTelephone.text.toString()
            )
        )
        return contact
    }

    private fun updateUI(uiModel: ContactViewModel.UiModel) {
        when (uiModel) {
            is ContactViewModel.UiModel.Loading -> Log.d("", "")
            is ContactViewModel.UiModel.Content -> showContactInfo(uiModel.contact)
        }
    }

    private fun showContactInfo(contact: Contact) {
        val contactPosition = LatLng(
            contact.latitude,
            contact.longitude
        )
        val cameraPosition = CameraPosition.Builder()
            .target(contactPosition)
            .zoom(17f)
            .build()

        mapFragment.getMapAsync {
            it.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        }

        binding?.let {
            it.etContactTitle.setText(contact.name)
            it.etContactPersonName.setText(contact.contactPerson[0].name)
            it.etContactPersonSurname.setText(contact.contactPerson[0].surname)
            it.etContactPersonTelephone.setText(contact.contactPerson[0].telephone)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}