package com.science.com.rchs.di.contract;

public interface WinSContract {

    public interface WinSView{
        public void showWinSData(String message);
    }

    public interface WinSPresenter<WinSView>{
        public void attachView(WinSView winSView);
        public void detachView(WinSView winSView);

        public void requestWinSData(String token,String type,int startTime,int endTime);
    }

    public interface WinSModel{
        public void reponseWinSData(String token,String type,int startTime,int endTime, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
