package com.science.com.rchs.data.bean;

import java.util.List;

public class StarRecord {

    /**
     * code : 0
     * message : 提现流水获取成功
     * data : [{"merc_id":"800121000011857","merc_nm":"大帅哥便利店","stoe_id":"102121053111659","stoe_nm":"河北省石家庄市大帅哥便利店","stl_crp_no":"6222030402002224265","opn_bnk_desc":"工商银行","ord_no":"agsljr","tx_log_no":"FW0000000004731652","ord_tm":"20190831135938","upt_tm":"20190831135938","txn_amt":"100","transfer_amt":"50","corg_fee":"50","sts":"S"},{"merc_id":"800121000011857","merc_nm":"大帅哥便利店","stoe_id":"102121053111659","stoe_nm":"河北省石家庄市大帅哥便利店","stl_crp_no":"6222030402002224265","opn_bnk_desc":"工商银行","ord_no":"ahg57d","tx_log_no":"FW0000000004736922","ord_tm":"20190831170441","upt_tm":"20190831170441","txn_amt":"200","transfer_amt":"150","corg_fee":"50","sts":"S"}]
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
         * merc_id : 800121000011857
         * merc_nm : 大帅哥便利店
         * stoe_id : 102121053111659
         * stoe_nm : 河北省石家庄市大帅哥便利店
         * stl_crp_no : 6222030402002224265
         * opn_bnk_desc : 工商银行
         * ord_no : agsljr
         * tx_log_no : FW0000000004731652
         * ord_tm : 20190831135938
         * upt_tm : 20190831135938
         * txn_amt : 100
         * transfer_amt : 50
         * corg_fee : 50
         * sts : S
         */

        private String merc_id;
        private String merc_nm;
        private String stoe_id;
        private String stoe_nm;
        private String stl_crp_no;
        private String opn_bnk_desc;
        private String ord_no;
        private String tx_log_no;
        private String ord_tm;
        private String upt_tm;
        private String txn_amt;
        private String transfer_amt;
        private String corg_fee;
        private String sts;

        public String getMerc_id() {
            return merc_id;
        }

        public void setMerc_id(String merc_id) {
            this.merc_id = merc_id;
        }

        public String getMerc_nm() {
            return merc_nm;
        }

        public void setMerc_nm(String merc_nm) {
            this.merc_nm = merc_nm;
        }

        public String getStoe_id() {
            return stoe_id;
        }

        public void setStoe_id(String stoe_id) {
            this.stoe_id = stoe_id;
        }

        public String getStoe_nm() {
            return stoe_nm;
        }

        public void setStoe_nm(String stoe_nm) {
            this.stoe_nm = stoe_nm;
        }

        public String getStl_crp_no() {
            return stl_crp_no;
        }

        public void setStl_crp_no(String stl_crp_no) {
            this.stl_crp_no = stl_crp_no;
        }

        public String getOpn_bnk_desc() {
            return opn_bnk_desc;
        }

        public void setOpn_bnk_desc(String opn_bnk_desc) {
            this.opn_bnk_desc = opn_bnk_desc;
        }

        public String getOrd_no() {
            return ord_no;
        }

        public void setOrd_no(String ord_no) {
            this.ord_no = ord_no;
        }

        public String getTx_log_no() {
            return tx_log_no;
        }

        public void setTx_log_no(String tx_log_no) {
            this.tx_log_no = tx_log_no;
        }

        public String getOrd_tm() {
            return ord_tm;
        }

        public void setOrd_tm(String ord_tm) {
            this.ord_tm = ord_tm;
        }

        public String getUpt_tm() {
            return upt_tm;
        }

        public void setUpt_tm(String upt_tm) {
            this.upt_tm = upt_tm;
        }

        public String getTxn_amt() {
            return txn_amt;
        }

        public void setTxn_amt(String txn_amt) {
            this.txn_amt = txn_amt;
        }

        public String getTransfer_amt() {
            return transfer_amt;
        }

        public void setTransfer_amt(String transfer_amt) {
            this.transfer_amt = transfer_amt;
        }

        public String getCorg_fee() {
            return corg_fee;
        }

        public void setCorg_fee(String corg_fee) {
            this.corg_fee = corg_fee;
        }

        public String getSts() {
            return sts;
        }

        public void setSts(String sts) {
            this.sts = sts;
        }
    }
}
