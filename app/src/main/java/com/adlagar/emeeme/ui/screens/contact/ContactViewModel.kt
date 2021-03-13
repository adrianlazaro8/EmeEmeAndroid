package com.adlagar.emeeme.ui.screens.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adlagar.domain.model.Contact
import com.adlagar.usecases.GetContactInfo
import com.adlagar.usecases.ModifyContactInfo
import kotlinx.coroutines.launch

class ContactViewModel(
    private val getContactInfo: GetContactInfo,
    private val modifyContactInfo: ModifyContactInfo
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) getContactInfo()
            return _model
        }

    private fun getContactInfo() = viewModelScope.launch {
        _model.value = UiModel.Loading
        _model.value = UiModel.Content(getContactInfo.invoke())
    }

    fun updateContactInfo(contact: Contact) = viewModelScope.launch {
        _model.value = UiModel.Loading
        _model.value = UiModel.Updated(modifyContactInfo.invoke(contact))
    }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val contact: Contact) : UiModel()
        class Updated(val sucess: Boolean) : UiModel()
    }
}