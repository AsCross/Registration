package com.ascrossgams.myapplication.data.datasource;

import com.ascrossgams.myapplication.data.datasource.api.RetrofitClientInstance;
import com.ascrossgams.myapplication.data.datasource.api.WeatherApi;
import com.ascrossgams.myapplication.data.models.retrofit.RetroWeatherResponseModel;

import retrofit2.Call;
import retrofit2.Callback;

public class WeatherApiDataSource {
    private static WeatherApiDataSource INSTANCE;
    WeatherApi service;

    public static WeatherApiDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WeatherApiDataSource();
        }

        return INSTANCE;
    }

    public WeatherApiDataSource() {
        service = RetrofitClientInstance.getRetrofitWeatherInstance().create(WeatherApi.class);
    }

    public void getWheatherInfo(Callback<RetroWeatherResponseModel> callback, String city) {
        Call<RetroWeatherResponseModel> call = service.getWeatherInfoByCity(city);
        call.enqueue(callback);
    }

}
