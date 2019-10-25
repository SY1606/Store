package com.science.com.rchs.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;



import android.support.v4.app.Fragment;


import com.science.com.rchs.R;
import com.science.com.rchs.view.activity_guest.GukeActivity;
import com.science.com.rchs.view.activity_guest.MoneyActivity;
import com.science.com.rchs.view.activity_guest.TimeActivity;
import com.science.com.rchs.view.fragment_two.Frag_s_all;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Frag_guest extends Fragment {

    @BindView(R.id.time)
    RelativeLayout time;
    @BindView(R.id.money)
    RelativeLayout money;
    @BindView(R.id.guke)
    RelativeLayout guke;
    private Unbinder unbinder;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_guest, container, false);
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

        return view;
    }


    @OnClick({R.id.time, R.id.money, R.id.guke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.time:
                Intent intent = new Intent(getActivity(), TimeActivity.class);
                startActivity(intent);
                break;
            case R.id.money:
                Intent intent1 = new Intent(getActivity(), MoneyActivity.class);
                startActivity(intent1);
                break;
            case R.id.guke:
                Intent intent2 = new Intent(getActivity(), GukeActivity.class);
                startActivity(intent2);
                break;
        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }
}
