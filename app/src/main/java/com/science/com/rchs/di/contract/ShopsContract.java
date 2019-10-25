package com.science.com.rchs.di.contract;

public interface ShopsContract {

    public interface ShopsView{
        public void showShopsData(String message);
    }

    public interface ShopsPresenter<ShopsView>{
        public void attachView(ShopsView shopsView);
        public void detachView(ShopsView shopsView);

        public void requestShopsData(String token);
    }

    public interface ShopsModel{
        public void reponseShopsData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
