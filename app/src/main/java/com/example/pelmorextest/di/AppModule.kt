package com.example.pelmorextest.di

import android.app.Application
import android.content.Context
import com.example.pelmorextest.api.WeatherService
import com.example.pelmorextest.constant.BASE_URL
import com.example.pelmorextest.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {



    @Provides
    fun provideContext(application: Application): Context = application.applicationContext



    @Singleton
    @Provides
    fun provideWeatherService(): WeatherService {
        return Retrofit.Builder()
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(WeatherService::class.java)
    }


}