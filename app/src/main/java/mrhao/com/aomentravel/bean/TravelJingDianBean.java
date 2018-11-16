package mrhao.com.aomentravel.bean;

import java.util.List;

public class TravelJingDianBean {


    /**
     * data : {"scenicSpots":[{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174638138CN.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"宋玉生公园","objectId":95},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174558937VN.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"何贤公园 (香山公园)","objectId":94},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174511090PO.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"白鸽巢公园 (贾梅士花园)","objectId":93},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174336991EJ.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"关帝庙 (三街会馆)","objectId":92},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174256235Q5.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"谭公庙","objectId":91},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174211244FE.jpg","commentTotal":1,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"菩提禅院","objectId":90},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174118591R9.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"莲溪庙","objectId":89},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091017402894478.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"莲峯庙","objectId":88},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091017394380632.jpg","commentTotal":0,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"观音堂","objectId":87},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910173858974A7.jpg","commentTotal":1,"categories":[{"categoryName":"自然景观","categoryId":3}],"title":"妈阁庙","objectId":86},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910173724534M7.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"圣老楞佐教堂","objectId":85},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910173633702X0.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"圣若瑟修院及圣堂","objectId":84},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091017355100794.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"望厦圣方济各小堂","objectId":83},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709101735071710V.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"玫瑰堂","objectId":82},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709101734063073Y.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"圣奥斯定教堂","objectId":81},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910173237416UR.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"圣安多尼教堂","objectId":80},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091017315238388.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"马礼逊教堂","objectId":79},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910173035441OB.jpg","commentTotal":1,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"九澳七苦圣母小堂","objectId":78},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091015514887530.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"花地玛圣母堂","objectId":77},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709101550586038L.jpg","commentTotal":0,"categories":[{"categoryName":"人文景观","categoryId":2}],"title":"嘉模圣母堂","objectId":76}]}
     * message : 获取成功
     * status : 0
     * total : 113
     */

    private DataBean data;
    private String message;
    private int status;
    private int total;


    @Override
    public String toString() {
        return "TravelJingDianBean{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", status=" + status +
                ", total=" + total +
                '}';
    }

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public static class DataBean {
        private List<ScenicSpotsBean> scenicSpots;

        public List<ScenicSpotsBean> getScenicSpots() {
            return scenicSpots;
        }

        public void setScenicSpots(List<ScenicSpotsBean> scenicSpots) {
            this.scenicSpots = scenicSpots;
        }

        public static class ScenicSpotsBean {
            /**
             * score : 0
             * coverImage : https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910174638138CN.jpg
             * commentTotal : 0
             * categories : [{"categoryName":"自然景观","categoryId":3}]
             * title : 宋玉生公园
             * objectId : 95
             */

            private double score;
            private String coverImage;
            private int commentTotal;
            private String title;
            private int objectId;
            private List<CategoriesBean> categories;

            @Override
            public String toString() {
                return "ScenicSpotsBean{" +
                        "score=" + score +
                        ", coverImage='" + coverImage + '\'' +
                        ", commentTotal=" + commentTotal +
                        ", title='" + title + '\'' +
                        ", objectId=" + objectId +
                        ", categories=" + categories +
                        '}';
            }

            public double getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getCoverImage() {
                return coverImage;
            }

            public void setCoverImage(String coverImage) {
                this.coverImage = coverImage;
            }

            public int getCommentTotal() {
                return commentTotal;
            }

            public void setCommentTotal(int commentTotal) {
                this.commentTotal = commentTotal;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getObjectId() {
                return objectId;
            }

            public void setObjectId(int objectId) {
                this.objectId = objectId;
            }

            public List<CategoriesBean> getCategories() {
                return categories;
            }

            public void setCategories(List<CategoriesBean> categories) {
                this.categories = categories;
            }

            public static class CategoriesBean {
                /**
                 * categoryName : 自然景观
                 * categoryId : 3
                 */

                private String categoryName;
                private int categoryId;

                @Override
                public String toString() {
                    return "CategoriesBean{" +
                            "categoryName='" + categoryName + '\'' +
                            ", categoryId=" + categoryId +
                            '}';
                }

                public String getCategoryName() {
                    return categoryName;
                }

                public void setCategoryName(String categoryName) {
                    this.categoryName = categoryName;
                }

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }
            }
        }
    }
}
