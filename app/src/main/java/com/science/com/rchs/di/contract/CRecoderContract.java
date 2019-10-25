package com.science.com.rchs.di.contract;

public interface CRecoderContract {

    public interface CRecoderView{
        public void showCRecoderData(String message);
    }

    public interface CRecoderPresenter<CRecoderView>{

        public void attachView(CRecoderView cRecoderView);
        public void detachView(CRecoderView cRecoderView);

        public void requestCRecoderData(String token);
    }

    public interface CRecoderModel{

        public void reponseCRecoderData(String token,CallBack callBack );

        public interface CallBack{
            public void onCallBack(String message);
        }
    }

}
