package com.example.weather2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather2.R;
import com.example.weather2.adapter.ForecastAdapter;
import com.example.weather2.adapter.WeatherAdapter;
import com.example.weather2.common.RecyclerGridDivider;
import com.example.weather2.module.ForecastData;
import com.example.weather2.module.WeatherDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
    public static final int COLUMN_COUNT = 3;
    List dataTodayDetail;
    List dataForecast;
    Context mContext;
    @BindView(R.id.rv_today_detail)
    RecyclerView rvTodayDetail;
    @BindView(R.id.rv_forecast)
    RecyclerView rvForecast;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = this.getContext();
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    private void initData() {
        dataTodayDetail = new ArrayList<WeatherDetail>();
        for (int i = 0; i < 6; i++) {
            WeatherDetail item = new WeatherDetail("Name" + i, "value" + i, R.drawable.ic_index_sunscreen);
            dataTodayDetail.add(item);
        }

        dataForecast = new ArrayList<ForecastData>();
        for (int i = 0; i < 7; i++) {
            ForecastData data = new ForecastData("周一","08.10","雨","37","29");
            dataForecast.add(data);
        }
    }

    private void initView() {
        //今日详情
        WeatherAdapter todatyDetailAdapter = new WeatherAdapter(dataTodayDetail);
        rvTodayDetail.setLayoutManager(new GridLayoutManager(mContext, COLUMN_COUNT));
        rvTodayDetail.setAdapter(todatyDetailAdapter);
        rvTodayDetail.addItemDecoration(new RecyclerGridDivider());

        //预报
        ForecastAdapter forecastAdapter = new ForecastAdapter(dataForecast);
        rvForecast.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        rvForecast.setAdapter(forecastAdapter);
        //rvForecast.addItemDecoration();
    }


}
