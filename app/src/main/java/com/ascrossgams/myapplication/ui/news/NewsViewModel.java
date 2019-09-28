package com.ascrossgams.myapplication.ui.news;

import com.ascrossgams.myapplication.data.Repository;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticle;
import com.ascrossgams.myapplication.data.models.retrofit.RetroArticlesResponseModel;

import java.io.IOException;
import java.util.List;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<List<RetroArticle>> articlesLiveData;
    private MutableLiveData<Throwable> errorsLiveData;

    public NewsViewModel() {
        articlesLiveData = new MutableLiveData<>();
        errorsLiveData = new MutableLiveData<>();
    }


    public MutableLiveData<List<RetroArticle>> getArticlesLiveData() {
        return articlesLiveData;
    }

    public MutableLiveData<Throwable> getErrorsLiveData() {
        return errorsLiveData;
    }

    public void loadArticles(int page, String sources) {

        Repository.getInstance().getAllArticles(page, sources, new Callback<RetroArticlesResponseModel>() {
            @Override
            public void onResponse(Call<RetroArticlesResponseModel> call, Response<RetroArticlesResponseModel> response) {
                if (response.body() != null) {
                    articlesLiveData.postValue(response.body().getArticles());
                } else {
                    try {
                        errorsLiveData.postValue(new Throwable(response.errorBody().string()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RetroArticlesResponseModel> call, Throwable t) {
                errorsLiveData.postValue(t);
            }
        });
    }


}