package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MyMaCaoYouJiBean;
import mrhao.com.aomentravel.bean.TravelYouJiBean;
import mrhao.com.aomentravel.findActivity.PhotoTextActivity;
import mrhao.com.aomentravel.findActivity.PhotoViewActivity;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.ScreenUtils;

public class Recy_YouJiAd extends RecyclerView.Adapter<Recy_YouJiAd.MyHolder> {

    Context context;
    List<MyMaCaoYouJiBean> list;
    ArrayList<MyMaCaoYouJiBean.NotesBean> yjbean = new ArrayList<>();
    DisplayMetrics dm;

    public Recy_YouJiAd(Context context, List<MyMaCaoYouJiBean> list) {
        this.context = context;
        this.list = list;
        this.dm = context.getResources().getDisplayMetrics();
    }

    @Override
    public Recy_YouJiAd.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvv = LayoutInflater.from(context).inflate(R.layout.recy_jingdianyouji, parent, false);
        return new MyHolder(vvv);
    }

    @Override
    public void onBindViewHolder(Recy_YouJiAd.MyHolder h, final int i) {
//  http://a.chanyouji.cn/208927/1494376314.jpg
        if (list.get(i).getTrip().getUser().getImage().contains("http://a.chanyouji.cn/")) {
            GlideApp.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538022593894&di=9b4f971ec9f892e2ec243cd7a289b72a&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa8773912b31bb051d4c455113d7adab44aede023.jpg").format(DecodeFormat.PREFER_RGB_565).override(86, 86).thumbnail(0.1f).dontAnimate().transform(new CircleTransform(context)).into(h.im);
        } else {
            GlideApp.with(context).load(list.get(i).getTrip().getUser().getImage()).format(DecodeFormat.PREFER_RGB_565).transform(new CircleTransform(context)).override(86, 86).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(h.im);
        }

        h.name.setText(list.get(i).getTrip().getUser().getName());
        if (TextUtils.isEmpty(list.get(i).getComment())) {
            h.des.setText("");
            h.des.setVisibility(View.GONE);
        } else {
            h.des.setVisibility(View.VISIBLE);
            h.des.setText("\u3000\u3000" + list.get(i).getComment());
        }
        yjbean = (ArrayList<MyMaCaoYouJiBean.NotesBean>) list.get(i).getNotes();
        LinearLayoutManager hxlay = new LinearLayoutManager(context);
        hxlay.setOrientation(LinearLayoutManager.HORIZONTAL);
        h.recy.setLayoutManager(hxlay);
        YouJiXiangPian adad = new YouJiXiangPian(context, yjbean);
        h.recy.setAdapter(adad);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView name, des;
        RecyclerView recy;

        public MyHolder(View v) {
            super(v);
            im = v.findViewById(R.id.youji_pic);
            name = v.findViewById(R.id.youji_name);
            des = v.findViewById(R.id.tv_youji);
            recy = v.findViewById(R.id.recy_youjixiangpian);
        }

    }

    public class YouJiXiangPian extends RecyclerView.Adapter<YouJiXiangPian.YJXPHolder> {

        Context ycontext;
        ArrayList<MyMaCaoYouJiBean.NotesBean> yjbean = new ArrayList<>();

        public YouJiXiangPian(Context ycontext, ArrayList<MyMaCaoYouJiBean.NotesBean> yjbean) {
            this.ycontext = ycontext;
            this.yjbean = yjbean;
        }

        @Override
        public YouJiXiangPian.YJXPHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View hyl = LayoutInflater.from(ycontext).inflate(R.layout.youji_xiangpian, parent, false);
            return new YJXPHolder(hyl);
        }

        @Override
        public void onBindViewHolder(YouJiXiangPian.YJXPHolder hh, final int p) {
            if (TextUtils.isEmpty(yjbean.get(p).getPhoto_url())) {
                hh.fralay.setVisibility(View.GONE);
                hh.relay.setVisibility(View.VISIBLE);
                hh.nopic.setText("\u3000\u3000" + yjbean.get(p).getDescription());
                hh.frakuan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent hao = new Intent(context, PhotoTextActivity.class);
                        Bundle b = new Bundle();
                        b.putString("wenzi", yjbean.get(p).getDescription());
                        hao.putExtras(b);
                        context.startActivity(hao);
                    }
                });

            } else {
                hh.fralay.setVisibility(View.VISIBLE);
                hh.relay.setVisibility(View.GONE);
                String thstr = "";
                for (int i = 0; i < yjbean.size(); i++) {
                    if (yjbean.get(p).getPhoto_url().contains("bacsecs")) {
                        thstr = yjbean.get(p).getPhoto_url().replace("bacsecs", "batletl");
                    } else {
                        if (yjbean.get(p).getPhoto_url().contains("pocshj0jc")) {
                            thstr = yjbean.get(p).getPhoto_url().replace("pocshj0jc", "potlhj0jc");
                        } else {
                            thstr = yjbean.get(p).getPhoto_url();
                        }

                    }
                }

                int hight = ScreenUtils.DptoPx(context, 188f);
                int kuandu = (yjbean.get(p).getWidth() * hight / yjbean.get(p).getHeight());
                hh.tv.setWidth(kuandu);
                GlideApp.with(ycontext).load(thstr).format(DecodeFormat.PREFER_RGB_565).override(kuandu, hight).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(hh.im);


                if (TextUtils.isEmpty(yjbean.get(p).getDescription())) {
                    hh.tv.setText("没有描述");
                } else {
                    hh.tv.setText("\u3000" + yjbean.get(p).getDescription());
                }
                final String curl = thstr;
                hh.frakuan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent hao = new Intent(context, PhotoViewActivity.class);
                        Bundle b = new Bundle();
                        b.putString("picurl", curl);
                        if ((yjbean.get(p).getDescription() + "").equals("null") || (yjbean.get(p).getDescription() + "").equals("")) {
                            b.putString("wenzi", "无图片描述");
                        } else if (!(yjbean.get(p).getDescription() + "").equals("null")) {
                            b.putString("wenzi", yjbean.get(p).getDescription() + "");
                        }
                        hao.putExtras(b);
                        context.startActivity(hao);
                    }
                });

            }


        }

        @Override
        public int getItemCount() {
            return yjbean.size();
        }


        public class YJXPHolder extends RecyclerView.ViewHolder {
            ImageView im;
            TextView tv, nopic;
            RelativeLayout relay;
            FrameLayout fralay, frakuan;

            public YJXPHolder(View v) {
                super(v);
                im = v.findViewById(R.id.youjixiangpian_im);
                tv = v.findViewById(R.id.youjixiangpian_tv);
                nopic = v.findViewById(R.id.youjinopic_tv);
                relay = v.findViewById(R.id.relay_notupian);
                fralay = v.findViewById(R.id.fralay_youjitupian);
                frakuan = v.findViewById(R.id.fra_555666);


            }
        }
    }


}
