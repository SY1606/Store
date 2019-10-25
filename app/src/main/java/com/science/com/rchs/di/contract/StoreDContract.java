package com.science.com.rchs.di.contract;

public interface StoreDContract {

    public interface StoreDView{
        public void showStoreDData(String message);
    }

    public interface StoreDPresenter<StoreView>{
        public void attachView(StoreView storeView);
        public void detachView(StoreView storeView);

        public void requestStoreDData(String token,int store_id);
    }

    public interface StoreDModel{
        public void reponseStoreDData(String token,int store_id,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
