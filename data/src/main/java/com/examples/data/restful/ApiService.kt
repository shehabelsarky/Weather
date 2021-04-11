package com.examples.data.restful

import com.examples.entities.weather.remote.RemoteWeather
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Shehab Elsarky
 */
interface ApiService {

    @GET(Config.WEATHER)
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String
    ): RemoteWeather
}