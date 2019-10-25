package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.CodeList;

import java.util.ArrayList;
import java.util.List;

public class ChooseCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_code);

        CodeList codeList = new CodeList();
        String money = codeList.getMoney();
        String name = codeList.getName();
        List<String> lists = new ArrayList<>();
        for (int i=0;i<5;i++){
            lists.add(money);
            lists.add(name);
        }

    }
}
