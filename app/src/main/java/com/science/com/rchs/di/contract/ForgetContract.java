package com.science.com.rchs.di.contract;

public interface ForgetContract {

    public interface ForgetView{
        public void showForgetData(String message);
    }

    public interface ForgetPresenter<ForgetView>{
        public void attachView(ForgetView forgetView);
        public void detachView(ForgetView forgetView);

        public void requestForgetData(String phone,String password,String passwordtwo,String signcode);
    }

    public interface ForgetModel{
        public void reponseForgetData(String phone,String password,String passwordtwo,String signcode, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
