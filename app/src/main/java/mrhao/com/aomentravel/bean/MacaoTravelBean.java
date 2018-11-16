package mrhao.com.aomentravel.bean;

import java.util.List;

public class MacaoTravelBean {


    /**
     * id : 4266
     * name_zh_cn : 葡萄酒博物馆
     * name_en : Wine Museum
     * description : 葡萄酒博物馆与大赛车博物馆一样，位于新口岸旅游活动中心，于1995年开放，主要介绍葡萄酒的场所。
     * tips_html : <strong>#游玩指南#</strong>
     <p>主要介绍葡萄酒的场所。除了介绍酿酒、葡萄种植历史，浏览葡萄种植、酿制工具器皿和各种陈年葡萄酒酒之外，还可让游客品尝美酒。</p>
     <strong>#开放时间#</strong>
     <p>10：00－18：00，逢星期二休馆。</p>

     * user_score : null
     * photos_count : 13
     * attraction_trips_count : 4
     * lat : 22.194799
     * lng : 113.553001
     * attraction_type : null
     * address : 中国澳门高美士街
     * ctrip_id : 76039
     * updated_at : 1383808397
     * image_url : http://m.chanyouji.cn/attractions/4266.jpg
     * attractions_count : 678
     * activities_count : 0
     * restaurants_count : 22
     * attraction_trip_tags : []
     * destination : {"id":14,"name_zh_cn":"澳门"}
     * contributors : []
     * attractions : [{"id":4213,"name_zh_cn":"大赛车博物馆","user_score":null,"distance":0.0223501802555563,"image_url":"http://m.chanyouji.cn/attractions/4213.jpg"},{"id":4416,"name_zh_cn":"金莲花广场","user_score":"2.6","distance":0.10295592513697,"image_url":"http://m.chanyouji.cn/attractions/4416.jpg"},{"id":165433,"name_zh_cn":"金龙酒店","user_score":null,"distance":0.172336495306986,"image_url":"http://m.chanyouji.cn/attractions/165433-1.jpg"},{"id":165568,"name_zh_cn":"富都夜总会","user_score":null,"distance":0.175762071457138,"image_url":"http://m.chanyouji.cn/attractions/165568-1.jpg"},{"id":165432,"name_zh_cn":"回力娱乐城","user_score":null,"distance":0.306264916630906,"image_url":"http://m.chanyouji.cn/attractions/165432-1.jpg"},{"id":4211,"name_zh_cn":"东望洋炮台和灯塔","user_score":"4.0","distance":0.36793452951107,"image_url":"http://m.chanyouji.cn/attractions/4211.jpg"},{"id":165456,"name_zh_cn":"新口岸葡国餐厅","user_score":null,"distance":0.395707162471213,"image_url":"http://m.chanyouji.cn/attractions/165456.jpg"},{"id":165262,"name_zh_cn":"丹桂轩","user_score":null,"distance":0.445210361718439,"image_url":"http://m.chanyouji.cn/attractions/165262.jpg"},{"id":13530,"name_zh_cn":"渔人码头","user_score":"3.88","distance":0.516109276920209,"image_url":"http://m.chanyouji.cn/attractions/13530.jpg"},{"id":165566,"name_zh_cn":"奥斯卡酒吧","user_score":null,"distance":0.637931765833584,"image_url":"http://m.chanyouji.cn/attractions/165566.jpg"}]
     * hotels : [{"id":8727,"name_zh_cn":"金龙酒店","distance":0.157800203083573,"image_url":"http://m.chanyouji.cn/hotels/8727.jpg"},{"id":8686,"name_zh_cn":"永利澳门酒店","distance":0.157800203083573,"image_url":"http://m.chanyouji.cn/hotels/8686.jpg"},{"id":8692,"name_zh_cn":"星际酒店","distance":0.211011533376784,"image_url":"http://m.chanyouji.cn/hotels/8692.jpg"},{"id":8706,"name_zh_cn":"皇家金堡酒店","distance":0.216391699379047,"image_url":"http://m.chanyouji.cn/hotels/8706.jpg"},{"id":8684,"name_zh_cn":"澳门文华东方酒店","distance":0.326314066733241,"image_url":"http://m.chanyouji.cn/hotels/8684.jpg"},{"id":8708,"name_zh_cn":"澳门莱斯酒店","distance":0.47437292241065,"image_url":"http://m.chanyouji.cn/hotels/8708.jpg"},{"id":8726,"name_zh_cn":"富豪酒店","distance":0.833698849635606,"image_url":"http://m.chanyouji.cn/hotels/8726.jpg"},{"id":8696,"name_zh_cn":"葡京酒店","distance":1.08038133589427,"image_url":"http://m.chanyouji.cn/hotels/8696.jpg"},{"id":8699,"name_zh_cn":"澳门新葡京酒店","distance":1.09078428595781,"image_url":"http://m.chanyouji.cn/hotels/8699.jpg"},{"id":8694,"name_zh_cn":"澳门美高梅","distance":1.09332859885648,"image_url":"http://m.chanyouji.cn/hotels/8694.jpg"}]
     * current_user_favorite : false
     */



    private int id;
    private String name_zh_cn;
    private String name_en;
    private String description;
    private String tips_html;
    private Object user_score;
    private int photos_count;
    private int attraction_trips_count;
    private String lat;
    private String lng;
    private Object attraction_type;
    private String address;
    private int ctrip_id;
    private int updated_at;
    private String image_url;
    private int attractions_count;
    private int activities_count;
    private int restaurants_count;
    private DestinationBean destination;
    private boolean current_user_favorite;
    private List<?> attraction_trip_tags;
    private List<?> contributors;
    private List<AttractionsBean> attractions;
    private List<HotelsBean> hotels;

