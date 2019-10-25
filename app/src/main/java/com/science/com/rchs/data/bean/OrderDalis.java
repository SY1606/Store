package com.science.com.rchs.data.bean;

public class OrderDalis {
    /**
     * code : 0
     * message : 请求成功
     * data : {"out_trade_no":"201909171014391512102541009","total_fee":"0.01","status":"1","createtime":"1568686479","service":"wx_jsapi","transaction_id":"4200000408201909173438196793"}
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
         * out_trade_no : 201909171014391512102541009
         * total_fee : 0.01
         * status : 1
         * createtime : 1568686479
         * service : wx_jsapi
         * transaction_id : 4200000408201909173438196793
         */

        private String out_trade_no;
        private String total_fee;
        private String status;
        private String createtime;
        private String service;
        private String transaction_id;

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }
    }
}
