package com.example.devmobb.ui.compost

import Compost
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompostViewModel : ViewModel() {

    private val _composts = MutableLiveData<List<Compost>>().apply {
        value = ArrayList()
    }
    val composts: MutableLiveData<List<Compost>> = _composts
}