package com.ascrossgams.myapplication.data.mapper;

import com.ascrossgams.myapplication.data.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {

    private static final String FIELD_MAIL                  = "mail";
    private static final String FIELD_PASSWORD              = "password";
    private static final String FIELD_CONFIRMATION_PASSWORD = "confirmationPassword";
    private static final String FIELD_COUNTRY               = "country";
    private static final String FIELD_CITY                  = "city";
    private static final String FIELD_NAME                  = "name";
    private static final String FIELD_SURNAME               = "surname";
    private static final String FIELD_PHONE_NUMBER          = "phoneNumber";
    private static final String FIELD_BIRTH_DATE            = "birthDate";
    private static final String FIELD_ID                    = "id";
    private static final String FIELD_SOURCES               = "sources";

    public static Map<String, Object> mapToMap(User user) {
        Map<String, Object> userData = new HashMap<>();
        userData.put(FIELD_MAIL, user.getMail());
        userData.put(FIELD_PASSWORD, user.getPassword());
        userData.put(FIELD_COUNTRY, user.getCountry());
        userData.put(FIELD_CITY, user.getCity());
        userData.put(FIELD_NAME, user.getName());
        userData.put(FIELD_SURNAME, user.getSurname());
        userData.put(FIELD_PHONE_NUMBER, user.getPhoneNumber());
        userData.put(FIELD_BIRTH_DATE, user.getBirthDate());
        userData.put(FIELD_ID, user.getId());
        userData.put(FIELD_SOURCES, user.getSources());

        return userData;
    }

    public static User mapToUser(Map<String, String> userData) {
        return new User(
                userData.get(FIELD_MAIL),
                userData.get(FIELD_PASSWORD),
                userData.get(FIELD_COUNTRY),
                userData.get(FIELD_CITY),
                userData.get(FIELD_NAME),
                userData.get(FIELD_SURNAME),
                userData.get(FIELD_PHONE_NUMBER),
                userData.get(FIELD_BIRTH_DATE),
                userData.get(FIELD_ID),
                userData.get(FIELD_SOURCES));
    }
}