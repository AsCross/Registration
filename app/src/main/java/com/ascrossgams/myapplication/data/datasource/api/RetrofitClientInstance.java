package com.ascrossgams.myapplication.data.datasource.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static       Retrofit retrofit;
    private static final String   BASE_NEWS_URL = "https://newsapi.org/";
    private static final String   BASE_WEATHER_URL = "http://api.weatherstack.com/";



    public static Retrofit getRetrofitNewsInstance() {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_NEWS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

   public static Retrofit getRetrofitWeatherInstance() {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_WEATHER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

}