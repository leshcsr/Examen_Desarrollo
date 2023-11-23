package com.example.kotlin.myapplication

/**
 * Data class representing COVID-19 data for a specific country.
 *
 * @property country Name of the country.
 * @property cases Number of COVID-19 cases in the country.
 * @property deaths Number of deaths due to COVID-19 in the country.
 * @property recovered Number of recovered cases in the country.
 */
data class CovidData(
    val country: String,
    val cases: Int,
    val deaths: Int,
    val recovered: Int
)
