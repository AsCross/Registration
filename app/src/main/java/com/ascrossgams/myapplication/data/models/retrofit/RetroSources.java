package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroSources {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String      name;
    @SerializedName("description")
    private String      description;
    @SerializedName("url")
    private String      url;
    @SerializedName("category")
    private String      category;
    @SerializedName("language")
    private String      language;
    @SerializedName("country")
    private String      country;

    public RetroSources(String id, String name, String description, String url, String category, String language, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }
}
