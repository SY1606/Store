package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Search;
import com.science.com.rchs.di.contract.SearchContract;
import com.science.com.rchs.di.presenter.SearchPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.adapter.SearchAdapter;
import com.science.com.rchs.view.fragment.Frag_check;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SearchActivity extends AppCompatActivity implements SearchContract.SearchView {

    @BindView(R.id.fan)
    ImageView fan;
    private SearchContract.SearchPresenter searchPresenter;
    private EditText search;
    private String token;

    private RecyclerView searchs;
    private String phone;
    private TextView text_shi;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        searchs = findViewById(R.id.searchs);
        searchPresenter = new SearchPresenter();
        searchPresenter.attachView(this);
        search = findViewById(R.id.search);

        sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        text_shi = findViewById(R.id.text_shi);

        TextView sousuo = findViewById(R.id.sousuo);
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phone = (search.getText().toString().trim());
                Log.i("terwtew", String.valueOf(phone));
                if (phone.equals("")) {
                    Toast.makeText(SearchActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    searchPresenter.requestSearchData(token, phone);

                }
            }
        });

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(SearchActivity.this, true);
        StatusBarUtil.setTranslucentStatus(SearchActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(SearchActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(SearchActivity.this, 0x55000000);
        }
        EditText editText = findViewById(R.id.search);
        String number = getIntent().getStringExtra("aaa");
        editText.setText(number + "");
    }

    @Override
    public void showSearchData(String message) {
        Gson gson = new Gson();
        Search search = gson.fromJson(message, Search.class);
        //ArrayList<Search.DataBean.ListBean> listBeans = (ArrayList<Search.DataBean.ListBean>) search.getData().getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this, LinearLayoutManager.VERTICAL, false);
        searchs.setLayoutManager(linearLayoutManager);
        List<Search.DataBean.ListBean> list = search.getData().getList();
        SearchAdapter searchAdapter = new SearchAdapter(R.layout.item_search, list);
        searchs.setAdapter(searchAdapter);

        searchs.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                SharedPreferences.Editor edit = sp.edit();

                edit.putInt("id", list.get(position).getId());
                edit.putString("nickname", list.get(position).getNickname());
                edit.putString("headimgurl", list.get(position).getHeadimgurl());
                edit.putString("balance", list.get(position).getBalance() + "");
                edit.putString("phone", list.get(position).getPhone() + "");
                edit.putString("card_number", list.get(position).getCard_number() + "");
                edit.putString("bonus", list.get(position).getBonus() + "");
                getSupportFragmentManager().beginTransaction().replace(R.id.details_framelayout, new Frag_check(), null)
                        .addToBackStack(null).commit();
                edit.commit();
            }
        });


      //Search.DataBean.ListBean  data = (Search.DataBean.ListBean) search.getData().getList();


        if (list.size() == 0) {
            text_shi.setVisibility(View.VISIBLE);
        } else {
            text_shi.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.fan)
    public void onViewClicked() {
        finish();
    }
}
