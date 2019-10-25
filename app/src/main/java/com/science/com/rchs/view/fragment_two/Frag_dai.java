package com.science.com.rchs.view.fragment_two;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.HList;

import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.presenter.DaiPresenter;
import com.science.com.rchs.view.activity.MemListActivity;
import com.science.com.rchs.view.adapter.DaiAdapter;
import com.science.com.rchs.view.adapter.MemListAdapter;

import java.util.List;


public class Frag_dai extends Fragment implements DaiContract.DaiView {

    private RecyclerView recy_dai;
    private DaiContract.DaiPresenter daiPresenter;

    int coupon_type =1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_dai, container, false);
        recy_dai = view.findViewById(R.id.recy_dai);

        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
       String token = sp.getString("token","");

        daiPresenter = new DaiPresenter();
        daiPresenter.attachView(this);
        daiPresenter.requestDaiData(token,coupon_type);
        return view;
    }

    @Override
    public void showDaiData(String message) {
        Gson gson = new Gson();
        HList hList =gson.fromJson(message,HList.class);
        List<HList.DataBean> beans = hList.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recy_dai.setLayoutManager(linearLayoutManager);

        DaiAdapter daiAdapter = new DaiAdapter(R.layout.item_dai, beans);
        recy_dai.setAdapter(daiAdapter);
    }
}
