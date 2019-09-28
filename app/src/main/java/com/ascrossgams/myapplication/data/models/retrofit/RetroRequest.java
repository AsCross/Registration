package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroRequest {
    @SerializedName("type")
    private String type;

    @SerializedName("query")
    private String query;

    @SerializedName("language")
    private String language;

    @SerializedName("unit")
    private String unit;

    public RetroRequest(String type, String query, String language, String unit) {
        this.type = type;
        this.query = query;
        this.language = language;
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }

    public String getLanguage() {
        return language;
    }

    public String getUnit() {
        return unit;
    }
}
