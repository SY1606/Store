package com.science.com.rchs.di.contract;

public interface YouAllContract {

    public interface YouAllView{
        public void showYouAllData(String message);
    }

    public interface YouAllPresenter<YouAllView>{
        public void attachView(YouAllView youAllView);
        public void detachView(YouAllView youAllView);

        public void requestYouAllData(String token, int coupon_type);
    }

    public interface YouAllModel{
        public void reponseYouAllData(String token, int coupon_type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
