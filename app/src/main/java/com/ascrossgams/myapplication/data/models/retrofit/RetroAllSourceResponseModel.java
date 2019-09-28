package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RetroAllSourceResponseModel {
    @SerializedName("status")
    private String             status;

    @SerializedName("sources")
    private List<RetroSources> sources;


    public RetroAllSourceResponseModel(String status, List<RetroSources> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public List<RetroSources> getSources() {
        return sources;
    }
}
