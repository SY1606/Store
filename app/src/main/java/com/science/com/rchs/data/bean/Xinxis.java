package com.science.com.rchs.data.bean;

public class Xinxis {

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

    public class Data{
        private String title;
        private String coupon_type;
        private String begin_timestamp;
        private String end_timestamp;
        private String status;
        private String number;
        private String receiveNum;
        private String useNum;

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

        public String getReceiveNum() {
            return receiveNum;
        }

        public void setReceiveNum(String receiveNum) {
            this.receiveNum = receiveNum;
        }

        public String getUseNum() {
            return useNum;
        }

        public void setUseNum(String useNum) {
            this.useNum = useNum;
        }
    }
}
