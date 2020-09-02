package com.adlagar.emeeme.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.adlagar.emeeme.R
import com.adlagar.emeeme.ui.about.AboutUsFragment
import com.adlagar.emeeme.ui.contact.ContactFragment
import com.adlagar.emeeme.ui.portfolio.PortfolioFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
    }
}