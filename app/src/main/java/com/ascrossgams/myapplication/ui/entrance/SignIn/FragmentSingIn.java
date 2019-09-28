package com.ascrossgams.myapplication.ui.entrance.SignIn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ascrossgams.myapplication.MainActivity;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.datasource.FirebaseDataSource;
import com.ascrossgams.myapplication.data.models.User;
import com.google.gson.Gson;

import java.lang.reflect.Type;


public class FragmentSingIn extends Fragment {

    Button signIn;
    EditText mailLogin;
    EditText passwordLogin;
    private ViewModelSingIn viewModelSingIn;
    String login;
    String password;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModelSingIn =
                ViewModelProviders.of(this).get(ViewModelSingIn.class);
        View root = inflater.inflate(R.layout.sing_in, container, false);
        mailLogin = root.findViewById(R.id.mail_login);
        signIn = root.findViewById(R.id.sign_in);
        passwordLogin = root.findViewById(R.id.password_login);
        final TextView textView = root.findViewById(R.id.text_sing_in);
        viewModelSingIn.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        setClickListeners();
        return root;
    }

    public void signIn() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    private void setClickListeners() {
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = mailLogin.getText().toString();
                password = passwordLogin.getText().toString();

                SharedPreferences sharedPreferences = getContext().getSharedPreferences("KEY_USER", 0);
                final Gson gson = new Gson();
                gson.fromJson(sharedPreferences.getString("KEY_USER", ""), (Type) User.class);
                String json = sharedPreferences.getString("KEY_USER", "");

                if (login.equals(gson.fromJson(json, User.class).getMail()) && password.equals(gson.fromJson(json, User.class).getPassword())) {
                    viewModelSingIn.proceedSignIn(login, password);
                    signIn();
                }

                else {
                    Toast.makeText(getContext(), "Wrong login or password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
