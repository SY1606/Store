package com.science.com.rchs.data.bean;

import java.util.List;

public class OrderShai {

    /**
     * code : 0
     * message : 请求成功
     * data : {"actualTotal":0,"receivableTotal":0,"refundTotal":0,"orderCount":0,"list":[]}
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
         * actualTotal : 0
         * receivableTotal : 0
         * refundTotal : 0
         * orderCount : 0
         * list : []
         */

        private int actualTotal;
        private int receivableTotal;
        private int refundTotal;
        private int orderCount;
        private List<?> list;

        public int getActualTotal() {
            return actualTotal;
        }

        public void setActualTotal(int actualTotal) {
            this.actualTotal = actualTotal;
        }

        public int getReceivableTotal() {
            return receivableTotal;
        }

        public void setReceivableTotal(int receivableTotal) {
            this.receivableTotal = receivableTotal;
        }

        public int getRefundTotal() {
            return refundTotal;
        }

        public void setRefundTotal(int refundTotal) {
            this.refundTotal = refundTotal;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }
    }
}
