package com.example.pelmorextest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pelmorextest.viewmodel.CommentViewModel
import com.example.pelmorextest.viewmodel.PhotoViewModel
import com.example.pelmorextest.viewmodel.WeatherInfoViewModel
import com.example.pelmorextest.viewmodel.WeatherInfoViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(WeatherInfoViewModel::class)
    abstract fun bindWeatherInfoViewModel(weatherInfoViewModel: WeatherInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CommentViewModel::class)
    abstract fun bindCommentViewModel(commentViewModel: CommentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PhotoViewModel::class)
    abstract fun bindPhotoViewModel(photoViewModel: PhotoViewModel): ViewModel



    @Binds
    abstract fun bindViewModelFactory(factory: WeatherInfoViewModelFactory): ViewModelProvider.Factory


}