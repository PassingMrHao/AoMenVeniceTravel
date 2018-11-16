package mrhao.com.aomentravel.bean;

import java.util.List;

public class CollectListBean {

    private List<DataBean> data;

    @Override
    public String toString() {
        return "CollectListBean{" +
                "data=" + data +
                '}';
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 21
         * userid : ceshi004
         * type : 折扣
         * title : SNP、巴宝莉、SwissRituel等低至3.6折优惠
         * image : https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2018090412223323204.jpg
         * tag : 化妆品
         * weburl : https://api.koudaihk.com:4432/api/info/discountDetail.html?objectId=20835
         */

        private String id;
        private String userid;
        private String type;
        private String title;
        private String image;
        private String tag;
        private String weburl;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", userid='" + userid + '\'' +
                    ", type='" + type + '\'' +
                    ", title='" + title + '\'' +
                    ", image='" + image + '\'' +
                    ", tag='" + tag + '\'' +
                    ", weburl='" + weburl + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getWeburl() {
            return weburl;
        }

        public void setWeburl(String weburl) {
            this.weburl = weburl;
        }
    }
}
