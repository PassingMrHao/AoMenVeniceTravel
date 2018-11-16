package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MaCaoYouJiBean;
import mrhao.com.aomentravel.myActivity.MaCaoYjDetilesAct;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;

public class Recycle_YouJiAd extends RecyclerView.Adapter<Recycle_YouJiAd.MyHolder> {

    Context context;
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list;
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list2 = new ArrayList<>();
    DisplayMetrics dm;

    public Recycle_YouJiAd(Context context, List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list) {
        this.context = context;
        this.list = list;
        this.dm = context.getResources().getDisplayMetrics();
    }

    @Override
    public Recycle_YouJiAd.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvv = LayoutInflater.from(context).inflate(R.layout.mygridview_macaoyouji, parent, false);
        return new MyHolder(vvv);
    }

    @Override
    public void onBindViewHolder(Recycle_YouJiAd.MyHolder h, final int i) {
        //图片压缩处理
        GlideApp.with(context).load(list.get(i).getContents().get(0).getPhoto_url()).placeholder(R.mipmap.pic_jzz).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.NONE).override(500, 360).into(h.im);
        GlideApp.with(context).load(list.get(i).getUser().getPhoto_url()).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.NONE).override(88, 88).transform(new CircleTransform(context)).into(h.userpic);
        Glide.get(context).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(context).clearDiskCache();
            }
        }.start();
        h.username.setText(list.get(i).getUser().getName());
        h.title.setText(list.get(i).getTopic());
        String str = "";
        if (list.get(i).getCategories().size() == 0) {
            h.tag.setText(" 无 ");
        } else {
            for (int j = 0; j < list.get(i).getCategories().size(); j++) {
                str += "  " + list.get(i).getCategories().get(j).getName();
            }
            h.tag.setText(str);
        }


        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list2.clear();
                list2.add(list.get(i));
                Intent intent = new Intent(context, MaCaoYjDetilesAct.class);
                intent.putExtra("macaoyj", (Serializable) list2);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView im, userpic;
        TextView username, title, tag;
        FrameLayout lay;

        public MyHolder(View v) {
            super(v);
            im = v.findViewById(R.id.mcyj_jdpic);
            userpic = v.findViewById(R.id.mcyj_userpic);
            username = v.findViewById(R.id.mcyj_username);
            title = v.findViewById(R.id.mcyj_title);
            tag = v.findViewById(R.id.mcyj_tag);
            lay = v.findViewById(R.id.mcyj_fralay);
        }
    }
}
