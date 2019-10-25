package com.science.com.rchs.di.contract;

import com.science.com.rchs.datepicker.CustomDatePicker;

public interface HomeContract {

    //这个是登录的
    public interface HomeView{
        public void showHomeData(String message);
        public void showChongzhiData(String message);
        public void showStoresData(String message);

        public void showBangData(String message);
    }

    public interface HomePresenter<HomeView>{

        public void attachView(HomeView homeView);
        public void detachView(HomeView homeView);

        public void requestHomeData(String token);
        public void requestChongzhiData(String token);
        public void requestStoresData(String token,int store_id);

        public void requestBandData(String token,String device_token,int store_id,String client_agent);
    }

    public interface HomeModel{

        public void reponseHomeData(String token,CallBack callBack );
        public void reponseChongzhiData(String token,CallBack callBack );
        public void reponseStoreData(String token,int store_id,CallBack callBack );
        public void reponseBandData(String token, String device_token, int store_id, String client_agent,CallBack callback);



        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
