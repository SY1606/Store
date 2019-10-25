package com.science.com.rchs.data.bean;

public class Xinxi {

    /**
     * code : 0
     * message : 请求成功
     * data : {"title":"满200减20代金券","coupon_type":"1","begin_timestamp":"1565740800","end_timestamp":"1566000000","status":"1","number":"100","receiveNum":0,"useNum":0}
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
         * title : 满200减20代金券
         * coupon_type : 1
         * begin_timestamp : 1565740800
         * end_timestamp : 1566000000
         * status : 1
         * number : 100
         * receiveNum : 0
         * useNum : 0
         */

        private String title;
        private String coupon_type;
        private String begin_timestamp;
        private String end_timestamp;
        private String status;
        private String number;
        private int receiveNum;
        private int useNum;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCoupon_type() {
            return coupon_type;
        }

        public void setCoupon_type(String coupon_type) {
            this.coupon_type = coupon_type;
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

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public int getReceiveNum() {
            return receiveNum;
        }

        public void setReceiveNum(int receiveNum) {
            this.receiveNum = receiveNum;
        }

        public int getUseNum() {
            return useNum;
        }

        public void setUseNum(int useNum) {
            this.useNum = useNum;
        }
    }
}