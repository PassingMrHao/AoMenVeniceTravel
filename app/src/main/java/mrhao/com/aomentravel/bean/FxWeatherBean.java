package mrhao.com.aomentravel.bean;

import java.util.List;

public class FxWeatherBean {


    /**
     * msg : success
     * result : [{"airCondition":"良","airQuality":{"aqi":69,"city":"澳门","district":"澳门","fetureData":[{"aqi":58,"date":"2018-10-24","quality":"良"},{"aqi":51,"date":"2018-10-25","quality":"良"},{"aqi":71,"date":"2018-10-26","quality":"良"},{"aqi":98,"date":"2018-10-27","quality":"良"},{"aqi":103,"date":"2018-10-28","quality":"轻度污染"}],"province":"澳门","quality":"良","updateTime":"2018-10-23 09:00:00"},"city":"澳门","coldIndex":"低发期","date":"2018-10-23","distrct":"澳门","dressingIndex":"薄短袖类","exerciseIndex":"不适宜","future":[{"date":"2018-10-23","dayTime":"多云","night":"小雨","temperature":"28°C / 23°C","week":"今天","wind":"无持续风向 小于3级"},{"date":"2018-10-24","dayTime":"多云","night":"多云","temperature":"28°C / 24°C","week":"星期三","wind":"东风 3～4级"},{"date":"2018-10-25","dayTime":"多云","night":"多云","temperature":"29°C / 23°C","week":"星期四","wind":"无持续风向 小于3级"},{"date":"2018-10-26","dayTime":"阵雨","night":"阴","temperature":"28°C / 22°C","week":"星期五","wind":"微风 小于3级"},{"date":"2018-10-27","dayTime":"多云","night":"多云","temperature":"26°C / 22°C","week":"星期六","wind":"微风 小于3级"},{"date":"2018-10-28","dayTime":"多云","night":"晴","temperature":"26°C / 23°C","week":"星期日","wind":"微风 小于3级"}],"humidity":"湿度：81%","pollutionIndex":"69","province":"澳门","sunrise":"06:10","sunset":"18:36","temperature":"25℃","time":"09:43","updateTime":"20181023095953","washIndex":"不太适宜","weather":"晴","week":"周二","wind":"北风3级"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * airCondition : 良
         * airQuality : {"aqi":69,"city":"澳门","district":"澳门","fetureData":[{"aqi":58,"date":"2018-10-24","quality":"良"},{"aqi":51,"date":"2018-10-25","quality":"良"},{"aqi":71,"date":"2018-10-26","quality":"良"},{"aqi":98,"date":"2018-10-27","quality":"良"},{"aqi":103,"date":"2018-10-28","quality":"轻度污染"}],"province":"澳门","quality":"良","updateTime":"2018-10-23 09:00:00"}
         * city : 澳门
         * coldIndex : 低发期
         * date : 2018-10-23
         * distrct : 澳门
         * dressingIndex : 薄短袖类
         * exerciseIndex : 不适宜
         * future : [{"date":"2018-10-23","dayTime":"多云","night":"小雨","temperature":"28°C / 23°C","week":"今天","wind":"无持续风向 小于3级"},{"date":"2018-10-24","dayTime":"多云","night":"多云","temperature":"28°C / 24°C","week":"星期三","wind":"东风 3～4级"},{"date":"2018-10-25","dayTime":"多云","night":"多云","temperature":"29°C / 23°C","week":"星期四","wind":"无持续风向 小于3级"},{"date":"2018-10-26","dayTime":"阵雨","night":"阴","temperature":"28°C / 22°C","week":"星期五","wind":"微风 小于3级"},{"date":"2018-10-27","dayTime":"多云","night":"多云","temperature":"26°C / 22°C","week":"星期六","wind":"微风 小于3级"},{"date":"2018-10-28","dayTime":"多云","night":"晴","temperature":"26°C / 23°C","week":"星期日","wind":"微风 小于3级"}]
         * humidity : 湿度：81%
         * pollutionIndex : 69
         * province : 澳门
         * sunrise : 06:10
         * sunset : 18:36
         * temperature : 25℃
         * time : 09:43
         * updateTime : 20181023095953
         * washIndex : 不太适宜
         * weather : 晴
         * week : 周二
         * wind : 北风3级
         */

