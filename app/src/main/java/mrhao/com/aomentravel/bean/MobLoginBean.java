package mrhao.com.aomentravel.bean;

public class MobLoginBean {
    /**
     * msg : success
     * result : {"token":"54ee73bd6312e2017f2f67b42025d904","uid":"07cbe57836582d65d98dcfea662cc0dd7d16d50b"}
     * retCode : 200
     */

    private String msg;
    private ResultBean result;
    private String retCode;

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
         * token : 54ee73bd6312e2017f2f67b42025d904
         * uid : 07cbe57836582d65d98dcfea662cc0dd7d16d50b
         */

        private String token;
        private String uid;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
