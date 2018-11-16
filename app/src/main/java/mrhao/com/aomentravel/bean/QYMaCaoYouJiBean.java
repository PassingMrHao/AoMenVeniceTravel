package mrhao.com.aomentravel.bean;

import java.io.Serializable;
import java.util.List;

public class QYMaCaoYouJiBean implements Serializable {

    /**
     * id : 1467
     * made_at : 2013-08-24T23:29:52.000Z
     * likes_count : 10
     * comments_count : 10
     * topic : 跟着乐团去旅行—《澳门随想》
     * contents_count : 9
     * district_id : 39
     * created_at : 2015-10-21T09:35:21.000Z
     * favorites_count : 1
     * parent_district_id : 39
     * parent_district_count : 1
     * description : 我的工作性质可以使我有机会 以演出的名义去到各个地方旅游 这次恰好与澳门中乐团合作 有机会来到这个在清朝就与西班牙签定《中葡会议》《中葡友好通商条约》 而今又以堵为生的城市
     * current_user_liked :
     * current_user_commented :
     * current_user_favorited :
     * contents : [{"id":3946,"caption":"我住的酒店 上面正好是一座教堂 听人说在上面可以看到澳门桥的全景。索性来一张","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3946/f41c41876274906e8ffbb078b51ebd34.jpg","width":1920,"height":1276,"position":0},{"id":3947,"caption":"这次音乐会的开场曲《澳门随想》","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3947/dcacc2073d775593cc15f00f722e41f7.jpg","width":1920,"height":1284,"position":1},{"id":3948,"caption":"在熟悉不过了 三八大牌坊 屡次在电视上看到过 澳门最具代表性的建筑 1580年竣工的圣保禄大教堂的前壁 此教堂融合了欧洲文艺复兴时期与东方建筑的风格而成","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3948/8de0b594b6772c83792175f6c56b96c3.jpg","width":1920,"height":1280,"position":2},{"id":3949,"caption":"澳门永利酒店加赌场 这里每天晚上都会有喷泉 是澳门荣获《福布斯旅游指南》五星级及水疗康体中心殊荣的综合式度假酒店 ","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3949/354559228fd702b783ebaa7ff86db979.jpg","width":1920,"height":1280,"position":3},{"id":3950,"caption":"这里是澳门威尼斯人度假酒店。好多人看来照片说澳门的天真\u201c蓝\u201d啊 哈哈。其实是人工造的的天空 澳门威尼斯人其建筑特式依照美国拉斯维加斯的威尼斯人度假酒店 以威尼斯人水乡为主题 酒店范围内是充满威尼斯特色的拱桥 小运河 石板路","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3950/9da63a74b97ea2adb514bd84d8458218.jpg","width":1920,"height":1280,"position":4},{"id":3951,"caption":null,"photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3951/9436c07e05424076fc1a98a25b764432.jpg","width":1920,"height":1280,"position":5},{"id":3952,"caption":"澳门大赛车博物馆 为纪念格兰披治大赛车40周年而成立的博物馆 会场展出30多部过去曾在澳门获奖赛车 包括舒马赫 塞纳等人的赛车 ","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3952/14804f004f71128e792df502c9578b1d.jpg","width":1920,"height":1284,"position":6},{"id":3953,"caption":"很巧的是赛车博物馆的对面就是澳门葡萄酒博物馆 里面的酒全都是西班牙进口的 没有关税 价格非常非常的便宜。好笑的是我不会说英语 让随行的同事帮忙翻译 他把能用的英语加粤语全都用上了 结果我说不买了 再考虑一下吧 哈哈","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3953/7ab7ea1931b79e1f00b11b73b0da1c3c.jpg","width":1920,"height":1280,"position":7},{"id":3954,"caption":"澳门最有特色的一家海鲜锅 爽","photo_url":"http://inspiration.chanyouji.cn/UserActivityContent/3954/19ef51bf6d54334b1f37641db4040330.jpg","width":1920,"height":1280,"position":8}]
     * districts : [{"id":39,"name":"澳门","name_en":"Macau","name_pinyin":"ao men|am","score":null,"level":3,"path":".120001.110000.39.","published":false,"is_in_china":true,"user_activities_count":467,"lat":22.1638,"lng":113.555,"is_valid_destination":true,"destination_id":49}]
     * categories : []
     * poi : null
     * user : {"id":2127,"name":"義水泛舟","gender":1,"level":3,"photo_url":"http://inspiration.chanyouji.cn/User/2127/c7b917a312ac8b780263da226e115ce5.jpg"}
     * inspiration_activity_id : 0
     * inspiration_activity : null
     * p : 1
     */

