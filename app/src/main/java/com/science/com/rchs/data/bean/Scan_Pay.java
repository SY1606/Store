package com.science.com.rchs.data.bean;

public class Scan_Pay {

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

    public class Data {
        private double total;
        private String out_trade_no;
        private String href;
        private String pay_type;
        private String pay_status;

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }
    }
        /**
         * code : 0
         * message : 请求成功
         * data : {"total":0.11,"pay_info":{"info":{"msg":"订单创建成功","type":"scan","api":"","out_trade_no":"201909300149380840501011015"},"status":1,"url":""},"out_trade_no":"201909300149380840501011015","href":"","pay_type":"","pay_status":"scan"}
         */

    /*private int code;
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
         * total : 0.11
         * pay_info : {"info":{"msg":"订单创建成功","type":"scan","api":"","out_trade_no":"201909300149380840501011015"},"status":1,"url":""}
         * out_trade_no : 201909300149380840501011015
         * href :
         * pay_type :
         * pay_status : scan
         */

       /* private double total;
        private PayInfoBean pay_info;
        private String out_trade_no;
        private String href;
        private String pay_type;
        private String pay_status;

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public PayInfoBean getPay_info() {
            return pay_info;
        }

        public void setPay_info(PayInfoBean pay_info) {
            this.pay_info = pay_info;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public static class PayInfoBean {
            /**
             * info : {"msg":"订单创建成功","type":"scan","api":"","out_trade_no":"201909300149380840501011015"}
             * status : 1
             * url :
             */

           /* private InfoBean info;
            private int status;
            private String url;

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public static class InfoBean {
                /**
                 * msg : 订单创建成功
                 * type : scan
                 * api :
                 * out_trade_no : 201909300149380840501011015
                 */

                /*private String msg;
                private String type;
                private String api;
                private String out_trade_no;

                public String getMsg() {
                    return msg;
                }

                public void setMsg(String msg) {
                    this.msg = msg;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getApi() {
                    return api;
                }

                public void setApi(String api) {
                    this.api = api;
                }

                public String getOut_trade_no() {
                    return out_trade_no;
                }

                public void setOut_trade_no(String out_trade_no) {
                    this.out_trade_no = out_trade_no;
                }
            }
        }
    }*/
}