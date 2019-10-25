package com.science.com.rchs.di.contract;

public interface ChooseStoreContract {

    public interface ChooseStoreView{
        public void showChooseStoreData(String message);
    }

    public interface ChooseStorePresenter<ChooseStoreView>{
        public void attachView(ChooseStoreView chooseStoreView);
        public void detachView(ChooseStoreView chooseStoreView);

        public void requestChooseStoreData(String token);
    }

    public interface ChooseStoreModel{
        public void reponseChooseStoreData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
