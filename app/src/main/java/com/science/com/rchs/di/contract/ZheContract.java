package com.science.com.rchs.di.contract;

public interface ZheContract {

    public interface ZheView{
        public void showZheData(String message);
    }

    public interface ZhePresenter<ZheView>{
        public void attachView(ZheView zheView);
        public void detachView(ZheView zheView);

        public void requestZheData(String token, int coupon_type);
    }

    public interface ZheModel{
        public void reponseZheData(String token, int coupon_type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
