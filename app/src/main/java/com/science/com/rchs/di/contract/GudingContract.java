package com.science.com.rchs.di.contract;

public interface GudingContract {

    public interface GudingView{
        public void showGudingData(String message);
    }

    public interface GudingPresenter<BillView>{
        public void attachView(BillView billView);
        public void detachView(BillView billView);

        public void requestGudingData(String token);
    }

    public interface GudingModel{
        public void reponseGudingData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
