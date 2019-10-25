package com.science.com.rchs.data.bean;

public class Open {

    /**
     * code : 0
     * message : 请求成功
     * data : {"qrcodeUrl":"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQFD8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyNVJzR05ZZnJjNWwxNGlMWHh2NHUAAgSSO1pdAwSAM_EB","backImage":"https://file.luyunkeji.com/Upload/wechatapi/cardBackGroundImage/%E4%BC%9A%E5%91%98%E5%8D%A1%E9%A2%86%E5%88%B8.jpg"}
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
         * qrcodeUrl : https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQFD8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyNVJzR05ZZnJjNWwxNGlMWHh2NHUAAgSSO1pdAwSAM_EB
         * backImage : https://file.luyunkeji.com/Upload/wechatapi/cardBackGroundImage/%E4%BC%9A%E5%91%98%E5%8D%A1%E9%A2%86%E5%88%B8.jpg
         */

        private String qrcodeUrl;
        private String backImage;

        public String getQrcodeUrl() {
            return qrcodeUrl;
        }

        public void setQrcodeUrl(String qrcodeUrl) {
            this.qrcodeUrl = qrcodeUrl;
        }

        public String getBackImage() {
            return backImage;
        }

        public void setBackImage(String backImage) {
            this.backImage = backImage;
        }
    }
}