    @Override
    public String toString() {
        return "MacaoTravelBean{" +
                "id=" + id +
                ", name_zh_cn='" + name_zh_cn + '\'' +
                ", name_en='" + name_en + '\'' +
                ", description='" + description + '\'' +
                ", tips_html='" + tips_html + '\'' +
                ", user_score=" + user_score +
                ", photos_count=" + photos_count +
                ", attraction_trips_count=" + attraction_trips_count +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", attraction_type=" + attraction_type +
                ", address='" + address + '\'' +
                ", ctrip_id=" + ctrip_id +
                ", updated_at=" + updated_at +
                ", image_url='" + image_url + '\'' +
                ", attractions_count=" + attractions_count +
                ", activities_count=" + activities_count +
                ", restaurants_count=" + restaurants_count +
                ", destination=" + destination +
                ", current_user_favorite=" + current_user_favorite +
                ", attraction_trip_tags=" + attraction_trip_tags +
                ", contributors=" + contributors +
                ", attractions=" + attractions +
                ", hotels=" + hotels +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_zh_cn() {
        return name_zh_cn;
    }

    public void setName_zh_cn(String name_zh_cn) {
        this.name_zh_cn = name_zh_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTips_html() {
        return tips_html;
    }

    public void setTips_html(String tips_html) {
        this.tips_html = tips_html;
    }

    public Object getUser_score() {
        return user_score;
    }

    public void setUser_score(Object user_score) {
        this.user_score = user_score;
    }

    public int getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(int photos_count) {
        this.photos_count = photos_count;
    }

    public int getAttraction_trips_count() {
        return attraction_trips_count;
    }

    public void setAttraction_trips_count(int attraction_trips_count) {
        this.attraction_trips_count = attraction_trips_count;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Object getAttraction_type() {
        return attraction_type;
    }

    public void setAttraction_type(Object attraction_type) {
        this.attraction_type = attraction_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCtrip_id() {
        return ctrip_id;
    }

    public void setCtrip_id(int ctrip_id) {
        this.ctrip_id = ctrip_id;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getAttractions_count() {
        return attractions_count;
    }

    public void setAttractions_count(int attractions_count) {
        this.attractions_count = attractions_count;
    }

    public int getActivities_count() {
        return activities_count;
    }

    public void setActivities_count(int activities_count) {
        this.activities_count = activities_count;
    }

    public int getRestaurants_count() {
        return restaurants_count;
    }

    public void setRestaurants_count(int restaurants_count) {
        this.restaurants_count = restaurants_count;
    }

    public DestinationBean getDestination() {
        return destination;
    }

    public void setDestination(DestinationBean destination) {
        this.destination = destination;
    }

    public boolean isCurrent_user_favorite() {
        return current_user_favorite;
    }

    public void setCurrent_user_favorite(boolean current_user_favorite) {
        this.current_user_favorite = current_user_favorite;
    }

    public List<?> getAttraction_trip_tags() {
        return attraction_trip_tags;
    }

    public void setAttraction_trip_tags(List<?> attraction_trip_tags) {
        this.attraction_trip_tags = attraction_trip_tags;
    }

    public List<?> getContributors() {
        return contributors;
    }

    public void setContributors(List<?> contributors) {
        this.contributors = contributors;
    }

    public List<AttractionsBean> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<AttractionsBean> attractions) {
        this.attractions = attractions;
    }

    public List<HotelsBean> getHotels() {
        return hotels;
    }

    public void setHotels(List<HotelsBean> hotels) {
        this.hotels = hotels;
    }

    public static class DestinationBean {
        /**
         * id : 14
         * name_zh_cn : 澳门
         */

        private int id;
        private String name_zh_cn;

        @Override
        public String toString() {
            return "DestinationBean{" +
                    "id=" + id +
                    ", name_zh_cn='" + name_zh_cn + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }
    }

    public static class AttractionsBean {
        /**
         * id : 4213
         * name_zh_cn : 大赛车博物馆
         * user_score : null
         * distance : 0.0223501802555563
         * image_url : http://m.chanyouji.cn/attractions/4213.jpg
         */

        private int id;
        private String name_zh_cn;
        private Object user_score;
        private double distance;
        private String image_url;

        @Override
        public String toString() {
            return "AttractionsBean{" +
                    "id=" + id +
                    ", name_zh_cn='" + name_zh_cn + '\'' +
                    ", user_score=" + user_score +
                    ", distance=" + distance +
                    ", image_url='" + image_url + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }

        public Object getUser_score() {
            return user_score;
        }

        public void setUser_score(Object user_score) {
            this.user_score = user_score;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }

    public static class HotelsBean {
        /**
         * id : 8727
         * name_zh_cn : 金龙酒店
         * distance : 0.157800203083573
         * image_url : http://m.chanyouji.cn/hotels/8727.jpg
         */

        private int id;
        private String name_zh_cn;
        private double distance;
        private String image_url;

        @Override
        public String toString() {
            return "HotelsBean{" +
                    "id=" + id +
                    ", name_zh_cn='" + name_zh_cn + '\'' +
                    ", distance=" + distance +
                    ", image_url='" + image_url + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName_zh_cn() {
            return name_zh_cn;
        }

        public void setName_zh_cn(String name_zh_cn) {
            this.name_zh_cn = name_zh_cn;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}
