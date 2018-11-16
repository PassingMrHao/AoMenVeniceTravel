package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MacaoTravelBean2;
import mrhao.com.aomentravel.findActivity.YinXiangPhotoActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class RecyJingDianAdapter extends RecyclerView.Adapter<RecyJingDianAdapter.MyHolder> {

    Context context;
    List<MacaoTravelBean2.AttractionTripTagsBean> list;

    public RecyJingDianAdapter(Context context, List<MacaoTravelBean2.AttractionTripTagsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyJingDianAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vv = LayoutInflater.from(context).inflate(R.layout.mygridview_jingdian, parent, false);
        return new MyHolder(vv);
    }

    @Override
    public void onBindViewHolder(RecyJingDianAdapter.MyHolder h, int i) {
        List<MacaoTravelBean2.AttractionTripTagsBean.AttractionContentsBean> list2 = new ArrayList<>();
        h.name.setText(list.get(i).getName());
        for (int j = 0; j < list.get(i).getAttraction_contents().size(); j++) {
            list2.add(list.get(i).getAttraction_contents().get(j));
        }

        h.recy.setLayoutManager(new LinearLayoutManager(context));
        recy_mmad recy_ad=new recy_mmad(context, list2);
        h.recy.setAdapter(recy_ad);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView name;
        RecyclerView recy;

        public MyHolder(View v) {
            super(v);
            name = v.findViewById(R.id.yinxiang_name);
            recy = v.findViewById(R.id.yinxiang_recycle);
        }
    }

    public class recy_mmad extends RecyclerView.Adapter<recy_mmad.MyHolder> {
        Context mcontext;
        List<MacaoTravelBean2.AttractionTripTagsBean.AttractionContentsBean> list2;

        public recy_mmad(Context mcontext, List<MacaoTravelBean2.AttractionTripTagsBean.AttractionContentsBean> list2) {
            this.mcontext = mcontext;
            this.list2 = list2;
        }

        @NonNull
        @Override
        public recy_mmad.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View  vv = LayoutInflater.from(mcontext).inflate(R.layout.yinxiang_gv, parent, false);
            return new MyHolder(vv);
        }

        @Override
        public void onBindViewHolder(@NonNull recy_mmad.MyHolder h, int i) {
            List<MacaoTravelBean2.AttractionTripTagsBean.AttractionContentsBean.NotesBean> list3 = new ArrayList<>();
            h.desc.setText(list2.get(i).getDescription());
            LinearLayoutManager kk = new LinearLayoutManager(mcontext);
            kk.setOrientation(LinearLayoutManager.HORIZONTAL);
            h.recy.setLayoutManager(kk);
            for (int j = 0; j < list2.get(i).getNotes().size(); j++) {
                list3.add(list2.get(i).getNotes().get(j));
            }

            hxzhappianad add = new hxzhappianad(mcontext, list3);
            h.recy.setAdapter(add);



        }

        @Override
        public int getItemCount() {
            return list2.size();
        }

        public class MyHolder extends RecyclerView.ViewHolder {
            RecyclerView recy;
            TextView desc;
            public MyHolder(View v) {
                super(v);
                desc= v.findViewById(R.id.yinxiang_desc);
                recy= v.findViewById(R.id.yinxiang_zhaopian);

            }
        }
    }


    public class hxzhappianad extends RecyclerView.Adapter<hxzhappianad.MyHolder> {
        Context hcontext;
        List<MacaoTravelBean2.AttractionTripTagsBean.AttractionContentsBean.NotesBean> list3;

        public hxzhappianad(Context hcontext, List<MacaoTravelBean2.AttractionTripTagsBean.AttractionContentsBean.NotesBean> list3) {
            this.hcontext = hcontext;
            this.list3 = list3;

        }

        @NonNull
        @Override
        public hxzhappianad.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View hao = LayoutInflater.from(hcontext).inflate(R.layout.yinxiang_recy_pic, parent, false);
            return new MyHolder(hao);
        }

        @Override
        public void onBindViewHolder(@NonNull hxzhappianad.MyHolder h, final int i) {
            if(list3.size()==0){
                h.im.setVisibility(View.GONE);

            }else if((list3.size()>0)) {
                h.im.setVisibility(View.VISIBLE);


                GlideApp.with(hcontext).load(list3.get(i).getPhoto_url()).override(list3.get(i).getWidth()/2,480).format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(h.im);
            }
            Glide.get(context).clearMemory();
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    Glide.get(context).clearDiskCache();
                }
            }.start();
            h.im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent gaoguiquan=new Intent(hcontext, YinXiangPhotoActivity.class);
                    Bundle b=new Bundle();
                    b.putString("yinxiangpic",list3.get(i).getPhoto_url());
                    gaoguiquan.putExtras(b);
                    hcontext.startActivity(gaoguiquan);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list3.size();
        }

        public class MyHolder extends RecyclerView.ViewHolder {
            ImageView im;

            public MyHolder(View v) {
                super(v);

                im = v.findViewById(R.id.im_yinxiang);

            }
        }
    }

}