        private String airCondition;
        private AirQualityBean airQuality;
        private String city;
        private String coldIndex;
        private String date;
        private String distrct;
        private String dressingIndex;
        private String exerciseIndex;
        private String humidity;
        private String pollutionIndex;
        private String province;
        private String sunrise;
        private String sunset;
        private String temperature;
        private String time;
        private String updateTime;
        private String washIndex;
        private String weather;
        private String week;
        private String wind;
        private List<FutureBean> future;

        public String getAirCondition() {
            return airCondition;
        }

        public void setAirCondition(String airCondition) {
            this.airCondition = airCondition;
        }

        public AirQualityBean getAirQuality() {
            return airQuality;
        }

        public void setAirQuality(AirQualityBean airQuality) {
            this.airQuality = airQuality;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getColdIndex() {
            return coldIndex;
        }

        public void setColdIndex(String coldIndex) {
            this.coldIndex = coldIndex;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDistrct() {
            return distrct;
        }

        public void setDistrct(String distrct) {
            this.distrct = distrct;
        }

        public String getDressingIndex() {
            return dressingIndex;
        }

        public void setDressingIndex(String dressingIndex) {
            this.dressingIndex = dressingIndex;
        }

        public String getExerciseIndex() {
            return exerciseIndex;
        }

        public void setExerciseIndex(String exerciseIndex) {
            this.exerciseIndex = exerciseIndex;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getPollutionIndex() {
            return pollutionIndex;
        }

        public void setPollutionIndex(String pollutionIndex) {
            this.pollutionIndex = pollutionIndex;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getWashIndex() {
            return washIndex;
        }

        public void setWashIndex(String washIndex) {
            this.washIndex = washIndex;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class AirQualityBean {
            /**
             * aqi : 69
             * city : 澳门
             * district : 澳门
             * fetureData : [{"aqi":58,"date":"2018-10-24","quality":"良"},{"aqi":51,"date":"2018-10-25","quality":"良"},{"aqi":71,"date":"2018-10-26","quality":"良"},{"aqi":98,"date":"2018-10-27","quality":"良"},{"aqi":103,"date":"2018-10-28","quality":"轻度污染"}]
             * province : 澳门
             * quality : 良
             * updateTime : 2018-10-23 09:00:00
             */

            private int aqi;
            private String city;
            private String district;
            private String province;
            private String quality;
            private String updateTime;
            private List<FetureDataBean> fetureData;

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public List<FetureDataBean> getFetureData() {
                return fetureData;
            }

            public void setFetureData(List<FetureDataBean> fetureData) {
                this.fetureData = fetureData;
            }

            public static class FetureDataBean {
                /**
                 * aqi : 58
                 * date : 2018-10-24
                 * quality : 良
                 */

                private int aqi;
                private String date;
                private String quality;

                public int getAqi() {
                    return aqi;
                }

                public void setAqi(int aqi) {
                    this.aqi = aqi;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getQuality() {
                    return quality;
                }

                public void setQuality(String quality) {
                    this.quality = quality;
                }
            }
        }

        public static class FutureBean {
            /**
             * date : 2018-10-23
             * dayTime : 多云
             * night : 小雨
             * temperature : 28°C / 23°C
             * week : 今天
             * wind : 无持续风向 小于3级
             */

            private String date;
            private String dayTime;
            private String night;
            private String temperature;
            private String week;
            private String wind;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getDayTime() {
                return dayTime;
            }

            public void setDayTime(String dayTime) {
                this.dayTime = dayTime;
            }

            public String getNight() {
                return night;
            }

            public void setNight(String night) {
                this.night = night;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }
        }
    }
}
