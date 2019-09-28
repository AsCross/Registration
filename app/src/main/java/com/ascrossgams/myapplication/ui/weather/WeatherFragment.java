package com.ascrossgams.myapplication.ui.weather;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.datasource.PreferencesDataSource;
import com.ascrossgams.myapplication.data.models.retrofit.RetroWeatherResponseModel;
import com.squareup.picasso.Picasso;

public class WeatherFragment extends Fragment {
    private Context context;
    private WeatherViewModel weatherViewModel;
    private TextView temperatureInfoText;
    private TextView windSpeed;
    private TextView weatherDescriptions;
    private TextView feelslike;
    private TextView windDir;
    private TextView cloudcover;
    private TextView city;
    private ImageView weatherIcons;

    PreferencesDataSource mPref;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        weatherViewModel =
                ViewModelProviders.of(this).get(WeatherViewModel.class);

        mPref = new PreferencesDataSource(getContext());

        View root = inflater.inflate(R.layout.fragment_weather, container, false);
        temperatureInfoText = root.findViewById(R.id.temperature);
        windSpeed = root.findViewById(R.id.wind_speed);
        weatherDescriptions = root.findViewById(R.id.weatherDescriptions);
        feelslike = root.findViewById(R.id.feelslike);
        windDir = root.findViewById(R.id.wind_dir);
        cloudcover = root.findViewById(R.id.cloudcover);
        city = root.findViewById(R.id.city_name);

        weatherIcons = root.findViewById(R.id.weather_icons);

        weatherViewModel.getWeatherLiveData().observe(this, new Observer<RetroWeatherResponseModel>() {
            @Override
            public void onChanged(@Nullable RetroWeatherResponseModel weather) {
                if (weather != null && weather.getCurrent() != null) {
                    temperatureInfoText.setText(weather.getCurrent().getTemperature() + " C");
                    feelslike.setText(weather.getCurrent().getFeelslike() + " C");
                    windDir.setText(weather.getCurrent().getWindDir());
                    cloudcover.setText(weather.getCurrent().getCloudcover());
                    windSpeed.setText(weather.getCurrent().getWindSpeed()+ " kmph");
                    weatherDescriptions.setText(weather.getCurrent().getWeatherDescriptions()[0]);
                    city.setText(mPref.getStringValue("KEY_USER_CITY_NAME", "City"));
                    Picasso.with(getContext()).load(weather.getCurrent().getWeatherIcons()[0]).into(weatherIcons);
                }
            }
        });

        weatherViewModel.getErrorsLiveData().observe(this, new Observer<Throwable>() {
            @Override
            public void onChanged(Throwable throwable) {
                Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        weatherViewModel.loadWeather(mPref.getStringValue("KEY_USER_CITY_NAME", "City"));
        return root;
    }
}