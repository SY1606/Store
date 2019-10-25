package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bang;
import com.science.com.rchs.data.bean.ChooseD;
import com.science.com.rchs.data.bean.CodeBean;
import com.science.com.rchs.data.bean.CodesPay;
import com.science.com.rchs.data.bean.Scan;
import com.science.com.rchs.data.bean.ScanPay;
import com.science.com.rchs.data.bean.Scan_Pay;
import com.science.com.rchs.data.bean.Scan_Pays;
import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.contract.CodeContract;
import com.science.com.rchs.di.contract.ScanContract;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.di.presenter.ScanPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static anet.channel.bytes.a.TAG;

public class Scan_hActivity extends AppCompatActivity implements CodeContract.CodeView, ScanContract.ScanView, ChooseDStoreContract.ChooseDStoreView {

    @BindView(R.id.sao)
    Button sao;
    @BindView(R.id.money)
    EditText money;
    @BindView(R.id.view9)
    View view9;
    @BindView(R.id.hexiao)
    EditText hexiao;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.view10)
    View view10;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.moneys)
    TextView moneys;
    @BindView(R.id.text5)
    TextView text5;
    @BindView(R.id.mlogin)
    Button mlogin;
    @BindView(R.id.text6)
    TextView text6;
    @BindView(R.id.shou)
    TextView shou;

    private int REQUEST_CODE_SCAN = 111;
    private ScanContract.ScanPresenter scanPresenter;
    private String token;
    String client_agent = "android";

    int store_id;
    private double total;
    String pay_method="unknow";

    private String title;
    private int code;
    private String messages;
    private String reduce_cost;
    private int moneyss;
    private HashMap<Object, Object> hashMap;
    private String coupon_type;
    private String least_cost;
    private String kkk;
    private String asca;
    private double bbb;
    private String sss;
    private String rate;
    private double ccc;
    private String jjj;
    ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    String pay_type;
    private String coupon_code;
    private String pay_type1;
    private String totals;
    private String pay_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_h);
        ButterKnife.bind(this);

        /*String aaa = "30";
        String bbb = "20";

        String sss = String.valueOf(Integer.parseInt(aaa)-Integer.parseInt(bbb));
        Log.i("awfafa",sss);*/

        SharedPreferences sps = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sps.getString("token", "");


        scanPresenter = new ScanPresenter();
        scanPresenter.attachView(this);

        chooseStoreDPresenter = new ChooseDStorePresenter();
        chooseStoreDPresenter.attachView(this);


        SharedPreferences spss = getSharedPreferences("ids", Context.MODE_PRIVATE);
        store_id = spss.getInt("id", 0);


        chooseStoreDPresenter.requestChooseDStoreData(token, store_id);


        //hexiao.setInputType(InputType.TYPE_NULL);
        total = Double.parseDouble(getIntent().getStringExtra("aaa"));
        result.setText("￥" + total + "");
        moneys.setText(total + "");

        //scanPresenter.requestCodesData(token,coupon_code);

        hexiao.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String text = s.toString();
                coupon_code = hexiao.getText().toString();
                scanPresenter.requestCodesData(token, coupon_code);
                if (code == 0 && hexiao.getText().toString().length() == 12) {

                    text5.setText(title);

                } else if (hexiao.getText().toString().length() == 12) {
                    text6.setVisibility(View.VISIBLE);
                    text5.setVisibility(View.GONE);
                } else {
                    text6.setVisibility(View.GONE);
                    text5.setVisibility(View.GONE);
                }

                /*if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        hexiao.setText(s.subSequence(0, 1));
                        hexiao.setSelection(1);
                        return;
                    }
                }*/

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        hexiao.setText(text);
                        hexiao.setSelection(text.length());
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(Scan_hActivity.this, true);
        StatusBarUtil.setTranslucentStatus(Scan_hActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Scan_hActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(Scan_hActivity.this, 0x55000000);
        }

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hexiao.getText().toString().equals("")){
                    ToastUtil.showToast(Scan_hActivity.this,"请输入核销码",Toast.LENGTH_SHORT);
                }else {
                    {

                        AndPermission.with(Scan_hActivity.this)
                                .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                                .onGranted(new Action() {
                                    @Override
                                    public void onAction(List<String> permissions) {
                                        Intent intent = new Intent(Scan_hActivity.this, CaptureActivity.class);
                                        ZxingConfig config = new ZxingConfig();
                                        intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                                        startActivityForResult(intent, REQUEST_CODE_SCAN);
                                    }
                                }).onDenied(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Uri packageURI = Uri.parse("package:" + getPackageName());
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);

                                Toast.makeText(Scan_hActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
                    }
                }
            }
        });

    }

    @OnClick({R.id.money, R.id.hexiao, R.id.sao, R.id.fan})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.fan:
                finish();
                break;
            case R.id.money:
                break;
            case R.id.hexiao:


                break;
            case R.id.sao:
                AndPermission.with(Scan_hActivity.this)
                        .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Intent intent = new Intent(Scan_hActivity.this, CaptureActivity.class);
                                /*ZxingConfig是配置类
                                 *可以设置是否显示底部布局，闪光灯，相册，
                                 * 是否播放提示音  震动
                                 * 设置扫描框颜色等
                                 * 也可以不传这个参数
                                 * */
                                ZxingConfig config = new ZxingConfig();
                                 config.setPlayBeep(true);//是否播放扫描声音 默认为true
                                 config.setShake(true);//是否震动  默认为true
                                // config.setDecodeBarCode(false);//是否扫描条形码 默认为true
