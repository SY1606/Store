package com.science.com.rchs.di.contract;

public interface ChooseDStoreContract {

    public interface ChooseDStoreView{
        public void showChooseDStoreData(String message);
    }

    public interface ChooseStoreDPresenter<ChooseDStoreView>{
        public void attachView(ChooseDStoreView chooseDStoreView);
        public void detachView(ChooseDStoreView chooseDStoreView);

        public void requestChooseDStoreData(String token,int store_id);
    }

    public interface ChooseStoreDModel{
        public void reponseChooseDStoreData(String token,int store_id, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
