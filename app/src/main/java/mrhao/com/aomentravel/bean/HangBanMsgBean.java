package mrhao.com.aomentravel.bean;

import java.util.List;

public class HangBanMsgBean {


    /**
     * msg : success
     * result : [{"airLines":"上海航空公司","flightNo":"FM817","flightRate":"84%","flightTime":"2h8m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"12:40","planTime":"10:05","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"上海航空公司","flightNo":"FM2007","flightRate":"- -","flightTime":"2h35m","from":"浦东国际机场","fromAirportCode":"PVG","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"15:00","planTime":"12:25","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"中国东方航空公司","flightNo":"MU2055","flightRate":"84%","flightTime":"2h5m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"18:55","planTime":"15:50","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"澳门航空公司","flightNo":"NX135","flightRate":"63%","flightTime":"2h19m","from":"浦东国际机场","fromAirportCode":"PVG","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T2","planArriveTime":"19:35","planTime":"16:40","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"春秋航空公司","flightNo":"9C8875","flightRate":"82%","flightTime":"2h14m","from":"浦东国际机场","fromAirportCode":"PVG","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T2","planArriveTime":"10:40","planTime":"08:05","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"中国国际航空公司","flightNo":"CA5427","flightRate":"98%","flightTime":"2h5m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"12:00","planTime":"09:15","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"澳门航空公司","flightNo":"NX109","flightRate":"81%","flightTime":"2h6m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"16:45","planTime":"13:55","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"中国国际航空公司","flightNo":"CA5407","flightRate":"63%","flightTime":"2h19m","from":"浦东国际机场","fromAirportCode":"PVG","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T2","planArriveTime":"19:35","planTime":"16:40","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"澳门航空公司","flightNo":"NX137","flightRate":"98%","flightTime":"2h5m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"12:00","planTime":"09:15","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"中国东方航空公司","flightNo":"MU9817","flightRate":"84%","flightTime":"2h8m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"12:40","planTime":"10:05","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"中国东方航空公司","flightNo":"MU2007","flightRate":"- -","flightTime":"2h35m","from":"浦东国际机场","fromAirportCode":"PVG","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"15:00","planTime":"12:25","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"中国国际航空公司","flightNo":"CA5405","flightRate":"81%","flightTime":"2h6m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"16:45","planTime":"13:55","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"上海航空公司","flightNo":"FM2055","flightRate":"84%","flightTime":"2h5m","from":"虹桥国际机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"T1","planArriveTime":"18:55","planTime":"15:50","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"},{"airLines":"上海吉祥航空公司","flightNo":"HO1295","flightTime":"2h40m","from":"浦东机场","fromAirportCode":"SHA","fromCityCode":"SHA","fromCityName":"上海","fromTerminal":"","planArriveTime":"20:55","planTime":"18:15","to":"澳门机场","toAirportCode":"MFM","toCityCode":"MFM","toCityName":"澳门","toTerminal":"","week":"一,二,三,四,五,六,日"}]
     * retCode : 200
     */

    private String msg;
    private String retCode;
    private List<ResultBean> result;

    @Override
    public String toString() {
        return "HangBanMsgBean{" +
                "msg='" + msg + '\'' +
                ", retCode='" + retCode + '\'' +
                ", result=" + result +
                '}';
    }

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
         * airLines : 上海航空公司
         * flightNo : FM817
         * flightRate : 84%
         * flightTime : 2h8m
         * from : 虹桥国际机场
         * fromAirportCode : SHA
         * fromCityCode : SHA
         * fromCityName : 上海
         * fromTerminal : T1
         * planArriveTime : 12:40
         * planTime : 10:05
         * to : 澳门机场
         * toAirportCode : MFM
         * toCityCode : MFM
         * toCityName : 澳门
         * toTerminal :
         * week : 一,二,三,四,五,六,日
         */

        private String airLines;
        private String flightNo;
        private String flightRate;
        private String flightTime;
        private String from;
        private String fromAirportCode;
        private String fromCityCode;
        private String fromCityName;
        private String fromTerminal;
        private String planArriveTime;
        private String planTime;
        private String to;
        private String toAirportCode;
        private String toCityCode;
        private String toCityName;
        private String toTerminal;
        private String week;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "airLines='" + airLines + '\'' +
                    ", flightNo='" + flightNo + '\'' +
                    ", flightRate='" + flightRate + '\'' +
                    ", flightTime='" + flightTime + '\'' +
                    ", from='" + from + '\'' +
                    ", fromAirportCode='" + fromAirportCode + '\'' +
                    ", fromCityCode='" + fromCityCode + '\'' +
                    ", fromCityName='" + fromCityName + '\'' +
                    ", fromTerminal='" + fromTerminal + '\'' +
                    ", planArriveTime='" + planArriveTime + '\'' +
                    ", planTime='" + planTime + '\'' +
                    ", to='" + to + '\'' +
                    ", toAirportCode='" + toAirportCode + '\'' +
                    ", toCityCode='" + toCityCode + '\'' +
                    ", toCityName='" + toCityName + '\'' +
                    ", toTerminal='" + toTerminal + '\'' +
                    ", week='" + week + '\'' +
                    '}';
        }

        public String getAirLines() {
            return airLines;
        }

        public void setAirLines(String airLines) {
            this.airLines = airLines;
        }

        public String getFlightNo() {
            return flightNo;
        }

        public void setFlightNo(String flightNo) {
            this.flightNo = flightNo;
        }

        public String getFlightRate() {
            return flightRate;
        }

        public void setFlightRate(String flightRate) {
            this.flightRate = flightRate;
        }

        public String getFlightTime() {
            return flightTime;
        }

        public void setFlightTime(String flightTime) {
            this.flightTime = flightTime;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getFromAirportCode() {
            return fromAirportCode;
        }

        public void setFromAirportCode(String fromAirportCode) {
            this.fromAirportCode = fromAirportCode;
        }

        public String getFromCityCode() {
            return fromCityCode;
        }

        public void setFromCityCode(String fromCityCode) {
            this.fromCityCode = fromCityCode;
        }

        public String getFromCityName() {
            return fromCityName;
        }

        public void setFromCityName(String fromCityName) {
            this.fromCityName = fromCityName;
        }

        public String getFromTerminal() {
            return fromTerminal;
        }

        public void setFromTerminal(String fromTerminal) {
            this.fromTerminal = fromTerminal;
        }

        public String getPlanArriveTime() {
            return planArriveTime;
        }

        public void setPlanArriveTime(String planArriveTime) {
            this.planArriveTime = planArriveTime;
        }

        public String getPlanTime() {
            return planTime;
        }

        public void setPlanTime(String planTime) {
            this.planTime = planTime;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getToAirportCode() {
            return toAirportCode;
        }

        public void setToAirportCode(String toAirportCode) {
            this.toAirportCode = toAirportCode;
        }

        public String getToCityCode() {
            return toCityCode;
        }

        public void setToCityCode(String toCityCode) {
            this.toCityCode = toCityCode;
        }

        public String getToCityName() {
            return toCityName;
        }

        public void setToCityName(String toCityName) {
            this.toCityName = toCityName;
        }

        public String getToTerminal() {
            return toTerminal;
        }

        public void setToTerminal(String toTerminal) {
            this.toTerminal = toTerminal;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }
    }
}
