package com.example.kotlin.myapplication

import retrofit2.http.GET
import retrofit2.http.Header

interface CovidApiService {
    @GET("v1/covid")
    suspend fun getCovidData(@Header("X-API-KEY") apiKey: String): List<CovidData>
}
