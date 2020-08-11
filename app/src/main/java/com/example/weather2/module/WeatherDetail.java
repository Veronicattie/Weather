package com.example.weather2.module;

public class WeatherDetail {
    private String name;
    private String value;
    private int img;

    public WeatherDetail(String name, String value, int img) {
        this.name = name;
        this.value = value;
        this.img = img;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }




}
