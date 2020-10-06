package com.driverco.famycheck.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TopicViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Topic Fragment"

    }
    val text: LiveData<String> = _text

}