package com.ascrossgams.myapplication.ui.entrance.SignIn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ascrossgams.myapplication.data.Repository;

public class ViewModelSingIn extends ViewModel {


    private MutableLiveData<String> mText;

    public ViewModelSingIn() {
        mText = new MutableLiveData<>();
        mText.setValue("SIGN IN");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void proceedSignIn(String login, String password) {
        Repository.getInstance().getUser(login, password);
    }
}
