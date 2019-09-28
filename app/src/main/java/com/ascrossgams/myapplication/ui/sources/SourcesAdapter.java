package com.ascrossgams.myapplication.ui.sources;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.datasource.FirebaseDataSource;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.models.retrofit.RetroSources;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SourcesAdapter extends RecyclerView.Adapter<SourcesAdapter.SourcesAdapterViewHolder>  {

    private List<RetroSources> sourcesList;
    private Context context;
    PreferencesDataSource mPref;
    String checkedResources;

    public SourcesAdapter(List<RetroSources> sourcesList, Context context) {
        this.sourcesList = sourcesList;
        this.context = context;
        mPref = new PreferencesDataSource(context);
        checkedResources = mPref.getStringValue("KEY_SOURCES", "abcnews.go.com,abc.net.au,aftenposten.no,aljazeera.com,ansa.it");;
    }

    @NonNull
    @Override
    public SourcesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_source, parent, false);

        return new SourcesAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final SourcesAdapterViewHolder holder, int position) {

        RetroSources currentSource = sourcesList.get(position);
        holder.description.setText(currentSource.getName());
        holder.name.setText(currentSource.getUrl());
        String s = sourcesList.get(position).getUrl().replaceAll("^(http://www\\.|http://|www\\.|https://www\\.|https://)|/.+|/","");
        if (checkedResources.contains(s)) {
            holder.checkedTextView.setChecked(true);
        }
        else {
            holder.checkedTextView.setChecked(false);
        }

        holder.checkedTextView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String sourcesPref = mPref.getStringValue("KEY_SOURCES", "");
                String newSource = "";
                String sourceText = holder.name.getText().toString().replaceAll("^(http://www\\.|http://|www\\.|https://www\\.|https://)|/.+|/","");
                if(isChecked) {
                    if (sourcesPref.equals("") || sourcesPref.equals(null)) {
                        newSource = sourceText;

                    }
                    else if (!sourcesPref.equals("")) {
                        newSource = "," + sourceText;

                    }
                    checkedResources = checkedResources + newSource;
                    mPref.setStringValue("KEY_SOURCES", sourcesPref + newSource);

                    Log.i(TAG, "Флажок выбран");
                }
                else if (!isChecked) {
                    newSource = sourceText;
                    mPref.setStringValue("KEY_SOURCES", sourcesPref.replaceAll(newSource, ""));
                    if (mPref.getStringValue("KEY_SOURCES", "").startsWith(",")) {
                        mPref.setStringValue("KEY_SOURCES", mPref.getStringValue("KEY_SOURCES", "").replaceFirst(",", ""));
                    }
                    mPref.setStringValue("KEY_SOURCES", mPref.getStringValue("KEY_SOURCES", "").replaceAll(",$", ""));
                     mPref.setStringValue("KEY_SOURCES", mPref.getStringValue("KEY_SOURCES", "").replaceAll(",,|,,,|,,,,|,,,,,|,,,,,,", ","));

                    if (mPref.getStringValue("KEY_SOURCES", "").startsWith(",") || mPref.getStringValue("KEY_SOURCES", "").endsWith(",")) {
                        mPref.setStringValue("KEY_SOURCES", mPref.getStringValue("KEY_SOURCES", "").replaceFirst(",", ""));
                        mPref.setStringValue("KEY_SOURCES", mPref.getStringValue("KEY_SOURCES", "").replaceAll(",$", ""));
                    }

                    if (mPref.getStringValue("KEY_SOURCES", "").equals(",")) {
                        mPref.setStringValue("KEY_SOURCES", mPref.getStringValue("KEY_SOURCES", "").replaceAll(",", ""));
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return sourcesList.size();
    }

    class SourcesAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView description;
        CheckBox checkedTextView;


        public SourcesAdapterViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Please use checkbox to choose source",
                            Toast.LENGTH_LONG).show();
                }
            });
            name = itemView.findViewById(R.id.sourceName);
            description = itemView.findViewById(R.id.sourceDescription);
            checkedTextView = itemView.findViewById(R.id.checkedTextView);
        }
    }
}
