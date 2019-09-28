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
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.models.User;
import com.ascrossgams.myapplication.ui.entrance.SignIn.FragmentSingIn;

public class FragmentRegistrationTwo extends Fragment {
    private ViewModelRegistrationTwo viewModelRegistrationTwo;
    Button registrationTwo;

    EditText firstname;
    EditText surname;
    EditText phone;
    EditText dateOfBirth;
    PreferencesDataSource mPrefs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        viewModelRegistrationTwo =
                ViewModelProviders.of(this).get(ViewModelRegistrationTwo.class);
        mPrefs = new PreferencesDataSource(getContext());
        View root = inflater.inflate(R.layout.registration_step_2, container, false);
        final TextView textView = root.findViewById(R.id.reg_2);
        firstname = root.findViewById(R.id.firstname);
        surname = root.findViewById(R.id.surname);
        phone = root.findViewById(R.id.phone);
        dateOfBirth = root.findViewById(R.id.date_of_birth);
        registrationTwo = root.findViewById(R.id.registration_2);
        viewModelRegistrationTwo.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                setClickListeners();
            }
        });
        return root;
    }

    private void setClickListeners() {
        registrationTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(firstname.getText().toString(),
                        surname.getText().toString(),
                        phone.getText().toString(),
                        dateOfBirth.getText().toString());


                if (!firstname.getText().toString().equals("") &&
                        !surname.getText().toString().equals("") &&
                        !phone.getText().toString().equals("") &&
                        !dateOfBirth.getText().toString().equals("")) {

                    viewModelRegistrationTwo.setContext(getContext());
                    viewModelRegistrationTwo.proceedRegistration(user);

                    mPrefs.setIntValue("KEY_USER_COUNTRY",0);
                    mPrefs.setIntValue("KEY_USER_CITY",0);

                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    FragmentSingIn bdf = new FragmentSingIn();
                    ft.replace(R.id.frgmCont, bdf);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.addToBackStack(null);
                    ft.commit();
                }
                else {
                    Toast.makeText(getContext(), "Enter all data",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
