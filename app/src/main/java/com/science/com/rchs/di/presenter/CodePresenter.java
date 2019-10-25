package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.CodeContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.CodeModel;

import java.lang.ref.SoftReference;

public class CodePresenter implements CodeContract.CodePresenter<CodeContract.CodeView> {

    CodeContract.CodeModel codeModel;
    CodeContract.CodeView codeView ;
    private SoftReference<CodeContract.CodeView> softReference;

    @Override
    public void attachView(CodeContract.CodeView codeView) {
        this.codeView = codeView;
        softReference = new SoftReference<>(codeView);
        codeModel = new CodeModel();
    }

    @Override
    public void detachView(CodeContract.CodeView codeView) {
        softReference.clear();
    }

    @Override
    public void requestCodeData(String token, String coupon_id, int code) {
        codeModel.reponseCodeData(token, coupon_id, code, new CodeContract.CodeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                codeView.showCodeData(message);
            }
        });
    }
}
