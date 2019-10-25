package com.science.com.rchs.di.contract;

public interface SelfContract {

    public interface SelfView{
        public void showSelfData(String message);
    }

    public interface SelfPresenter<SelfView>{
        public void attachView(SelfView selfView);
        public void detachView(SelfView selfView);

        public void requestSelfData(String token,int store_id);
    }

    public interface SelfModel{
        public void reponseSelfData(String token,int store_id,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
