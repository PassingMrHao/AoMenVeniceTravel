package mrhao.com.aomentravel.bean;

import java.util.List;

public class MarketBean {


    /**
     * data : {"malls":[{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910093351434GK.jpg","commentTotal":21,"categories":[{"categoryName":"商场","categoryId":1}],"title":"新八佰伴百货公司","objectId":8},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910193210921N5.jpg","commentTotal":1,"categories":[{"categoryName":"其他","categoryId":8}],"title":"路凼城","objectId":17},{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910192306569T7.jpg","commentTotal":4,"categories":[{"categoryName":"其他","categoryId":8}],"title":"大三巴区","objectId":12},{"score":4.3,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709101918214800J.jpg","commentTotal":3,"categories":[{"categoryName":"其他","categoryId":8}],"title":"新马路区","objectId":11},{"score":4,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709101926593796Z.jpg","commentTotal":1,"categories":[{"categoryName":"其他","categoryId":8}],"title":"板樟堂区","objectId":13},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091019284971798.jpg","commentTotal":0,"categories":[{"categoryName":"其他","categoryId":8}],"title":"高士德区","objectId":14},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091019294454997.jpg","commentTotal":0,"categories":[{"categoryName":"其他","categoryId":8}],"title":"凼仔旧城区","objectId":15},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709101022003002H.jpg","commentTotal":1,"categories":[{"categoryName":"商场","categoryId":1}],"title":"新濠影汇购物大道","objectId":10},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910093505029KI.jpg","commentTotal":1,"categories":[{"categoryName":"商场","categoryId":1}],"title":"澳门渔人码头","objectId":9},{"score":4.8,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910093228598MZ.jpg","commentTotal":4,"categories":[{"categoryName":"商场","categoryId":1}],"title":"「澳门银河™」时尚汇购物中心","objectId":7},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709100925599383T.jpg","commentTotal":1,"categories":[{"categoryName":"商场","categoryId":1}],"title":"新濠大道","objectId":6},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091009243821268.jpg","commentTotal":1,"categories":[{"categoryName":"商场","categoryId":1}],"title":"金沙广场","objectId":5},{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910092337605C3.jpg","commentTotal":2,"categories":[{"categoryName":"商场","categoryId":1}],"title":"四季\u2027名店","objectId":4},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091009221873479.jpg","commentTotal":0,"categories":[{"categoryName":"商场","categoryId":1}],"title":"威尼斯人购物中心","objectId":3},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709082112296193J.jpg","commentTotal":1,"categories":[{"categoryName":"商场","categoryId":1}],"title":"澳门壹号广场","objectId":1},{"score":3,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910091621263TQ.jpg","commentTotal":1,"categories":[{"categoryName":"商场","categoryId":1}],"title":"永利名店购物区","objectId":2}],"categories":[{"categoryName":"全部类型","categoryId":0},{"categoryName":"商场","categoryId":1},{"categoryName":"母婴","categoryId":2},{"categoryName":"食品","categoryId":3},{"categoryName":"数码家电","categoryId":4},{"categoryName":"化妆品","categoryId":5},{"categoryName":"服饰鞋包","categoryId":6},{"categoryName":"金饰钟表","categoryId":7},{"categoryName":"其他","categoryId":8}],"sorts":[{"sortId":0,"sortName":"默认排序"},{"sortId":1,"sortName":"距离"},{"sortId":2,"sortName":"人气"}]}
     * message : 获取成功
     * status : 0
     * total : 16
     */

    private DataBean data;
    private String message;
    private int status;
    private int total;

    @Override
    public String toString() {
        return "MarketBean{" +
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
        private List<MallsBean> malls;
        private List<CategoriesBeanX> categories;
        private List<SortsBean> sorts;

        @Override
        public String toString() {
            return "DataBean{" +
                    "malls=" + malls +
                    ", categories=" + categories +
                    ", sorts=" + sorts +
                    '}';
        }

        public List<MallsBean> getMalls() {
            return malls;
        }

        public void setMalls(List<MallsBean> malls) {
            this.malls = malls;
        }

        public List<CategoriesBeanX> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBeanX> categories) {
            this.categories = categories;
        }

        public List<SortsBean> getSorts() {
            return sorts;
        }

        public void setSorts(List<SortsBean> sorts) {
            this.sorts = sorts;
        }

        public static class MallsBean {
            /**
             * score : 4.5
             * coverImage : https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910093351434GK.jpg
             * commentTotal : 21
             * categories : [{"categoryName":"商场","categoryId":1}]
             * title : 新八佰伴百货公司
             * objectId : 8
             */

            private double score;
            private String coverImage;
            private int commentTotal;
            private String title;
            private int objectId;
            private List<CategoriesBean> categories;

            @Override
            public String toString() {
                return "MallsBean{" +
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

            public void setScore(double score) {
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
                 * categoryName : 商场
                 * categoryId : 1
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

        public static class CategoriesBeanX {
            /**
             * categoryName : 全部类型
             * categoryId : 0
             */

            private String categoryName;
            private int categoryId;

            @Override
            public String toString() {
                return "CategoriesBeanX{" +
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

        public static class SortsBean {
            /**
             * sortId : 0
             * sortName : 默认排序
             */

            private int sortId;
            private String sortName;

            @Override
            public String toString() {
                return "SortsBean{" +
                        "sortId=" + sortId +
                        ", sortName='" + sortName + '\'' +
                        '}';
            }

            public int getSortId() {
                return sortId;
            }

            public void setSortId(int sortId) {
                this.sortId = sortId;
            }

            public String getSortName() {
                return sortName;
            }

            public void setSortName(String sortName) {
                this.sortName = sortName;
            }
        }
    }
}
