package com.example.ggweather;



import com.example.ggweather.model.WeatherData;
import com.example.ggweather.model.WeatherForecastData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Weather
{

    @GET("data/2.5/weather?")
    Call<WeatherData> getCurrentWeatherData(@Query("id") String id, @Query("appid") String app_id);

    @GET("data/2.5/forecast?")
    Call<WeatherForecastData> getCurrentForecastData(@Query("id") String id, @Query("appid") String app_id);

}


/*

IopenweatherMap = Weather
Weather result = retro
WeatherForecastResult = CityCountry.



*/

