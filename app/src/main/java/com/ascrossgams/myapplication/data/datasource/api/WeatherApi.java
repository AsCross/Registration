package com.ascrossgams.myapplication.data.datasource.api;


import com.ascrossgams.myapplication.data.models.retrofit.RetroWeatherResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    String API_KEY = "a93c65012f3362c5374a5dc7528a8c89";

    @GET("current?access_key=" + API_KEY)
    Call<RetroWeatherResponseModel> getWeatherInfoByCity(@Query("query") String city);
}