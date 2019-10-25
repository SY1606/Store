package com.science.com.rchs.di.contract;

public interface XinxiContract {

    public interface XinxiView{
        public void showXinxiData(String message);
    }

    public interface XinxiPresenter<XinxiView>{
        public void attachView(XinxiView xinxiView);
        public void detachView(XinxiView xinxiView);

        public void requestXinxiData(String token, String  coupon_id);
    }

    public interface XinxiModel{
        public void reponseXinxiData(String token, String coupon_id, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
