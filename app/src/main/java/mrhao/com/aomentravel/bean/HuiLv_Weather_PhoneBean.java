package mrhao.com.aomentravel.bean;

import java.util.List;

public class HuiLv_Weather_PhoneBean {


    /**
     * data : {"exchangeRate":{"CNYToHKDRateValue":1.1489,"date":"2018-08-28 11:40:09","CNYToMOPRateValue":1.1808},"weathers":[{"date":"08/28","week":"今天","desc":"中雨转大雨","temperature":"25~30℃"},{"date":"08/29","week":"明天","desc":"大雨","temperature":"24~30℃"},{"date":"08/30","week":"周四","desc":"大雨转中雨","temperature":"26~30℃"},{"date":"08/31","week":"周五","desc":"中雨转阵雨","temperature":"27~30℃"},{"date":"09/01","week":"周六","desc":"阵雨","temperature":"26~31℃"},{"date":"09/02","week":"周日","desc":"阵雨","temperature":"27~31℃"},{"date":"09/03","week":"周一","desc":"中雨","temperature":"27~30℃"}],"usefulNumbers":[{"telephone":"+853 8397 1120","title":"议事厅前地利斯大厦（开放时间：09:00-18:00）"},{"telephone":"+853 2872 6416","title":"外港客运码头（开放时间：09:00-22:00）"},{"telephone":"+853 2843 9310","title":"关闸（开放时间：09:15-18:00）"},{"telephone":"+853 2885 0438","title":"氹仔临时客运码头（开放时间：早上09:30-13:00  下午14:30-18:15）"},{"telephone":"999","title":"紧急报警求助热线"},{"telephone":"+853 2886 1436","title":"澳门国际机场（开放时间：早上09:30-13:30  下午14:15-19:30  晚上20:15-22:00）"},{"telephone":"+853 2831 3731","title":"仁伯爵综合医院"},{"telephone":"+853 2837 1333","title":"镜湖医院"},{"telephone":"+853 2886 1111","title":"机场服务"},{"telephone":"+853 2882 1838","title":"科大医院"},{"telephone":"+853 2833 3000","title":"旅游热线"},{"telephone":"+853 8988  9315","title":"消费者委员会"}]}
     * message : 获取成功
     * status : 0
     */

    private DataBean data;
    private String message;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * exchangeRate : {"CNYToHKDRateValue":1.1489,"date":"2018-08-28 11:40:09","CNYToMOPRateValue":1.1808}
         * weathers : [{"date":"08/28","week":"今天","desc":"中雨转大雨","temperature":"25~30℃"},{"date":"08/29","week":"明天","desc":"大雨","temperature":"24~30℃"},{"date":"08/30","week":"周四","desc":"大雨转中雨","temperature":"26~30℃"},{"date":"08/31","week":"周五","desc":"中雨转阵雨","temperature":"27~30℃"},{"date":"09/01","week":"周六","desc":"阵雨","temperature":"26~31℃"},{"date":"09/02","week":"周日","desc":"阵雨","temperature":"27~31℃"},{"date":"09/03","week":"周一","desc":"中雨","temperature":"27~30℃"}]
         * usefulNumbers : [{"telephone":"+853 8397 1120","title":"议事厅前地利斯大厦（开放时间：09:00-18:00）"},{"telephone":"+853 2872 6416","title":"外港客运码头（开放时间：09:00-22:00）"},{"telephone":"+853 2843 9310","title":"关闸（开放时间：09:15-18:00）"},{"telephone":"+853 2885 0438","title":"氹仔临时客运码头（开放时间：早上09:30-13:00  下午14:30-18:15）"},{"telephone":"999","title":"紧急报警求助热线"},{"telephone":"+853 2886 1436","title":"澳门国际机场（开放时间：早上09:30-13:30  下午14:15-19:30  晚上20:15-22:00）"},{"telephone":"+853 2831 3731","title":"仁伯爵综合医院"},{"telephone":"+853 2837 1333","title":"镜湖医院"},{"telephone":"+853 2886 1111","title":"机场服务"},{"telephone":"+853 2882 1838","title":"科大医院"},{"telephone":"+853 2833 3000","title":"旅游热线"},{"telephone":"+853 8988  9315","title":"消费者委员会"}]
         */

        private ExchangeRateBean exchangeRate;
        private List<WeathersBean> weathers;
        private List<UsefulNumbersBean> usefulNumbers;

        public ExchangeRateBean getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(ExchangeRateBean exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        public List<WeathersBean> getWeathers() {
            return weathers;
        }

        public void setWeathers(List<WeathersBean> weathers) {
            this.weathers = weathers;
        }

        public List<UsefulNumbersBean> getUsefulNumbers() {
            return usefulNumbers;
        }

        public void setUsefulNumbers(List<UsefulNumbersBean> usefulNumbers) {
            this.usefulNumbers = usefulNumbers;
        }

        public static class ExchangeRateBean {
            /**
             * CNYToHKDRateValue : 1.1489
             * date : 2018-08-28 11:40:09
             * CNYToMOPRateValue : 1.1808
             */

            private double CNYToHKDRateValue;
            private String date;
            private double CNYToMOPRateValue;

            public double getCNYToHKDRateValue() {
                return CNYToHKDRateValue;
            }

            public void setCNYToHKDRateValue(double CNYToHKDRateValue) {
                this.CNYToHKDRateValue = CNYToHKDRateValue;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public double getCNYToMOPRateValue() {
                return CNYToMOPRateValue;
            }

            public void setCNYToMOPRateValue(double CNYToMOPRateValue) {
                this.CNYToMOPRateValue = CNYToMOPRateValue;
            }
        }

        public static class WeathersBean {
            /**
             * date : 08/28
             * week : 今天
             * desc : 中雨转大雨
             * temperature : 25~30℃
             */

            private String date;
            private String week;
            private String desc;
            private String temperature;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }
        }

        public static class UsefulNumbersBean {
            /**
             * telephone : +853 8397 1120
             * title : 议事厅前地利斯大厦（开放时间：09:00-18:00）
             */

            private String telephone;
            private String title;

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
