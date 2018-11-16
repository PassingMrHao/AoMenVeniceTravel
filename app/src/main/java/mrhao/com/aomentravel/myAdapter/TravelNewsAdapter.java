package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TravelNewsBean;
import mrhao.com.aomentravel.myActivity.BannerWebActivity;
import mrhao.com.aomentravel.myActivity.ZheKouWebActivity;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.CreatGlideAppUtil;
import mrhao.com.aomentravel.utils.GlideApp;

public class TravelNewsAdapter extends RecyclerView.Adapter<TravelNewsAdapter.MyHolder> {

    Context context;
    List<TravelNewsBean.DataBean.StrategiesBean> list;
    public TravelNewsAdapter(Context context,List<TravelNewsBean.DataBean.StrategiesBean> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public TravelNewsAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.travel_news,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelNewsAdapter.MyHolder h, final int i) {
        h.title.setText(list.get(i).getTitle());
        h.biaoqian.setText(list.get(i).getCategories().get(0).getCategoryName());
        if (list.get(i).getCoverImage() != null) {
            GlideApp.with(context).load(list.get(i).getCoverImage()).override(400,240).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).transform(new CircleTransform(context)).into(h.im);
        } else {
            GlideApp.with(context).load(R.mipmap.zanwu_pic).transform(new CircleTransform(context)).into(h.im);
        }
        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hao = new Intent(context, BannerWebActivity.class);
                Bundle b=new Bundle();
                b.putString("title",list.get(i).getTitle());
                b.putString("img",list.get(i).getCoverImage());
                b.putString("tag",list.get(i).getCategories().get(0).getCategoryName());
                b.putString("bannerweb", list.get(i).getDetailUrl());
                hao.putExtras(b);
                context.startActivity(hao);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView title,biaoqian;
        ImageView im;
        LinearLayout lay;
        public MyHolder(View v) {
            super(v);
            title=v.findViewById(R.id.travel_title);
            biaoqian=v.findViewById(R.id.travel_biaoqian);
            im=v.findViewById(R.id.travel_news_img);
            lay=v.findViewById(R.id.linlay_news);
        }
    }
}
