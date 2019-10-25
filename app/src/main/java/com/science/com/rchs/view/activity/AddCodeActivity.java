package com.science.com.rchs.view.activity;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.CodeList;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.SystemBarTintManager;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCodeActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Map<String, String>> mStringList = new ArrayList<>();
    private ListView mListView;
    private Button mBtn_insert;
    private EditText mEt_songName;
    private EditText mEt_singer;
    private EditText mEt_input;
    private EditText mEt_dialog_songName;
    private EditText mEt_dialog_singer;
    private Toolbar mToolbar;
    private SimpleCursorAdapter mSimpleCursorAdapter;
    private SQLiteDatabase mDbWriter;
    private SQLiteDatabase mDbReader;
    private MySQLite mMySQLite;
    private String TAG = "TAG";
    private ImageView fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PushAgent.getInstance(this).onAppStart();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_code);



        applyKitKatTranslucency();
        mListView = (ListView) findViewById(R.id.myListview);
        mBtn_insert = (Button) findViewById(R.id.btn_insert);

        mEt_songName = (EditText) findViewById(R.id.et_songname);
        mEt_singer = (EditText) findViewById(R.id.et_singer);

        mEt_songName.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        mBtn_insert.setOnClickListener(this);
        mMySQLite = new MySQLite(this);
        mDbWriter = mMySQLite.getWritableDatabase();
        mDbReader = mMySQLite.getReadableDatabase();

        mSimpleCursorAdapter = new SimpleCursorAdapter(AddCodeActivity.this, R.layout.listview_sql_item, null,
                new String[]{"songname", "singer"}, new int[]{R.id.songname, R.id.singer}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        mListView.setAdapter(mSimpleCursorAdapter);     //给ListView设置适配器
        refreshListview();      //自定义的方法，用于当数据列表改变时刷新ListView



        mEt_songName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        mEt_songName.setText(s.subSequence(0, 1));
                        mEt_songName.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        mEt_songName.setText(text);
                        mEt_songName.setSelection(text.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(AddCodeActivity.this, true);
        StatusBarUtil.setTranslucentStatus(AddCodeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(AddCodeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(AddCodeActivity.this, 0x55000000);
        }

    //单击修改item
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, final View view, final int position, long l) {
            View mView = View.inflate(AddCodeActivity.this, R.layout.dialog_et_layout, null);       //将放置了两个EditText的布局dialog_et_layout渲染成view对象
            mEt_dialog_songName = mView.findViewById(R.id.et_dialog_songname);
            mEt_dialog_singer = (EditText) mView.findViewById(R.id.et_dialog_singer);
            mEt_dialog_songName.setText(((TextView) view.findViewById(R.id.songname)).getText());   //获取并显示原来的歌曲.0
            Intent intent = new Intent(AddCodeActivity.this,FixedActivity.class);

            intent.putExtra("afadfa",((TextView) view.findViewById(R.id.songname)).getText());
            Log.i("moneys", (String) ((TextView) view.findViewById(R.id.songname)).getText());
            startActivity(intent);
            finish();
            mEt_dialog_singer.setText(((TextView) view.findViewById(R.id.singer)).getText());       //获取并显示原来的歌手

        }
    });


    //长按删除item
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
            new android.support.v7.app.AlertDialog.Builder(AddCodeActivity.this)
                    .setTitle("提示")
                    .setMessage("是否删除该项")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            deleteData(position);
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return true;
        }
    });
}
 //刷新数据列表
    public void refreshListview() {
        Cursor mCursor = mDbWriter.query("music_msg", null, null, null, null, null, null);
        mSimpleCursorAdapter.changeCursor(mCursor);
    }

    //增
    public void insertData() {
        String name = mEt_songName.getText().toString().trim();

        if (TextUtils.isEmpty(name)){
            Toast.makeText(AddCodeActivity.this,"请输入金额",Toast.LENGTH_SHORT).show();
        }else {
            ContentValues mContentValues = new ContentValues();
            mContentValues.put("songname", mEt_songName.getText().toString().trim());
            mContentValues.put("singer", mEt_singer.getText().toString().trim());
            mDbWriter.insert("music_msg", null, mContentValues);
            refreshListview();
        }

    }

    //删
    public void deleteData(int positon) {
        Cursor mCursor = mSimpleCursorAdapter.getCursor();
        mCursor.moveToPosition(positon);
        int itemId = mCursor.getInt(mCursor.getColumnIndex("_id"));
        mDbWriter.delete("music_msg", "_id=?", new String[]{itemId + ""});
        refreshListview();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //点击添加按钮
            case R.id.btn_insert:
                if (mEt_songName.equals("")){
                    Toast.makeText(AddCodeActivity.this,"请输入金额",Toast.LENGTH_SHORT).show();
                }else{
                    insertData();
                    mEt_songName.setText("");
                    Log.i("fdafds","");
                    mEt_singer.setText("");
                }
                break;
        }
    }
    /**
     * Apply KitKat specific translucency.
     */
    private void applyKitKatTranslucency() {

        // KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);

            mTintManager.setStatusBarTintResource(R.color.colorBlue_Three);//通知栏所需颜色
        }

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
