package com.science.com.rchs.di.presenter;



import com.science.com.rchs.di.contract.LoginContract;
import com.science.com.rchs.di.model.LoginModel;

import java.lang.ref.SoftReference;

public class LoginPresenter implements LoginContract.LoginPresenter<LoginContract.LoginView> {

    LoginContract.LoginModel loginModel;
    LoginContract.LoginView loginView;
    private SoftReference<LoginContract.LoginView> softReference;

    @Override
    public void attachView(LoginContract.LoginView loginView) {
        this.loginView = loginView;
        softReference = new SoftReference<>(loginView);
        loginModel = new LoginModel();
    }

    @Override
    public void detachView(LoginContract.LoginView loginView) {
        softReference.clear();
    }

    @Override
    public void requestLoginData(String grant_type,String mch_seller_number,String password) {
        loginModel.reponseLoginData(grant_type, mch_seller_number, password, new LoginContract.LoginModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                loginView.showData(message);
            }
        });
    }
}
