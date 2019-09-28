package com.ascrossgams.myapplication.data.datasource.api;

import com.ascrossgams.myapplication.data.models.retrofit.RetroAllSourceResponseModel;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticlesResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    //String API_KEY = "4424dfd5ff494cf4b0c9336a5c573f0e";
    String API_KEY = "37c29930ba10435eb5498941f6e0a551";

    @GET("v2/top-headlines?q=bitcoin&apiKey=" + API_KEY)
    Call<RetroArticlesResponseModel> getTopHeadlines();

    @GET("v2/sources?apiKey=" + API_KEY)
    Call<RetroArticlesResponseModel> getTopSource();

    @GET("v2/everything?sortBy=popularity&apiKey=" + API_KEY)
    Call<RetroArticlesResponseModel> getEverything(@Query("page") int page, @Query("domains") String sources);

    @GET("v2/sources?apiKey=" + API_KEY)
    Call<RetroAllSourceResponseModel> getSources();
}