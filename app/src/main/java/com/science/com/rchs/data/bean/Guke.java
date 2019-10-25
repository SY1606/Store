package com.science.com.rchs.data.bean;

public class Guke {

    /**
     * code : 0
     * message : 请求成功
     * data : {"todayCount":1,"threeCount":1,"sevenCount":1}
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
         * todayCount : 1
         * threeCount : 1
         * sevenCount : 1
         */

        private int todayCount;
        private int threeCount;
        private int sevenCount;

        public int getTodayCount() {
            return todayCount;
        }

        public void setTodayCount(int todayCount) {
            this.todayCount = todayCount;
        }

        public int getThreeCount() {
            return threeCount;
        }

        public void setThreeCount(int threeCount) {
            this.threeCount = threeCount;
        }

        public int getSevenCount() {
            return sevenCount;
        }

        public void setSevenCount(int sevenCount) {
            this.sevenCount = sevenCount;
        }
    }
}
