package com.science.com;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.science.com.times.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SixActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout llContainer;
    private ImageView ivTest;	//示例测试图片
    private TextView tvHint;	//测试文本

    private Button btnSnap;
    private Button btnImgSnap;
    private Button btnTVSnap;

    private ImageView ivShow;
    private Button btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        initViews();
    }
        private void initViews () {
            llContainer = (LinearLayout) findViewById(R.id.llContainer);
            ivTest = (ImageView) findViewById(R.id.ivTest);
            tvHint = findViewById(R.id.tvHint);

            btnSnap = (Button) findViewById(R.id.btnSnap);
            btnImgSnap = (Button) findViewById(R.id.btnImgSnap);
            btnTVSnap = (Button) findViewById(R.id.btnTVSnap);

            ivShow = (ImageView) findViewById(R.id.ivShow);
            btnReset = (Button) findViewById(R.id.btnReset);

            btnSnap.setOnClickListener(this);
            btnImgSnap.setOnClickListener(this);
            btnTVSnap.setOnClickListener(this);
            btnReset.setOnClickListener(this);
        }

        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.btnSnap:
                    // 针对Layout整体（ImageView + TextView）截图
                    testViewSnapshot(llContainer);
                    break;
                case R.id.btnImgSnap:
                    // 针对ImageView截图
                    testViewSnapshot(ivTest);
                    break;
                case R.id.btnTVSnap:
                    // 针对TextView截图
                    testViewSnapshot(tvHint);
                    break;
                case R.id.btnReset:
                    // 清除
                    reset();
                    break;
                default:
                    break;
            }
        }

        /**
         * 对View进行截图
         */
        private void testViewSnapshot (View view){
            //使控件可以进行缓存
            view.setDrawingCacheEnabled(true);
            //获取缓存的 Bitmap
        Bitmap drawingCache = view.getDrawingCache();
            //复制获取的 Bitmap
            drawingCache = Bitmap.createBitmap(drawingCache);
            //关闭视图的缓存
            view.setDrawingCacheEnabled(false);

            if (drawingCache != null) {
                ivShow.setImageBitmap(drawingCache);
                Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
            }
        }

        /**
         * 设置默认显示图片
         */
        private void reset () {
            ivShow.setImageResource(R.mipmap.ic_launcher);
        }

}
