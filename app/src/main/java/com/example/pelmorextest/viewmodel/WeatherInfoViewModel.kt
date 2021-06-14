package com.example.pelmorextest.viewmodel

import com.example.pelmorextest.repository.WeatherInfoRepository
import com.example.pelmorextest.viewmodel.base.BaseViewModel
import javax.inject.Inject

class WeatherInfoViewModel @Inject constructor(
    private val weatherInfoRepository: WeatherInfoRepository) : BaseViewModel() {


   // private val weatherInfoRepository: WeatherInfoRepository = WeatherInfoRepository()
    val weatherInfo = weatherInfoRepository.result


    fun loadWeatherInformation(cityCode: String) {
        weatherInfoRepository.fetchFromNetwork(cityCode)
    }


}