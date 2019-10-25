package com.science.com.rchs.data.bean;

public class Shops {

    /**
     * code : 0
     * message : 请求成功
     * data : {"id":4147,"phone":"13582010041","logo":"https://luyunkeji.oss-cn-qingdao.aliyuncs.com/Upload/attachment/2019-09-24/dyj.png","ali_alleys":"Aliisv","wx_alleys":"WxPay","password_type":0,"app_state":0}
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
         * id : 4147
         * phone : 13582010041
         * logo : https://luyunkeji.oss-cn-qingdao.aliyuncs.com/Upload/attachment/2019-09-24/dyj.png
         * ali_alleys : Aliisv
         * wx_alleys : WxPay
         * password_type : 0
         * app_state : 0
         */

        private int id;
        private String phone;
        private String logo;
        private String ali_alleys;
        private String wx_alleys;
        private int password_type;
        private int app_state;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getAli_alleys() {
            return ali_alleys;
        }

        public void setAli_alleys(String ali_alleys) {
            this.ali_alleys = ali_alleys;
        }

        public String getWx_alleys() {
            return wx_alleys;
        }

        public void setWx_alleys(String wx_alleys) {
            this.wx_alleys = wx_alleys;
        }

        public int getPassword_type() {
            return password_type;
        }

        public void setPassword_type(int password_type) {
            this.password_type = password_type;
        }

        public int getApp_state() {
            return app_state;
        }

        public void setApp_state(int app_state) {
            this.app_state = app_state;
        }
    }
}

