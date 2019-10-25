package com.science.com.rchs.data.bean;

public class Money {

    /**
     * code : 0
     * message : 请求成功
     * data : {"oneHundredMoney":2,"fiveHundredMoney":0,"oneThousandmoney":0,"twoThousandmoney":0}
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
         * oneHundredMoney : 2
         * fiveHundredMoney : 0
         * oneThousandmoney : 0
         * twoThousandmoney : 0
         */

        private int oneHundredMoney;
        private int fiveHundredMoney;
        private int oneThousandmoney;
        private int twoThousandmoney;

        public int getOneHundredMoney() {
            return oneHundredMoney;
        }

        public void setOneHundredMoney(int oneHundredMoney) {
            this.oneHundredMoney = oneHundredMoney;
        }

        public int getFiveHundredMoney() {
            return fiveHundredMoney;
        }

        public void setFiveHundredMoney(int fiveHundredMoney) {
            this.fiveHundredMoney = fiveHundredMoney;
        }

        public int getOneThousandmoney() {
            return oneThousandmoney;
        }

        public void setOneThousandmoney(int oneThousandmoney) {
            this.oneThousandmoney = oneThousandmoney;
        }

        public int getTwoThousandmoney() {
            return twoThousandmoney;
        }

        public void setTwoThousandmoney(int twoThousandmoney) {
            this.twoThousandmoney = twoThousandmoney;
        }
    }
}
