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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.data.bean.Shops;
import com.science.com.rchs.data.bean.Stars;
import com.science.com.rchs.data.bean.WinS;
import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.ShopsContract;
import com.science.com.rchs.di.contract.WinContract;
import com.science.com.rchs.di.presenter.BillPresenter;
import com.science.com.rchs.di.presenter.WeiPresenter;
import com.science.com.rchs.view.activity.StarPayActivity;
import com.science.com.rchs.view.activity.StoreActivity;
import com.science.com.rchs.view.activity_bill.DalisListActivity;
import com.science.com.rchs.view.activity_bill.ShaiActivity;
import com.science.com.rchs.view.adapter.BillAdapter;
import com.science.com.rchs.view.adapter.BillsAdapter;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Frag_bill extends Fragment implements BillContract.BillView, ShopsContract.ShopsView, WinContract.WinView {
    @BindView(R.id.rec_money)
    TextView recMoney;
    @BindView(R.id.r_money)
    TextView rMoney;
    @BindView(R.id.tr_number)
    TextView trNumber;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.tr_money)
    TextView trMoney;
    @BindView(R.id.t_money)
    TextView tMoney;
    @BindView(R.id.tui_money)
    TextView tuiMoney;
    @BindView(R.id.tu_money)
    TextView tuMoney;
    @BindView(R.id.sim_dalisList)
    SimpleDraweeView simDalisList;
    @BindView(R.id.sim_refund)
    SimpleDraweeView simRefund;
    @BindView(R.id.sim_store)
    SimpleDraweeView simStore;
    @BindView(R.id.dalisList)
    TextView dalisList;
    @BindView(R.id.refund)
    TextView refund;
    @BindView(R.id.store)
    TextView store;
    @BindView(R.id.shai)
    TextView shai;
    @BindView(R.id.stats)
    LinearLayout stats;
    @BindView(R.id.images)
    ImageView images;
    @BindView(R.id.texts)
    TextView texts;
    @BindView(R.id.rvl)
    SwipeRefreshLayout rvl;
    private Unbinder unbinder;
    private RecyclerView recy_bill;
    private BillContract.BillPresenter billPresenter;
    private RecyclerView listView;
    private Bill.DataBean dataBean;
    private WinContract.WinPresenter winPresenter;
    private String token;
    Handler handler = new Handler();
    private LinearLayoutManager linearLayoutManager;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_bill, container, false);
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

        if (getArguments() != null) {
            int crimeid = (int) getArguments().getSerializable("ids");
            Log.i("eeee", crimeid + "");
        }

        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");


        rvl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                billPresenter.requestBillData(token);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        rvl.setRefreshing(false);
                    }
                }, 2000);
            }
        });

        billPresenter = new BillPresenter();
        billPresenter.attachView(this);

        billPresenter.requestStarsData(token);
        billPresenter.requestBillData(token);
        winPresenter = new WeiPresenter();
        winPresenter.attachView(this);

        SharedPreferences sps = getActivity().getSharedPreferences("win", Context.MODE_PRIVATE);
        String type = sps.getString("types", "");
        int startTime = sps.getInt("startTimes", 0);
        int endTime = sps.getInt("endTimes", 0);
        //winPresenter.requestWinData(token, type, startTime, endTime);

        listView = view.findViewById(R.id.list);

        return view;
    }

    @OnClick({R.id.sim_dalisList, R.id.sim_refund, R.id.sim_store, R.id.shai})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //日结清单
            case R.id.sim_dalisList:
                Intent intent = new Intent(getActivity(), DalisListActivity.class);
                startActivity(intent);
                break;
            //门店统计
            case R.id.sim_refund:
                Intent intent3 = new Intent(getActivity(), StoreActivity.class);
                startActivity(intent3);
                break;

            //星驿付
            case R.id.sim_store:
                Intent intent4 = new Intent(getActivity(), StarPayActivity.class);
                startActivity(intent4);
                break;
            //筛选
            case R.id.shai:
                Intent intent5 = new Intent(getActivity(), ShaiActivity.class);
                startActivity(intent5);

                break;

        }
    }

    @Override
    public void showBillData(String message) {
        Gson gson = new Gson();
        Bill bill = gson.fromJson(message, Bill.class);
        dataBean = bill.getData();
        ArrayList<Bill.DataBean.ListBean> beanList = (ArrayList<Bill.DataBean.ListBean>) bill.getData().getList();
        //BillsAdapter billsAdapter = new BillsAdapter(getContext(), beanList);
        //listView.setAdapter(billsAdapter);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        BillsAdapter myAdapter = new BillsAdapter(getContext(),beanList);
        listView.setAdapter(myAdapter);
        listView.setLayoutManager(linearLayoutManager);


        if (beanList.size() == 0) {
            images.setVisibility(View.VISIBLE);
            texts.setVisibility(View.VISIBLE);
        } else {
            images.setVisibility(View.GONE);
            texts.setVisibility(View.GONE);
            //myAdapter.notifyDataSetChanged();
        }

        number.setText(dataBean.getOrderCount() + "");

        tuMoney.setText(dataBean.getRefundTotal() + "");

        NumberFormat nf = new DecimalFormat("##.##");
        Double d = Double.valueOf(dataBean.getActualTotal() + "");
        Double ds = Double.valueOf(dataBean.getReceivableTotal() + "");
        String str = nf.format(d);
        String strs = nf.format(ds);
        rMoney.setText(str);
        tMoney.setText(strs);

        //myAdapter.notifyDataSetChanged();
    }

    @Override
    public void showStarsData(String message) {
        Gson gson = new Gson();
        Stars stars = gson.fromJson(message, Stars.class);
        List<Stars.DataBean> dataBeans = stars.getData();
        for (int i = 0; i < dataBeans.size(); i++) {
            int flag = Integer.parseInt(dataBeans.get(i).getFlag());

        }
    }

    @Override
    public void showShopsData(String message) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(message, Shops.class);
        Shops.DataBean dataBean = shops.getData();
        String ali_alleys = dataBean.getAli_alleys();
        String wx_alleys = dataBean.getWx_alleys();

    }

    @Override
    public void showWinData(String message) {
        Gson gson = new Gson();
        WinS winS = gson.fromJson(message, WinS.class);
        List<WinS.DataBean.ListBean> beans = (List<WinS.DataBean.ListBean>) winS.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }
}
