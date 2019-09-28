package com.ascrossgams.myapplication.ui.weather;

import com.ascrossgams.myapplication.data.Repository;
import com.ascrossgams.myapplication.data.models.retrofit.RetroWeatherResponseModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends ViewModel {

    private MutableLiveData<RetroWeatherResponseModel> weatherLiveData;
    private MutableLiveData<Throwable> errorsLiveData;

    public WeatherViewModel() {
        weatherLiveData = new MutableLiveData<>();
        errorsLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<RetroWeatherResponseModel> getWeatherLiveData() {
        return weatherLiveData;
    }

    public MutableLiveData<Throwable> getErrorsLiveData() {
        return errorsLiveData;
    }

    public void loadWeather(String city) {
        Repository.getInstance().getWeather(new Callback<RetroWeatherResponseModel>() {
            @Override
            public void onResponse(Call<RetroWeatherResponseModel> call, Response<RetroWeatherResponseModel> response) {
                weatherLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<RetroWeatherResponseModel> call, Throwable t) {
                errorsLiveData.postValue(t);
            }
        }, city);
    }
}