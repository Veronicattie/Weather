package com.example.weather2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather2.R;
import com.example.weather2.module.WeatherDetail;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<WeatherDetail> mUserList;

    public WeatherAdapter(List<WeatherDetail> list){
        this.mUserList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_detail,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherDetail user = mUserList.get(position);
        holder.tv.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView tvValue;
        public ViewHolder(View view){
            super(view);
            tv = view.findViewById(R.id.tv_name);
            tvValue = view.findViewById(R.id.tv_value);
        }
    }
}
