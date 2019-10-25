package com.science.com.rchs.di.contract;



public interface LoginContract {
    //这个是登录的
    public interface LoginView{
        public void showData(String message);

    }

    public interface LoginPresenter<LoginView>{

        public void attachView(LoginView loginView);
        public void detachView(LoginView loginView);

        public void requestLoginData(String grant_type, String mch_seller_number, String password);

    }

    public interface LoginModel{

        public void reponseLoginData(String grant_type, String mch_seller_number, String password, CallBack callBack);


        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
