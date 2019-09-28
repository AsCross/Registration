package com.ascrossgams.myapplication.ui.entrance.Registration;

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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.models.User;

public class FragmentRegistrationOne extends Fragment {
    private ViewModelRegistrationOne viewModelRegistrationOne;
    Button registrationOne;
    EditText mail;
    EditText password;
    EditText confirmPassword;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        viewModelRegistrationOne =
                ViewModelProviders.of(this).get(ViewModelRegistrationOne.class);
        View root = inflater.inflate(R.layout.registration_step_1, container, false);
        registrationOne = root.findViewById(R.id.registration_1);
        password = root.findViewById(R.id.password);
        mail = root.findViewById(R.id.mail);
        confirmPassword = root.findViewById(R.id.passwordCon);
        final TextView textView = root.findViewById(R.id.reg_1);

        setClickListeners();
        viewModelRegistrationOne.setContext(getContext());
        viewModelRegistrationOne.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    private void setClickListeners() {
        registrationOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(mail.getText().toString(),
                        password.getText().toString());

                if (!mail.getText().toString().equals("") &&
                        !password.getText().toString().equals("") &&
                        !confirmPassword.getText().toString().equals("") &&
                        password.getText().toString().equals(confirmPassword.getText().toString())) {

                    viewModelRegistrationOne.proceedRegistration(user);
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    FragmentRegistrationTwo bdf = new FragmentRegistrationTwo();
                    ft.replace(R.id.frgmCont, bdf);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();
                }
                else if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
                    Toast.makeText(getContext(), "Passwords do not match",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getContext(), "Enter all data",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
