package com.example.pelmorextest.di

import com.example.pelmorextest.ui.CommentActivity
import com.example.pelmorextest.ui.MainActivity
import com.example.pelmorextest.ui.PhotoActivity
import com.example.pelmorextest.ui.WeatherInfoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeCommentActivity(): CommentActivity

    @ContributesAndroidInjector
    abstract fun contributePhotoActivity(): PhotoActivity


    @ContributesAndroidInjector
    abstract fun contributeWeatherInfoActivity(): WeatherInfoActivity



}