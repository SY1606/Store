package com.science.com.rchs.keyword;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.science.com.rchs.R;


/**
 * Created by xuejinwei on 16/8/19.
 * Email:xuejinwei@outlook.com
 */
public class RandomActivity extends AppCompatActivity {


    private EditText et_rondom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        et_rondom = findViewById(R.id.et_rondom);

        final KeyboardUtil keyboardUtil = new KeyboardUtil(RandomActivity.this,true);

        et_rondom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardUtil.attachTo(et_rondom);
            }
        });
    }
}
