package com.science.com.rchs.view.adapter;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;


import com.science.com.rchs.R;
import com.science.com.rchs.keyword.KeyboardUtil;
import com.science.com.rchs.keyword.MyKeyBoardView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by xuejinwei on 16/8/19.
 * Email:xuejinwei@outlook.com
 */
public class XianYuActivity extends AppCompatActivity {


    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_price)
    LinearLayout llPrice;
    @BindView(R.id.et_price)
    EditText etPrice;
    @BindView(R.id.et_orginal_price)
    EditText etOrginalPrice;
    @BindView(R.id.et_freight)
    EditText etFreight;
    @BindView(R.id.keyboard_view)
    MyKeyBoardView keyboardView;
    @BindView(R.id.ll_price_select)
    LinearLayout llPriceSelect;
    private Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xianyu);
        ButterKnife.bind(this);
        unbinder = ButterKnife.bind(this);
        final KeyboardUtil keyboardUtil = new KeyboardUtil(XianYuActivity.this);
        keyboardUtil.setOnOkClick(new KeyboardUtil.OnOkClick() {
            @Override
            public void onOkClick() {
                if (validate()) {
                    llPriceSelect.setVisibility(View.GONE);
                    tvPrice.setText(etPrice.getText() + "/价格，" + etOrginalPrice.getText() + "/原价，" + etFreight.getText() + "/运费");
                }
            }
        });

        keyboardUtil.setOnCancelClick(new KeyboardUtil.onCancelClick() {
            @Override
            public void onCancellClick() {
                llPriceSelect.setVisibility(View.GONE);
            }
        });

        llPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardUtil.attachTo(etPrice);
                etPrice.setFocusable(true);
                etPrice.setFocusableInTouchMode(true);
                etPrice.requestFocus();
                llPriceSelect.setVisibility(View.VISIBLE);
            }
        });

        etPrice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(etPrice);
                return false;
            }
        });
        etOrginalPrice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(etOrginalPrice);
                return false;
            }
        });
        etFreight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                keyboardUtil.attachTo(etFreight);
                return false;
            }
        });
    }

    public boolean validate() {
        if (etPrice.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "价格不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (etOrginalPrice.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "原价不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else if (etFreight.getText().toString().equals("")) {
            Toast.makeText(getApplication(), "运费不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (llPriceSelect.getVisibility() == View.VISIBLE) {
            llPriceSelect.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}
