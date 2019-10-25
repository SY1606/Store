package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Home;
import com.science.com.rchs.data.bean.MemList;
import com.science.com.rchs.di.contract.HomeContract;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.presenter.HomePresenter;
import com.science.com.rchs.di.presenter.MemListPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.adapter.MemListAdapter;
import com.science.com.rchs.view.fragment.Frag_check;

import java.lang.reflect.Method;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MemListActivity extends AppCompatActivity implements MemListContract.MemListView, HomeContract.HomeView {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.leiji)
    TextView leiji;
    private MemListContract.MemListPresenter memListPresenter;
    private RecyclerView recycler_menlist;
    private String token;
    private SharedPreferences sp;
    private RelativeLayout searchs;
    private HomeContract.HomePresenter homePresenter;
    private Home.DataBean dataBean;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_mem_list);
        ButterKnife.bind(this);

        recycler_menlist = findViewById(R.id.recycler_menlist);
        searchs = findViewById(R.id.searchs);

        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        memListPresenter = new MemListPresenter();
        memListPresenter.attachView(this);
        memListPresenter.requestMemListData(token);

        if (android.os.Build.VERSION.SDK_INT <= 10) {
            search.setInputType(InputType.TYPE_NULL);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            try {
                Class<EditText> cls = EditText.class;
                Method setSoftInputShownOnFocus;
                setSoftInputShownOnFocus = cls.getMethod("setSoftInputShownOnFocus", boolean.class);
                setSoftInputShownOnFocus.setAccessible(true);
                setSoftInputShownOnFocus.invoke(search, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.requestHomeData(token);


        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(MemListActivity.this, true);
        StatusBarUtil.setTranslucentStatus(MemListActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(MemListActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(MemListActivity.this, 0x55000000);
        }

        search = findViewById(R.id.search);

        search.setFocusable(true);
        search.requestFocus();
        search.setFocusableInTouchMode(true);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MemListActivity.this, SearchActivity.class);
                intent.putExtra("aaa",search.getText().toString().trim());
                startActivity(intent);
            }

        });

    }

    @Override
    public void showPhotoData(String message) {
        Gson gson = new Gson();
        MemList memList = gson.fromJson(message, MemList.class);
        final List<MemList.DataBean> beans = memList.getData();
        //List<MemList.DataBean> dataBeans = (List<MemList.DataBean>) memList.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MemListActivity.this, LinearLayoutManager.VERTICAL, false);
        recycler_menlist.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setStackFromEnd(false);
        linearLayoutManager.setReverseLayout(false);
        MemListAdapter memListAdapter = new MemListAdapter(R.layout.item_menlist, beans);
        recycler_menlist.setAdapter(memListAdapter);

        recycler_menlist.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                backgroundAlpha(0.6f);
            }
        });

        recycler_menlist.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

                backgroundAlpha(1.0f);
                SharedPreferences.Editor edit = sp.edit();

                edit.putInt("id", beans.get(position).getId());
                edit.putString("nickname", beans.get(position).getNickname());
                edit.putString("headimgurl", beans.get(position).getHeadimgurl());
                edit.putString("balance", beans.get(position).getBalance() + "");
                edit.putString("phone", beans.get(position).getPhone() + "");
                edit.putString("card_number", beans.get(position).getCard_number() + "");
                edit.putString("bonus", beans.get(position).getBonus() + "");
                getSupportFragmentManager().beginTransaction().replace(R.id.details_framelayout, new Frag_check())
                        .addToBackStack(null).commit();
                edit.commit();
            }
        });

    }

    @OnClick(R.id.fan)
    public void onViewClicked() {
        finish();

    }

    @Override
    public void showHomeData(String message) {
        Gson gson = new Gson();
        Home home = gson.fromJson(message, Home.class);
        //List<Home.DataBean> list = (List<Home.DataBean>) home.getData();
        dataBean = home.getData();

        number.setText(dataBean.getMembersTotalToday()+"");
        leiji.setText(dataBean.getMembersTotal()+"");
    }

    @Override
    public void showChongzhiData(String message) {

    }

    @Override
    public void showStoresData(String message) {

    }

    @Override
    public void showBangData(String message) {

    }

    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        lp.alpha = f;
        getWindow().setAttributes(lp);
    }

}
