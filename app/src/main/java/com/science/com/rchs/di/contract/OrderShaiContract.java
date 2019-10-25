package com.science.com.rchs.di.contract;

public interface OrderShaiContract {

    public interface OrderShaiView{
        public void showOrderShaiData(String message);
    }

    public interface OrderShaiPresenter<OrderShaiView>{
        public void attachView(OrderShaiView orderShaiView);
        public void detachView(OrderShaiView orderShaiView);

        public void requestOrderShaiData(String token, String type,int startTime,int endTime);
    }

    public interface OrderShaiModel{
        public void reponseOrderShaiData(String token, String type,int startTime,int endTime,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