//                                config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
//                                config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
//                                config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
                                //config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                                startActivityForResult(intent, RESULT_CANCELED);
                            }
                        })
                        .onDenied(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Uri packageURI = Uri.parse("package:" + getPackageName());
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);

                                Toast.makeText(Scan_hActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
                break;
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==RESULT_CANCELED&&resultCode==RESULT_OK){
            if (data!=null){
                coupon_code = data.getStringExtra(Constant.CODED_CONTENT);
                hexiao.setText(coupon_code);
            }
        }

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                        String pay_code = data.getStringExtra(Constant.CODED_CONTENT);
                        //coupon_code = hexiao.getText().toString();
                        //scanPresenter.requestBangData(token, device_token, client_agent);

                        String pay_type = "coupon";
                        scanPresenter.requestScan_payData(token,store_id,String.valueOf(total),pay_method,pay_code,pay_type, coupon_code);

                        Log.i("pppp",token);
                        Log.i("oooo",store_id+"");
                        Log.i("iiii",total+"");
                        Log.i("uuuu",pay_method);
                        Log.i("yyyy",pay_code);
                        Log.i("tttt",pay_type);
                        Log.i("rrrr", coupon_code+"");

                       // scanPresenter.requestScanData(token, store_id, String.valueOf(total), pay_method, pay_code, pay_type);

                       //scanPresenter.requestScan_paySData(token,store_id,String.valueOf(total),pay_method,pay_code,pay_type, coupon_code);
                       // scanPresenter.requestScanPayData(token, store_id, String.valueOf(total), pay_method, pay_code, pay_type);

            }
        }


    }

    @Override
    public void showCodeData(String message) {
        Gson gson = new Gson();
        CodeBean codeBean = gson.fromJson(message, CodeBean.class);
        CodeBean.DataBean dataBean = codeBean.getData();
        boolean can = dataBean.isCan_consume();

    }

    @Override
    public void showScanData(String message) {
        /*Gson gson = new Gson();
        Scan scan = gson.fromJson(message, Scan.class);
        String messages = scan.getMessage();
        int code = scan.getCode();
        if (code == 0) {
            hexiao.getText().clear();
            //ToastUtil.showToast(Scan_hActivity.this,messages,Toast.LENGTH_SHORT);
            Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
            intent.putExtra("ress", total);
            startActivity(intent);

        } else {
            //ToastUtil.showToast(Scan_hActivity.this,messages,Toast.LENGTH_SHORT);
            //Intent intent = new Intent(SacnActivity.this,Ti_fActivity.class);
            //startActivity(intent);
        }*/
    }

    @Override
    public void showScanPayData(String message) {
        /*Gson gson = new Gson();
        ScanPay scan = gson.fromJson(message, ScanPay.class);
        String messages = scan.getMessage();
        int code = scan.getCode();
        if (code == 0) {
            hexiao.getText().clear();
            //ToastUtil.showToast(Scan_hActivity.this,messages,Toast.LENGTH_SHORT);
            Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
            intent.putExtra("ress", total);
            startActivity(intent);

        } else {
            //ToastUtil.showToast(Scan_hActivity.this,messages,Toast.LENGTH_SHORT);
            //Intent intent = new Intent(SacnActivity.this,Ti_fActivity.class);
            //startActivity(intent);
        }*/
    }

    @Override
    public void showBandData(String message) {
        Gson gson = new Gson();
        Bang bang = gson.fromJson(message, Bang.class);
        int code = bang.getCode();
        String messages = bang.getMessage();
        if (code == 0) {

           // ToastUtil.showToast(Scan_hActivity.this, messages, Toast.LENGTH_SHORT);
        } else {
           // ToastUtil.showToast(Scan_hActivity.this, messages, Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void showCodesData(String message) {

        Gson gson = new Gson();
        CodesPay codesPay = gson.fromJson(message, CodesPay.class);

        code = codesPay.getCode();
        Object data = codesPay.getData();
        messages = codesPay.getMessage();

        if (code == 0 && hexiao.getText().toString().length() == 12) {
            hashMap = new HashMap((Map) data);
            title = (String) hashMap.get("title");
            coupon_type = (String) hashMap.get("coupon_type");
            least_cost = (String) hashMap.get("least_cost");
            reduce_cost = (String) hashMap.get("reduce_cost");
            rate = (String) hashMap.get("rate");
            text5.setText(title);
            text5.setVisibility(View.VISIBLE);
            text6.setVisibility(View.GONE);


            asca = String.valueOf((int)Double.parseDouble(least_cost));
            bbb = Double.parseDouble(reduce_cost);
            ccc = Double.parseDouble(rate);

            Log.i("oooo", bbb +"");
        }
        //代金券
        if (code == 0 &&coupon_type.equals("1")&&total>=Double.parseDouble(asca)){

            Double sss = total-bbb;

            NumberFormat nf = new DecimalFormat("##.##");
            Double d = Double.valueOf(sss);
            double dddd = Double.parseDouble(nf.format(d));
            moneys.setText(dddd+"");

        }
        if (code == 0 &&coupon_type.equals("1")&&total<Double.parseDouble(asca)){
            moneys.setText(total+"");
        }



        if (code == 0 &&coupon_type.equals("3")&&total>0){

            jjj = String.valueOf(total-bbb);
            NumberFormat nf = new DecimalFormat("##.##");
            Double d = Double.valueOf(jjj);
            double jjj = Double.parseDouble(nf.format(d));
            moneys.setText(jjj+"");
        }
        if (code == 0 &&coupon_type.equals("3")&&total-bbb<=0){
            jjj = "0";
            moneys.setText(jjj);
            Log.i("adxa",jjj);
        }


        //折扣券
        if (code == 0 &&coupon_type.equals("2")&&total>0){
            sss = String.valueOf(total*ccc);
            moneys.setText(sss);
        }


        if (code == 0 && coupon_type.equals("2") && total > 0) {
             sss = String.valueOf(total * ccc);
            NumberFormat nf = new DecimalFormat("##.##");
            Double d = Double.valueOf(sss);
            double dddd = Double.parseDouble(nf.format(d));
            moneys.setText(dddd+"");
            Log.i("rggs",dddd+"");

        }
    }

    @Override
    public void showScan_PayData(String message) {
        /*Gson gson = new Gson();
        ScanPay scan = gson.fromJson(message,ScanPay.class);
        String messages = scan.getMessage();
        int code = scan.getCode();
        if (code==0){
            hexiao.getText().clear();
            Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
            intent.putExtra("ress", total);
            Log.i("gadxaa",total+"");
            startActivity(intent);
        }else {
            //ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
            //Intent intent = new Intent(SacnActivity.this,Ti_fActivity.class);
            //startActivity(intent);
        }*/
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Scan_Pay  scan_pay = gson.fromJson(message,Scan_Pay.class);
                int code = scan_pay.getCode();
                String messages = scan_pay.getMessage();
                Object data = scan_pay.getData();
                if (code==0) {
                    HashMap<Object, Object> hashMap = new HashMap((Map) data);
                    double total = (Double) hashMap.get("total");
                    Log.i("frgxs",total+"");
                    hexiao.getText().clear();
                    Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
                    intent.putExtra("ress", total);
                    startActivity(intent);
                }else {
                    ToastUtil.showToast(Scan_hActivity.this,messages,Toast.LENGTH_SHORT);
                }
        /*if (code==0&&pay_status.equals("scan")){

        }else if (code!=0&&pay_type1.equals("Starpos")){
            ToastUtil.showToast(Scan_hActivity.this,"失败啦",Toast.LENGTH_SHORT);

        }*/
            }
        });

    }

    @Override
    public void showScan_PaySData(String message) {

        Gson gson = new Gson();
        ScanPay scan = gson.fromJson(message,ScanPay.class);
        String messages = scan.getMessage();
        int code = scan.getCode();
        /*if (code==0){
            hexiao.getText().clear();
            Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
            intent.putExtra("ress", totals);
            startActivity(intent);

        }else {
            //ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
            //Intent intent = new Intent(SacnActivity.this,Ti_fActivity.class);
            //startActivity(intent);
        }

        /*Gson gson = new Gson();
        Scan_Pays scan_pay = gson.fromJson(message,Scan_Pays.class);
        int code = scan_pay.getCode();
        Object data = scan_pay.getData();
        if (code==0){
            HashMap<Object,Object> hashMap = new HashMap((Map)data);
            pay_type1 = (String) hashMap.get("pay_type");
             totals = (String) hashMap.get("total");

            //hexiao.getText().clear();
            //ToastUtil.showToast(Scan_hActivity.this,messages,Toast.LENGTH_SHORT);
            //Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
            //intent.putExtra("ress", total);
            //startActivity(intent);
        }
        if (code==0&&pay_type1.equals("Starpos")){
            hexiao.getText().clear();
            Intent intent = new Intent(Scan_hActivity.this, Ti_SActivity.class);
            intent.putExtra("ress", totals);
            startActivity(intent);
        }else if (code!=0&&pay_type1.equals("Starpos")){
            ToastUtil.showToast(Scan_hActivity.this,"收款失败",Toast.LENGTH_SHORT);

        }else {
            //ToastUtil.showToast(Scan_hActivity.this,message,Toast.LENGTH_SHORT);
        }*/
    }



    @Override
    public void showChooseDStoreData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);
        List<ChooseD.DataBean> dataBeans = chooseD.getData();
        store_id = dataBeans.get(0).getId();
    }
}
