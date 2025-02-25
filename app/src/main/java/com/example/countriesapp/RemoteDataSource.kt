package com.example.countriesapp

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.converter.gson.GsonConverterFactory



interface RestCountriesAPI {
    @GET("name/{name}")
    suspend fun getCountryByName(@Path("name") cityName: String): List<Country>
}

var retrofit = Retrofit.Builder()
    .baseUrl("https://restcountries.com/v3.1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var restCountriesAPI = retrofit.create(RestCountriesAPI::class.java)