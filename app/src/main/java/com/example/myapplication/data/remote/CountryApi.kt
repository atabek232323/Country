package com.example.myapplication.data.remote

import com.example.myapplication.model.CountryModel
import retrofit2.http.GET

interface CountryApi {

    @GET("countrydataset.json")
    suspend fun getCountry():List<CountryModel>
}