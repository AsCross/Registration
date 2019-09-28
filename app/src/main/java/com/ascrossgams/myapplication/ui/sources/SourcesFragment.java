package com.ascrossgams.myapplication.ui.sources;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.datasource.FirebaseDataSource;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.models.User;
import com.ascrossgams.myapplication.data.models.retrofit.RetroSources;
import com.ascrossgams.myapplication.ui.source.SourceFragment;

import java.util.List;

public class SourcesFragment extends Fragment {

    private SourcesViewModel sourcesViewModel;
    private RecyclerView recyclerView;
    SourceFragment sourceFragment;
    String userMail;
    String userPassword;
    String userName;
    String userSurname;
    String userBirhtdayDate;
    String userPhone;
    String country;
    String city;
    String sources;
    String id;

    PreferencesDataSource mPrefs;
    Button saveSources;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sourcesViewModel =
                ViewModelProviders.of(this).get(SourcesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sources, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewSources);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        saveSources = root.findViewById(R.id.buttonSaveSource);
        mPrefs = new PreferencesDataSource(getContext());
        sourceFragment = new SourceFragment();
        userMail = FirebaseDataSource.getInstance().getMail();

        sourcesViewModel.getSourcesLiveData().observe(this, new Observer<List<RetroSources>>() {
            @Override
            public void onChanged(List<RetroSources> retroSources) {
                recyclerView.setAdapter(new SourcesAdapter(retroSources, getContext()));
            }
        });

        sourcesViewModel.getErrorsLiveData().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        setClickListeners();
        sourcesViewModel.loadSources();

        return root;
    }

    private void setClickListeners() {
        saveSources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userMail = FirebaseDataSource.getInstance().getMail();
                userPassword = FirebaseDataSource.getInstance().getPassword();
                userName = FirebaseDataSource.getInstance().getName();
                userSurname = FirebaseDataSource.getInstance().getSurname();
                userBirhtdayDate = FirebaseDataSource.getInstance().getBirthDate();
                userPhone = FirebaseDataSource.getInstance().getPhone();
                id = FirebaseDataSource.getInstance().getId();
                country = FirebaseDataSource.getInstance().getCountry();
                city = FirebaseDataSource.getInstance().getCity();
                sources = mPrefs.getStringValue("KEY_SOURCES", "abcnews.go.com,abc.net.au,aftenposten.no,aljazeera.com,ansa.it");

                User user = new User(userMail,
                        userPassword,
                        userName,
                        userSurname,
                        userPhone,
                        userBirhtdayDate,
                        country,
                        city,
                        id,
                        sources);

                    sourcesViewModel.setContext(getContext());
                    sourcesViewModel.proceedUpdateSave(user, userMail, sources);

                    Toast.makeText(getContext(), "Data was saved",
                            Toast.LENGTH_LONG).show();
            }
        });
    }
}