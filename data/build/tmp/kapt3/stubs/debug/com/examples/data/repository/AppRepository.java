package com.examples.data.repository;

import java.lang.System;

/**
 * Created by Shehab Elsarky
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/examples/data/repository/AppRepository;", "", "getCities", "", "Lcom/examples/entities/city/remote/RemoteCity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeatherByCityName", "Lcom/examples/entities/weather/remote/RemoteWeather;", "cityName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCity", "", "city", "Lcom/examples/entities/city/local/City;", "(Lcom/examples/entities/city/local/City;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAllCities", "", "data_debug"})
public abstract interface AppRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWeatherByCityName(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.examples.entities.weather.remote.RemoteWeather> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.examples.entities.city.remote.RemoteCity>> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertCity(@org.jetbrains.annotations.NotNull()
    com.examples.entities.city.local.City city, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object selectAllCities(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.examples.entities.city.local.City>> p0);
}