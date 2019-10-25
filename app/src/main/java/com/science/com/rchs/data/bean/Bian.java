package com.science.com.rchs.data.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Bian {
    private int code;

    private String message;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public class Data{
        private String card_type;
        private Object discount;

        public String getCard_type() {
            return card_type;
        }

        public void setCard_type(String card_type) {
            this.card_type = card_type;
        }

        public Object getDiscount() {
            return discount;
        }

        public void setDiscount(Object discount) {
            this.discount = discount;
        }
    }

    public class discount{
        private Object base_info;
        private String discount;
        public Object advanced_info;

        public Object getBase_info() {
            return base_info;
        }

        public void setBase_info(Object base_info) {
            this.base_info = base_info;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public Object getAdvanced_info() {
            return advanced_info;
        }

        public void setAdvanced_info(Object advanced_info) {
            this.advanced_info = advanced_info;
        }
    }

    public class baseinfo{
        private String id;
        private String logo_url;
        private String code_type;
        private String brand_name;
        private String title;
        private String color;
        private String notice;
        private String description;
        private int use_limit;
        private int get_limit;
        private boolean can_share;
        private boolean can_give_friend;
        private String status;
        private int create_time;
        private int update_time;


    }
}
