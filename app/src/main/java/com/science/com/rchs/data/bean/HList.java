package com.science.com.rchs.data.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class HList {

    /**
     * code : 0
     * message : 请求成功
     * data : [{"title":"0.01元全场通用","code":"778838347972","coupon_type":"3","least_cost":"0.00","reduce_cost":"0.01","rate":"1.00","updated_at":"2019-09-10 15:16:58"},{"title":"满100减1代金券","code":"169861773442","coupon_type":"1","least_cost":"100.00","reduce_cost":"1.00","rate":"0.99","updated_at":"2019-09-05 10:29:19"},{"title":"满100减1代金券","code":"839395356536","coupon_type":"1","least_cost":"100.00","reduce_cost":"1.00","rate":"0.99","updated_at":"2019-09-05 10:28:09"},{"title":"满100减1代金券","code":"295534951622","coupon_type":"1","least_cost":"100.00","reduce_cost":"1.00","rate":"0.99","updated_at":"2019-09-05 10:25:31"},{"title":"0.01元全场通用","code":"919185485810","coupon_type":"3","least_cost":"0.00","reduce_cost":"0.01","rate":"1.00","updated_at":"2019-09-04 19:20:52"},{"title":"满0.02减0.01代金券","code":"180353037242","coupon_type":"1","least_cost":"0.02","reduce_cost":"0.01","rate":"0.50","updated_at":"2019-09-04 19:07:16"},{"title":"满100减1代金券","code":"636571126594","coupon_type":"1","least_cost":"100.00","reduce_cost":"1.00","rate":"0.99","updated_at":"2019-08-31 16:30:34"}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean{
        /**
         * title : 0.01元全场通用
         * code : 778838347972
         * coupon_type : 3
         * least_cost : 0.00
         * reduce_cost : 0.01
         * rate : 1.00
         * updated_at : 2019-09-10 15:16:58
         */
        //public static final int  TEXTSS =2;
        //public static final int TEXTS= 2;
        //public static final int IMGS = 1;
        //private int itemType;


        private String title;
        private String code;
        private String coupon_type;
        private String least_cost;
        private String reduce_cost;
        private String rate;
        private String updated_at;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCoupon_type() {
            return coupon_type;
        }

        public void setCoupon_type(String coupon_type) {
            this.coupon_type = coupon_type;
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

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }
}
