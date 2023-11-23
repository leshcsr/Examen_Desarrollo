package com.example.kotlin.myapplication

import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Interfaz que define las operaciones disponibles en el servicio web para obtener datos de COVID.
 */
interface CovidApiService {

    /**
     * Método para obtener datos de COVID.
     *
     * @param apiKey Clave de la API para autenticación.
     * @return Lista de objetos [CovidData] que representan los datos de COVID.
     */
    @GET("v1/covid")
    suspend fun getCovidData(@Header("X-API-KEY") apiKey: String): List<CovidData>
}
