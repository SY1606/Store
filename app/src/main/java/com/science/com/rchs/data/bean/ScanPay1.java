package com.science.com.rchs.data.bean;

public class ScanPay1 {

    /**
     * code : 0
     * message : 请求成功
     * data : {"total":0.01,"pay_info":{"info":{"msg":"订单创建成功","type":"scan","api":"","out_trade_no":"201909291524100248979710097"},"status":1,"url":""},"out_trade_no":"201909291524100248979710097","href":"","pay_type":"","pay_status":"scan"}
     */

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
        private double total;
        private String out_trade_no;
        private String href;
        private String pay_type;
        private String pay_status;


        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }


        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }
    }
}
