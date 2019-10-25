package com.science.com.rchs.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Zhe {

    /**
     * code : 0
     * message : 请求成功
     * data : {"list":[{"id":9,"mch_seller_id":"4123","coupon_type":"2","coupon_id":"pD9sF1V7m2sQHbiuocugoZQpWFrE","title":"0.9折券","number":"49","store_id":"0","rate":"0.09","code_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEz8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyd2wwVU5yZnJjNWwxNE1yVGh2NEkAAgSwJ1ZdAwSAM_EB","logo_url":"undefined","least_cost":"0.00","reduce_cost":"0.00","begin_timestamp":"1565913600","end_timestamp":"1566259200","status":"1","is_del":"0","default":"0","created_at":"2019-08-16 11:49:04","updated_at":"2019-08-21 14:52:02"},{"id":10,"mch_seller_id":"4123","coupon_type":"2","coupon_id":"pD9sF1TBsO8S-O6Rbw2l13HaJV7E","title":"7折券","number":"7","store_id":"0","rate":"0.70","code_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQHG7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyLTRxZU1iZnJjNWwxN1BTVE52NEwAAgRzQ1ZdAwSAM_EB","logo_url":"http://mmbiz.qpic.cn/mmbiz_png/MV8dBUmdfs7e3zYM3TToekqichyyA0Y5LuRk3t4ThiaCg2nJgqUXBPPdrkemWEhYlS36OstWz2Y8wm6ZYuq5n26Q/0","least_cost":"0.00","reduce_cost":"0.00","begin_timestamp":"1567267200","end_timestamp":"1567353600","status":"1","is_del":"0","default":"0","created_at":"2019-08-16 13:47:31","updated_at":"2019-08-21 15:07:12"},{"id":11,"mch_seller_id":"4123","coupon_type":"2","coupon_id":"pD9sF1czVR3toDo-ZmzMwG3WJA8M","title":"8.8折券","number":"100","store_id":"0","rate":"0.88","code_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGk8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyY1ZDY04xZnJjNWwxZFN3Vk52NDIAAgT2rFhdAwSAM_EB","logo_url":"undefined","least_cost":"0.00","reduce_cost":"0.00","begin_timestamp":"1566086400","end_timestamp":"1567209600","status":"1","is_del":"0","default":"0","created_at":"2019-08-18 09:42:14","updated_at":"2019-08-18 09:43:59"}],"count":3}
     */

    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"id":9,"mch_seller_id":"4123","coupon_type":"2","coupon_id":"pD9sF1V7m2sQHbiuocugoZQpWFrE","title":"0.9折券","number":"49","store_id":"0","rate":"0.09","code_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEz8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyd2wwVU5yZnJjNWwxNE1yVGh2NEkAAgSwJ1ZdAwSAM_EB","logo_url":"undefined","least_cost":"0.00","reduce_cost":"0.00","begin_timestamp":"1565913600","end_timestamp":"1566259200","status":"1","is_del":"0","default":"0","created_at":"2019-08-16 11:49:04","updated_at":"2019-08-21 14:52:02"},{"id":10,"mch_seller_id":"4123","coupon_type":"2","coupon_id":"pD9sF1TBsO8S-O6Rbw2l13HaJV7E","title":"7折券","number":"7","store_id":"0","rate":"0.70","code_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQHG7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyLTRxZU1iZnJjNWwxN1BTVE52NEwAAgRzQ1ZdAwSAM_EB","logo_url":"http://mmbiz.qpic.cn/mmbiz_png/MV8dBUmdfs7e3zYM3TToekqichyyA0Y5LuRk3t4ThiaCg2nJgqUXBPPdrkemWEhYlS36OstWz2Y8wm6ZYuq5n26Q/0","least_cost":"0.00","reduce_cost":"0.00","begin_timestamp":"1567267200","end_timestamp":"1567353600","status":"1","is_del":"0","default":"0","created_at":"2019-08-16 13:47:31","updated_at":"2019-08-21 15:07:12"},{"id":11,"mch_seller_id":"4123","coupon_type":"2","coupon_id":"pD9sF1czVR3toDo-ZmzMwG3WJA8M","title":"8.8折券","number":"100","store_id":"0","rate":"0.88","code_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGk8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyY1ZDY04xZnJjNWwxZFN3Vk52NDIAAgT2rFhdAwSAM_EB","logo_url":"undefined","least_cost":"0.00","reduce_cost":"0.00","begin_timestamp":"1566086400","end_timestamp":"1567209600","status":"1","is_del":"0","default":"0","created_at":"2019-08-18 09:42:14","updated_at":"2019-08-18 09:43:59"}]
         * count : 3
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 9
             * mch_seller_id : 4123
             * coupon_type : 2
             * coupon_id : pD9sF1V7m2sQHbiuocugoZQpWFrE
             * title : 0.9折券
             * number : 49
             * store_id : 0
             * rate : 0.09
             * code_url : https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEz8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyd2wwVU5yZnJjNWwxNE1yVGh2NEkAAgSwJ1ZdAwSAM_EB
             * logo_url : undefined
             * least_cost : 0.00
             * reduce_cost : 0.00
             * begin_timestamp : 1565913600
             * end_timestamp : 1566259200
             * status : 1
             * is_del : 0
             * default : 0
             * created_at : 2019-08-16 11:49:04
             * updated_at : 2019-08-21 14:52:02
             */

            private int id;
            private String mch_seller_id;
            private String coupon_type;
            private String coupon_id;
            private String title;
            private String number;
            private String store_id;
            private String rate;
            private String code_url;
            private String logo_url;
            private String least_cost;
            private String reduce_cost;
            private String begin_timestamp;
            private String end_timestamp;
            private String status;
            private String is_del;
            @SerializedName("default")
            private String defaultX;
            private String created_at;
            private String updated_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMch_seller_id() {
                return mch_seller_id;
            }

            public void setMch_seller_id(String mch_seller_id) {
                this.mch_seller_id = mch_seller_id;
            }

            public String getCoupon_type() {
                return coupon_type;
            }

            public void setCoupon_type(String coupon_type) {
                this.coupon_type = coupon_type;
            }

            public String getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(String coupon_id) {
                this.coupon_id = coupon_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getCode_url() {
                return code_url;
            }

            public void setCode_url(String code_url) {
                this.code_url = code_url;
            }

            public String getLogo_url() {
                return logo_url;
            }

            public void setLogo_url(String logo_url) {
                this.logo_url = logo_url;
            }

            public String getLeast_cost() {
                return least_cost;
            }

            public void setLeast_cost(String least_cost) {
                this.least_cost = least_cost;
            }

            public String getReduce_cost() {
                return reduce_cost;
            }

            public void setReduce_cost(String reduce_cost) {
                this.reduce_cost = reduce_cost;
            }

            public String getBegin_timestamp() {
                return begin_timestamp;
            }

            public void setBegin_timestamp(String begin_timestamp) {
                this.begin_timestamp = begin_timestamp;
            }

            public String getEnd_timestamp() {
                return end_timestamp;
            }

            public void setEnd_timestamp(String end_timestamp) {
                this.end_timestamp = end_timestamp;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIs_del() {
                return is_del;
            }

            public void setIs_del(String is_del) {
                this.is_del = is_del;
            }

            public String getDefaultX() {
                return defaultX;
            }

            public void setDefaultX(String defaultX) {
                this.defaultX = defaultX;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
