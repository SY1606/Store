package com.science.com.rchs.view.fragment_two;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.di.contract.YouAllContract;
import com.science.com.rchs.di.contract.ZheContract;
import com.science.com.rchs.di.presenter.YouAllPresenter;
import com.science.com.rchs.di.presenter.ZhePresenter;
import com.science.com.rchs.view.adapter.YouAllAdapter;
import com.science.com.rchs.view.adapter.ZheAdapter;

import java.util.List;

public class Frag_zhe extends Fragment implements ZheContract.ZheView {

    private RecyclerView frag_zhe;
    int coupon_type=2;
    private ZheContract.ZhePresenter zhePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_zhe, container, false);

        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        String token = sp.getString("token","");
        frag_zhe = view.findViewById(R.id.frag_zhe);
        zhePresenter = new ZhePresenter();
        zhePresenter.attachView(this);
        zhePresenter.requestZheData(token,coupon_type);
        return view;
    }
    @Override
    public void showZheData(String message) {
        Gson gson = new Gson();
        HList hList =gson.fromJson(message,HList.class);
        List<HList.DataBean> beans = hList.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        frag_zhe.setLayoutManager(linearLayoutManager);

        ZheAdapter zheAdapter = new ZheAdapter(R.layout.item_zhe, beans);
        frag_zhe.setAdapter(zheAdapter);
    }
}
