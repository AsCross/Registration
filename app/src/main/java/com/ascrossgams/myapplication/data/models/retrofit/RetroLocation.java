package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroLocation {

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("region")
    private String region;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lon")
    private String lon;

    @SerializedName("timezone_id")
    private String timezoneId;

    @SerializedName("localtime")
    private String localtime;

    @SerializedName("localtime_epoch")
    private int localtimeEpoch;

    @SerializedName("utc_offset")
    private String utcOffset;

    public RetroLocation(String name, String country, String region, String lat, String lon, String timezoneId, String localtime, int localtimeEpoch, String utcOffset) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.lat = lat;
        this.lon = lon;
        this.timezoneId = timezoneId;
        this.localtime = localtime;
        this.localtimeEpoch = localtimeEpoch;
        this.utcOffset = utcOffset;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTimezoneId() {
        return timezoneId;
    }

    public String getLocaltime() {
        return localtime;
    }

    public long getLocaltimeEpoch() {
        return localtimeEpoch;
    }

    public String getUtcOffset() {
        return utcOffset;
    }
}
