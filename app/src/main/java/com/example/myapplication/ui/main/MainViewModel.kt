package com.example.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.CountryModel
import com.example.myapplication.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository): ViewModel() {

    val myRespomce:MutableLiveData<List<CountryModel>> = MutableLiveData()

    fun getCountry(){
        viewModelScope.launch {
            val result=repository.getCountry()
            myRespomce.value=result
        }
    }
}