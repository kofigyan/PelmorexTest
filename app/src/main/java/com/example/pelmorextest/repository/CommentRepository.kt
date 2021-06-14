package com.example.pelmorextest.repository

import com.example.pelmorextest.api.WeatherService
import javax.inject.Inject

class CommentRepository@Inject constructor(private val apiService: WeatherService) {


}