package com.science.com.rchs.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.science.com.rchs.R;
import com.science.com.rchs.view.activity.CRecordActivity;
import com.science.com.rchs.view.activity.PCorderActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Frag_check extends Fragment {

    @BindView(R.id.views)
    View views;
    @BindView(R.id.yue)
    TextView yue;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.jifen)
    TextView jifen;
    @BindView(R.id.fen)
    TextView fen;
    @BindView(R.id.shouji)
    TextView shouji;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.huiyuan)
    TextView huiyuan;
    @BindView(R.id.number)
    TextView number;
    Unbinder unbinder;
    @BindView(R.id.heads)
    ImageView heads;
    @BindView(R.id.names)
    TextView names;
    @BindView(R.id.cuo)
    ImageView cuo;

    @BindView(R.id.recoder)
    Button recoder;
    private SharedPreferences sp;
    private int id;
    private String phones;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_check, container, false);
        unbinder = ButterKnife.bind(this, view);
        sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);

        id = sp.getInt("id",0);
        String head = sp.getString("headimgurl", "");
        heads.setImageURI(Uri.parse(head));
        String name = sp.getString("nickname", "");
        names.setText(name);
        String moneys = sp.getString("balance", "");
        money.setText(moneys + "元");
        String boun = sp.getString("bonus", "");
        fen.setText(boun);
        phones = sp.getString("phone", "");
        phone.setText(phones);

        String card_number = sp.getString("card_number", "");
        number.setText(card_number);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.cuo, R.id.recoder})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cuo:
                getActivity().onBackPressed();
                break;
            case R.id.recoder:
                Intent intent = new Intent(getActivity(),PCorderActivity.class);
                SharedPreferences sp = getActivity().getSharedPreferences("hhhh",Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("phone",phones);
                edit.commit();
                startActivity(intent);

                break;
        }
    }
}
