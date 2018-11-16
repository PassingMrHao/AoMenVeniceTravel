package mrhao.com.aomentravel.bean;

import java.util.List;

public class FindFoodBean {


    /**
     * data : {"restaurants":[{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911201659025RW.jpg","commentTotal":2,"categories":[{"categoryName":"甜品","categoryId":13},{"categoryName":"面包/西饼","categoryId":14},{"categoryName":"咖啡厅","categoryId":16},{"categoryName":"法国菜","categoryId":21}],"title":"卡夫卡 KAFKA","objectId":128},{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20180212143702493XX.jpg","commentTotal":2,"categories":[{"categoryName":"茶餐厅","categoryId":4},{"categoryName":"咖啡厅","categoryId":16},{"categoryName":"多国菜","categoryId":25}],"title":"南屏雅叙Nam Ping","objectId":1015},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201801231520324012Q.jpg","commentTotal":1,"categories":[{"categoryName":"粤菜","categoryId":2},{"categoryName":"中菜(除粤菜)","categoryId":18}],"title":"黄枝记","objectId":1014},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20180122164230208K7.jpg","commentTotal":0,"categories":[{"categoryName":"茶餐厅","categoryId":4},{"categoryName":"港式菜","categoryId":22}],"title":"新鸿发咖啡美食","objectId":1013},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20180108172323441BN.jpg","commentTotal":0,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"小飞象葡国餐厅 Restaurante Dumbo","objectId":1012},{"score":5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911211016328FX.jpg","commentTotal":1,"categories":[{"categoryName":"自助餐","categoryId":7},{"categoryName":"葡国菜","categoryId":20},{"categoryName":"多国菜","categoryId":25}],"title":"mezza9 Macau","objectId":248},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2018010816114970107.jpg","commentTotal":0,"categories":[{"categoryName":"自助餐","categoryId":7}],"title":"沨竹自助餐 Bambu","objectId":1011},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2018010816104970301.jpg","commentTotal":0,"categories":[{"categoryName":"自助餐","categoryId":7}],"title":"360°旋转餐厅","objectId":1010},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20180108160923297QE.jpg","commentTotal":0,"categories":[{"categoryName":"自助餐","categoryId":7}],"title":"盛宴","objectId":1009},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201801081606329363B.jpg","commentTotal":0,"categories":[{"categoryName":"自助餐","categoryId":7},{"categoryName":"多国菜","categoryId":25}],"title":"海风餐厅 Mistral Restaurant","objectId":1008},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709112010311812N.jpg","commentTotal":0,"categories":[{"categoryName":"自助餐","categoryId":7},{"categoryName":"西餐","categoryId":8},{"categoryName":"酒吧","categoryId":15}],"title":"贝隆 Belon","objectId":111},{"score":4.5,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910150042602ZQ.jpg","commentTotal":2,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"老地方 Belos Tempos","objectId":14},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170910151835398VQ.jpg","commentTotal":0,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"东东阳光咖啡美食 Tong Tong Cafe Sopa","objectId":30},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911193553759OJ.jpg","commentTotal":0,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"广场葡国餐厅 The Square Cafe And Portuguese Restaurant","objectId":54},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911193744428II.jpg","commentTotal":0,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"葡国美食Boa Mesa Portuguese Food","objectId":56},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911200806356D9.jpg","commentTotal":0,"categories":[{"categoryName":"自助餐","categoryId":7},{"categoryName":"西餐","categoryId":8},{"categoryName":"葡国菜","categoryId":20}],"title":"皇家葡萄肴","objectId":105},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic2017091120044475974.jpg","commentTotal":0,"categories":[{"categoryName":"西餐","categoryId":8},{"categoryName":"葡国菜","categoryId":20}],"title":"葡轩 Gosto","objectId":94},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911201432952I2.jpg","commentTotal":0,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"葡萄园餐厅 Restaurante Vinha","objectId":121},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911202009858XN.jpg","commentTotal":0,"categories":[{"categoryName":"葡国菜","categoryId":20}],"title":"葡国美食天地  A Petisqueira","objectId":139},{"score":0,"coverImage":"https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic201709112045276575Z.jpg","commentTotal":0,"categories":[{"categoryName":"粤菜","categoryId":2},{"categoryName":"法国菜","categoryId":21}],"title":"巴黎轩 La Chine","objectId":186}],"categories":[{"categoryName":"全部类型","categoryId":0},{"categoryName":"米其林餐厅","categoryId":1},{"categoryName":"粤菜","categoryId":2},{"categoryName":"海鲜","categoryId":3},{"categoryName":"茶餐厅","categoryId":4},{"categoryName":"大排档","categoryId":5},{"categoryName":"小吃","categoryId":6},{"categoryName":"自助餐","categoryId":7},{"categoryName":"西餐","categoryId":8},{"categoryName":"日本料理","categoryId":9},{"categoryName":"韩国料理","categoryId":10},{"categoryName":"泰国菜","categoryId":11},{"categoryName":"东南亚菜","categoryId":12},{"categoryName":"甜品","categoryId":13},{"categoryName":"面包/西饼","categoryId":14},{"categoryName":"酒吧","categoryId":15},{"categoryName":"咖啡厅","categoryId":16},{"categoryName":"火锅","categoryId":17},{"categoryName":"中菜(除粤菜)","categoryId":18},{"categoryName":"多国菜","categoryId":25},{"categoryName":"葡国菜","categoryId":20},{"categoryName":"法国菜","categoryId":21},{"categoryName":"港式菜","categoryId":22},{"categoryName":"意大利菜","categoryId":23},{"categoryName":"西班牙菜","categoryId":24},{"categoryName":"其他","categoryId":19}],"sorts":[{"sortId":0,"sortName":"默认排序"},{"sortId":1,"sortName":"距离"},{"sortId":2,"sortName":"人气"}]}
     * message : 获取成功
     * status : 0
     * total : 259
     */

    private DataBean data;
    private String message;
    private int status;
    private int total;

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
        private List<RestaurantsBean> restaurants;
        private List<CategoriesBeanX> categories;
        private List<SortsBean> sorts;

        public List<RestaurantsBean> getRestaurants() {
            return restaurants;
        }

        public void setRestaurants(List<RestaurantsBean> restaurants) {
            this.restaurants = restaurants;
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

        public static class RestaurantsBean {
            /**
             * score : 5.0
             * coverImage : https://ogvebp247.qnssl.com/server/public/static/upload/topic/topic20170911201659025RW.jpg
             * commentTotal : 2
             * categories : [{"categoryName":"甜品","categoryId":13},{"categoryName":"面包/西饼","categoryId":14},{"categoryName":"咖啡厅","categoryId":16},{"categoryName":"法国菜","categoryId":21}]
             * title : 卡夫卡 KAFKA
             * objectId : 128
             */

            private double score;
            private String coverImage;
            private int commentTotal;
            private String title;
            private int objectId;
            private List<CategoriesBean> categories;

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
                 * categoryName : 甜品
                 * categoryId : 13
                 */

                private String categoryName;
                private int categoryId;

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
