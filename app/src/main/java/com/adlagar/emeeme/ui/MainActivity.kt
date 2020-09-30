package com.adlagar.emeeme.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.adlagar.emeeme.R
import com.adlagar.emeeme.di.DaggerEmeEmeApplicationComponent
import com.adlagar.emeeme.di.EmeEmeApplicationComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var applicationComponent: EmeEmeApplicationComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        applicationComponent = DaggerEmeEmeApplicationComponent
            .factory()
            .create(application)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
    }
}