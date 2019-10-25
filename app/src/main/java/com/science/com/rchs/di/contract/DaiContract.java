package com.science.com.rchs.di.contract;

public interface DaiContract {

    public interface DaiView{
        public void showDaiData(String message);
    }

    public interface DaiPresenter<DisListView>{
        public void attachView(DisListView disListView);
        public void detachView(DisListView disListView);

        public void requestDaiData(String token, int coupon_type);
    }

    public interface DaiModel{
        public void reponseDaiData(String token, int coupon_type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
