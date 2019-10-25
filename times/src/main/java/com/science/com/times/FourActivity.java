package com.science.com.times;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jzxiang.pickerview.utils.Utils;
import com.science.com.times.dialog.SelectAddressDialog;
import com.science.com.times.dialog.SelectDateDialog;
import com.science.com.times.dialog.SelectDefineDialog;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import study.com.wheelviewlibrary.listener.SelectInterface;

public class FourActivity extends AppCompatActivity implements SelectInterface {
    private TextView tvResult;
    private SelectDateDialog dateDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        tvResult = (TextView) findViewById(R.id.tv_result);

    }
    /**
     * 弹出时间对话框
     *
     * @param view
     */
    public void year(View view) {
        dateDialog = new SelectDateDialog(FourActivity.this);
        dateDialog.showDateDialog(FourActivity.this);
    }

    @Override
    public void selectedResult(String result) {
        tvResult.setText(result);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
