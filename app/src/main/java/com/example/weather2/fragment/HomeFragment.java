package com.example.weather2.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.example.weather2.http.GetRequest_Interface;
import com.example.weather2.module.ForecastData;
import com.example.weather2.module.TodayWeather;
import com.example.weather2.module.WeatherDetail;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    public static final int COLUMN_COUNT = 3;
    List dataTodayDetail;
    WeatherAdapter todatyDetailAdapter;
    List dataForecast;
    Context mContext;
    Retrofit retrofit;
    @BindView(R.id.rv_today_detail)
    RecyclerView rvTodayDetail;
    @BindView(R.id.rv_forecast)
    RecyclerView rvForecast;
    GetRequest_Interface request;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = this.getContext();
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        initRetrofit();
        getTodayWeatherData();
        getWeatherForecastData();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    private void initData() {
        dataTodayDetail = new ArrayList<WeatherDetail>();
        WeatherDetail item1 = new WeatherDetail("体感温度", "30℃", R.drawable.ic_index_sunscreen);
        WeatherDetail item2 = new WeatherDetail("湿度", "52.0%", R.drawable.ic_index_sunscreen);
        WeatherDetail item3 = new WeatherDetail("紫外线指数", "11", R.drawable.ic_index_sunscreen);
        WeatherDetail item4 = new WeatherDetail("降水指数", "0.0mm", R.drawable.ic_index_sunscreen);
        WeatherDetail item5 = new WeatherDetail("降水概率", "12%", R.drawable.ic_index_sunscreen);
        WeatherDetail item6 = new WeatherDetail("能见度", "11km", R.drawable.ic_index_sunscreen);
        dataTodayDetail.add(item1);
        dataTodayDetail.add(item2);
        dataTodayDetail.add(item3);
        dataTodayDetail.add(item4);
        dataTodayDetail.add(item5);
        dataTodayDetail.add(item6);
//        for (int i = 0; i < 6; i++) {
//            WeatherDetail item = new WeatherDetail("Name" + i, "value" + i, R.drawable.ic_index_sunscreen);
//            dataTodayDetail.add(item);
//        }

        dataForecast = new ArrayList<ForecastData>();
        for (int i = 0; i < 7; i++) {
            ForecastData data = new ForecastData("周一","08.10","雨","37","29");
            dataForecast.add(data);
        }
    }

    private void initView() {
        //今日详情
        todatyDetailAdapter = new WeatherAdapter(dataTodayDetail);
        rvTodayDetail.setLayoutManager(new GridLayoutManager(mContext, COLUMN_COUNT));
        rvTodayDetail.setAdapter(todatyDetailAdapter);
        rvTodayDetail.addItemDecoration(new RecyclerGridDivider());

        //预报
        ForecastAdapter forecastAdapter = new ForecastAdapter(dataForecast);
        rvForecast.setLayoutManager(new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false));
        rvForecast.setAdapter(forecastAdapter);
        //rvForecast.addItemDecoration();


    }


    private List<WeatherDetail> getTodayWeatherArr(TodayWeather todayWeather){
        List<WeatherDetail> tmp = new ArrayList<WeatherDetail>();
        WeatherDetail item1 = new WeatherDetail("体感温度", todayWeather.getFeelst()+"℃", R.drawable.ic_index_sunscreen);
        WeatherDetail item2 = new WeatherDetail("湿度", todayWeather.getHumidity()+"%", R.drawable.ic_index_sunscreen);
        WeatherDetail item3 = new WeatherDetail("紫外线指数", todayWeather.getWindpower()+"", R.drawable.ic_index_sunscreen);
        WeatherDetail item4 = new WeatherDetail("降水指数", "0.0mm", R.drawable.ic_index_sunscreen);
        WeatherDetail item5 = new WeatherDetail("降水概率", "12%", R.drawable.ic_index_sunscreen);
        WeatherDetail item6 = new WeatherDetail("能见度", "11km", R.drawable.ic_index_sunscreen);
        tmp.add(item1);
        tmp.add(item2);
        tmp.add(item3);
        tmp.add(item4);
        tmp.add(item5);
        tmp.add(item6);
        return tmp;
    }

    private void initRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://service.envicloud.cn:8082")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        request = retrofit.create(GetRequest_Interface.class);
    }

    private void getTodayWeatherData(){

        Call<TodayWeather> call = request.getTodayWeather();
        call.enqueue(new Callback<TodayWeather>() {
            @Override
            public void onResponse(Call<TodayWeather> call, Response<TodayWeather> response) {
                TodayWeather todayWeather = response.body();
                dataTodayDetail.clear();
                dataTodayDetail.addAll(getTodayWeatherArr(todayWeather));
               // rvTodayDetail.notify();
                todatyDetailAdapter.notifyDataSetChanged();
                Log.i("MainActivity",todayWeather.toString());
            }

            @Override
            public void onFailure(Call<TodayWeather> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    private void getWeatherForecastData(){

        Call<ResponseBody> call = request.getWeatherForecast();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("MainActivity ","getWeatherForecastData----"+response.body().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
