package com.science.com.rchs.di.contract;

public interface WxContract {

    public interface WxView{

        //微信优惠券收款
        public void showWxData(String message);

        //文字信息
        public void showCodesData(String message);
    }

    public interface WxPresenter<ChatView>{
        public void attachView(ChatView chatView);
        public void detachView(ChatView chatView);


        public void requestWxData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type,String coupon_code);
        public void requestCodesData(String token, String coupon_code);

    }

    public interface WxModel{
        public void reponseWxData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type,String coupon_code, CallBack callBack);

        public void reponseCodesData(String token,String coupon_code,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
