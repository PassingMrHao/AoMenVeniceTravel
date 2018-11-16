package mrhao.com.aomentravel.bean;

public class TravelXiangCeBean {


    /**
     * id : 12920786
     * image_width : 1080
     * image_height : 1440
     * note_id : 13928156
     * likes_count : 0
     * image_url : http://p.chanyouji.cn/360228/1456481884159p1acehbclvf59q38nb0uvpt5e9.jpg
     * description : 48元一个的猪扒包，厚实得吃不完，酥酥油油的，吃完一嘴油，四只花猫哈哈
     * trip_id : 360228
     * trip_name : 广州-珠海-澳门#杨小羊在路上
     */

    private int id;
    private int image_width;
    private int image_height;
    private int note_id;
    private int likes_count;
    private String image_url;
    private String description;
    private int trip_id;
    private String trip_name;

    @Override
    public String toString() {
        return "TravelXiangCeBean{" +
                "id=" + id +
                ", image_width=" + image_width +
                ", image_height=" + image_height +
                ", note_id=" + note_id +
                ", likes_count=" + likes_count +
                ", image_url='" + image_url + '\'' +
                ", description='" + description + '\'' +
                ", trip_id=" + trip_id +
                ", trip_name='" + trip_name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage_width() {
        return image_width;
    }

    public void setImage_width(int image_width) {
        this.image_width = image_width;
    }

    public int getImage_height() {
        return image_height;
    }

    public void setImage_height(int image_height) {
        this.image_height = image_height;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }
}
