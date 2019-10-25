package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.activity_bill.DalisListActivity;
import com.science.com.rchs.view.fragment.Frag_check;
import com.science.com.rchs.view.fragment_two.Frag_why;


public class TixianActivity extends AppCompatActivity {

    private EditText vercode;
    private ImageView why;
    private ImageView fan;
    private LinearLayout shuoming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tixian);
        StatusBarUtil.setRootViewFitsSystemWindows(TixianActivity.this,true);
        StatusBarUtil.setTranslucentStatus(TixianActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(TixianActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(TixianActivity.this,0x55000000);
        }

        vercode = findViewById(R.id.vercode);
        why = findViewById(R.id.why);
        //Button button = findViewById(R.id.mlogin);
        fan = findViewById(R.id.fan);
        shuoming = findViewById(R.id.shuoming);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vercode.equals("")){
                    Toast.makeText(TixianActivity.this,"不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(TixianActivity.this,Success_tActivity.class);
                    intent.putExtra("aaa",vercode.getText().toString().trim());
                    startActivity(intent);
                }
            }
        });*/
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        shuoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.hehe, new Frag_why(), null)
                        .addToBackStack(null).commit();
            }
        });
        /*why.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.details_framelayout, new Frag_why(), null)
                        .addToBackStack(null).commit();

            }
        });*/
    }
}
