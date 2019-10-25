package com.science.com.rchs.data.bean;

import java.util.List;

public class Recoder {

    /**
     * code : 0
     * message : 请求成功
     * data : {"list":[{"change_money":"-0.10","created_at":"2019-08-23 16:24:32","card_number":"658743202650","phone":"15903215600"},{"change_money":"-1.00","created_at":"2019-08-23 15:52:28","card_number":"658743202650","phone":"15903215600"},{"change_money":"-1.00","created_at":"2019-08-23 15:40:10","card_number":"658743202650","phone":"15903215600"},{"change_money":"-0.01","created_at":"2019-08-23 14:49:24","card_number":"658743202650","phone":"15903215600"},{"change_money":"-0.01","created_at":"2019-08-23 11:34:26","card_number":"658743202650","phone":"15903215600"},{"change_money":"-0.01","created_at":"2019-08-21 14:27:28","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-20 09:28:30","card_number":"630247987131","phone":"18832130327"},{"change_money":"-0.01","created_at":"2019-08-19 16:28:43","card_number":"482371623177","phone":"18931167713"},{"change_money":"-0.01","created_at":"2019-08-17 18:16:03","card_number":"482371623177","phone":"18931167713"},{"change_money":"-0.08","created_at":"2019-08-17 15:14:09","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-17 15:13:45","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-17 15:02:23","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-16 13:46:52","card_number":"482371623177","phone":"18931167713"},{"change_money":"-0.01","created_at":"2019-08-14 18:40:04","card_number":"482371623177","phone":"18931167713"}],"count":14}
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
         * list : [{"change_money":"-0.10","created_at":"2019-08-23 16:24:32","card_number":"658743202650","phone":"15903215600"},{"change_money":"-1.00","created_at":"2019-08-23 15:52:28","card_number":"658743202650","phone":"15903215600"},{"change_money":"-1.00","created_at":"2019-08-23 15:40:10","card_number":"658743202650","phone":"15903215600"},{"change_money":"-0.01","created_at":"2019-08-23 14:49:24","card_number":"658743202650","phone":"15903215600"},{"change_money":"-0.01","created_at":"2019-08-23 11:34:26","card_number":"658743202650","phone":"15903215600"},{"change_money":"-0.01","created_at":"2019-08-21 14:27:28","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-20 09:28:30","card_number":"630247987131","phone":"18832130327"},{"change_money":"-0.01","created_at":"2019-08-19 16:28:43","card_number":"482371623177","phone":"18931167713"},{"change_money":"-0.01","created_at":"2019-08-17 18:16:03","card_number":"482371623177","phone":"18931167713"},{"change_money":"-0.08","created_at":"2019-08-17 15:14:09","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-17 15:13:45","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-17 15:02:23","card_number":"417706614525","phone":"15232136981"},{"change_money":"-0.01","created_at":"2019-08-16 13:46:52","card_number":"482371623177","phone":"18931167713"},{"change_money":"-0.01","created_at":"2019-08-14 18:40:04","card_number":"482371623177","phone":"18931167713"}]
         * count : 14
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
             * change_money : -0.10
             * created_at : 2019-08-23 16:24:32
             * card_number : 658743202650
             * phone : 15903215600
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
