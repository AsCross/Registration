package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroWeatherIcons {
    @SerializedName("https://assets.weatherstack.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png")
    private String url;

    public RetroWeatherIcons(String sunny) {
        this.url = sunny;
    }

    public String getSunny() {
        return url;
    }
}
