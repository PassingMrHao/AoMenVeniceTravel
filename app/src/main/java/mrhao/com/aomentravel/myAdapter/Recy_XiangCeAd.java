package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.Placeholder;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TravelXiangCeBean;
import mrhao.com.aomentravel.findActivity.PhotoViewActivity;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.ScreenUtils;

public class Recy_XiangCeAd extends RecyclerView.Adapter<Recy_XiangCeAd.MyHolder> {
    Context context;
    List<TravelXiangCeBean> list;

    DisplayMetrics dm;

    public Recy_XiangCeAd(Context context, List<TravelXiangCeBean> list) {
        this.context = context;
        this.list = list;
        this.dm=context.getResources().getDisplayMetrics();
    }

    @NonNull
    @Override
    public Recy_XiangCeAd.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.travel_xiangce,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final Recy_XiangCeAd.MyHolder h, final int i) {


     ViewGroup.LayoutParams params=h.im.getLayoutParams();

        params.width= (int) (dm.widthPixels/2);
        params.height= (int) (((double)list.get(i).getImage_height()/list.get(i).getImage_width())*params.width);
//        h.im.setLayoutParams(params);


        GlideApp.with(context).load(list.get(i).getImage_url()).format(DecodeFormat.PREFER_RGB_565).placeholder(R.mipmap.pic_jzz).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(params.width/2,params.height/2).into(h.im);

        if ((list.get(i).getDescription() + "").equals("null") || (list.get(i).getDescription() + "").equals("")) {
            h.tv.setText("无图片描述");
        } else if (!(list.get(i).getDescription() + "").equals("null")) {
            h.tv.setText(list.get(i).getDescription() + "");
        }


        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, PhotoViewActivity.class);
                Bundle b = new Bundle();
                b.putString("picurl", list.get(i).getImage_url());
                if ((list.get(i).getDescription() + "").equals("null") || (list.get(i).getDescription() + "").equals("")) {
                    b.putString("wenzi", "无图片描述");
                } else if (!(list.get(i).getDescription() + "").equals("null")) {
                    b.putString("wenzi", list.get(i).getDescription() + "");
                }
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

        ImageView im;
        TextView tv;
        FrameLayout lay;
        public MyHolder(View v) {
            super(v);
            im=v.findViewById(R.id.im_xiangce);
            tv=v.findViewById(R.id.tv_xiangce);
            lay = v.findViewById(R.id.fralay_pic);
        }

    }



}
