package com.adlagar.emeeme.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.adlagar.emeeme.R
import com.adlagar.emeeme.databinding.ActivityMainBinding
import com.adlagar.emeeme.di.DaggerEmeEmeApplicationComponent
import com.adlagar.emeeme.di.EmeEmeApplicationComponent

class MainActivity : AppCompatActivity() {

    lateinit var applicationComponent: EmeEmeApplicationComponent

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        applicationComponent = DaggerEmeEmeApplicationComponent
            .factory()
            .create(application)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)
    }
}