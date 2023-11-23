package com.example.kotlin.myapplication

import com.example.kotlin.myapplication.CovidData

data class CovidData(
    val country: String,
    val cases: Int,
    val deaths: Int,
    val recovered: Int
)