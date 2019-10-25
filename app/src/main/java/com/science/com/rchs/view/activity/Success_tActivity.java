package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.science.com.rchs.R;

public class Success_tActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_t);

        TextView textView = findViewById(R.id.price);
        String  number = getIntent().getStringExtra("aaa");
        textView.setText(number+"");

    }
}
