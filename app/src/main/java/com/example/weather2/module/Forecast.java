package com.example.weather2.module;

import java.util.List;

public class Forecast extends BaseData{
    private List<Forecast> forecast;

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
    public List<Forecast> getForecast() {
        return forecast;
    }

    public class ForecastEntity {


        private Wind wind;
        private String hum;
        private Astro astro;
        private String pcpn;
        private String uv;
        private Tmp tmp;
        private String pop;
        private String pres;
        private String date;
        private Cond cond;
        private String vis;

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Wind getWind() {
            return wind;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getHum() {
            return hum;
        }

        public void setAstro(Astro astro) {
            this.astro = astro;
        }

        public Astro getAstro() {
            return astro;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setUv(String uv) {
            this.uv = uv;
        }

        public String getUv() {
            return uv;
        }

        public void setTmp(Tmp tmp) {
            this.tmp = tmp;
        }

        public Tmp getTmp() {
            return tmp;
        }

        public void setPop(String pop) {
            this.pop = pop;
        }

        public String getPop() {
            return pop;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getPres() {
            return pres;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public void setCond(Cond cond) {
            this.cond = cond;
        }

        public Cond getCond() {
            return cond;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public String getVis() {
            return vis;
        }

        public class Wind {

            private String dir;
            private String deg;
            private String sc;
            private String spd;
            public void setDir(String dir) {
                this.dir = dir;
            }
            public String getDir() {
                return dir;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }
            public String getDeg() {
                return deg;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }
            public String getSc() {
                return sc;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
            public String getSpd() {
                return spd;
            }

        }

        public class Astro {

            private String mr;
            private String sr;
            private String ms;
            private String ss;
            public void setMr(String mr) {
                this.mr = mr;
            }
            public String getMr() {
                return mr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }
            public String getSr() {
                return sr;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }
            public String getMs() {
                return ms;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }
            public String getSs() {
                return ss;
            }

        }

        public class Tmp {

            private String min;
            private String max;
            public void setMin(String min) {
                this.min = min;
            }
            public String getMin() {
                return min;
            }

            public void setMax(String max) {
                this.max = max;
            }
            public String getMax() {
                return max;
            }

        }


        public class Cond {

            private String cond_n;
            private String cond_d;
            public void setCond_n(String cond_n) {
                this.cond_n = cond_n;
            }
            public String getCond_n() {
                return cond_n;
            }

            public void setCond_d(String cond_d) {
                this.cond_d = cond_d;
            }
            public String getCond_d() {
                return cond_d;
            }

        }
    }

}
