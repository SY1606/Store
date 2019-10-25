package com.science.com.rchs.view.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Search;

import java.util.List;

public class SearchAdapter extends BaseQuickAdapter<Search.DataBean.ListBean,BaseViewHolder> {
    public SearchAdapter(int layoutResId, @Nullable List<Search.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Search.DataBean.ListBean item) {
        helper.setText(R.id.name,item.getNickname());
        helper.setText(R.id.time,item.getCreated_at());
        Glide.with(mContext).load(item.getHeadimgurl()) .apply(RequestOptions.bitmapTransform(new CircleCrop())).into((ImageView) helper.getView(R.id.imagehead));
    }
}
