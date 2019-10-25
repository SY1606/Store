package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.AddContract;
import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.model.AddModel;
import com.science.com.rchs.di.model.BillModel;

import java.lang.ref.SoftReference;

public class AddPresenter implements AddContract.AddPresenter<AddContract.AddView> {

    AddContract.AddModel addModel;
    AddContract.AddView addView ;
    private SoftReference<AddContract.AddView> softReference;


    @Override
    public void attachView(AddContract.AddView addView) {
        this.addView = addView;
        softReference = new SoftReference<>(addView);
        addModel = new AddModel();
    }

    @Override
    public void detachView(AddContract.AddView addView) {
        softReference.clear();
    }

    @Override
    public void requestAddData(String token, String logo_url, String color, String begin_timestamp, String end_timestamp, String notice, String description, int quantity, String least_cost, String reduce_cost) {
        addModel.reponseAddData(token, logo_url, color, begin_timestamp, end_timestamp, notice, description, quantity, least_cost, reduce_cost, new AddContract.AddModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                addView.showAddData(message);
            }
        });
    }

    @Override
    public void requestAddZheData(String token, String logo_url, String color, String begin_timestamp, String end_timestamp, String notice, String description, int quantity, String discount) {
        addModel.reponseAddZheData(token, logo_url, color, begin_timestamp, end_timestamp, notice, description, quantity, discount, new AddContract.AddModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                addView.showAddZheData(message);
            }
        });
    }

    @Override
    public void requestAddYouData(String token, String logo_url, String color, String begin_timestamp, String end_timestamp, String notice, String description, int quantity, String default_detail) {
        addModel.reponseAddYouData(token, logo_url, color, begin_timestamp, end_timestamp, notice, description, quantity, default_detail, new AddContract.AddModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                addView.showAddYouData(message);
            }
        });
    }
}
