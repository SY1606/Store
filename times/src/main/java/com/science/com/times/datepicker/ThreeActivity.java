package com.science.com.times.datepicker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.science.com.times.R;

import java.io.ByteArrayOutputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class ThreeActivity extends AppCompatActivity {

    private Button btn_test;
    private Button btn_test2;
    private ImageView pic_test;
    private TextView tv_test;
    private ImageView asd;
    private int startTime;
    private TextView texts;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        tv_test = findViewById(R.id.tv_test);
        pic_test = findViewById(R.id.pic_test);
        btn_test = findViewById(R.id.btn_test);
        btn_test2 = findViewById(R.id.btn_test2);
        asd = findViewById(R.id.asd);
        texts = findViewById(R.id.texts);

        /*bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //该方法用来压缩图片，第一个参数为图片格式，第二个参数为截取图片的保留率，如当前为90，则保留之前图片90%的区域
        bitmap.compress(Bitmap.CompressFormat.JPEG,90,outputStream );

        byte[] imagebyte = outputStream.toByteArray();

        //得到图片的String
        String imageStr = Base64.encode(imagebyte);*/

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        String createTime = "2019-08-24 14:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            startTime = (int) sdf.parse(createTime).getTime();
            texts.setText(startTime+"");
        } catch (ParseException e) {
            e.printStackTrace();
        }




        String  url = "http://zc.yingjiajiqiren.com/EQ/P11620196";
        Bitmap bitmap = QRCodeEncoder.syncEncodeQRCode(url, 700);
        //给图片控件设置成二维码
        asd.setImageBitmap(bitmap);

        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new IntentIntegrator(ThreeActivity.this)
                        .setOrientationLocked(false)
                        .setCaptureActivity(ScanActivity.class) // 设置自定义的activity是ScanActivity
                        .initiateScan(); // 初始化扫描
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult != null) {
            if(intentResult.getContents() == null) {
                Toast.makeText(this,"内容为空",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,"扫描成功",Toast.LENGTH_LONG).show();
                // ScanResult 为 获取到的字符串
                String ScanResult = intentResult.getContents();
                tv_test.setText(ScanResult);
            }
        } else {
            super.onActivityResult(requestCode,resultCode,data);
        }


    }

    // 图片转化成base64字符串
    /*public static String GetImageStr() {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String imgFile = "C:/Users/Star/Desktop/test.png";// 待处理的图片
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }*/
    public Bitmap stringToBitmap(String string) {
        // 将字符串转换成Bitmap类型
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray;
            bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
                    bitmapArray.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public String bitmapToString(Bitmap bitmap){
        //将Bitmap转换成字符串
        String string=null;
        ByteArrayOutputStream bStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bStream);
        byte[]bytes=bStream.toByteArray();
        string=Base64.encodeToString(bytes,Base64.DEFAULT);


        return string;

    }

}
