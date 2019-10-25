package com.science.com.rchs.di.contract;

public interface ScanContract {

    public interface ScanView{
        public void showScanData(String message);
        public void showScanPayData(String message);
        public void showBandData(String message);

        public void showCodesData(String message);
        public void showScan_PayData(String message);
        public void showScan_PaySData(String message);

    }

    public interface ScanPresenter<ScanView>{
        public void attachView(ScanView scanView);
        public void detachView(ScanView scanView);

        public void requestScanPayData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type);
        public void requestScanData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type);
        public void requestBangData(String token, String device_token,int store_id,String client_agent);

        public void requestScan_payData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type,String coupon_code);
        public void requestScan_paySData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type,String coupon_code);

        public void requestCodesData(String token, String coupon_code);

    }

    public interface ScanModel{
        public void reponseScanData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type, CallBack callBack);
        public void reponseBandData(String token, String device_token,int store_id,String client_agent, CallBack callBack);
        public void reponseScanPayData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type, CallBack callBack);
        public void requestScan_payData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type,String coupon_code,CallBack callBack);
        public void requestScan_paySData(String token, int store_id,String total,String pay_method,String pay_code, String pay_type,String coupon_code,CallBack callBack);

        public void reponseCodesData(String token,String coupon_code, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
