package com.examples.data.source.cloud

import com.examples.data.restful.ApiService
import com.examples.entities.weather.remote.RemoteWeather

/**
 * Created by Shehab Elsarky
 */
class CloudRepository(private val apIs: ApiService) : BaseCloudRepository {

    override suspend fun getWeatherByCityName(cityName: String): RemoteWeather {
        return apIs.getWeatherByCityName(cityName)
    }
}
