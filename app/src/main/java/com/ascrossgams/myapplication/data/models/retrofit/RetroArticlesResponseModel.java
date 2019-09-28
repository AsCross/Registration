package com.ascrossgams.myapplication.data.models.retrofit;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RetroArticlesResponseModel {
    @SerializedName("status")
    private String             status;

    @SerializedName("totalResults")
    private String             totalResults;

    @SerializedName("articles")
    private List<RetroArticle> articles;

    public RetroArticlesResponseModel(String status, String totalResults, List<RetroArticle> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public List<RetroArticle> getArticles() {
        return articles;
    }
}
