package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroWeatherResponseModel {
    @SerializedName("request")
    private RetroRequest request;

    @SerializedName("location")
    private RetroLocation location;

    @SerializedName("current")
    private RetroCurrent current;


    public RetroWeatherResponseModel(RetroCurrent current) {
        this.current = current;
    }

    public RetroCurrent getCurrent() {
        return current;
    }
}
