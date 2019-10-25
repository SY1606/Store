package com.science.com.rchs.data.bean;

public class ScanPay {
    /**
     * code : 0
     * message : 请求成功
     * data : {"total":0.01,"pay_info":{"info":{"msg":"订单创建成功","type":"scan","api":"","out_trade_no":"201909121827220492975798975"},"status":1,"url":""},"out_trade_no":"201909121827220492975798975","href":"","pay_type":"","pay_status":"scan"}
     */

    private int code;
    private String message;

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


}
