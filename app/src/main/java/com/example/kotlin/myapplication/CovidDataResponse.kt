package com.example.kotlin.myapplication
import com.google.gson.annotations.SerializedName
data class CovidDataResponse(
    val country: String,
    val region: String,
    val cases: Map<String, CaseData>
)

data class CaseData(
    val total: Int,
    val new: Int
)