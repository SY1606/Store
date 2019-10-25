package com.science.com.rchs.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseStore;
import com.science.com.rchs.view.activity.HomeActivity;
import com.science.com.rchs.view.activity_bill.ShaiActivity;

import java.util.List;

public class ChooseSrAdapter extends BaseQuickAdapter<ChooseStore.DataBean,BaseViewHolder> {
    public ChooseSrAdapter(int layoutResId, @Nullable List<ChooseStore.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ChooseStore.DataBean item) {
        helper.setText(R.id.store,item.getName());

        helper.getView(R.id.store).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                refresh();
                if (Activity.class.isInstance(mContext)){
                    Activity activity = (Activity) mContext;
                    activity.finish();
                }
            }
            private void refresh() {
                SharedPreferences sp = mContext.getSharedPreferences("ids",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putInt("id",item.getId());
                editor.putString("names",item.getName());
                Intent intent = new Intent(mContext, ShaiActivity.class);
                mContext.startActivity(intent);
                editor.commit();
            }
        });
    }
}
