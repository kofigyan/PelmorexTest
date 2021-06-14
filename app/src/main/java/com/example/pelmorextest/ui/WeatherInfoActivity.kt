package com.example.pelmorextest.ui

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.pelmorextest.R
import com.example.pelmorextest.constant.DEFAULT_CITY_POS
import com.example.pelmorextest.databinding.ActivityWeatherInfoBinding
import com.example.pelmorextest.ui.base.BaseActivity
import com.example.pelmorextest.viewmodel.WeatherInfoViewModel

class WeatherInfoActivity: BaseActivity<WeatherInfoViewModel, ActivityWeatherInfoBinding>() {


    override val layoutId: Int
        get() = R.layout.activity_weather_info

    override val viewModelClass: Class<WeatherInfoViewModel>
        get() = WeatherInfoViewModel::class.java


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewmodel = viewModel


        val citiesCodes = resources.getStringArray(R.array.cities_code_array);

        ArrayAdapter.createFromResource(
            this,
            R.array.cities_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerCities.adapter = adapter
        }


        binding.spinnerCities.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val cityCode = citiesCodes[position]
                viewModel.loadWeatherInformation(cityCode)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        viewModel.loadWeatherInformation(citiesCodes[DEFAULT_CITY_POS])

    }
}