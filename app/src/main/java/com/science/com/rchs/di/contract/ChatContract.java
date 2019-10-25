package com.science.com.rchs.di.contract;

public interface ChatContract {

    public interface ChatView{
        public void showChatData(String message);
    }

    public interface ChatPresenter<ChatView>{
        public void attachView(ChatView chatView);
        public void detachView(ChatView chatView);

        public void requestChatData(String token, int type);
    }

    public interface ChatModel{
        public void reponseChattData(String token, int type, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
