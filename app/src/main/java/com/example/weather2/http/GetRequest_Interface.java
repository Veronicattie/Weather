package com.example.weather2.http;

import com.example.weather2.module.TodayWeather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

//长沙城市编号  101250101
public interface GetRequest_Interface {

    @GET("/v2/weatherlive/DMVYB25PY2EXNTK3MZEWODUYMZC4/101250101")
    Call<TodayWeather> getTodayWeather();

    @GET("/v2/weatherforecast/DMVYB25PY2EXNTK3MZEWODUYMZC4/101250101")
    Call<ResponseBody> getWeatherForecast();
}
