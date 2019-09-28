package com.ascrossgams.myapplication.ui.entrance.Registration;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ascrossgams.myapplication.data.Repository;
import com.ascrossgams.myapplication.data.models.User;

public class ViewModelRegistrationTwo extends ViewModel {
    private MutableLiveData<String> mText;
    private Context context;

    public ViewModelRegistrationTwo() {
        mText = new MutableLiveData<>();
        mText.setValue("Сontinued registration");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void proceedRegistration(User user) {
        Repository.getInstance().updateUser(user, getContext());
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
