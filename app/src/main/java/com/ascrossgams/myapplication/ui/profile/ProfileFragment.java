package com.ascrossgams.myapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.datasource.FirebaseDataSource;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.models.User;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    Button save;

    TextView userMail;
    TextView userPassword;
    TextView userName;
    TextView userSurname;
    TextView userBirhtdayDate;
    TextView userPhone;
    String country;
    String city;
    String login;

    Spinner countrySpinner;
    Spinner citySpinner;

    String ukraine;
    String poland;
    String german;

    String kiev;
    String dnipro;
    String kharkiv;
    String lviv;

    String berlin;
    String munich;
    String cologne;
    String hamburg;

    String warsaw;
    String krakow;
    String lodz;
    String poznan;

    int countryPosition;
    int cityPosition;


    public PreferencesDataSource mPrefs;

    public String getCity() {
        return city;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        mPrefs = new PreferencesDataSource(getContext());
        countryPosition = mPrefs.getIntValue("KEY_USER_COUNTRY", 0);
        cityPosition = mPrefs.getIntValue("KEY_USER_CITY", 0);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        userMail = root.findViewById(R.id.userMail);
        userPassword = root.findViewById(R.id.userPassword);
        userName = root.findViewById(R.id.userName);
        userSurname = root.findViewById(R.id.userSurname);
        userBirhtdayDate = root.findViewById(R.id.userBirhtdayDate);
        userPhone = root.findViewById(R.id.userPhone);
        save = root.findViewById(R.id.save);

        String[] countries;
        String[] citiesUkraine;
        String[] citiesPoland;
        String[] citiesGerman;

        countries = getResources().getStringArray(R.array.countries);
        citiesUkraine = getResources().getStringArray(R.array.cities_ukraine);
        citiesPoland = getResources().getStringArray(R.array.cities_poland);
        citiesGerman = getResources().getStringArray(R.array.cities_german);

        ukraine = countries[0];
        poland = countries[1];
        german = countries[2];

        kiev = citiesUkraine[0];
        dnipro = citiesUkraine[1];
        kharkiv = citiesUkraine[2];
        lviv = citiesUkraine[3];

        warsaw = citiesPoland[0];
        krakow = citiesPoland[1];
        lodz = citiesPoland[2];
        poznan = citiesPoland[3];

        berlin = citiesGerman[0];
        munich = citiesGerman[1];
        cologne = citiesGerman[2];
        hamburg = citiesGerman[3];

        String[] dataCountry = {"", ukraine, poland, german};
        final String[] dataCitiesUkraine = {"", kiev, dnipro, kharkiv, lviv};
        final String[] dataCitiesPoland = {"", warsaw, krakow, lodz, poznan};
        final String[] dataCitiesGerman = {"", berlin, munich, cologne, hamburg};

        countrySpinner = (Spinner) root.findViewById(R.id.spinner_country);
        citySpinner = (Spinner) root.findViewById(R.id.spinner_city);

        ArrayAdapter<String> adapterCountry = new ArrayAdapter<String>(getContext(),
                R.layout.row, R.id.position, dataCountry);

        final ArrayAdapter<String> adapterCity = null;

        adapterCountry.setDropDownViewResource(R.layout.row_drop);
        countrySpinner.setAdapter(adapterCountry);

        countrySpinner.setSelection(countryPosition);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if (countrySpinner.getSelectedItemId() == 1) {
                    ArrayAdapter<String> adapterCity = new ArrayAdapter<String>(getContext(),
                            R.layout.row, R.id.position, dataCitiesUkraine);
                    adapterCity.setDropDownViewResource(R.layout.row_drop);
                    citySpinner.setAdapter(adapterCity);
                    citySpinner.setSelection(cityPosition);
                    setClickListnerCitySpinner();
                }
                else if (countrySpinner.getSelectedItemId() == 2) {
                    ArrayAdapter<String> adapterCity = new ArrayAdapter<String>(getContext(),
                            R.layout.row, R.id.position, dataCitiesPoland);
                    adapterCity.setDropDownViewResource(R.layout.row_drop);
                    citySpinner.setAdapter(adapterCity);
                    citySpinner.setSelection(cityPosition);
                    setClickListnerCitySpinner();
                }

                else if (countrySpinner.getSelectedItemId() == 3) {
                    ArrayAdapter<String> adapterCity = new ArrayAdapter<String>(getContext(),
                            R.layout.row, R.id.position, dataCitiesGerman);
                    adapterCity.setDropDownViewResource(R.layout.row_drop);
                    citySpinner.setAdapter(adapterCity);
                    citySpinner.setSelection(cityPosition);
                    setClickListnerCitySpinner();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        userMail.setText(FirebaseDataSource.getInstance().getMail());
        userPassword.setText(FirebaseDataSource.getInstance().getPassword());
        userName.setText(FirebaseDataSource.getInstance().getName());
        userSurname.setText(FirebaseDataSource.getInstance().getSurname());
        userBirhtdayDate.setText(FirebaseDataSource.getInstance().getBirthDate());
        userPhone.setText(FirebaseDataSource.getInstance().getPhone());

        final TextView textView = root.findViewById(R.id.text_tools);
        profileViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        setClickListeners();
        return root;
    }


    public void setClickListnerCitySpinner(){
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }


    private void setClickListeners() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login = mPrefs.getStringValue("KEY_USER_MAIL", "");

                if (countrySpinner.getSelectedItemId() == 1) {
                    country = ukraine;
                    mPrefs.setIntValue("KEY_USER_COUNTRY", 1);
                    if (citySpinner.getSelectedItemId() == 1) {
                        city = kiev;
                        mPrefs.setIntValue("KEY_USER_CITY", 1);
                    }
                    else if (citySpinner.getSelectedItemId() == 2) {
                        city = dnipro;
                        mPrefs.setIntValue("KEY_USER_CITY", 2);
                    }
                    else if (citySpinner.getSelectedItemId() == 3) {
                        city = kharkiv;
                        mPrefs.setIntValue("KEY_USER_CITY", 3);
                    }
                    else if (citySpinner.getSelectedItemId() == 4) {
                        city = lviv;
                        mPrefs.setIntValue("KEY_USER_CITY", 4);
                    }
                    mPrefs.setStringValue("KEY_USER_CITY_NAME", city);
                }
                else if (countrySpinner.getSelectedItemId() == 2) {
                    country = poland;
                    mPrefs.setIntValue("KEY_USER_COUNTRY", 2);
                    if (citySpinner.getSelectedItemId() == 1) {
                        city = warsaw;
                        mPrefs.setIntValue("KEY_USER_CITY", 1);
                    }
                    else if (citySpinner.getSelectedItemId() == 2) {
                        city = krakow;
                        mPrefs.setIntValue("KEY_USER_CITY", 2);
                    }
                    else if (citySpinner.getSelectedItemId() == 3) {
                        city = lodz;
                        mPrefs.setIntValue("KEY_USER_CITY", 3);
                    }
                    else if (citySpinner.getSelectedItemId() == 4) {
                        city = poznan;
                        mPrefs.setIntValue("KEY_USER_CITY", 4);
                    }
                    mPrefs.setStringValue("KEY_USER_CITY_NAME", city);
                }
                else if (countrySpinner.getSelectedItemId() == 3) {
                    country = german;
                    mPrefs.setIntValue("KEY_USER_COUNTRY", 3);
                    if (citySpinner.getSelectedItemId() == 1) {
                        city = berlin;
                        mPrefs.setIntValue("KEY_USER_CITY", 1);
                    }
                    else if (citySpinner.getSelectedItemId() == 2) {
                        city = munich;
                        mPrefs.setIntValue("KEY_USER_CITY", 2);
                    }
                    else if (citySpinner.getSelectedItemId() == 3) {
                        city = cologne;
                        mPrefs.setIntValue("KEY_USER_CITY", 3);
                    }
                    else if (citySpinner.getSelectedItemId() == 4) {
                        city = hamburg;
                        mPrefs.setIntValue("KEY_USER_CITY", 4);
                    }
                    mPrefs.setStringValue("KEY_USER_CITY_NAME", city);
                }

                User user = new User(userMail.getText().toString(),
                        userPassword.getText().toString(),
                        userName.getText().toString(),
                        userSurname.getText().toString(),
                        userPhone.getText().toString(),
                        userBirhtdayDate.getText().toString(),
                        country,
                        city,
                        FirebaseDataSource.getInstance().getId(),
                        FirebaseDataSource.getInstance().getSources());

                if (    !userPassword.getText().toString().equals("") &&
                        !userName.getText().toString().equals("") &&
                        !userSurname.getText().toString().equals("") &&
                        !userPhone.getText().toString().equals("") &&
                        !userBirhtdayDate.getText().toString().equals("") &&
                        citySpinner.getSelectedItemId() != 0 &&
                        countrySpinner.getSelectedItemId() != 0
                ) {
                    profileViewModel.setContext(getContext());
                    profileViewModel.proceedUpdateSave(user, login);
                    Toast.makeText(getContext(), "Data was saved",
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