package com.science.com.rchs.data.bean;

public class Self {

    /**
     * code : 0
     * message : 请求成功
     * data : {"url":"http://zc.yingjiajiqiren.com/EQ/P11620196","code":"P11620196"}
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
         * url : http://zc.yingjiajiqiren.com/EQ/P11620196
         * code : P11620196
         */

        private String url;
        private String code;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
