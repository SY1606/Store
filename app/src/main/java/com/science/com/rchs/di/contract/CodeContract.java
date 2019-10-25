package com.science.com.rchs.di.contract;

public interface CodeContract {

    public interface CodeView{
        public void showCodeData(String message);
    }

    public interface CodePresenter<CodeView>{
        public void attachView(CodeView codeView);
        public void detachView(CodeView codeView);

        public void requestCodeData(String token, String coupon_id,int code);
    }

    public interface CodeModel{
        public void reponseCodeData(String token, String coupon_id,int code, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
