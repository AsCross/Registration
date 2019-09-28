package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroSource {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;

    public RetroSource(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
