package com.examples.data.repository

import com.examples.entities.city.local.City
import com.examples.entities.city.remote.RemoteCity
import com.examples.entities.weather.remote.RemoteWeather

/**
 * Created by Shehab Elsarky
 */
interface AppRepository{

    suspend fun getWeatherByCityName(
        cityName: String
    ): RemoteWeather

    suspend fun getCities(): List<RemoteCity>

    suspend fun insertCity(city: City)
    suspend fun selectAllCities(): MutableList<City>
}