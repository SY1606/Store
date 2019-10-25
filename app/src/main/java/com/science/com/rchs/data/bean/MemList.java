package com.science.com.rchs.data.bean;

import java.util.List;

public class MemList {

    /**
     * code : 0
     * message : 请求成功
     * data : [{"id":25,"card_number":"074207339439","phone":"13935255703","balance":"0.00","bonus":"109","created_at":"2019-09-06 16:41:13","nickname":"终遇你","headimgurl":""},{"id":22,"card_number":"123118386158","phone":"15811485714","balance":"1.00","bonus":"1210","created_at":"2019-09-05 21:08:31","nickname":"🌚","headimgurl":""},{"id":21,"card_number":"961473069836","phone":"18931105703","balance":"0.00","bonus":"100","created_at":"2019-09-05 18:03:27","nickname":"磊Ley","headimgurl":""},{"id":16,"card_number":"170119142569","phone":"15232136981","balance":"0.98","bonus":"1238","created_at":"2019-09-04 18:40:34","nickname":"请叫我'小妖'","headimgurl":"http://thirdwx.qlogo.cn/mmopen/haGO7SZXDH6fsgkwryAlEnmib1MWPzQg0REBBDoT4VguEEz6FtD52OUnwWS8H5pbausG5OFlQnXu9q12qwzdotNaS12Z2WXOE/132"},{"id":11,"card_number":"852370079407","phone":"13582010041","balance":"0.00","bonus":"100","created_at":"2019-09-02 10:11:46","nickname":"蹦哒哒","headimgurl":""},{"id":10,"card_number":"569674150390","phone":"18931167713","balance":"0.01","bonus":"218","created_at":"2019-08-31 16:27:44","nickname":"Mr.Q","headimgurl":"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLC9vY396p9u8l7sbVh24f0obXCeeTbesCszuWBiaQEKJvdtibLHfFIHGE0ZStCqcELgtD1raaNAvZ6Q/132"},{"id":7,"card_number":"860064373493","phone":"15903215600","balance":"0.00","bonus":"310","created_at":"2019-08-29 10:13:26","nickname":"有些人叫我阿zùn","headimgurl":""},{"id":6,"card_number":"104648373560","phone":"13731175456","balance":"0.00","bonus":"100","created_at":"2019-08-29 10:11:55","nickname":"巴扎嘿","headimgurl":""},{"id":5,"card_number":"616310825142","phone":"13603393467","balance":"0.00","bonus":"100","created_at":"2019-08-29 09:56:59","nickname":"阿盟","headimgurl":""}]
     */

    private int code;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 25
         * card_number : 074207339439
         * phone : 13935255703
         * balance : 0.00
         * bonus : 109
         * created_at : 2019-09-06 16:41:13
         * nickname : 终遇你
         * headimgurl :
         */

        private int id;
        private String card_number;
        private String phone;
        private String balance;
        private String bonus;
        private String created_at;
        private String nickname;
        private String headimgurl;

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
    }
}
