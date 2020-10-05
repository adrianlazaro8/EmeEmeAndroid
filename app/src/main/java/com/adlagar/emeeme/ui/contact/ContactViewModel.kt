package com.adlagar.emeeme.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adlagar.domain.model.Contact
import com.adlagar.usecases.GetContactInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ContactViewModel(
    private val getContactInfo: GetContactInfo
) : ViewModel() {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) getContactInfo()
            return _model
        }

    private fun getContactInfo() = GlobalScope.launch {
        _model.value = UiModel.Loading
        _model.value = UiModel.Content(getContactInfo.invoke())
    }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val contact: Contact) : UiModel()
    }
}