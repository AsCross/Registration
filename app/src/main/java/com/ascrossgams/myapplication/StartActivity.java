package com.ascrossgams.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.ui.entrance.Registration.FragmentRegistrationOne;
import com.ascrossgams.myapplication.ui.entrance.Registration.FragmentRegistrationTwo;
import com.ascrossgams.myapplication.ui.entrance.SignIn.FragmentSingIn;
import com.google.android.material.navigation.NavigationView;

public class StartActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    FragmentSingIn singInFrag;
    FragmentRegistrationOne registration1Frag;
    FragmentRegistrationTwo registration2Frag;

    Button registration;
    Button signIn;
    FragmentTransaction fTrans;
    PreferencesDataSource mPref;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        registration = findViewById(R.id.go_to_registration);
        signIn = findViewById(R.id.go_to_sing_in);
        singInFrag = new FragmentSingIn();
        registration1Frag = new FragmentRegistrationOne();
        registration2Frag = new FragmentRegistrationTwo();
        fTrans = getSupportFragmentManager().beginTransaction();
        mPref = new PreferencesDataSource(getBaseContext());

        if (mPref.getIntValue("KEY_EXIT", 0) == 1) {
            mPref.setIntValue("KEY_EXIT", 0);
            fTrans.replace(R.id.frgmCont, singInFrag);
            registration.setVisibility(View.GONE);
            signIn.setVisibility(View.GONE);
            fTrans.commit();
    }
    }

    public void toMainActivity(View view) {
        Intent questionIntent = new Intent(StartActivity.this,
                MainActivity.class);
        startActivityForResult(questionIntent, 0);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.go_to_registration:
                fTrans.replace(R.id.frgmCont, registration1Frag);
                registration.setVisibility(View.GONE);
                signIn.setVisibility(View.GONE);
                break;
            case R.id.go_to_sing_in:
                fTrans.replace(R.id.frgmCont, singInFrag);
                registration.setVisibility(View.GONE);
                signIn.setVisibility(View.GONE);
                break;
            case R.id.registration_1:
                fTrans.replace(R.id.frgmCont, registration2Frag);
                break;
            default:
                break;
        }
        fTrans.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}