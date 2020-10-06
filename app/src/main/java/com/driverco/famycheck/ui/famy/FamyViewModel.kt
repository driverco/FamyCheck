package com.driverco.famycheck.ui.famy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FamyViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Famy Fragment"
    }
    val text: LiveData<String> = _text
}