package com.science.com.rchs.di.contract;

public interface OpenContract {

    public interface OpenView{
        public void showOpenData(String message);
    }

    public interface OpenPresenter<OpenView>{
        public void attachView(OpenView openView);
        public void detachView(OpenView openView);

        public void requestOpenData(String token,String type);
    }

    public interface OpenModel{
        public void reponseOpenData(String token, String type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
