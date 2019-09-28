package com.ascrossgams.myapplication.data.models;

public class User {
    private String mail;
    private String password;
    private String name;
    private String surname;
    private String phoneNumber;
    private String birthDate;
    private String country;
    private String city;
    private String id;
    private String sources;




    public User(String sources) {
        this.sources = sources;
    }

    public User(String mail, String password, String name, String surname, String phoneNumber, String birthDate, String country, String city, String id, String sources) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.country = country;
        this.city = city;
        this.id = id;
        this.sources = sources;
    }

    public User(String mail, String password, String name, String surname, String phoneNumber, String birthDate, String country, String city) {
        this.mail = mail;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.country = country;
        this.city = city;
    }

    public User(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public User(String mail, String password, String id) {
        this.mail = mail;
        this.password = password;
        this.id = id;
    }

    public User(String name, String surname, String phoneNumber, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public User(String password, String name, String surname, String phoneNumber, String birthDate, String country, String city) {
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.country = country;
        this.city = city;
    }

    public String getSources() {
        return sources;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }


    public void setSources(String sources) {
        this.sources = sources;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
