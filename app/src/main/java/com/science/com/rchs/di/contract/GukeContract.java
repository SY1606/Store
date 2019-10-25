package com.science.com.rchs.di.contract;

public interface GukeContract {
    public interface GukeView{
        public void showGukeData(String message);
    }

    public interface GukePresenter<GukeView>{
        public void attachView(GukeView gukeView);
        public void detachView(GukeView gukeView);

        public void requestGukeData(String token);
    }

    public interface GukeModel{
        public void reponseGukeData(String token,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
