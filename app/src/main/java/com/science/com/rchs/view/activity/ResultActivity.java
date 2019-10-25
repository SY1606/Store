package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.science.com.rchs.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView text = findViewById(R.id.text);
        Intent intent = getIntent();
       String name = intent.getStringExtra("ress");
       text.setText(name);
    }
}
