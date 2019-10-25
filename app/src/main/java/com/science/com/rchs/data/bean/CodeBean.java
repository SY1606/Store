package com.science.com.rchs.data.bean;

public class CodeBean {

    /**
     * code : 0
     * message : 请求成功
     * data : {"card":{"card_id":"pD9sF1RD2O9wq2rtbf4awtaHqtv8","begin_time":1567987200,"end_time":1568419200,"code":"778838347972"},"can_consume":false}
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
         * card : {"card_id":"pD9sF1RD2O9wq2rtbf4awtaHqtv8","begin_time":1567987200,"end_time":1568419200,"code":"778838347972"}
         * can_consume : false
         */

        private CardBean card;
        private boolean can_consume;

        public CardBean getCard() {
            return card;
        }

        public void setCard(CardBean card) {
            this.card = card;
        }

        public boolean isCan_consume() {
            return can_consume;
        }

        public void setCan_consume(boolean can_consume) {
            this.can_consume = can_consume;
        }

        public static class CardBean {
            /**
             * card_id : pD9sF1RD2O9wq2rtbf4awtaHqtv8
             * begin_time : 1567987200
             * end_time : 1568419200
             * code : 778838347972
             */

            private String card_id;
            private int begin_time;
            private int end_time;
            private String code;

            public String getCard_id() {
                return card_id;
            }

            public void setCard_id(String card_id) {
                this.card_id = card_id;
            }

            public int getBegin_time() {
                return begin_time;
            }

            public void setBegin_time(int begin_time) {
                this.begin_time = begin_time;
            }

            public int getEnd_time() {
                return end_time;
            }

            public void setEnd_time(int end_time) {
                this.end_time = end_time;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
