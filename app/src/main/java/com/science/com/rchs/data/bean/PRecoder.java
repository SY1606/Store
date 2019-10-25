package com.science.com.rchs.data.bean;

import java.util.List;

public class PRecoder {

    /**
     * code : 0
     * message : 请求成功
     * data : {"list":[{"change_money":"-0.01","created_at":"2019-09-05 19:33:43","card_number":"170119142569","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-09-04 18:51:47","card_number":"170119142569","phone":"15232136981"}],"count":2}
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
         * list : [{"change_money":"-0.01","created_at":"2019-09-05 19:33:43","card_number":"170119142569","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-09-04 18:51:47","card_number":"170119142569","phone":"15232136981"}]
         * count : 2
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * change_money : -0.01
             * created_at : 2019-09-05 19:33:43
             * card_number : 170119142569
             * phone : 15232136981
             */

            private String change_money;
            private String created_at;
            private String card_number;
            private String phone;

            public String getChange_money() {
                return change_money;
            }

            public void setChange_money(String change_money) {
                this.change_money = change_money;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getCard_number() {
                return card_number;
            }

            public void setCard_number(String card_number) {
                this.card_number = card_number;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }
}
