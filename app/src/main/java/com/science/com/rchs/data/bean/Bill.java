package com.science.com.rchs.data.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class Bill {

    /**
     * code : 0
     * message : 请求成功
     * data : {"actualTotal":"0.02","receivableTotal":"0.02","refundTotal":"0","orderCount":2,"list":[{"out_trade_no":"201909181031400917991004955","total_fee":"0.01","status":"1","createtime":"1568773902","service":"wx_scan"},{"out_trade_no":"201909181029430336555697975","total_fee":"0.01","status":"1","createtime":"1568773785","service":"wx_scan"}]}
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
         * actualTotal : 0.02
         * receivableTotal : 0.02
         * refundTotal : 0
         * orderCount : 2
         * list : [{"out_trade_no":"201909181031400917991004955","total_fee":"0.01","status":"1","createtime":"1568773902","service":"wx_scan"},{"out_trade_no":"201909181029430336555697975","total_fee":"0.01","status":"1","createtime":"1568773785","service":"wx_scan"}]
         */

        private String actualTotal;
        private String receivableTotal;
        private String refundTotal;
        private int orderCount;
        private List<ListBean> list;

        public String getActualTotal() {
            return actualTotal;
        }

        public void setActualTotal(String actualTotal) {
            this.actualTotal = actualTotal;
        }

        public String getReceivableTotal() {
            return receivableTotal;
        }

        public void setReceivableTotal(String receivableTotal) {
            this.receivableTotal = receivableTotal;
        }

        public String getRefundTotal() {
            return refundTotal;
        }

        public void setRefundTotal(String refundTotal) {
            this.refundTotal = refundTotal;
        }

        public int getOrderCount() {
            return orderCount;
        }

        public void setOrderCount(int orderCount) {
            this.orderCount = orderCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean{
            /**
             * out_trade_no : 201909181031400917991004955
             * total_fee : 0.01
             * status : 1
             * createtime : 1568773902
             * service : wx_scan
             */

            private String out_trade_no;
            private String total_fee;
            private String status;
            private String createtime;
            private String service;

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

        }
    }
}

