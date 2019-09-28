package com.ascrossgams.myapplication.ui.profile;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ascrossgams.myapplication.data.Repository;
import com.ascrossgams.myapplication.data.models.User;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Context context;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("PROFILE");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void proceedReadForProfile(String login) {
    }

    public void proceedUpdateSave(User user, String login) {
        Repository.getInstance().updateUserProfile(user, getContext(), login);

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}