package com.science.com.rchs.data.bean;

import java.util.List;

public class Chongzhi {

    /**
     * code : 0
     * message : 请求成功
     * data : {"list":[{"total_fee":"0.1","createtime":"1566014138","status":"1","card_number":"417706614525"},{"total_fee":"0.01","createtime":"1565934310","status":"1","card_number":"482371623177"},{"total_fee":"0.05","createtime":"1565925926","status":"1","card_number":"541312016154"},{"total_fee":"0.98","createtime":"1565925904","status":"1","card_number":"251395153625"},{"total_fee":"0.01","createtime":"1565898164","status":"1","card_number":"482371623177"},{"total_fee":"0.01","createtime":"1565778164","status":"1","card_number":"482371623177"},{"total_fee":"0.01","createtime":"1565778164","status":"1","card_number":"482371623177"}],"todayTotal":"0.00","cumulativeTotal":"1.17"}
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
         * list : [{"total_fee":"0.1","createtime":"1566014138","status":"1","card_number":"417706614525"},{"total_fee":"0.01","createtime":"1565934310","status":"1","card_number":"482371623177"},{"total_fee":"0.05","createtime":"1565925926","status":"1","card_number":"541312016154"},{"total_fee":"0.98","createtime":"1565925904","status":"1","card_number":"251395153625"},{"total_fee":"0.01","createtime":"1565898164","status":"1","card_number":"482371623177"},{"total_fee":"0.01","createtime":"1565778164","status":"1","card_number":"482371623177"},{"total_fee":"0.01","createtime":"1565778164","status":"1","card_number":"482371623177"}]
         * todayTotal : 0.00
         * cumulativeTotal : 1.17
         */

        private String todayTotal;
        private String cumulativeTotal;
        private List<ListBean> list;

        public String getTodayTotal() {
            return todayTotal;
        }

        public void setTodayTotal(String todayTotal) {
            this.todayTotal = todayTotal;
        }

        public String getCumulativeTotal() {
            return cumulativeTotal;
        }

        public void setCumulativeTotal(String cumulativeTotal) {
            this.cumulativeTotal = cumulativeTotal;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * total_fee : 0.1
             * createtime : 1566014138
             * status : 1
             * card_number : 417706614525
             */

            private String total_fee;
            private String createtime;
            private String status;
            private String card_number;

            public String getTotal_fee() {
                return total_fee;
            }

            public void setTotal_fee(String total_fee) {
                this.total_fee = total_fee;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getCard_number() {
                return card_number;
            }

            public void setCard_number(String card_number) {
                this.card_number = card_number;
            }
        }
    }
}
