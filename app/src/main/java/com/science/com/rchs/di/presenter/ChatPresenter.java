package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.DisListModel;

import java.lang.ref.SoftReference;

public class ChatPresenter implements ChatContract.ChatPresenter<ChatContract.ChatView> {

    ChatContract.ChatModel chatModel;
    ChatContract.ChatView chatView ;
    private SoftReference<ChatContract.ChatView> softReference;

    @Override
    public void attachView(ChatContract.ChatView chatView) {
        this.chatView = chatView;
        softReference = new SoftReference<>(chatView);
        chatModel = new ChatModel();
    }

    @Override
    public void detachView(ChatContract.ChatView chatView) {
        softReference.clear();
    }

    @Override
    public void requestChatData(String token, int type) {
        chatModel.reponseChattData(token, type, new ChatContract.ChatModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                chatView.showChatData(message);
            }
        });
    }
}
