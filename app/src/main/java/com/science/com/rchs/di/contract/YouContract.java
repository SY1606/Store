package com.science.com.rchs.di.contract;

public interface YouContract {

    public interface YouView{
        public void showDaiData(String message);
    }

    public interface YouPresenter<YouView>{
        public void attachView(YouView youView);
        public void detachView(YouView youView);

        public void requestYouData(String token, int type);
    }

    public interface YouModel{
        public void reponseYouData(String token, int type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
