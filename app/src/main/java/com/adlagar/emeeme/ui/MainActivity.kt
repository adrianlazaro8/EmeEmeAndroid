package com.adlagar.emeeme.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.portfolio -> {
                    openFragment(PortfolioFragment.newInstance())
                    true
                }
                R.id.about_us -> {
                    openFragment(AboutUsFragment.newInstance())
                    true
                }
                R.id.contact -> {
                    openFragment(ContactFragment.newInstance())
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.navHostFragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}