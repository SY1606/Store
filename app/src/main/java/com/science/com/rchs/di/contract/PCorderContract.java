package com.science.com.rchs.di.contract;

public interface PCorderContract {

    public interface PCorderView{
        public void showPCorderData(String message);
    }

    public interface PCorderPresenter<PCorderView>{
        public void attachView(PCorderView pCorderView);
        public void detachView(PCorderView pCorderView);

        public void requestPCorderData(String token, String phone);
    }

    public interface PCorderModel{
        public void reponsePCorderData(String token, String phone, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
