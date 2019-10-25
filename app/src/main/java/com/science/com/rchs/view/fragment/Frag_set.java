package com.science.com.rchs.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseD;
import com.science.com.rchs.data.bean.Shops;
import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.contract.ShopsContract;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.di.presenter.ShopsPresenter;
import com.science.com.rchs.net.APKVersionCodeUtils;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.activity.LoginActivity;
import com.science.com.rchs.view.activity_set.ChooseStoreActivity;
import com.science.com.rchs.view.activity_set.UpdatePwdActivity;
import com.science.com.rchs.weidgt.DataCleanManager;
import com.science.com.rchs.weidgt.MyDialog;
import com.science.com.rchs.weidgt.MyNotifiService;
import com.suke.widget.SwitchButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Frag_set extends Fragment implements ShopsContract.ShopsView, ChooseDStoreContract.ChooseDStoreView {

    @BindView(R.id.msimple)
    ImageView msimple;

    @BindView(R.id.mtext_qian)
    TextView mtextQian;
    @BindView(R.id.image_capacity)
    ImageView imageCapacity;
    @BindView(R.id.text_capacity)
    TextView textCapacity;
    @BindView(R.id.choose)
    RelativeLayout choose;
    @BindView(R.id.image_sound)
    ImageView imageSound;
    @BindView(R.id.text_sound)
    TextView textSound;
    @BindView(R.id.views)
    View views;
    @BindView(R.id.image_tui)
    ImageView imageTui;
    @BindView(R.id.text_tui)
    TextView textTui;
    @BindView(R.id.image_update)
    ImageView imageUpdate;
    @BindView(R.id.text_update)
    TextView textUpdate;
    @BindView(R.id.image_qing)
    ImageView imageQing;
    @BindView(R.id.text_qing)
    TextView textQing;
    @BindView(R.id.tuichu)
    Button tuichu;
    @BindView(R.id.update)
    RelativeLayout update;
    @BindView(R.id.image_banben)
    ImageView imageBanben;
    @BindView(R.id.text_banben)
    TextView textBanben;
    Unbinder unbinder;
    @BindView(R.id.clear)
    RelativeLayout clear;
    @BindView(R.id.mtext_name)
    TextView mtextName;
    @BindView(R.id.banben)
    TextView banben;


    private TextView numbers;
    private MemListContract.MemListPresenter memListPresenter;


    int page = 1;
    private String token;
    private String phones;
    private String image;
    private ShopsContract.ShopsPresenter shopsPresenter;

    private String totalCache;
    private boolean isGetData = false;
    private Dialog dialog;
    private ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    private String name;

    private int store_id;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_set, container, false);
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

        numbers = view.findViewById(R.id.numbers);

        Intent intent = new Intent(getActivity(), MyNotifiService.class);//启动服务
        getActivity().startService(intent);//启动服务

        final SharedPreferences spss = getActivity().getSharedPreferences("msg", Context.MODE_PRIVATE);
        textUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getMsg = spss.getString("getMsg", "");
                if (!TextUtils.isEmpty(getMsg)) {

                }
            }
        });


        final boolean falg = true;
        SwitchButton switchButton = view.findViewById(R.id.switchButton);
        SwitchButton switchButton1 = view.findViewById(R.id.switchButton1);
        switchButton.setChecked(true);
        switchButton1.setChecked(true);


        SharedPreferences preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        if (preferences != null) {
            boolean name = preferences.getBoolean("flag", falg);
            switchButton.setChecked(name);
        }

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked) {
                    ToastUtil.showToast(getActivity(), "已开启", Toast.LENGTH_SHORT);
                    SharedPreferences preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("flag", true);
                    editor.commit();

                } else {
                    ToastUtil.showToast(getActivity(), "已关闭", Toast.LENGTH_SHORT);
                    SharedPreferences preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("flag", false);
                    editor.commit();

                }
            }
        });

        switchButton1.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                if (isChecked) {
                    ToastUtil.showToast(getActivity(), "已开启", Toast.LENGTH_SHORT);
                    SharedPreferences preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("flag", true);
                    editor.commit();
                } else {
                    ToastUtil.showToast(getActivity(), "已关闭", Toast.LENGTH_SHORT);
                    SharedPreferences preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("flag", false);
                    editor.commit();
                }
            }
        });


        String versionCode = APKVersionCodeUtils.getVersionCode(getActivity()) + "";

        String versionName = APKVersionCodeUtils.getVerName(getActivity());

        banben.setText(versionName);

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

        RelativeLayout update = view.findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), UpdatePwdActivity.class);
                startActivity(intent);
            }
        });

        String totalCache = null;
        try {
            totalCache = DataCleanManager.getTotalCacheSize(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        numbers.setText(totalCache);
        return view;
    }

    @OnClick({R.id.choose, R.id.tuichu, R.id.clear})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.choose:
                Intent intent = new Intent(getActivity(), ChooseStoreActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            case R.id.tuichu:
                View views = getLayoutInflater().inflate(R.layout.item_dialog, null);
                TextView textView = views.findViewById(R.id.textView);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                TextView textview1 = views.findViewById(R.id.textview1);
                textview1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                        intent2.putExtra("mima","");
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent2);


                        /*Intent intent_login = new Intent();
                        intent_login.setClass(getActivity(),LoginActivity.class);
                        intent_login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //关键的一句，将新的activity置为栈顶
                        startActivity(intent_login);
                        getActivity().finish();*/
                    }
                });
                dialog = new MyDialog(getActivity(), 0, 0, views, R.style.DialogTheme);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
                dialog.setCancelable(false);
                dialog.show();

                //alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE);
                //alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(Color.BLUE);


                break;
            case R.id.clear:
                //清除缓存
                totalCache = null;
                DataCleanManager.clearAllCache(getActivity());
                try {
                    //清除完缓存更新一下缓存数据
                    totalCache = DataCleanManager.getTotalCacheSize(getActivity());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                numbers.setText(totalCache);
                ToastUtil.showToast(getActivity(), "清除完成", Toast.LENGTH_SHORT);
                break;
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showShopsData(String message) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(message, Shops.class);
        Shops.DataBean dataBeans = shops.getData();
        phones = dataBeans.getPhone();

        String logo = dataBeans.getLogo();
        //msimple.setImageURI(Uri.parse(logo));

        Glide.with(getActivity()) // 依赖组件，不要依赖Context，依赖具体的活动(fragment,activiyt) ;glide 会随具体的活动生命周期做活动；防止内存泄漏
                .load(Uri.parse(logo))
                 .apply(RequestOptions.bitmapTransform(new CircleCrop()))//需要加载的地址
                .into(msimple); // 需要填充的view
        mtextName.setText(phones);
    }

    @Override
    public void showChooseDStoreData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);
        List<ChooseD.DataBean> dataBeans = chooseD.getData();
            store_id = dataBeans.get(0).getId();
            name = dataBeans.get(0).getName();
            textCapacity.setText(name);
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }
}
