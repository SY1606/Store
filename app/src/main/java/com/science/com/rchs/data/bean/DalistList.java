package com.science.com.rchs.data.bean;

public class DalistList {

    /**
     * code : 0
     * message : 请求成功
     * data : {"wxTotal":"0.04","aliTotal":"0.03","total":"0.07","wxCount":4,"aliCount":3,"count":7,"memberConsumptionRecordTotal":"-0.01","memberCumulativeTotal":"0","couponCount":0}
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
         * wxTotal : 0.04
         * aliTotal : 0.03
         * total : 0.07
         * wxCount : 4
         * aliCount : 3
         * count : 7
         * memberConsumptionRecordTotal : -0.01
         * memberCumulativeTotal : 0
         * couponCount : 0
         */

        private String wxTotal;
        private String aliTotal;
        private String total;
        private int wxCount;
        private int aliCount;
        private int count;
        private String memberConsumptionRecordTotal;
        private String memberCumulativeTotal;
        private int couponCount;

        public String getWxTotal() {
            return wxTotal;
        }

        public void setWxTotal(String wxTotal) {
            this.wxTotal = wxTotal;
        }

        public String getAliTotal() {
            return aliTotal;
        }

        public void setAliTotal(String aliTotal) {
            this.aliTotal = aliTotal;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public int getWxCount() {
            return wxCount;
        }

        public void setWxCount(int wxCount) {
            this.wxCount = wxCount;
        }

        public int getAliCount() {
            return aliCount;
        }

        public void setAliCount(int aliCount) {
            this.aliCount = aliCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getMemberConsumptionRecordTotal() {
            return memberConsumptionRecordTotal;
        }

        public void setMemberConsumptionRecordTotal(String memberConsumptionRecordTotal) {
            this.memberConsumptionRecordTotal = memberConsumptionRecordTotal;
        }

        public String getMemberCumulativeTotal() {
            return memberCumulativeTotal;
        }

        public void setMemberCumulativeTotal(String memberCumulativeTotal) {
            this.memberCumulativeTotal = memberCumulativeTotal;
        }

        public int getCouponCount() {
            return couponCount;
        }

        public void setCouponCount(int couponCount) {
            this.couponCount = couponCount;
        }
    }
}

