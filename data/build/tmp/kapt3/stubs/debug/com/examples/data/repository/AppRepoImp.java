package com.examples.data.repository;

import java.lang.System;

/**
 * Created by Shehab Elsarky
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/examples/data/repository/AppRepoImp;", "Lcom/examples/data/repository/AppRepository;", "cloudRepository", "Lcom/examples/data/source/cloud/BaseCloudRepository;", "citiesDatabase", "Lcom/examples/data/source/db/AppCitiesDatabase;", "mockJson", "Lcom/examples/data/source/local/MockJson;", "(Lcom/examples/data/source/cloud/BaseCloudRepository;Lcom/examples/data/source/db/AppCitiesDatabase;Lcom/examples/data/source/local/MockJson;)V", "deleteCitiesTable", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCities", "", "Lcom/examples/entities/city/remote/RemoteCity;", "getWeatherByCityName", "Lcom/examples/entities/weather/remote/RemoteWeather;", "cityName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCity", "city", "Lcom/examples/entities/city/local/City;", "(Lcom/examples/entities/city/local/City;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAllCities", "", "data_debug"})
public final class AppRepoImp implements com.examples.data.repository.AppRepository {
    private final com.examples.data.source.cloud.BaseCloudRepository cloudRepository = null;
    private final com.examples.data.source.db.AppCitiesDatabase citiesDatabase = null;
    private final com.examples.data.source.local.MockJson mockJson = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getWeatherByCityName(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.examples.entities.weather.remote.RemoteWeather> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getCities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.examples.entities.city.remote.RemoteCity>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertCity(@org.jetbrains.annotations.NotNull()
    com.examples.entities.city.local.City city, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object selectAllCities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.examples.entities.city.local.City>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteCitiesTable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @javax.inject.Inject()
    public AppRepoImp(@org.jetbrains.annotations.NotNull()
    com.examples.data.source.cloud.BaseCloudRepository cloudRepository, @org.jetbrains.annotations.NotNull()
    com.examples.data.source.db.AppCitiesDatabase citiesDatabase, @org.jetbrains.annotations.NotNull()
    com.examples.data.source.local.MockJson mockJson) {
        super();
    }
}