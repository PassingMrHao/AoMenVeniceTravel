package mrhao.com.aomentravel.bean;

import java.io.Serializable;
import java.util.List;

public class TravelYouJiBean implements Serializable {

    private int id;
    private String name;
    private int trips_count;
    private List<AttractionTripsBean> attraction_trips;

    @Override
    public String toString() {
        return "Recy_YouJiAd{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", trips_count=" + trips_count +
                ", attraction_trips=" + attraction_trips +
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

    public int getTrips_count() {
        return trips_count;
    }

    public void setTrips_count(int trips_count) {
        this.trips_count = trips_count;
    }

    public List<AttractionTripsBean> getAttraction_trips() {
        return attraction_trips;
    }

    public void setAttraction_trips(List<AttractionTripsBean> attraction_trips) {
        this.attraction_trips = attraction_trips;
    }

    public static class AttractionTripsBean implements Serializable {
        /**
         * featured : true
         * photos_count : 18
         * comment : 【世界文化遺產】大三巴牌坊的建築由花崗石建成，整個牆壁是巴洛克式，但一些設計或雕刻，卻具有明顯的東方色彩，如中文字或象徵日本傳統的菊花圖案，這座中西合璧的石壁在全世界的天主教教堂中是獨一無二的。
         * node_id : 422832
         * node_comments_count : 0
         * trip : {"id":26706,"name":"澳門「世界文化遺產﹣歷史城區」之旅","photos_count":512,"start_date":"2012-09-17","end_date":"2012-09-20","days":4,"level":4,"privacy":false,"front_cover_photo_id":1309825,"views_count":21280,"comments_count":42,"likes_count":565,"state":"publish","source":"app","serial_id":null,"serial_position":null,"front_cover_photo_url":"http://p.chanyouji.cn/26706/1369066760843p17r1bpqjqf3p17jr939ljo1r192.jpg","updated_at":1408186598,"user":{"id":36369,"name":"mountainlioncat","image":"http://tp4.sinaimg.cn/2705405923/180/5657098672/1"}}
         * notes : [{"id":1390264,"description":"十五年後，舊地重遊這澳門的標誌性建築物","width":1600,"height":1062,"photo_url":"http://p.chanyouji.cn/26706/1369066775610p17r1bpqjqn51fkfrtiqbq1n4p3.jpg","video_url":null},{"id":1623000,"description":"「三巴」這個名字是來自於「聖保祿」的葡文（São Paulo），而「大」是指最大的教堂，故「大三巴」是指「最大的教堂」","width":1063,"height":1600,"photo_url":"http://p.chanyouji.cn/26706/1370758872467p17sjp4vh818cc1qj0f8i16th112r1r.jpg","video_url":null},{"id":1623001,"description":"1835年1月26日黃昏，教堂起火，最後剩下教堂的前壁。由於教堂前壁形似中國的傳統牌坊，故本地人便稱之為「大三巴牌坊」","width":1063,"height":1600,"photo_url":"http://p.chanyouji.cn/26706/1370758878813p17sjp4vh81bkkcnckne1mh81e4h1s.jpg","video_url":null},{"id":1622988,"description":"","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370758752047p17sjp4vh877mnb73ukdfl2jv1e.jpg","video_url":null},{"id":1622989,"description":"","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370758759797p17sjp4vh81hep16ulflv19i4qo61f.jpg","video_url":null},{"id":1622992,"description":"現展出了屬天主教澳門教區的文物，其中包括油畫、耶穌受難像、聖像、教堂聖物、禮拜器物等，共三十四件","width":1600,"height":1062,"photo_url":"http://p.chanyouji.cn/26706/1370758780211p17sjp4vh8d5hpvqi3j12091asa1i.jpg","video_url":null},{"id":1622993,"description":"其中尤以《聖彌額爾大天神》油畫最珍貴，是聖保祿學院唯一留存至今的油畫藝術品","width":1600,"height":1062,"photo_url":"http://p.chanyouji.cn/26706/1370758787188p17sjp4vh81r8v1qhs4k9n5okve1j.jpg","video_url":null},{"id":1622994,"description":"墓室安放了由路環聖方濟各聖堂遷來的日本和越南殉道者骸骨。中央為一座花崗岩墓穴的遺址，墓主很可能是聖保祿學院創始人范禮安神父","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370758798207p17sjp4vh81vlnm1e6bc1ct31k531k.jpg","video_url":null},{"id":1622990,"description":"政府在大三巴牌坊的背部安裝了鐵架樓梯，以供遊人參觀，可是樓梯的鐵架插了在牌坊的結構之內，此舉引來一些文物專家的不滿","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370758767513p17sjp4vh81lsv3t111ur1b2k1kgt1g.jpg","video_url":null},{"id":1623023,"description":"1990年代初，政府曾對聖保祿教堂的遺址進行考古調查及修復工作，並發現了當時教堂背後的建築遺址","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370759075928p17sjp4vh9qcqsgf137f1o2env72h.jpg","video_url":null},{"id":2077492,"description":"","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1373706071592p17vbk6bd71q7t11morhr1g1h14b02.jpg","video_url":null},{"id":1622991,"description":"1996年，政府在該遺址建成了天主教藝術博物館與墓室，展出不少澳門教會的珍貴文物","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370758774361p17sjp4vh8gr01hinlqpldq1sf1h.jpg","video_url":null},{"id":1622999,"description":"","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370758858128p17sjp4vh81vuijem1u1e1is31ad81q.jpg","video_url":null},{"id":1623024,"description":"","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370759089247p17sjp4vh9dmu120l171t1imtvbi2i.jpg","video_url":null},{"id":1623025,"description":"大三巴牌坊是位於聖保祿山的天主之母教堂（A lgreja da Madre de Deus）前壁","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370759102903p17sjp4vh91p688ad19mh1qq2mm32j.jpg","video_url":null},{"id":1622263,"description":"","width":1063,"height":1600,"photo_url":"http://p.chanyouji.cn/26706/1370754398428p17sjkbimf3kh1epkhhpuua1d541c.jpg","video_url":null},{"id":1622262,"description":"","width":1600,"height":1063,"photo_url":"http://p.chanyouji.cn/26706/1370754364930p17sjkbimf1o8o1jjtplc1q331cd61b.jpg","video_url":null},{"id":1622264,"description":"","width":1600,"height":1067,"photo_url":"http://p.chanyouji.cn/26706/1370754417311p17sjkbimf13fiq432lk12g31h701d.jpg","video_url":null}]
         */

        private boolean featured;
        private int photos_count;
        private String comment;
        private int node_id;
        private int node_comments_count;
        private TripBean trip;
        private List<NotesBean> notes;

        @Override
        public String toString() {
            return "AttractionTripsBean{" +
                    "featured=" + featured +
                    ", photos_count=" + photos_count +
                    ", comment='" + comment + '\'' +
                    ", node_id=" + node_id +
                    ", node_comments_count=" + node_comments_count +
                    ", trip=" + trip +
                    ", notes=" + notes +
                    '}';
        }

        public boolean isFeatured() {
            return featured;
        }

        public void setFeatured(boolean featured) {
            this.featured = featured;
        }

        public int getPhotos_count() {
            return photos_count;
        }

        public void setPhotos_count(int photos_count) {
            this.photos_count = photos_count;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getNode_id() {
            return node_id;
        }

        public void setNode_id(int node_id) {
            this.node_id = node_id;
        }

        public int getNode_comments_count() {
            return node_comments_count;
        }

        public void setNode_comments_count(int node_comments_count) {
            this.node_comments_count = node_comments_count;
        }

        public TripBean getTrip() {
            return trip;
        }

        public void setTrip(TripBean trip) {
            this.trip = trip;
        }

        public List<NotesBean> getNotes() {
            return notes;
        }

        public void setNotes(List<NotesBean> notes) {
            this.notes = notes;
        }

        public static class TripBean implements Serializable{
            /**
             * id : 26706
             * name : 澳門「世界文化遺產﹣歷史城區」之旅
             * photos_count : 512
             * start_date : 2012-09-17
             * end_date : 2012-09-20
             * days : 4
             * level : 4
             * privacy : false
             * front_cover_photo_id : 1309825
             * views_count : 21280
             * comments_count : 42
             * likes_count : 565
             * state : publish
             * source : app
             * serial_id : null
             * serial_position : null
             * front_cover_photo_url : http://p.chanyouji.cn/26706/1369066760843p17r1bpqjqf3p17jr939ljo1r192.jpg
             * updated_at : 1408186598
             * user : {"id":36369,"name":"mountainlioncat","image":"http://tp4.sinaimg.cn/2705405923/180/5657098672/1"}
             */

            private int id;
            private String name;
            private int photos_count;
            private String start_date;
            private String end_date;
            private int days;
            private int level;
            private boolean privacy;
            private int front_cover_photo_id;
            private int views_count;
            private int comments_count;
            private int likes_count;
            private String state;
            private String source;
            private Object serial_id;
            private Object serial_position;
            private String front_cover_photo_url;
            private int updated_at;
            private UserBean user;

            @Override
            public String toString() {
                return "TripBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", photos_count=" + photos_count +
                        ", start_date='" + start_date + '\'' +
                        ", end_date='" + end_date + '\'' +
                        ", days=" + days +
                        ", level=" + level +
                        ", privacy=" + privacy +
                        ", front_cover_photo_id=" + front_cover_photo_id +
                        ", views_count=" + views_count +
                        ", comments_count=" + comments_count +
                        ", likes_count=" + likes_count +
                        ", state='" + state + '\'' +
                        ", source='" + source + '\'' +
                        ", serial_id=" + serial_id +
                        ", serial_position=" + serial_position +
                        ", front_cover_photo_url='" + front_cover_photo_url + '\'' +
                        ", updated_at=" + updated_at +
                        ", user=" + user +
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

            public int getPhotos_count() {
                return photos_count;
            }

            public void setPhotos_count(int photos_count) {
                this.photos_count = photos_count;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public int getDays() {
                return days;
            }

            public void setDays(int days) {
                this.days = days;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public boolean isPrivacy() {
                return privacy;
            }

            public void setPrivacy(boolean privacy) {
                this.privacy = privacy;
            }

            public int getFront_cover_photo_id() {
                return front_cover_photo_id;
            }

            public void setFront_cover_photo_id(int front_cover_photo_id) {
                this.front_cover_photo_id = front_cover_photo_id;
            }

            public int getViews_count() {
                return views_count;
            }

            public void setViews_count(int views_count) {
                this.views_count = views_count;
            }

            public int getComments_count() {
                return comments_count;
            }

            public void setComments_count(int comments_count) {
                this.comments_count = comments_count;
            }

            public int getLikes_count() {
                return likes_count;
            }

            public void setLikes_count(int likes_count) {
                this.likes_count = likes_count;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public Object getSerial_id() {
                return serial_id;
            }

            public void setSerial_id(Object serial_id) {
                this.serial_id = serial_id;
            }

            public Object getSerial_position() {
                return serial_position;
            }

            public void setSerial_position(Object serial_position) {
                this.serial_position = serial_position;
            }

            public String getFront_cover_photo_url() {
                return front_cover_photo_url;
            }

            public void setFront_cover_photo_url(String front_cover_photo_url) {
                this.front_cover_photo_url = front_cover_photo_url;
            }

            public int getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(int updated_at) {
                this.updated_at = updated_at;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public static class UserBean implements Serializable{
                /**
                 * id : 36369
                 * name : mountainlioncat
                 * image : http://tp4.sinaimg.cn/2705405923/180/5657098672/1
                 */

                private int id;
                private String name;
                private String image;

                @Override
                public String toString() {
                    return "UserBean{" +
                            "id=" + id +
                            ", name='" + name + '\'' +
                            ", image='" + image + '\'' +
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

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }

        public static class NotesBean implements Serializable{
            /**
             * id : 1390264
             * description : 十五年後，舊地重遊這澳門的標誌性建築物
             * width : 1600
             * height : 1062
             * photo_url : http://p.chanyouji.cn/26706/1369066775610p17r1bpqjqn51fkfrtiqbq1n4p3.jpg
             * video_url : null
             */

            private int id;
            private String description;
            private int width;
            private int height;
            private String photo_url;
            private Object video_url;

            @Override
            public String toString() {
                return "NotesBean{" +
                        "id=" + id +
                        ", description='" + description + '\'' +
                        ", width=" + width +
                        ", height=" + height +
                        ", photo_url='" + photo_url + '\'' +
                        ", video_url=" + video_url +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

            public Object getVideo_url() {
                return video_url;
            }

            public void setVideo_url(Object video_url) {
                this.video_url = video_url;
            }
        }
    }
}
