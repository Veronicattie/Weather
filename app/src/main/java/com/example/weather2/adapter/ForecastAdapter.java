package com.example.weather2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather2.R;
import com.example.weather2.module.ForecastData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private List<ForecastData> data;
    public ForecastAdapter(List<ForecastData> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_forecast, parent, false);
        ForecastViewHolder holder = new ForecastViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder holder, int position) {
        ForecastData item  =data.get(position);
        holder.tvDate.setText(item.getDate());
        holder.tvWeek.setText(item.getWeek());
        holder.tvDescription.setText(item.getDescription());
        holder.tvTemprature.setText(item.getHighTemperate()+"°/"+item.getLowTemperate()+"°");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_week)
        TextView tvWeek;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.tv_temprature)
        TextView tvTemprature;

        public ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
