package mrhao.com.aomentravel.bean;

public class MobJieMianBean {
    /**
     * msg : success
     * result : {"k":"yuansheng","updateTime":1530234104473,"v":"1"}
     * retCode : 200
     */

    private String msg;
    private ResultBean result;
    private String retCode;


    @Override
    public String toString() {
        return "MobJieMianBean{" +
                "msg='" + msg + '\'' +
                ", result=" + result +
                ", retCode='" + retCode + '\'' +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public static class ResultBean {
        /**
         * k : yuansheng
         * updateTime : 1530234104473
         * v : 1
         */

        private String k;
        private long updateTime;
        private String v;

        @Override
        public String toString() {
            return "ResultBean{" +
                    "k='" + k + '\'' +
                    ", updateTime=" + updateTime +
                    ", v='" + v + '\'' +
                    '}';
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }
}
