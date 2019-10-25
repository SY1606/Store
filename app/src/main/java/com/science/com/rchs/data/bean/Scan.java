package com.science.com.rchs.data.bean;

public class Scan {

    /**
     * code : 500
     * message : 支付失败，请重试
     * data :
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
