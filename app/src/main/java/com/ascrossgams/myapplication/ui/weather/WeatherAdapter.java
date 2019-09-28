package com.ascrossgams.myapplication.ui.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ascrossgams.myapplication.R;
import com.ascrossgams.myapplication.data.models.retrofit.RetroCurrent;
import com.ascrossgams.myapplication.data.models.retrofit.RetroLocation;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherAdapterViewHolder>{

    private List<RetroCurrent> weatherList;
    private List<RetroLocation> locationrList;
    private Context context;

    public WeatherAdapter(List<RetroCurrent> weatherList, Context context) {
        this.weatherList = weatherList;
        this.context = context;
    }

    @NonNull
    @Override
    public WeatherAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather, parent, false);
        return new WeatherAdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapterViewHolder holder, int position) {
        RetroCurrent currentWeather = weatherList.get(position);
        RetroLocation currentLocation = locationrList.get(position);
        holder.observationTime.setText(currentWeather.getObservationTime());
        holder.temperature.setText(currentWeather.getTemperature());
        holder.temperature.setText(currentWeather.getTemperature());
        holder.windSpeed.setText(currentWeather.getWindSpeed());
        holder.windDegree.setText(currentWeather.getWindDegree());
        holder.city.setText(currentLocation.getName());
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class WeatherAdapterViewHolder extends RecyclerView.ViewHolder {
        ImageView weatherIcons;
        TextView observationTime;
        TextView temperature;
        TextView windSpeed;
        TextView windDegree;
        TextView feelslike;
        TextView cloudcover;
        TextView city;

        public WeatherAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            weatherIcons = itemView.findViewById(R.id.weather_icons);
            observationTime = itemView.findViewById(R.id.observation_time);
            temperature = itemView.findViewById(R.id.temperature);
            windSpeed = itemView.findViewById(R.id.wind_speed);
            windDegree = itemView.findViewById(R.id.wind_degree);
            feelslike = itemView.findViewById(R.id.feelslike);
            cloudcover = itemView.findViewById(R.id.cloudcover);
            city = itemView.findViewById(R.id.city_name);
        }
    }
}
