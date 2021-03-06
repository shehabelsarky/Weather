package com.example.weather.ui.fragment.weather

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.weather.R
import com.example.weather.ui.fragment.HomeViewModel
import com.examples.core.base.fragment.BaseFragment
import com.examples.core.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_layout.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Shehab Elsarky
 */
@ExperimentalCoroutinesApi
@FlowPreview
@AndroidEntryPoint
class WeatherFragment : BaseFragment<HomeViewModel>() {

    override var layoutResourceId: Int = R.layout.fragment_weather
    override val viewModel by viewModels<HomeViewModel>()
    private lateinit var weatherAdapter: WeatherAdapter
    private val args: WeatherFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWeatherList()
        collectWeatherList()
    }

    private fun initWeatherList() {
        weatherAdapter = WeatherAdapter()
        rvList.adapter = weatherAdapter
    }

    private fun collectWeatherList() {
        if (isNetworkConnected)
            lifecycleScope.launch {
                with(viewModel) {
                    getWeather(args.cityName)
                    weatherChannel.asFlow().collect {
                        weatherAdapter.submitList(it)
                    }
                }
            }
        else
            requireContext().showToast("No internet connection")
    }
}