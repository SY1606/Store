package com.science.com.rchs.data.bean;

import java.util.List;

public class WinS {


    /**
     * code : 0
     * message : 请求成功
     * data : {"actualTotal":0,"receivableTotal":0,"refundTotal":0,"orderCount":0,"list":[{"out_trade_no":"201908231114491681574999511","total_fee":"0.65","status":"1","createtime":"1566530089","service":"wx_jsapi"},{"out_trade_no":"201908231114141276545610153","total_fee":"0.02","status":"1","createtime":"1566530055","service":"wx_jsapi"},{"out_trade_no":"201908221037450201575356102","total_fee":"0.01","status":"1","createtime":"1566441466","service":"wx_jsapi"},{"out_trade_no":"201908211844580585979910052","total_fee":"0.01","status":"1","createtime":"1566384299","service":"wx_jsapi"},{"out_trade_no":"201908211835460758501019710","total_fee":"0.01","status":"1","createtime":"1566383748","service":"wx_jsapi"},{"out_trade_no":"201908211452240379565657565","total_fee":"0.01","status":"1","createtime":"1566370345","service":"wx_jsapi"},{"out_trade_no":"201908211445200111485456999","total_fee":"0.01","status":"1","createtime":"1566369921","service":"wx_jsapi"},{"out_trade_no":"201908201652250907575497100","total_fee":"0.01","status":"1","createtime":"1566291146","service":"wx_jsapi"},{"out_trade_no":"201908171831330791539952501","total_fee":"0.01","status":"1","createtime":"1566037894","service":"wx_jsapi"},{"out_trade_no":"201908171812060351544898100","total_fee":"0.01","status":"1","createtime":"1566036727","service":"wx_jsapi"},{"out_trade_no":"201908171807230753985548995","total_fee":"0.01","status":"1","createtime":"1566036444","service":"wx_jsapi"},{"out_trade_no":"201908171723490490539797545","total_fee":"0.07","status":"1","createtime":"1566033830","service":"wx_jsapi"},{"out_trade_no":"201908171705560393525648535","total_fee":"0.01","status":"1","createtime":"1566032757","service":"wx_jsapi"},{"out_trade_no":"201908171630000620561005754","total_fee":"0.01","status":"1","createtime":"1566030602","service":"wx_jsapi"},{"out_trade_no":"201908171538070972102554851","total_fee":"0.01","status":"1","createtime":"1566027488","service":"wx_jsapi"},{"out_trade_no":"201908171406220820101559848","total_fee":"0.09","status":"1","createtime":"1566021983","service":"wx_jsapi"},{"out_trade_no":"201908171405260435545454985","total_fee":"0.01","status":"1","createtime":"1566021927","service":"wx_jsapi"},{"out_trade_no":"201908171404240309565354551","total_fee":"0.01","status":"1","createtime":"1566021865","service":"wx_jsapi"},{"out_trade_no":"201908171155370712575099514","total_fee":"0.1","status":"1","createtime":"1566014138","service":"wx_jsapi"},{"out_trade_no":"201908161354490864579997994","total_fee":"0.7","status":"1","createtime":"1565934890","service":"wx_jsapi"}]}
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
         * list : [{"out_trade_no":"201908231114491681574999511","total_fee":"0.65","status":"1","createtime":"1566530089","service":"wx_jsapi"},{"out_trade_no":"201908231114141276545610153","total_fee":"0.02","status":"1","createtime":"1566530055","service":"wx_jsapi"},{"out_trade_no":"201908221037450201575356102","total_fee":"0.01","status":"1","createtime":"1566441466","service":"wx_jsapi"},{"out_trade_no":"201908211844580585979910052","total_fee":"0.01","status":"1","createtime":"1566384299","service":"wx_jsapi"},{"out_trade_no":"201908211835460758501019710","total_fee":"0.01","status":"1","createtime":"1566383748","service":"wx_jsapi"},{"out_trade_no":"201908211452240379565657565","total_fee":"0.01","status":"1","createtime":"1566370345","service":"wx_jsapi"},{"out_trade_no":"201908211445200111485456999","total_fee":"0.01","status":"1","createtime":"1566369921","service":"wx_jsapi"},{"out_trade_no":"201908201652250907575497100","total_fee":"0.01","status":"1","createtime":"1566291146","service":"wx_jsapi"},{"out_trade_no":"201908171831330791539952501","total_fee":"0.01","status":"1","createtime":"1566037894","service":"wx_jsapi"},{"out_trade_no":"201908171812060351544898100","total_fee":"0.01","status":"1","createtime":"1566036727","service":"wx_jsapi"},{"out_trade_no":"201908171807230753985548995","total_fee":"0.01","status":"1","createtime":"1566036444","service":"wx_jsapi"},{"out_trade_no":"201908171723490490539797545","total_fee":"0.07","status":"1","createtime":"1566033830","service":"wx_jsapi"},{"out_trade_no":"201908171705560393525648535","total_fee":"0.01","status":"1","createtime":"1566032757","service":"wx_jsapi"},{"out_trade_no":"201908171630000620561005754","total_fee":"0.01","status":"1","createtime":"1566030602","service":"wx_jsapi"},{"out_trade_no":"201908171538070972102554851","total_fee":"0.01","status":"1","createtime":"1566027488","service":"wx_jsapi"},{"out_trade_no":"201908171406220820101559848","total_fee":"0.09","status":"1","createtime":"1566021983","service":"wx_jsapi"},{"out_trade_no":"201908171405260435545454985","total_fee":"0.01","status":"1","createtime":"1566021927","service":"wx_jsapi"},{"out_trade_no":"201908171404240309565354551","total_fee":"0.01","status":"1","createtime":"1566021865","service":"wx_jsapi"},{"out_trade_no":"201908171155370712575099514","total_fee":"0.1","status":"1","createtime":"1566014138","service":"wx_jsapi"},{"out_trade_no":"201908161354490864579997994","total_fee":"0.7","status":"1","createtime":"1565934890","service":"wx_jsapi"}]
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
             * out_trade_no : 201908231114491681574999511
             * total_fee : 0.65
             * status : 1
             * createtime : 1566530089
             * service : wx_jsapi
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
