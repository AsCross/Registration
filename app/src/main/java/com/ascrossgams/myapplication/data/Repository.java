package com.ascrossgams.myapplication.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.ascrossgams.myapplication.data.datasource.FirebaseDataSource;
import com.ascrossgams.myapplication.data.datasource.NewsApiDataSource;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.datasource.WeatherApiDataSource;
import com.ascrossgams.myapplication.data.mapper.UserMapper;
import com.ascrossgams.myapplication.data.models.User;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import retrofit2.Callback;

public class Repository {

    public PreferencesDataSource mPrefs;

    private static Repository INSTANCE;

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public void createUser(User user, Context context) {
        mPrefs = new PreferencesDataSource(context);
        mPrefs.setStringValue("KEY_USER_MAIL", user.getMail());

        SharedPreferences sharedPreferences = context.getSharedPreferences("KEY_USER", 0);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        final Gson gson = new Gson();
        String serializedObject = gson.toJson(user);
        sharedPreferencesEditor.putString("KEY_USER", serializedObject);
        sharedPreferencesEditor.apply();
    }

    public void getUser(String userId, String password) {
        FirebaseDataSource.getInstance().readUser(userId, password);
    }

    public void updateUser(User user, Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("KEY_USER", 0);
            final Gson gson = new Gson();
            gson.fromJson(sharedPreferences.getString("KEY_USER", ""), (Type) User.class);
         String json = sharedPreferences.getString("KEY_USER", "");

        user.setMail(gson.fromJson(json, User.class).getMail());
        user.setPassword(gson.fromJson(json, User.class).getPassword());

        if (gson.fromJson(json, User.class).getName() != null) {
            user.setName(gson.fromJson(json, User.class).getName());
            user.setSurname(gson.fromJson(json, User.class).getSurname());
            user.setPhoneNumber(gson.fromJson(json, User.class).getPhoneNumber());
            user.setBirthDate(gson.fromJson(json, User.class).getBirthDate());
            user.setCountry(gson.fromJson(json, User.class).getCountry());
            user.setCity(gson.fromJson(json, User.class).getCity());
            user.setPassword(gson.fromJson(json, User.class).getPassword());
        }

        FirebaseDataSource.getInstance().updateUser(UserMapper.mapToMap(user));

        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        String serializedObject = gson.toJson(user);
        sharedPreferencesEditor.putString("KEY_USER", serializedObject);
        sharedPreferencesEditor.apply();
    }

    public void updateUserProfile(User user, Context context, String login) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("KEY_USER", 0);
        final Gson gson = new Gson();
        gson.fromJson(sharedPreferences.getString("KEY_USER", ""), (Type) User.class);
        String json = sharedPreferences.getString("KEY_USER", "");

            user.setMail(gson.fromJson(json, User.class).getMail());

        FirebaseDataSource.getInstance().updateUserFromProfile(login, (UserMapper.mapToMap(user)));

        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        String serializedObject = gson.toJson(user);
        sharedPreferencesEditor.putString("KEY_USER", serializedObject);
        sharedPreferencesEditor.apply();
    }


    public void updateUserSource(User user, Context context, String mail, String source) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("KEY_USER", 0);
        final Gson gson = new Gson();

        user.setMail(mail);
        user.setSources(source);

        FirebaseDataSource.getInstance().updateUserFromSources(mail, source, (UserMapper.mapToMap(user)));

        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        String serializedObject = gson.toJson(user);
        sharedPreferencesEditor.putString("KEY_USER", serializedObject);
        sharedPreferencesEditor.apply();
    }

    public void getTopArticles(Callback callback) {
        NewsApiDataSource.getInstance().getTopHeadlines(callback);
    }

    public void getAllArticles(int page, String sources, Callback callback) {
        NewsApiDataSource.getInstance().getEverything(page, sources, callback);
    }

    public void getAllSources(Callback callback) {
        NewsApiDataSource.getInstance().getSources(callback);
    }

    public void getWeather(Callback callback, String city) {
        WeatherApiDataSource.getInstance().getWheatherInfo(callback, city);
    }
}
