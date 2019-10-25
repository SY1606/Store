package com.science.com.rchs.di.contract;

public interface StoreContract {

    public interface StoreView{
        public void showStoreData(String message);
        public void showStoresData(String message);
    }

    public interface StorePresenter<StoreView>{
        public void attachView(StoreView storeView);
        public void detachView(StoreView storeView);

        public void requestStoreData(String token);
        public void requestStoresData(String token,int startTime,int endTime);
    }

    public interface StoreModel{
        public void reponseStoreData(String token, CallBack callBack);
        public void reponseStoresData(String token,int startTime,int endTime,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
