package mrhao.com.aomentravel.bean;

import java.util.List;

public class PlayBean {

    /**
     * data : {"categories":[{"categoryName":"全部类型","categoryId":0},{"categoryName":"游乐场","categoryId":1},{"categoryName":"赌场","categoryId":2},{"categoryName":"其他","categoryId":3}],"amusements":[{"score":4.7,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090818573915163.jpg","commentTotal":3,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"皇家金堡娱乐场","objectId":2},{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709081849319475V.jpg","commentTotal":2,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"新葡京娱乐场","objectId":1},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908194644309D1.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"美高梅金殿娱乐城","objectId":19},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819452998092.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"新濠影汇娱乐场","objectId":18},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908194408513AE.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"新濠天地娱乐场","objectId":17},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908194212851J1.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"骏景娱乐场","objectId":16},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819403055346.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"新濠锋娱乐场","objectId":15},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819372373537.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"永利皇宫娱乐场","objectId":14},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819314776021.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"永利娱乐场","objectId":13},{"score":4,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908192927220TE.jpg","commentTotal":2,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"澳门巴黎人娱乐场","objectId":12},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819265768187.jpg","commentTotal":1,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"金沙城中心娱乐场","objectId":11},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819225454532.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"百利宫娱乐场","objectId":10},{"score":4,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908192123446F9.jpg","commentTotal":1,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"威尼斯人娱乐场","objectId":9},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908191944788QY.jpg","commentTotal":1,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"金沙娱乐场","objectId":8},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908191832560NL.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"星际娱乐场","objectId":7},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908191447151EW.jpg","commentTotal":1,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"总统娱乐场","objectId":6},{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090819112794520.jpg","commentTotal":2,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"英皇宫殿娱乐场","objectId":5},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170908190946752QK.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"葡京娱乐场","objectId":4},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709081905519930W.jpg","commentTotal":0,"categories":[{"categoryName":"赌场","categoryId":2}],"title":"十六浦娱乐场","objectId":3}],"sorts":[{"sortId":0,"sortName":"默认排序"},{"sortId":1,"sortName":"距离"},{"sortId":2,"sortName":"人气"}]}
     * message : 获取成功
     * status : 0
     * total : 19
     */

    private DataBean data;
    private String message;
    private int status;
    private int total;

    @Override
    public String toString() {
        return "Grid_PlayAd{" +
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
        private List<CategoriesBean> categories;
        private List<AmusementsBean> amusements;
        private List<SortsBean> sorts;

        @Override
        public String toString() {
            return "DataBean{" +
                    "categories=" + categories +
                    ", amusements=" + amusements +
                    ", sorts=" + sorts +
                    '}';
        }

        public List<CategoriesBean> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBean> categories) {
            this.categories = categories;
        }

        public List<AmusementsBean> getAmusements() {
            return amusements;
        }

        public void setAmusements(List<AmusementsBean> amusements) {
            this.amusements = amusements;
        }

        public List<SortsBean> getSorts() {
            return sorts;
        }

        public void setSorts(List<SortsBean> sorts) {
            this.sorts = sorts;
        }

        public static class CategoriesBean {
            /**
             * categoryName : 全部类型
             * categoryId : 0
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

        public static class AmusementsBean {
            /**
             * score : 4.7
             * coverImage : https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017090818573915163.jpg
             * commentTotal : 3
             * categories : [{"categoryName":"赌场","categoryId":2}]
             * title : 皇家金堡娱乐场
             * objectId : 2
             */

            private double score;
            private String coverImage;
            private int commentTotal;
            private String title;
            private int objectId;
            private List<CategoriesBeanX> categories;

            @Override
            public String toString() {
                return "AmusementsBean{" +
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

            public List<CategoriesBeanX> getCategories() {
                return categories;
            }

            public void setCategories(List<CategoriesBeanX> categories) {
                this.categories = categories;
            }

            public static class CategoriesBeanX {
                /**
                 * categoryName : 赌场
                 * categoryId : 2
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
