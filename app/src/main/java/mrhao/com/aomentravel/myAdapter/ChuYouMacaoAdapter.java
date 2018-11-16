package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.utils.GlideApp;

public class ChuYouMacaoAdapter extends RecyclerView.Adapter<ChuYouMacaoAdapter.MyHolder> {

    Context context;
    List<String> pic_title;
    List<String> pic_url;
    List<Class> actlist;

    public ChuYouMacaoAdapter(Context context, List<String> pic_title, List<String> pic_url, List<Class> actlist) {
        this.context = context;
        this.pic_title = pic_title;
        this.pic_url = pic_url;
        this.actlist = actlist;
    }

    @Override
    public ChuYouMacaoAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvv = LayoutInflater.from(context).inflate(R.layout.chuyoumacao, parent, false);
        return new MyHolder(vvv);
    }

    @Override
    public void onBindViewHolder(ChuYouMacaoAdapter.MyHolder h, final int i) {

        h.tv.setText(pic_title.get(i));
        GlideApp.with(context).load(pic_url.get(i)).format(DecodeFormat.PREFER_RGB_565).override(800,480).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(h.img);
//
//        Glide.get(context).clearMemory();
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                Glide.get(context).clearDiskCache();
//            }
//        }.start();
        h.fralay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, actlist.get(i)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pic_title.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        FrameLayout fralay;

        public MyHolder(View v) {
            super(v);
            img = v.findViewById(R.id.chuyou_img);
            tv = v.findViewById(R.id.chuyou_title);
            fralay = v.findViewById(R.id.chuyoufra);
        }
    }
}
