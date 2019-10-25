package com.science.com.rchs.data.bean;

public class CodesPay {


    private int code;

    private String message;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public class Data {
        private int id;
        private String mch_seller_id;
        private String members_id;
        private String coupon_id;
        private String coupon_type;
        private String title;
        private String code;
        private String status;
        private String is_del;
        private String least_cost;
        private String reduce_cost;
        private String rate;
        private String begin_timestamp;
        private String end_timestamp;
        private String created_at;
        private Object updated_at;

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

        public String getMembers_id() {
            return members_id;
        }

        public void setMembers_id(String members_id) {
            this.members_id = members_id;
        }

        public String getCoupon_id() {
            return coupon_id;
        }

        public void setCoupon_id(String coupon_id) {
            this.coupon_id = coupon_id;
        }

        public String getCoupon_type() {
            return coupon_type;
        }

        public void setCoupon_type(String coupon_type) {
            this.coupon_type = coupon_type;
        }

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

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public Object getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Object updated_at) {
            this.updated_at = updated_at;
        }
    }

    /**
     * code : 0
     * message : 请求成功
     * data : {"id":57,"mch_seller_id":"4088","members_id":"29","coupon_id":"56","coupon_type":"3","title":"10元全场通用","code":"729010707074","status":"0","is_del":"0","least_cost":"0.00","reduce_cost":"10.00","rate":"1.00","begin_timestamp":"1568846151","end_timestamp":"1569168000","created_at":"2019-09-22 17:25:21","updated_at":null}
     */

    /*private int code;
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
         * id : 57
         * mch_seller_id : 4088
         * members_id : 29
         * coupon_id : 56
         * coupon_type : 3
         * title : 10元全场通用
         * code : 729010707074
         * status : 0
         * is_del : 0
         * least_cost : 0.00
         * reduce_cost : 10.00
         * rate : 1.00
         * begin_timestamp : 1568846151
         * end_timestamp : 1569168000
         * created_at : 2019-09-22 17:25:21
         * updated_at : null
         */

        /*private int id;
        private String mch_seller_id;
        private String members_id;
        private String coupon_id;
        private String coupon_type;
        private String title;
        private String code;
        private String status;
        private String is_del;
        private String least_cost;
        private String reduce_cost;
        private String rate;
        private String begin_timestamp;
        private String end_timestamp;
        private String created_at;
        private Object updated_at;

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

        public String getMembers_id() {
            return members_id;
        }

        public void setMembers_id(String members_id) {
            this.members_id = members_id;
        }

        public String getCoupon_id() {
            return coupon_id;
        }

        public void setCoupon_id(String coupon_id) {
            this.coupon_id = coupon_id;
        }

        public String getCoupon_type() {
            return coupon_type;
        }

        public void setCoupon_type(String coupon_type) {
            this.coupon_type = coupon_type;
        }

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

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public Object getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Object updated_at) {
            this.updated_at = updated_at;
        }
    }*/
}
