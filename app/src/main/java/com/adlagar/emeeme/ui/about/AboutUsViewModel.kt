package com.adlagar.emeeme.ui.about

import androidx.lifecycle.ViewModel
import com.adlagar.usecases.GetAboutUsInfo
import com.adlagar.usecases.ModifyAboutUsInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AboutUsViewModel(
    private val getAboutUsInfo: GetAboutUsInfo,
    private val modifyAboutUsInfo: ModifyAboutUsInfo
): ViewModel() {

    fun getAboutCompany() = GlobalScope.launch {
        getAboutUsInfo.invoke()
    }

    fun modifyAboutCompany(text: String) = GlobalScope.launch {
        modifyAboutUsInfo.invoke(text)
    }

}