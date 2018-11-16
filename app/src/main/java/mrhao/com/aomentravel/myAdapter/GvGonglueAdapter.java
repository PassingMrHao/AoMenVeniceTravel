package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TravelNewsBean;
import mrhao.com.aomentravel.myActivity.BannerWebActivity;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;

public class GvGonglueAdapter extends BaseAdapter {


    Context context;
    List<TravelNewsBean.DataBean.StrategiesBean> list;
    public GvGonglueAdapter(Context context,List<TravelNewsBean.DataBean.StrategiesBean> list){
        this.context=context;
        this.list=list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View v, ViewGroup parent) {
        v= LayoutInflater.from(context).inflate(R.layout.travel_news,parent,false);
        TextView title=v.findViewById(R.id.travel_title);
        TextView biaoqian=v.findViewById(R.id.travel_biaoqian);
        ImageView im=v.findViewById(R.id.travel_news_img);
        LinearLayout lay=v.findViewById(R.id.linlay_news);

        title.setText(list.get(i).getTitle());
        biaoqian.setText(list.get(i).getCategories().get(0).getCategoryName());
        if (list.get(i).getCoverImage() != null) {
            GlideApp.with(context).load(list.get(i).getCoverImage()).override(400,240).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).transform(new CircleTransform(context)).into(im);
        } else {
            GlideApp.with(context).load(R.mipmap.zanwu_pic).transform(new CircleTransform(context)).into(im);
        }
        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hao = new Intent(context, BannerWebActivity.class);
                Bundle b=new Bundle();
                b.putString("bt","澳门旅游指南");
                b.putString("type","资讯攻略");
                b.putString("title",list.get(i).getTitle());
                b.putString("image",list.get(i).getCoverImage());
                b.putString("tag",list.get(i).getCategories().get(0).getCategoryName());
                b.putString("weburl",list.get(i).getDetailUrl());
                b.putString("bannerweb", list.get(i).getDetailUrl());
                hao.putExtras(b);
                context.startActivity(hao);

            }
        });

        return v;
    }
}
