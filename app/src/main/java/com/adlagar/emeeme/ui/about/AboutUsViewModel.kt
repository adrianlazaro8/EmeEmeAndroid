package com.adlagar.emeeme.ui.about

import androidx.lifecycle.ViewModel
import com.adlagar.usecases.GetAboutUsInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AboutUsViewModel(
    private val getAboutUsInfo: GetAboutUsInfo
): ViewModel() {

    fun getAboutCompany() = GlobalScope.launch {
        getAboutUsInfo.invoke()
    }

}