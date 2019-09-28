package com.ascrossgams.myapplication.ui.sources;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ascrossgams.myapplication.data.Repository;
import com.ascrossgams.myapplication.data.models.User;
import com.ascrossgams.myapplication.data.models.retrofit.RetroAllSourceResponseModel;
import com.ascrossgams.myapplication.data.models.retrofit.RetroSources;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SourcesViewModel extends ViewModel {

    private MutableLiveData<List<RetroSources>> sourcesLiveData;
    private MutableLiveData<Throwable> errorsLiveData;
    private Context context;

    public SourcesViewModel() {
        sourcesLiveData = new MutableLiveData<>();
        errorsLiveData = new MutableLiveData<>();
    }


    public MutableLiveData<List<RetroSources>> getSourcesLiveData() {
        return sourcesLiveData;
    }

    public MutableLiveData<Throwable> getErrorsLiveData() {
        return errorsLiveData;
    }

    public void loadSources() {

        Repository.getInstance().getAllSources(new Callback<RetroAllSourceResponseModel>() {
            @Override
            public void onResponse(Call<RetroAllSourceResponseModel> call, Response<RetroAllSourceResponseModel> response) {
                sourcesLiveData.postValue(response.body().getSources());
            }

            @Override
            public void onFailure(Call<RetroAllSourceResponseModel> call, Throwable t) {
                errorsLiveData.postValue(t);
            }
        });
    }


    public void proceedUpdateSave(User user, String mail, String sources) {
        Repository.getInstance().updateUserSource(user, getContext(), mail, sources);

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}