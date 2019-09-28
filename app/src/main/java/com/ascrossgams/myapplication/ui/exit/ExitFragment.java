package com.ascrossgams.myapplication.ui.exit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.StartActivity;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;

public class ExitFragment extends Fragment {

    private ExitViewModel shareViewModel;
    String isSignIn;
    PreferencesDataSource mPref;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mPref = new PreferencesDataSource(getContext());
        mPref.setIntValue("KEY_EXIT", 1);
        Intent intent = new Intent(getContext(), StartActivity.class);
        startActivity(intent);
        shareViewModel =
                ViewModelProviders.of(this).get(ExitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exit, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}