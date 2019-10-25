package com.science.com.rchs.di.contract;

public interface WinContract {

    public interface WinView{
        public void showWinData(String message);
    }

    public interface WinPresenter<WinView>{
        public void attachView(WinView winView);
        public void detachView(WinView winView);

        public void requestWinData(String token, String type,int startTime,int endTime);
    }

    public interface WinModel{
        public void reponseWinData(String token, String type,int startTime,int endTime, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
