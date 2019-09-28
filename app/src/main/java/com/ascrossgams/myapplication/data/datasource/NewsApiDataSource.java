package com.ascrossgams.myapplication.data.datasource;

import com.ascrossgams.myapplication.data.datasource.api.NewsApi;
import com.ascrossgams.myapplication.data.datasource.api.RetrofitClientInstance;
import com.ascrossgams.myapplication.data.models.retrofit.RetroAllSourceResponseModel;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticlesResponseModel;

import retrofit2.Call;
import retrofit2.Callback;

public class NewsApiDataSource {

    private static NewsApiDataSource INSTANCE;
    NewsApi service;

    public static NewsApiDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NewsApiDataSource();
        }

        return INSTANCE;
    }

    public NewsApiDataSource() {
        service = RetrofitClientInstance.getRetrofitNewsInstance().create(NewsApi.class);
    }

    public void getTopHeadlines(Callback<RetroArticlesResponseModel> callback) {
        Call<RetroArticlesResponseModel> call = service.getTopHeadlines();
        call.enqueue(callback);
    }

    public void getEverything(int page, String sources, Callback<RetroArticlesResponseModel> callback) {
        Call<RetroArticlesResponseModel> call = service.getEverything(page, sources);
        call.enqueue(callback);
    }

    public void getSources(Callback<RetroAllSourceResponseModel> callback) {
        Call<RetroAllSourceResponseModel> call = service.getSources();
        call.enqueue(callback);
    }

}
