package com.example.myapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
private val retrofit by lazy { Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/").addConverterFactory(
    GsonConverterFactory.create()).build() }

    val api by lazy {
        retrofit.create(CountryApi::class.java)
    }
}