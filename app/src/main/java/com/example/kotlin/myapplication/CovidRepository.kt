package com.example.kotlin.myapplication

class CovidRepository () {
    private lateinit var api:CovidApiService
    suspend fun getCovidData(country:String, region: String):CovidDataResponse? {
        //todo: Inicializar variable api
        return try {
            api.getCovidData(country, region)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }

}