package com.science.com.rchs.di.contract;

public interface TixianContract {

    public interface TixianView{
        public void showTixianData(String message);

    }

    public interface TixianPresenter<TixianView>{
        public void attachView(TixianView tixianView);
        public void detachView(TixianView tixianView);

        public void requestTixianData(String token,String mchId);

    }

    public interface TixianModel{
        public void reponseTixianData(String token,String mchId, CallBack callBack);
        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
