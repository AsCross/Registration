package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RetroWeather {
    @SerializedName("observation_time")
    private List<RetroCurrent> retroCurrent;
    private List<RetroLocation> retroLocation;

    public RetroWeather(List<RetroCurrent> retroCurrent, List<RetroLocation> retroLocation) {
        this.retroCurrent = retroCurrent;
        this.retroLocation = retroLocation;
    }

    public RetroWeather(List<RetroCurrent> retroCurrent) {
        this.retroCurrent = retroCurrent;
    }

    public List<RetroCurrent> getRetroCurrent() {
        return retroCurrent;
    }

    public List<RetroLocation> getRetroLocation() {
        return retroLocation;
    }
}
