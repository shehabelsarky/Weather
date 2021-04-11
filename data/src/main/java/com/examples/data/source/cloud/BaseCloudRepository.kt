package com.examples.data.source.cloud

import com.examples.entities.weather.remote.RemoteWeather

/**
 * Created by Shehab Elsarky
 */
interface BaseCloudRepository {

    suspend fun getWeatherByCityName(
        cityName: String
    ): RemoteWeather
}