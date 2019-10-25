package com.science.com.rchs.di.contract;

public interface SendContract {

    public interface SendView{
        public void showSendData(String message);
    }

    public interface SendPresenter<SendView>{
        public void attachView(SendView sendView);
        public void detachView(SendView SendView);

        public void requestSendData(String phone);
    }

    public interface SendModel{
        public void reponseSendData(String phone, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
