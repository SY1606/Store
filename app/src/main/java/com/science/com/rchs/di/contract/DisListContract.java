package com.science.com.rchs.di.contract;

public interface DisListContract {

    public interface DisListView{
        public void showDisListData(String message);
    }

    public interface DisListPresenter<DisListView>{
        public void attachView(DisListView disListView);
        public void detachView(DisListView disListView);

        public void requestDisListData(String token, int type);
    }

    public interface DisListModel{
        public void reponseDisListData(String token, int type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
