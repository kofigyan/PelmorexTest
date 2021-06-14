package com.example.pelmorextest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.pelmorextest.api.*
import com.example.pelmorextest.constant.EMPTY_NETWORK_RESPONSE_MESSAGE
import com.example.pelmorextest.constant.ERROR_NETWORK_RESPONSE_MESSAGE
import com.example.pelmorextest.model.Resource
import com.example.pelmorextest.model.WeatherInfo
import javax.inject.Inject

class WeatherInfoRepository @Inject constructor(private val apiService: WeatherService) {

    private var _result = MediatorLiveData<Resource<WeatherInfo>>()

    val result: LiveData<Resource<WeatherInfo>>
        get() = _result

    private fun setValue(newValue: Resource<WeatherInfo>) {
        if (_result.value != newValue) {
            _result.value = newValue
        }
    }

    fun fetchFromNetwork(cityCode: String) {

        _result.value = Resource.loading(null)

        val apiResponse = apiService.getWeatherInfo(cityCode)

        _result.addSource(apiResponse) { response: ApiResponse<WeatherInfo> ->

            when (response) {

                is ApiSuccessResponse -> setValue(Resource.success(response.body))

                is ApiEmptyResponse -> setValue(
                    Resource.error(
                        EMPTY_NETWORK_RESPONSE_MESSAGE,
                        null
                    )
                )

                is ApiErrorResponse -> setValue(
                    Resource.error(
                        ERROR_NETWORK_RESPONSE_MESSAGE,
                        null
                    )
                )
            }

        }
    }

}