    private String id;
    private String made_at;
    private String likes_count;
    private String comments_count;
    private String topic;
    private String contents_count;
    private String district_id;
    private String created_at;
    private String favorites_count;
    private String parent_district_id;
    private String parent_district_count;
    private String description;
    private String current_user_liked;
    private String current_user_commented;
    private String current_user_favorited;
    private String categories;
    private Object poi;
    private UserBean user;
    private String inspiration_activity_id;
    private Object inspiration_activity;
    private String p;
    private List<ContentsBean> contents;
    private List<DistrictsBean> districts;

    @Override
    public String toString() {
        return "QYMaCaoYouJiBean{" +
                "id='" + id + '\'' +
                ", made_at='" + made_at + '\'' +
                ", likes_count='" + likes_count + '\'' +
                ", comments_count='" + comments_count + '\'' +
                ", topic='" + topic + '\'' +
                ", contents_count='" + contents_count + '\'' +
                ", district_id='" + district_id + '\'' +
                ", created_at='" + created_at + '\'' +
                ", favorites_count='" + favorites_count + '\'' +
                ", parent_district_id='" + parent_district_id + '\'' +
                ", parent_district_count='" + parent_district_count + '\'' +
                ", description='" + description + '\'' +
                ", current_user_liked='" + current_user_liked + '\'' +
                ", current_user_commented='" + current_user_commented + '\'' +
                ", current_user_favorited='" + current_user_favorited + '\'' +
                ", categories='" + categories + '\'' +
                ", poi=" + poi +
                ", user=" + user +
                ", inspiration_activity_id='" + inspiration_activity_id + '\'' +
                ", inspiration_activity=" + inspiration_activity +
                ", p='" + p + '\'' +
                ", contents=" + contents +
                ", districts=" + districts +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMade_at() {
        return made_at;
    }

    public void setMade_at(String made_at) {
        this.made_at = made_at;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContents_count() {
        return contents_count;
    }

    public void setContents_count(String contents_count) {
        this.contents_count = contents_count;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(String favorites_count) {
        this.favorites_count = favorites_count;
    }

    public String getParent_district_id() {
        return parent_district_id;
    }

    public void setParent_district_id(String parent_district_id) {
        this.parent_district_id = parent_district_id;
    }

    public String getParent_district_count() {
        return parent_district_count;
    }

    public void setParent_district_count(String parent_district_count) {
        this.parent_district_count = parent_district_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrent_user_liked() {
        return current_user_liked;
    }

    public void setCurrent_user_liked(String current_user_liked) {
        this.current_user_liked = current_user_liked;
    }

    public String getCurrent_user_commented() {
        return current_user_commented;
    }

    public void setCurrent_user_commented(String current_user_commented) {
        this.current_user_commented = current_user_commented;
    }

    public String getCurrent_user_favorited() {
        return current_user_favorited;
    }

    public void setCurrent_user_favorited(String current_user_favorited) {
        this.current_user_favorited = current_user_favorited;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Object getPoi() {
        return poi;
    }

    public void setPoi(Object poi) {
        this.poi = poi;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getInspiration_activity_id() {
        return inspiration_activity_id;
    }

    public void setInspiration_activity_id(String inspiration_activity_id) {
        this.inspiration_activity_id = inspiration_activity_id;
    }

    public Object getInspiration_activity() {
        return inspiration_activity;
    }

    public void setInspiration_activity(Object inspiration_activity) {
        this.inspiration_activity = inspiration_activity;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public List<ContentsBean> getContents() {
        return contents;
    }

    public void setContents(List<ContentsBean> contents) {
        this.contents = contents;
    }

    public List<DistrictsBean> getDistricts() {
        return districts;
    }

    public void setDistricts(List<DistrictsBean> districts) {
        this.districts = districts;
    }

    public static class UserBean implements Serializable{
        /**
         * id : 2127
         * name : 義水泛舟
         * gender : 1
         * level : 3
         * photo_url : http://inspiration.chanyouji.cn/User/2127/c7b917a312ac8b780263da226e115ce5.jpg
         */

        private int id;
        private String name;
        private int gender;
        private int level;
        private String photo_url;

        @Override
        public String toString() {
            return "UserBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", level=" + level +
                    ", photo_url='" + photo_url + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }
    }

    public static class ContentsBean implements Serializable{
        /**
         * id : 3946
         * caption : 我住的酒店 上面正好是一座教堂 听人说在上面可以看到澳门桥的全景。索性来一张
         * photo_url : http://inspiration.chanyouji.cn/UserActivityContent/3946/f41c41876274906e8ffbb078b51ebd34.jpg
         * width : 1920
         * height : 1276
         * position : 0
         */

        private int id;
        private String caption;
        private String photo_url;
        private int width;
        private int height;
        private int position;

        @Override
        public String toString() {
            return "ContentsBean{" +
                    "id=" + id +
                    ", caption='" + caption + '\'' +
                    ", photo_url='" + photo_url + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    ", position=" + position +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getPhoto_url() {
            return photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    public static class DistrictsBean implements Serializable{
        /**
         * id : 39
         * name : 澳门
         * name_en : Macau
         * name_pinyin : ao men|am
         * score : null
         * level : 3
         * path : .120001.110000.39.
         * published : false
         * is_in_china : true
         * user_activities_count : 467
         * lat : 22.1638
         * lng : 113.555
         * is_valid_destination : true
         * destination_id : 49
         */
        private int id;
        private String name;
        private String name_en;
        private String name_pinyin;
        private Object score;
        private int level;
        private String path;
        private boolean published;
        private boolean is_in_china;
        private int user_activities_count;
        private double lat;
        private double lng;
        private boolean is_valid_destination;
        private int destination_id;

        @Override
        public String toString() {
            return "DistrictsBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", name_en='" + name_en + '\'' +
                    ", name_pinyin='" + name_pinyin + '\'' +
                    ", score=" + score +
                    ", level=" + level +
                    ", path='" + path + '\'' +
                    ", published=" + published +
                    ", is_in_china=" + is_in_china +
                    ", user_activities_count=" + user_activities_count +
                    ", lat=" + lat +
                    ", lng=" + lng +
                    ", is_valid_destination=" + is_valid_destination +
                    ", destination_id=" + destination_id +
                    '}';
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName_en() {
            return name_en;
        }

        public void setName_en(String name_en) {
            this.name_en = name_en;
        }

        public String getName_pinyin() {
            return name_pinyin;
        }

        public void setName_pinyin(String name_pinyin) {
            this.name_pinyin = name_pinyin;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public boolean isPublished() {
            return published;
        }

        public void setPublished(boolean published) {
            this.published = published;
        }

        public boolean isIs_in_china() {
            return is_in_china;
        }

        public void setIs_in_china(boolean is_in_china) {
            this.is_in_china = is_in_china;
        }

        public int getUser_activities_count() {
            return user_activities_count;
        }

        public void setUser_activities_count(int user_activities_count) {
            this.user_activities_count = user_activities_count;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public boolean isIs_valid_destination() {
            return is_valid_destination;
        }

        public void setIs_valid_destination(boolean is_valid_destination) {
            this.is_valid_destination = is_valid_destination;
        }

        public int getDestination_id() {
            return destination_id;
        }

        public void setDestination_id(int destination_id) {
            this.destination_id = destination_id;
        }
    }
}
