package com.science.com.rchs.di.contract;

public interface BianjiContract {

    public interface BianjiView{
        public void showBianjiData(String message);
    }

    public interface BianjiPresenter<AddView>{
        public void attachView(AddView addView);
        public void detachView(AddView addView);
        public void requestBianjiData(String token, String coupon_id, String type, String logo_url, String color, String notice, String description,String begin_timestamp,String end_timestamp);

    }

    public interface BianjiModel{
        public void reponseBianjiData(String token, String coupon_id, String type, String logo_url, String color, String notice, String description,String begin_timestamp,String end_timestamp,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
