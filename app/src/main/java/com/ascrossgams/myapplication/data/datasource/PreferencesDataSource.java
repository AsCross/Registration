package com.ascrossgams.myapplication.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesDataSource {
    private SharedPreferences mPrefs;
    private SharedPreferences.Editor mEditor;
    private static final String GAME_DATA = "game_data";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_MAIL = "user_mail";
    public static final String KEY_USER_PASSWORD = "user_password";
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_SURNAME = "user_surname";
    public static final String KEY_USER_PHONE_NUMBER = "user_phone_number";
    public static final String KEY_USER_BIRTH_DATE = "user_birth_date";
    public static final String KEY_USER_COUNTRY = "user_country";
    public static final String KEY_USER_CITY = "user_city";
    public static final String KEY_USER_CITY_NAME = "user_city_name";
    public static final String KEY_USER = "user";
    public static final String KEY_EXIT = "exit";

//    public static final String KEY_SOURCE_ONE = "source_one";
//    public static final String KEY_SOURCE_TWO = "source_two";
//    public static final String KEY_SOURCE_THREE = "source_three";
//    public static final String KEY_SOURCE_FOUR = "source_four";
//    public static final String KEY_SOURCE_FIVE = "source_five";

    public static final String KEY_SOURCES = "sources";

    public PreferencesDataSource(Context context) {
        mPrefs = context.getSharedPreferences(GAME_DATA, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    public void setIntValue(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.apply();
        mEditor.commit();
    }

    public void setBoolValue(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.apply();
        mEditor.commit();
    }

    public void setLongValue(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.apply();
        mEditor.commit();
    }

    public void setStringValue(String key, String value) {
        mEditor.putString(key, value);
        mEditor.apply();
        mEditor.commit();
    }

    public int getIntValue(String key, int defaultValue) {
        return mPrefs.getInt(key, defaultValue);
    }

    public boolean getBoolValue(String key, boolean defaultValue) {
        return mPrefs.getBoolean(key, defaultValue);
    }

    public long getLongValue(String key, int defaultValue) {
        return mPrefs.getLong(key, defaultValue);
    }

    public String getStringValue(String key, String defaultValue) {
        return mPrefs.getString(key, defaultValue);
    }

}

