package com.example.pelmorextest.api

import androidx.lifecycle.LiveData
import com.example.pelmorextest.model.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("{CITY_CODE}/c")
    fun getWeatherInfo(@Path("CITY_CODE") cityCode: String): LiveData<ApiResponse<WeatherInfo>>


}