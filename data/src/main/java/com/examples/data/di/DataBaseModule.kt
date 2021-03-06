package com.examples.data.di

import android.app.Application
import androidx.room.Room
import com.examples.data.source.db.AppCitiesDatabase
import com.examples.data.source.db.CitiesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Shehab Elsarky
 */
@Module
@InstallIn(ApplicationComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideRoomCitiesDatabase(application: Application): AppCitiesDatabase {
        return Room
            .databaseBuilder(application, AppCitiesDatabase::class.java, AppCitiesDatabase.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCityDao(appDataBase: AppCitiesDatabase): CitiesDao {
        return appDataBase.citiesDao()
    }
}