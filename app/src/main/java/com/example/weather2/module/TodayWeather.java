package com.example.weather2.module;

public class TodayWeather extends BaseData{


    //风向
    private String winddirect;
    //风速
    private String windspeed;
    //风力
    private String windpower;
    //气压
    private String airpressure;
    //天气现象
    private String phenomena;
    //相对湿度(%)
    private String humidity;
    //更新时间
    private String updatetime;
    //体感温度
    private String feelst;
    //降雨量
    private String rain;
    //气温
    private String temperature;
    public void setWindspeed(String windspeed) {
        this.windspeed = windspeed;
    }
    public String getWindspeed() {
        return windspeed;
    }

    public void setAirpressure(String airpressure) {
        this.airpressure = airpressure;
    }
    public String getAirpressure() {
        return airpressure;
    }

    public void setPhenomena(String phenomena) {
        this.phenomena = phenomena;
    }
    public String getPhenomena() {
        return phenomena;
    }


    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
    public String getHumidity() {
        return humidity;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
    public String getUpdatetime() {
        return updatetime;
    }

    public void setWindpower(String windpower) {
        this.windpower = windpower;
    }
    public String getWindpower() {
        return windpower;
    }

    public void setFeelst(String feelst) {
        this.feelst = feelst;
    }
    public String getFeelst() {
        return feelst;
    }

    public void setWinddirect(String winddirect) {
        this.winddirect = winddirect;
    }
    public String getWinddirect() {
        return winddirect;
    }


    public void setRain(String rain) {
        this.rain = rain;
    }
    public String getRain() {
        return rain;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "TodayWeather{" +
                "rcode=" + getRcode() +
                ", rdesc='" + getRdesc() + '\'' +
                ", winddirect='" + winddirect + '\'' +
                ", windspeed='" + windspeed + '\'' +
                ", windpower='" + windpower + '\'' +
                ", airpressure='" + airpressure + '\'' +
                ", phenomena='" + phenomena + '\'' +
                ", humidity='" + humidity + '\'' +
                ", updatetime='" + updatetime + '\'' +
                ", feelst='" + feelst + '\'' +
                ", rain='" + rain + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
