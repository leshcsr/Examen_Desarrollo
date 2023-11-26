package com.example.kotlin.myapplication

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

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
    @GET("v1/covid19")
    suspend fun getCovidData(
        @Query("country") country: String,
        @Query("region") region: String,
        @Header("X-Api-Key") apiKey: String = "wLVPN1zV08lJYF7uXqgyPw==zVwp6TlVcAO1NLUf",
    ): CovidDataResponse

}
