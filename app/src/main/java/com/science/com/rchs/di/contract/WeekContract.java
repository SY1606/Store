package com.science.com.rchs.di.contract;

public interface WeekContract {
    public interface WeekView{
        public void showWeekData(String message);
    }

    public interface WeekPresenter<WeekView>{
        public void attachView(WeekView weekView);
        public void detachView(WeekView weekView);

        public void requestWeekData(String token);
    }

    public interface WeekModel{
        public void reponseWeekData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
