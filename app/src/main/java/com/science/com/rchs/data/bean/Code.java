package com.science.com.rchs.data.bean;

public class Code {

    /**
     * code : 0
     * message : 请求成功
     * data : {"qrcode_url":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGX8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRGhDb01JZnJjNWwxMU82S3h2NG0AAgTx0kxdAwSAM_EB"}
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
         * qrcode_url : https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQGX8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyRGhDb01JZnJjNWwxMU82S3h2NG0AAgTx0kxdAwSAM_EB
         */

        private String qrcode_url;

        public String getQrcode_url() {
            return qrcode_url;
        }

        public void setQrcode_url(String qrcode_url) {
            this.qrcode_url = qrcode_url;
        }
    }
}
