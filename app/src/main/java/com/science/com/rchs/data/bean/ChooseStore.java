package com.science.com.rchs.data.bean;

import java.util.List;

public class ChooseStore {

    /**
     * code : 0
     * message : 请求成功
     * data : [{"id":4230,"name":"路云家居用品","actualTotal":0.04,"orderCount":4}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4230
         * name : 路云家居用品
         * actualTotal : 0.04
         * orderCount : 4
         */

        private int id;
        private String name;
        private double actualTotal;
        private int orderCount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getActualTotal() {
            return actualTotal;
        }

        public void setActualTotal(double actualTotal) {
            this.actualTotal = actualTotal;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }
    }
}
