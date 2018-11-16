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
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MyMaCaoYouJiBean;
import mrhao.com.aomentravel.findActivity.PhotoTextActivity;
import mrhao.com.aomentravel.findActivity.PhotoViewActivity;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;

public class GvYouJiAdapter extends BaseAdapter {
    Context context;
    List<MyMaCaoYouJiBean> list;
    ArrayList<MyMaCaoYouJiBean.NotesBean> yjbean = new ArrayList<>();
    DisplayMetrics dm;
    public GvYouJiAdapter(Context context, List<MyMaCaoYouJiBean> list) {
        this.context = context;
        this.list = list;
        this.dm = context.getResources().getDisplayMetrics();
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
    public View getView(int i, View v, ViewGroup viewGroup) {
        v = LayoutInflater.from(context).inflate(R.layout.gv_youji, viewGroup, false);
        ImageView im = v.findViewById(R.id.gvyouji_pic);
        TextView name = v.findViewById(R.id.gvyouji_name);
        TextView des = v.findViewById(R.id.tv_gvyouji);
        RecyclerView recy = v.findViewById(R.id.gv_youjixiangpian);
        if (list.get(i).getTrip().getUser().getImage().contains("http://a.chanyouji.cn/")) {
            GlideApp.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538022593894&di=9b4f971ec9f892e2ec243cd7a289b72a&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa8773912b31bb051d4c455113d7adab44aede023.jpg").transform(new CircleTransform(context)).into(im);
        } else {
            GlideApp.with(context).load(list.get(i).getTrip().getUser().getImage()).transform(new CircleTransform(context)).into(im);
        }
        name.setText(list.get(i).getTrip().getUser().getName());
        if (TextUtils.isEmpty(list.get(i).getComment())) {
            des.setText("");
            des.setVisibility(View.GONE);
        } else {
            des.setVisibility(View.VISIBLE);
            des.setText("\u3000\u3000" + list.get(i).getComment());
        }

        yjbean = (ArrayList<MyMaCaoYouJiBean.NotesBean>) list.get(i).getNotes();
        YouJiXiangPian adad = new YouJiXiangPian(context, yjbean);
        LinearLayoutManager hxlay = new LinearLayoutManager(context);
        hxlay.setOrientation(LinearLayoutManager.HORIZONTAL);
        recy.setLayoutManager(hxlay);
        recy.setAdapter(adad);

        return v;
    }


    private class YouJiXiangPian extends RecyclerView.Adapter<YouJiXiangPian.YJXPHolder> {

        Context ycontext;
        ArrayList<MyMaCaoYouJiBean.NotesBean> yjbean = new ArrayList<>();

        public YouJiXiangPian(Context ycontext,ArrayList<MyMaCaoYouJiBean.NotesBean> yjbean) {
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
                Glide.with(ycontext).load(yjbean.get(p).getPhoto_url()).into(hh.im);
                int kuandu = yjbean.get(p).getWidth() * 180 / yjbean.get(p).getHeight();
                hh.tv.setWidth(kuandu * 3);
                if (TextUtils.isEmpty(yjbean.get(p).getDescription())) {
                    hh.tv.setText("没有描述");
                } else {
                    hh.tv.setText("\u3000" + yjbean.get(p).getDescription());
                }

                hh.frakuan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent hao = new Intent(context, PhotoViewActivity.class);
                        Bundle b = new Bundle();

                        b.putString("picurl", yjbean.get(p).getPhoto_url());
                        if ((yjbean.get(p).getDescription()+ "").equals("null") || (yjbean.get(p).getDescription() + "").equals("")) {
                            b.putString("wenzi", "无图片描述");
                        } else if (!(yjbean.get(p).getDescription() + "").equals("null")) {
                            b.putString("wenzi",yjbean.get(p).getDescription() + "");
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
