package com.ascrossgams.myapplication.data.datasource;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.Map;
import androidx.annotation.NonNull;

public class FirebaseDataSource {

    public String mail;
    public String password;
    public String name;
    public String surname;
    public String birthDate;
    public String phone;
    public String country;
    public String city;
    public String id;
    public String sources;


    public String getSources() {
        return sources;
    }

    public String getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    private static FirebaseDataSource INSTANCE;
    public         FirebaseFirestore  db;

    public static FirebaseDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FirebaseDataSource();
        }

        return INSTANCE;
    }

    public FirebaseDataSource() {
        db = FirebaseFirestore.getInstance();
    }

    public void createUser(Map<String, Object> userData) {
        db.collection("users")
                .add(userData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                       Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }

    public void updateUser(final Map<String, Object> userData) {
        db.collection("users")
                .add(userData)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        id = documentReference.getId();
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }


    public void readUser(final String mailLogin, final String passwordLogin) {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (mailLogin.equals(document.getString("mail")) && passwordLogin.equals(document.getString("password"))) {
                                    mail = document.getString("mail");
                                    password = document.getString("password");
                                    name = document.getString("name");
                                    surname = document.getString("surname");
                                    phone = document.getString("phoneNumber");
                                    birthDate = document.getString("birthDate");
                                    country = document.getString("country");
                                    city = document.getString("city");

                                    id = document.getId();
                                    sources = document.getString("sources");
                                }

                                else {
                                    Log.d("Wrong", "Wrong mail or password");
                                }
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("TAG", "Error getting documents. ", task.getException());
                        }
                    }
                });
    }


    public void updateUserFromProfile(final String mailLogin, final Map<String, Object> userData) {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (mailLogin.equals(document.getString("mail"))) {
                                    mail = document.getString("mail");
                                    password = document.getString("password");
                                    name = document.getString("name");
                                    surname = document.getString("surname");
                                    phone = document.getString("phoneNumber");
                                    birthDate = document.getString("birthDate");
                                    country = document.getString("country");
                                    city = document.getString("city");
                                    sources = document.getString("sources");
                                    id = document.getString("id");
                                }
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("TAG", "Error getting documents. ", task.getException());
                        }
                    }
                });

        db.collection("users")
                .document(id).update(userData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        boolean b = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }


    public void updateUserFromSources(final String mailLogin, final String sourcesFromSave, final Map<String, Object> userData) {
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                if (mailLogin.equals(document.getString("mail"))) {
                                    mail = document.getString("mail");
                                    password = document.getString("password");
                                    name = document.getString("name");
                                    surname = document.getString("surname");
                                    phone = document.getString("phoneNumber");
                                    birthDate = document.getString("birthDate");
                                    country = document.getString("country");
                                    city = document.getString("city");

                                    id = document.getId();
                                    sources = sourcesFromSave;
                                }
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("TAG", "Error getting documents. ", task.getException());
                        }
                    }
                });
        db.collection("users")
                .document(id).update(userData)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        boolean b = true;
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });
    }



}