package com.example.myapplication.repository

import com.example.myapplication.data.remote.RetrofitInstance
import com.example.myapplication.model.CountryModel

class Repository {
    suspend fun getCountry():List<CountryModel>{
        return RetrofitInstance.api.getCountry()
    }
}