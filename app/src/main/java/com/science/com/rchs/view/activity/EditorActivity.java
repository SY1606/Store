package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;


public class EditorActivity extends AppCompatActivity {

    private TextView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(EditorActivity.this,true);
        StatusBarUtil.setTranslucentStatus(EditorActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(EditorActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(EditorActivity.this,0x55000000);
        }

        delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
