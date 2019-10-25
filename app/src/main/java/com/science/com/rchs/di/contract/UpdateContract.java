package com.science.com.rchs.di.contract;

public interface UpdateContract {

    public interface UpdateView{
        public void showUpdateData(String message);
    }

    public interface UpdatePresenter<UpdateView>{
        public void attachView(UpdateView updateView);
        public void detachView(UpdateView updateView);

        public void requestUpdateData(String token);
    }

    public interface UpdateModel{
        public void reponseUpdateData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
