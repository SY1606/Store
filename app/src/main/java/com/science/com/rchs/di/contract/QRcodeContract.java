package com.science.com.rchs.di.contract;

public interface QRcodeContract {

    public interface QRcodeView{
        public void showQRcodeData(String message);
    }

    public interface QRcodePresenter<QRcodeView>{
        public void attachView(QRcodeView qRcodeView);
        public void detachView(QRcodeView qRcodeView);

        public void requestQRcodeData(String token);
    }

    public interface QRcodeModel{
        public void reponseQRcodeData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
