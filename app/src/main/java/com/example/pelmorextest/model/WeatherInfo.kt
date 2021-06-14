package com.example.pelmorextest.model

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("placecode") val placeCode: String,
    @SerializedName("updatetime") val updateTime: String,
    @SerializedName("wxcondition") val condition: String,
    @SerializedName("temperature") val temperature: String,
    @SerializedName("feels_like") val feelsLike: String,
    @SerializedName("temperature_unit") val temperatureUnit: String,
    @SerializedName("icon") val icon: String
)