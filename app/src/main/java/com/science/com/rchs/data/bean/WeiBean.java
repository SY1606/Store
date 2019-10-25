package com.science.com.rchs.data.bean;

import java.util.List;

public class WeiBean {

    /**
     * code : 0
     * message : 请求成功
     * data : {"actualTotal":0,"receivableTotal":0,"refundTotal":0,"orderCount":0,"list":[{"out_trade_no":"20190606###6561015350","total_fee":"0.1","status":1,"createtime":1559820460,"service":"ali_jsapi"},{"out_trade_no":"2019060###2677565449565","total_fee":"0.01","status":0,"createtime":1559815321,"service":"ali_jsapi"}]}
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
         * list : [{"out_trade_no":"20190606###6561015350","total_fee":"0.1","status":1,"createtime":1559820460,"service":"ali_jsapi"},{"out_trade_no":"2019060###2677565449565","total_fee":"0.01","status":0,"createtime":1559815321,"service":"ali_jsapi"}]
         */

        private int actualTotal;
        private int receivableTotal;
        private int refundTotal;
        private int orderCount;
        private List<ListBean> list;

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * out_trade_no : 20190606###6561015350
             * total_fee : 0.1
             * status : 1
             * createtime : 1559820460
             * service : ali_jsapi
             */

            private String out_trade_no;
            private String total_fee;
            private int status;
            private int createtime;
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getCreatetime() {
                return createtime;
            }

            public void setCreatetime(int createtime) {
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
