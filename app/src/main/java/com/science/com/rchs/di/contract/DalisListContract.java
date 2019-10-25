package com.science.com.rchs.di.contract;

public interface DalisListContract {

    public interface DalisListView{
        public void showDalisListData(String message);
    }

    public interface DalisListPresenter<StoreView>{
        public void attachView(StoreView storeView);
        public void detachView(StoreView storeView);

        public void requestDalisListData(String token,int startTime,int endTime);
    }

    public interface DalisListModel{
        public void reponseDalisListData(String token,int startTime,int endTime,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
