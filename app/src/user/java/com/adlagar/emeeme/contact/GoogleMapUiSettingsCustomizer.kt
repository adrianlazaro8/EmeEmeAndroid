package com.adlagar.emeeme.contact

import com.google.android.gms.maps.GoogleMap

class GoogleMapUiSettingsCustomizer(
    private val googleMap: GoogleMap
) {

    init {
        googleMap.uiSettings.setAllGesturesEnabled(false)
    }
}