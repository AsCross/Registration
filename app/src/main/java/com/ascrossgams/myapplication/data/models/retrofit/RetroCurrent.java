package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroCurrent {
    @SerializedName("observation_time")
    private String observationTime;

    @SerializedName("temperature")
    private String temperature;

    @SerializedName("weather_code")
    private String weatherСode;

    @SerializedName("weather_icons")
    private String[] weatherIcons;

    @SerializedName("weather_descriptions")
    private String[] weatherDescriptions;

    @SerializedName("wind_speed")
    private String windSpeed;

    @SerializedName("wind_degree")
    private String windDegree;

    @SerializedName("wind_dir")
    private String windDir;

    @SerializedName("pressure")
    private String pressure;

    @SerializedName("precip")
    private String precip;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("cloudcover")
    private String cloudcover;

    @SerializedName("feelslike")
    private String feelslike;

    @SerializedName("uv_index")
    private String uvIndex;

    @SerializedName("visibility")
    private String visibility;

    @SerializedName("is_day")
    private boolean isDay;

    public RetroCurrent(String observationTime, String temperature, String weatherСode, String[] weatherIcons,
                        String[] weatherDescriptions, String windSpeed, String windDegree, String windDir,
                        String pressure, String precip, String humidity, String cloudcover, String feelslike, String uvIndex,
                        String visibility, boolean isDay) {
        this.observationTime = observationTime;
        this.temperature = temperature;
        this.weatherСode = weatherСode;
        this.weatherIcons = weatherIcons;
        this.weatherDescriptions = weatherDescriptions;
        this.windSpeed = windSpeed;
        this.windDegree = windDegree;
        this.windDir = windDir;
        this.pressure = pressure;
        this.precip = precip;
        this.humidity = humidity;
        this.cloudcover = cloudcover;
        this.feelslike = feelslike;
        this.uvIndex = uvIndex;
        this.visibility = visibility;
    }

    public String getObservationTime() {
        return observationTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeather_code() {
        return weatherСode;
    }

    public String[] getWeatherIcons() {
        return weatherIcons;
    }

    public String[] getWeatherDescriptions() {
        return weatherDescriptions;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindDegree() {
        return windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public String getPressure() {
        return pressure;
    }

    public String getPrecip() {
        return precip;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public String getFeelslike() {
        return feelslike;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public String getVisibility() {
        return visibility;
    }
}
