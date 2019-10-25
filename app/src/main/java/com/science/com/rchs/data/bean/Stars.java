package com.science.com.rchs.data.bean;

import java.util.List;

public class Stars {

    /**
     * code : 0
     * message : 请求成功
     * data : [{"pay_day_max":"10000000","pay_day_min":"100","pay_sig_max":"5000000","service_fee":"0.02","flag":"0","merc_id":"800121000011857","stoe_id":"102121053111659","merc_nm":"大帅哥便利店","stoe_nm":"河北省石家庄市大帅哥便利店","reg_dt":"20190818070851","stl_oac":"6222030402002224265","opn_bnk_desc":"工商银行","balance":"0"}]
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
         * pay_day_max : 10000000
         * pay_day_min : 100
         * pay_sig_max : 5000000
         * service_fee : 0.02
         * flag : 0
         * merc_id : 800121000011857
         * stoe_id : 102121053111659
         * merc_nm : 大帅哥便利店
         * stoe_nm : 河北省石家庄市大帅哥便利店
         * reg_dt : 20190818070851
         * stl_oac : 6222030402002224265
         * opn_bnk_desc : 工商银行
         * balance : 0
         */

        private String pay_day_max;
        private String pay_day_min;
        private String pay_sig_max;
        private String service_fee;
        private String flag;
        private String merc_id;
        private String stoe_id;
        private String merc_nm;
        private String stoe_nm;
        private String reg_dt;
        private String stl_oac;
        private String opn_bnk_desc;
        private String balance;

        public String getPay_day_max() {
            return pay_day_max;
        }

        public void setPay_day_max(String pay_day_max) {
            this.pay_day_max = pay_day_max;
        }

        public String getPay_day_min() {
            return pay_day_min;
        }

        public void setPay_day_min(String pay_day_min) {
            this.pay_day_min = pay_day_min;
        }

        public String getPay_sig_max() {
            return pay_sig_max;
        }

        public void setPay_sig_max(String pay_sig_max) {
            this.pay_sig_max = pay_sig_max;
        }

        public String getService_fee() {
            return service_fee;
        }

        public void setService_fee(String service_fee) {
            this.service_fee = service_fee;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getMerc_id() {
            return merc_id;
        }

        public void setMerc_id(String merc_id) {
            this.merc_id = merc_id;
        }

        public String getStoe_id() {
            return stoe_id;
        }

        public void setStoe_id(String stoe_id) {
            this.stoe_id = stoe_id;
        }

        public String getMerc_nm() {
            return merc_nm;
        }

        public void setMerc_nm(String merc_nm) {
            this.merc_nm = merc_nm;
        }

        public String getStoe_nm() {
            return stoe_nm;
        }

        public void setStoe_nm(String stoe_nm) {
            this.stoe_nm = stoe_nm;
        }

        public String getReg_dt() {
            return reg_dt;
        }

        public void setReg_dt(String reg_dt) {
            this.reg_dt = reg_dt;
        }

        public String getStl_oac() {
            return stl_oac;
        }

        public void setStl_oac(String stl_oac) {
            this.stl_oac = stl_oac;
        }

        public String getOpn_bnk_desc() {
            return opn_bnk_desc;
        }

        public void setOpn_bnk_desc(String opn_bnk_desc) {
            this.opn_bnk_desc = opn_bnk_desc;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }
    }
}
