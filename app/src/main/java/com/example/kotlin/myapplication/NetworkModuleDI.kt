package com.example.kotlin.myapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.kotlin.myapplication.Constants
object NetworkModuleDI {

    private val gsonFactory: GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    operator fun invoke(): CovidApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(CovidApiService::class.java)
    }

    fun provideCovidApiService(): CovidApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.ninja/") // Ajusta la URL base según tu API
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(CovidApiService::class.java)
    }

}