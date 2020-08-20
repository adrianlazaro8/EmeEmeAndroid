package com.adlagar.emeeme.ui

import android.app.Application
import com.adlagar.emeeme.di.DaggerEmeEmeApplicationComponent
import dagger.Component

class EmeEmeApplication: Application() {

    private val appComponent by lazy {
        DaggerEmeEmeApplicationComponent.factory().create(this)
    }

}