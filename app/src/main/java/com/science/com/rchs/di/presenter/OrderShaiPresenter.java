package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.di.contract.OrderShaiContract;
import com.science.com.rchs.di.model.DisListModel;
import com.science.com.rchs.di.model.OrderShaiModel;

import java.lang.ref.SoftReference;

public class OrderShaiPresenter implements OrderShaiContract.OrderShaiPresenter<OrderShaiContract.OrderShaiView> {

    OrderShaiContract.OrderShaiModel orderShaiModel;
    OrderShaiContract.OrderShaiView orderShaiView;
    private SoftReference<OrderShaiContract.OrderShaiView> softReference;

    @Override
    public void attachView(OrderShaiContract.OrderShaiView orderShaiView) {
        this.orderShaiView = orderShaiView;
        softReference = new SoftReference<>(orderShaiView);
        orderShaiModel = new OrderShaiModel();
    }

    @Override
    public void detachView(OrderShaiContract.OrderShaiView orderShaiView) {
        softReference.clear();
    }

    @Override
    public void requestOrderShaiData(String token, String type, int startTime, int endTime) {
        orderShaiModel.reponseOrderShaiData(token, type, startTime, endTime, new OrderShaiContract.OrderShaiModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                orderShaiView.showOrderShaiData(message);
            }
        });
    }
}
