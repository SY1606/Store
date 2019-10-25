package com.science.com.rchs.view.frag_two;

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

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.di.contract.YouContract;
import com.science.com.rchs.di.presenter.YouPresenter;
import com.science.com.rchs.view.adapter.DisListAdapter;
import com.science.com.rchs.view.adapter.DisList_yAdapter;

import java.util.ArrayList;
import java.util.List;


public class Frag03 extends Fragment implements YouContract.YouView {

    private RecyclerView recy_frag02;
    private YouContract.YouPresenter youPresenter;
    int type;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag03, container, false);


        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        String token = sp.getString("token","");

        recy_frag02 = view.findViewById(R.id.recy_frag02);
        youPresenter = new YouPresenter();
        youPresenter.attachView(this);
        youPresenter.requestYouData(token,type);
        return view;
    }

    @Override
    public void showDaiData(String message) {
        Gson gson = new Gson();
        DisList disList = gson.fromJson(message,DisList.class);
        ArrayList<DisList.DataBean.ListBean> beans = (ArrayList<DisList.DataBean.ListBean>) disList.getData().getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recy_frag02.setLayoutManager(linearLayoutManager);

        DisList_yAdapter disList_yAdapter = new DisList_yAdapter(R.layout.item03, beans);

        recy_frag02.setAdapter(disList_yAdapter);
    }
}
