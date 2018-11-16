package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MaCaoYouJiBean;
import mrhao.com.aomentravel.findActivity.PhotoViewActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class MyGvYJDetilesAdapter extends BaseAdapter {

    Context context;
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list;

    public MyGvYJDetilesAdapter(Context context, List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.get(0).getContents().size();
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
    public View getView(final int i, View v, ViewGroup viewGroup) {

        v = LayoutInflater.from(context).inflate(R.layout.mygvyjdetiles, viewGroup, false);
        ImageView im = v.findViewById(R.id.gvyjad_im);
        TextView tv = v.findViewById(R.id.gvyjad_tv);
        RelativeLayout grayback = v.findViewById(R.id.grayback);
        FrameLayout lay = v.findViewById(R.id.gvyjad_fralay);

        GlideApp.with(context).load(list.get(0).getContents().get(i).getPhoto_url()).format(DecodeFormat.PREFER_RGB_565).override(700, 480).placeholder(R.mipmap.pic_jzz).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im);
        if (TextUtils.isEmpty(list.get(0).getContents().get(i).getCaption()) || list.get(0).getContents().get(i).getCaption().toString().trim().equals("")) {
            grayback.setVisibility(View.GONE);
        } else {
            grayback.setVisibility(View.VISIBLE);
        }
        tv.setText(list.get(0).getContents().get(i).getCaption());
        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, PhotoViewActivity.class);
                Bundle b = new Bundle();
                b.putString("picurl", list.get(0).getContents().get(i).getPhoto_url());

                if (TextUtils.isEmpty(list.get(0).getContents().get(i).getCaption()) || list.get(0).getContents().get(i).getCaption().toString().trim().equals("")) {
                    b.putString("wenzi", "");

                } else {
                    b.putString("wenzi", list.get(0).getContents().get(i).getCaption());

                }

                hao.putExtras(b);
                context.startActivity(hao);
            }
        });

        return v;
    }
}
