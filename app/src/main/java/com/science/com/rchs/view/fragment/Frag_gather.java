package com.science.com.rchs.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.data.bean.Chongzhi;
import com.science.com.rchs.data.bean.ChooseD;
import com.science.com.rchs.data.bean.Home;
import com.science.com.rchs.data.bean.Shop1;
import com.science.com.rchs.data.bean.Shops;
import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.contract.HomeContract;
import com.science.com.rchs.di.contract.ScanContract;
import com.science.com.rchs.di.contract.ShopsContract;
import com.science.com.rchs.di.presenter.BillPresenter;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.di.presenter.HomePresenter;
import com.science.com.rchs.di.presenter.ShopsPresenter;

import com.science.com.rchs.view.activity.ConsumeActivity;
import com.science.com.rchs.view.activity.DiscountListActivity;
import com.science.com.rchs.view.activity.FixedActivity;
import com.science.com.rchs.view.activity.HexiaoActivity;
import com.science.com.rchs.view.activity.MemListActivity;
import com.science.com.rchs.view.activity.NewDiscountActivity;
import com.science.com.rchs.view.activity.OpenActivity;
import com.science.com.rchs.view.activity.SacnActivity;
import com.science.com.rchs.view.activity.SelfActivity;
import com.umeng.message.PushAgent;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Frag_gather extends Fragment implements HomeContract.HomeView, BillContract.BillView, ChooseDStoreContract.ChooseDStoreView,ShopsContract.ShopsView {

    @BindView(R.id.jiao)
    TextView jiao;
    @BindView(R.id.j_m)
    TextView jM;
    @BindView(R.id.tui)
    TextView tui;
    @BindView(R.id.t_m)
    TextView tM;
    @BindView(R.id.shi)
    TextView shi;
    @BindView(R.id.s_m)
    TextView sM;
    @BindView(R.id.Nm)
    TextView Nm;
    @BindView(R.id.send)
    TextView send;
    @BindView(R.id.chong)
    TextView chong;
    @BindView(R.id.n_m)
    TextView nM;
    @BindView(R.id.send_m)
    TextView sendM;
    @BindView(R.id.c_m)
    TextView cM;
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.member)
    TextView member;
    @BindView(R.id.sim_x)
    ImageView simX;
    @BindView(R.id.x)
    TextView x;
    @BindView(R.id.xiaofei1)
    LinearLayout xiaofei1;
    @BindView(R.id.sim_l)
    ImageView simL;
    @BindView(R.id.l)
    TextView l;
    @BindView(R.id.huiyaun1)
    LinearLayout huiyaun1;
    @BindView(R.id.sim_s)
    ImageView simS;
    @BindView(R.id.s)
    TextView s;
    @BindView(R.id.kaika1)
    LinearLayout kaika1;
    @BindView(R.id.as)
    ImageView as;
    @BindView(R.id.hexiao1)
    LinearLayout hexiao1;
    @BindView(R.id.ad)
    ImageView ad;
    @BindView(R.id.ls)
    TextView ls;
    @BindView(R.id.liebiao1)
    LinearLayout liebiao1;
    @BindView(R.id.ee)
    ImageView ee;
    @BindView(R.id.xinzeng1)
    LinearLayout xinzeng1;
    @BindView(R.id.scan)
    LinearLayout scan;
    @BindView(R.id.self)
    LinearLayout self;
    @BindView(R.id.guding)
    LinearLayout guding;
    @BindView(R.id.jiaju)
    TextView jiaju;
    @BindView(R.id.rvl)
    SwipeRefreshLayout rvl;
    @BindView(R.id.scans)
    LinearLayout scans;

    private Unbinder unbinder;
    private HomeContract.HomePresenter homePresenter;
    private BillContract.BillPresenter billPresenter;
    Handler handler = new Handler();
    private int store_id;
    private String name;
    private ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    private String token;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    PushAgent mPushAgent;
    private ShopsContract.ShopsPresenter shopsPresenter;
    private ScanContract.ScanPresenter scanPresenter;
    String client_agent = "android";
    private String app_state;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_gather, container, false);
        Fresco.initialize(getActivity());
        unbinder = ButterKnife.bind(this, view);



        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commit();
        }

        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        shopsPresenter = new ShopsPresenter();
        shopsPresenter.attachView(this);

        shopsPresenter.requestShopsData(token);

        chooseStoreDPresenter = new ChooseDStorePresenter();
        chooseStoreDPresenter.attachView(this);

        SharedPreferences sps = getActivity().getSharedPreferences("ids", Context.MODE_PRIVATE);

        store_id = sps.getInt("id", 0);

        chooseStoreDPresenter.requestChooseDStoreData(token, store_id);

        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.requestHomeData(token);
        homePresenter.requestChongzhiData(token);
        homePresenter.requestStoresData(token, store_id);
        billPresenter = new BillPresenter();
        billPresenter.attachView(this);
        billPresenter.requestBillData(token);

        rvl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                homePresenter.requestHomeData(token);
                homePresenter.requestChongzhiData(token);
                billPresenter.requestBillData(token);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rvl.setRefreshing(false);
                    }
                }, 1500);

            }
        });


        SharedPreferences spss = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        token = spss.getString("token", "");

        if (savedInstanceState != null) {
            // FRAGMENTS_TAG
            savedInstanceState.remove("android:support:fragments");
            savedInstanceState.remove("android:fragments");
        }
        super.onCreate(savedInstanceState);

        return view;

    }


    @Override
    public void showHomeData(String message) {
        Gson gson = new Gson();
        Home home = gson.fromJson(message, Home.class);
        //List<Home.DataBean> list = (List<Home.DataBean>) home.getData();
        Home.DataBean dataBean = home.getData();
        Home.DataBean.CardListBean cardListBean = home.getData().getCardList();

        nM.setText(dataBean.getMembersTotalToday() + "");
        sendM.setText(dataBean.getCouponsTotalToday() + "");


    }

    @Override
    public void showChongzhiData(String message) {
        Gson gson = new Gson();
        Chongzhi chongzhi = gson.fromJson(message, Chongzhi.class);
        Chongzhi.DataBean dataBean = chongzhi.getData();
        String moneys = dataBean.getTodayTotal();
        cM.setText(moneys);

    }

    @Override
    public void showStoresData(String message) {

    }

    @Override
    public void showBangData(String message) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void showBillData(String message) {
        Gson gson = new Gson();
        Bill bill = gson.fromJson(message, Bill.class);
        Bill.DataBean dataBean = bill.getData();


        //sM.setText(dataBean.getActualTotal() + "");
        tM.setText(dataBean.getRefundTotal() + "");

        NumberFormat nf = new DecimalFormat("##.##");
        Double d = Double.valueOf(dataBean.getReceivableTotal() + "");
        Double ds = Double.valueOf(dataBean.getActualTotal() + "");
        String str = nf.format(d);
        String strs = nf.format(ds);
        jM.setText(str);
        sM.setText(strs);
    }

    @Override
    public void showStarsData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);
        List<ChooseD.DataBean> dataBeans = chooseD.getData();
        for (int i = 0; i < dataBeans.size(); i++) {
            store_id = dataBeans.get(i).getId();
            String name = dataBeans.get(i).getName();
            jiaju.setText(name);
        }
    }

    @OnClick({R.id.scan, R.id.self, R.id.xiaofei1, R.id.huiyaun1, R.id.kaika1, R.id.hexiao1, R.id.liebiao1, R.id.xinzeng1, R.id.guding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xiaofei1:
                Intent intent3 = new Intent(getActivity(), ConsumeActivity.class);
                startActivity(intent3);
                break;
            case R.id.huiyaun1:
                Intent intent5 = new Intent(getActivity(), MemListActivity.class);
                startActivity(intent5);
                break;
            case R.id.kaika1:
                Intent intent6 = new Intent(getActivity(), OpenActivity.class);
                startActivity(intent6);
                break;
            case R.id.hexiao1:
                Intent intent7 = new Intent(getActivity(), HexiaoActivity.class);
                startActivity(intent7);
                break;
            case R.id.liebiao1:
                Intent intent8 = new Intent(getActivity(), DiscountListActivity.class);
                startActivity(intent8);
                break;
            case R.id.xinzeng1:
                Intent intent9 = new Intent(getActivity(), NewDiscountActivity.class);
                startActivity(intent9);
                break;
            case R.id.scan:
                Intent intent = new Intent(getActivity(), SacnActivity.class);
                startActivity(intent);
                break;

            case R.id.guding:
                Intent intent13 = new Intent(getActivity(), FixedActivity.class);
                startActivity(intent13);
                break;

            //自动收款
            case R.id.self:
                Intent intent1 = new Intent(getActivity(), SelfActivity.class);
                startActivity(intent1);
                break;
        }
    }


    @Override
    public void showChooseDStoreData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);

        List<ChooseD.DataBean> dataBeans = chooseD.getData();
        store_id = dataBeans.get(0).getId();
        name = dataBeans.get(0).getName();
        Log.i("efaa", store_id + "");
        jiaju.setText(name);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void showShopsData(String message) {


        /*Object data = shop1.getData();
        if (code==0){
            HashMap<Object,Object> hashMap = new HashMap((Map)data);
            app_state = (String) hashMap.get("app_state");
            Log.i("fdvxs",app_state+"");
            scans.setVisibility(View.GONE);
            xiaofei1.setVisibility(View.GONE);
        }
        if (code==0&&app_state.equals("0")){
            Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
            scans.setVisibility(View.GONE);
            xiaofei1.setVisibility(View.GONE);
        }else if (app_state.equals("1")){
            scans.setVisibility(View.VISIBLE);
            xiaofei1.setVisibility(View.VISIBLE);
        }*/
    }
}
