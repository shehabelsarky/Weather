package com.examples.data.repository

import com.examples.data.source.cloud.BaseCloudRepository
import com.examples.data.source.db.AppCitiesDatabase
import com.examples.data.source.local.MockJson
import com.examples.entities.city.local.City
import com.examples.entities.city.remote.RemoteCity
import com.examples.entities.weather.remote.RemoteWeather
import javax.inject.Inject

/**
 * Created by Shehab Elsarky
 */
class AppRepoImp @Inject constructor(
    private val cloudRepository: BaseCloudRepository,
    private val citiesDatabase: AppCitiesDatabase,
    private val mockJson: MockJson

) : AppRepository {

    override suspend fun getWeatherByCityName(cityName: String): RemoteWeather {
        return cloudRepository.getWeatherByCityName(cityName)
    }

    override suspend fun getCities(): List<RemoteCity> {
        return mockJson.getCityList()
    }

    override suspend fun insertCity(city: City) {
        return citiesDatabase.citiesDao().insertCity(city)
    }

    override suspend fun selectAllCities(): MutableList<City> {
        return citiesDatabase.citiesDao().selectAllCities()
    }

    override suspend fun deleteCitiesTable() {
        return citiesDatabase.citiesDao().deleteCitiesTable()
    }
}