package com.science.com.rchs.di.contract;

public interface XiaofeiContract {

    public interface XiaofeiView{
        public void showXiaofeiData(String message);
    }

    public interface XiaofeiPresenter<XiaofeiView>{
        public void attachView(XiaofeiView xiaofeiView);
        public void detachView(XiaofeiView xiaofeiView);

        public void requestXiaofeiData(String token,String card_number,String value,String remark);
    }

    public interface XiaofeiModel{
        public void reponseXiaofeiData(String token,String card_number,String value,String remark, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
