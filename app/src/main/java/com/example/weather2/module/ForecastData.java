package com.example.weather2.module;

public class ForecastData {
    private String week;
    private String date;
    private String description;
    private String highTemperate;

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHighTemperate() {
        return highTemperate;
    }

    public void setHighTemperate(String highTemperate) {
        this.highTemperate = highTemperate;
    }

    public String getLowTemperate() {
        return lowTemperate;
    }

    public void setLowTemperate(String lowTemperate) {
        this.lowTemperate = lowTemperate;
    }

    public ForecastData(String week, String date, String description, String highTemperate, String lowTemperate) {
        this.week = week;
        this.date = date;
        this.description = description;
        this.highTemperate = highTemperate;
        this.lowTemperate = lowTemperate;
    }

    private String lowTemperate;
}
