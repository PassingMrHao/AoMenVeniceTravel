package mrhao.com.aomentravel.bean;

public class AllJingDianDateBean {


    /**
     * id : 4201
     * name : 水舞间
     * attraction_trips_count : 18
     * user_score : 5.0
     * description : 位于新濠天地，据说是总投资超过20亿港元的全球最大水上表演，经过了5年筹划和2年排练才得以和观众见面。
     * name_en : House of the Dancing Water
     * attraction_type : null
     * description_summary : 位于新濠天地，据说是总投资超过20亿港元的全球最大水上表演，经过了5年筹划和2年
     * image_url : http://m.chanyouji.cn/attractions/4201.jpg
     */

    private String id;
    private String name;
    private String attraction_trips_count;
    private String user_score;
    private String description;
    private String name_en;
    private Object attraction_type;
    private String description_summary;
    private String image_url;

    @Override
    public String toString() {
        return "AllJingDianDateBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attraction_trips_count='" + attraction_trips_count + '\'' +
                ", user_score='" + user_score + '\'' +
                ", description='" + description + '\'' +
                ", name_en='" + name_en + '\'' +
                ", attraction_type=" + attraction_type +
                ", description_summary='" + description_summary + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttraction_trips_count() {
        return attraction_trips_count;
    }

    public void setAttraction_trips_count(String attraction_trips_count) {
        this.attraction_trips_count = attraction_trips_count;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public Object getAttraction_type() {
        return attraction_type;
    }

    public void setAttraction_type(Object attraction_type) {
        this.attraction_type = attraction_type;
    }

    public String getDescription_summary() {
        return description_summary;
    }

    public void setDescription_summary(String description_summary) {
        this.description_summary = description_summary;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
