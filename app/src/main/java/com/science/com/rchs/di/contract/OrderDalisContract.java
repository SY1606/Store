package com.science.com.rchs.di.contract;

public interface OrderDalisContract {

    public interface OrderDalisView{
        public void showOrderDalisData(String message);
    }

    public interface OrderDalisPresenter<ChatView>{
        public void attachView(ChatView chatView);
        public void detachView(ChatView chatView);

        public void requestOrderDalisData(String token, String orderNumber);
    }

    public interface OrderDalisModel{
        public void reponseOrderDalisData(String token, String orderNumber, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
