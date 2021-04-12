package com.example.weather.ui.fragment

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.examples.core.base.view_model.BaseViewModel
import com.examples.domain.usecases.cities.CitiesUseCase
import com.examples.domain.usecases.cities.DropCitiesUseCase
import com.examples.domain.usecases.cities.InsertCityUseCase
import com.examples.domain.usecases.cities.SelectCitiesUseCase
import com.examples.domain.usecases.weather.WeatherUseCase
import com.examples.entities.city.local.City
import com.examples.entities.weather.local.Weather
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.launch

/**
 * Created by Shehab Elsarky
 */
@FlowPreview
@ExperimentalCoroutinesApi
class HomeViewModel @ViewModelInject constructor(
    private val citiesUseCase: CitiesUseCase,
    private val weatherUseCase: WeatherUseCase,
    private val insertCityUseCase: InsertCityUseCase,
    private val selectCitiesUseCase: SelectCitiesUseCase,
    private val dropCitiesUseCase: DropCitiesUseCase
) : BaseViewModel() {
    private val TAG = HomeViewModel::class.simpleName


    val weatherChannel: ConflatedBroadcastChannel<List<Weather>> by lazy {
        ConflatedBroadcastChannel<List<Weather>>()
    }

    fun getWeather(cityName: String) {
        weatherUseCase.execute(cityName) {
            onComplete {
                viewModelScope.launch {
                    weatherChannel.offer(it)
                }
            }
            onError(::setErrorReason)
            onCancel(::setCancellationReason)
            isLoading(::setLoading)
        }
    }

    val citiesChannel: ConflatedBroadcastChannel<List<City>> by lazy {
        ConflatedBroadcastChannel<List<City>>()
    }

    fun getCities() {
        callApi(citiesChannel) { callBack ->
            citiesUseCase.execute(Unit) {
                onComplete {
                    viewModelScope.launch {
                        citiesChannel.offer(it)
                        dropCities()
                        it.map(::insertCity)
                    }
                }
                onError(::setErrorReason)
                onCancel(::setCancellationReason)
                isLoading(::setLoading)
            }
        }
    }

    fun addCity(citiesList: ArrayList<City>,cityName: String,index: Int){
        citiesUseCase.addCity(
            citiesList,
            cityName,
            index
        )
    }

    private fun insertCity(city: City) {
        viewModelScope.launch {
            insertCityUseCase.execute(city) {
                onComplete {
                    Log.d(TAG, "Inserting...Id= ${city.id} name= ${city.cityName}")
                }
                onCancel {
                    Log.d(TAG, "Insert exception occurred...")
                }
            }
        }
    }

    fun selectCities() {
        viewModelScope.launch {
            selectCitiesUseCase.execute(Unit) {
                onComplete {
                    it.map {
                        Log.d(TAG, "Selected data...id:${it.id} name:${it.cityName}")
                    }
                    viewModelScope.launch {
                        citiesChannel.offer(it)
                    }
                }
                onCancel {
                    Log.d(TAG, "Coroutine is cancelled")
                }
            }
        }
    }

    private fun dropCities() {
        viewModelScope.launch {
            dropCitiesUseCase.execute(Unit) {
                onComplete {
                    Log.d(TAG, "cities table is nuked")
                    // TODO() if you want to drop table then insert call insert method here
                }
                onCancel {
                    Log.d(TAG, "Coroutine is cancelled")
                }
            }
        }
    }
}