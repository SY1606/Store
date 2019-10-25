package com.science.com.rchs.data.bean;

import java.util.List;

public class Search {

    /**
     * code : 0
     * message : 请求成功
     * data : {"list":[{"id":13,"card_number":"251395153625","phone":"13582010041","sex":"","balance":"1.00","bonus":"100","created_at":"2019-08-15 15:32:15","nickname":"蹦哒哒","headimgurl":"http://thirdwx.qlogo.cn/mmopen/Lfn91n8lX9Lm6wK40AnuQ0saPTaOgHAIpA3pBgrxRqXyNsIMbBH3mAXotN8S3lYnrmyibqxnSibKkqGmicqsicpmicg/132","discount":null}],"count":0}
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
         * list : [{"id":13,"card_number":"251395153625","phone":"13582010041","sex":"","balance":"1.00","bonus":"100","created_at":"2019-08-15 15:32:15","nickname":"蹦哒哒","headimgurl":"http://thirdwx.qlogo.cn/mmopen/Lfn91n8lX9Lm6wK40AnuQ0saPTaOgHAIpA3pBgrxRqXyNsIMbBH3mAXotN8S3lYnrmyibqxnSibKkqGmicqsicpmicg/132","discount":null}]
         * count : 0
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
             * id : 13
             * card_number : 251395153625
             * phone : 13582010041
             * sex :
             * balance : 1.00
             * bonus : 100
             * created_at : 2019-08-15 15:32:15
             * nickname : 蹦哒哒
             * headimgurl : http://thirdwx.qlogo.cn/mmopen/Lfn91n8lX9Lm6wK40AnuQ0saPTaOgHAIpA3pBgrxRqXyNsIMbBH3mAXotN8S3lYnrmyibqxnSibKkqGmicqsicpmicg/132
             * discount : null
             */

            private int id;
            private String card_number;
            private String phone;
            private String sex;
            private String balance;
            private String bonus;
            private String created_at;
            private String nickname;
            private String headimgurl;
            private Object discount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getBonus() {
                return bonus;
            }

            public void setBonus(String bonus) {
                this.bonus = bonus;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getHeadimgurl() {
                return headimgurl;
            }

            public void setHeadimgurl(String headimgurl) {
                this.headimgurl = headimgurl;
            }

            public Object getDiscount() {
                return discount;
            }

            public void setDiscount(Object discount) {
                this.discount = discount;
            }
        }
    }
}
