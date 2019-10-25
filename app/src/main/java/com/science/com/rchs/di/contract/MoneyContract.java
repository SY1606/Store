package com.science.com.rchs.di.contract;

public interface MoneyContract {
    public interface MoneyView{
        public void showMoneyData(String message);
    }

    public interface MoneyPresenter<MoneyView>{
        public void attachView(MoneyView moneyView);
        public void detachView(MoneyView moneyView);

        public void requestMoneyData(String token);
    }

    public interface MoneyModel{
        public void reponseMoneyData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
