package com.example.teste.ui.ingresso
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IngressoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is ingresso Fragment"
    }
    val text: LiveData<String> = _text
}