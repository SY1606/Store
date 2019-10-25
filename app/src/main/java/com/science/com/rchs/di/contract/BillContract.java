package com.science.com.rchs.di.contract;

public interface BillContract {

    public interface BillView{
        public void showBillData(String message);
        public void showStarsData(String message);
    }

    public interface BillPresenter<BillView>{
        public void attachView(BillView billView);
        public void detachView(BillView billView);

        public void requestBillData(String token);
        public void requestStarsData(String token);
    }

    public interface BillModel{
        public void reponseBillData(String token, CallBack callBack);
        public void reponseStarsData(String token, CallBack callBack);
        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
