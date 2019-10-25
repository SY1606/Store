package com.science.com.rchs.view.frag_two;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.presenter.ChatPresenter;
import com.science.com.rchs.view.activity_set.DisDetalisActivity;
import com.science.com.rchs.view.adapter.DisListAdapter;

import java.util.ArrayList;
import java.util.List;


public class Frag02 extends Fragment implements ChatContract.ChatView {

    private RecyclerView recy_frag02;
    private ChatContract.ChatPresenter chatPresenter;
    private String token;
    int type;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag02, container, false);

        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");

        recy_frag02 = view.findViewById(R.id.recy_frag02);

        chatPresenter = new ChatPresenter();
        chatPresenter.attachView(this);
        chatPresenter.requestChatData(token,type);
        return view;
    }

    @Override
    public void showChatData(String message) {
        Gson gson = new Gson();
        DisList disList = gson.fromJson(message,DisList.class);
        ArrayList<DisList.DataBean.ListBean> beans = (ArrayList<DisList.DataBean.ListBean>) disList.getData().getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recy_frag02.setLayoutManager(linearLayoutManager);
        DisListAdapter disListAdapter = new DisListAdapter(R.layout.item02, beans);
        recy_frag02.setAdapter(disListAdapter);
    }
}
