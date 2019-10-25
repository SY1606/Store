package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.XinxiContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.XinxiModel;

import java.lang.ref.SoftReference;

public class XinxiPresenter implements XinxiContract.XinxiPresenter<XinxiContract.XinxiView> {

    XinxiContract.XinxiModel xinxiModel;
    XinxiContract.XinxiView xinxiView ;
    private SoftReference<XinxiContract.XinxiView> softReference;

    @Override
    public void attachView(XinxiContract.XinxiView xinxiView) {
        this.xinxiView = xinxiView;
        softReference = new SoftReference<>(xinxiView);
        xinxiModel = new XinxiModel();
    }

    @Override
    public void detachView(XinxiContract.XinxiView xinxiView) {
        softReference.clear();
    }

    @Override
    public void requestXinxiData(String token, String coupon_id) {
        xinxiModel.reponseXinxiData(token, coupon_id, new XinxiContract.XinxiModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                xinxiView.showXinxiData(message);
            }
        });
    }
}
