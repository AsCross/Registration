package com.ascrossgams.myapplication.ui.entrance.Registration;

import android.content.Context;
import com.ascrossgams.myapplication.data.Repository;
import com.ascrossgams.myapplication.data.models.User;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelRegistrationOne extends ViewModel {

    private Context context;

    private MutableLiveData<String> mText;

    public ViewModelRegistrationOne() {
        mText = new MutableLiveData<>();
        mText.setValue("Registration");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public void proceedRegistration(User user) {
        Repository.getInstance().createUser(user, getContext());
    }
}
