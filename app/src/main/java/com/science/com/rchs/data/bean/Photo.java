package com.science.com.rchs.data.bean;

public class Photo {
    /**
     * code : 0
     * message : 请求成功
     * data : {"url":"http://mmbiz.qpic.cn/***"}
     */

    private int code;

    private String message;

    private Object data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public class Data {

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
