package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroWeatherDescriptions {
    @SerializedName("Sunny")
    private String sunny;

    public RetroWeatherDescriptions(String sunny) {
        this.sunny = sunny;
    }

    public String getSunny() {
        return sunny;
    }
}
