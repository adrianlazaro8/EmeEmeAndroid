package com.adlagar.emeeme.ui.screens.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.AboutUs
import com.adlagar.usecases.GetAboutUsInfo
import com.adlagar.usecases.ModifyAboutUsInfo
import kotlinx.coroutines.launch
import java.io.File

class AboutUsViewModel(
    private val getAboutUsInfo: GetAboutUsInfo,
    private val modifyAboutUsInfo: ModifyAboutUsInfo
) : ViewModel() {

    private val _aboutUs = MutableLiveData<UiState>()
    val aboutUs: LiveData<UiState>
        get() {
            if (_aboutUs.value == null) getAboutCompany()
            return _aboutUs
        }

    private fun getAboutCompany() = viewModelScope.launch {
        _aboutUs.value = UiState.Loading
        _aboutUs.value = UiState.AboutUsInfo(getAboutUsInfo.invoke())
    }

    fun modifyAboutCompany(file: File, text: String) = viewModelScope.launch {
        _aboutUs.value = UiState.Loading
        val updated = modifyAboutUsInfo.invoke(file, text)
        if (!updated) {
            _aboutUs.value = UiState.Error
        } else {
            _aboutUs.value = UiState.AboutUsInfo(getAboutUsInfo.invoke())
        }
    }

    sealed class UiState {
        object Loading : UiState()
        object Error : UiState()
        class AboutUsInfo(val aboutUs: AboutUs) : UiState()
    }

}