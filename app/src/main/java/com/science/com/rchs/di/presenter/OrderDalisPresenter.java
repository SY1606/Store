package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.OrderDalisContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.OrderDalisModel;

import java.lang.ref.SoftReference;

public class OrderDalisPresenter implements OrderDalisContract.OrderDalisPresenter<OrderDalisContract.OrderDalisView> {

    OrderDalisContract.OrderDalisModel orderDalisModel;
    OrderDalisContract.OrderDalisView orderDalisView ;
    private SoftReference<OrderDalisContract.OrderDalisView> softReference;

    @Override
    public void attachView(OrderDalisContract.OrderDalisView orderDalisView) {
        this.orderDalisView = orderDalisView;
        softReference = new SoftReference<>(orderDalisView);
        orderDalisModel = new OrderDalisModel();
    }

    @Override
    public void detachView(OrderDalisContract.OrderDalisView orderDalisView) {
        softReference.clear();
    }

    @Override
    public void requestOrderDalisData(String token, String orderNumber) {
        orderDalisModel.reponseOrderDalisData(token, orderNumber, new OrderDalisContract.OrderDalisModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                orderDalisView.showOrderDalisData(message);
            }
        });
    }
}
