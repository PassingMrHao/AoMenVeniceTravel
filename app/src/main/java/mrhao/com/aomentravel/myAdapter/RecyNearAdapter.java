package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import java.math.BigDecimal;
import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MacaoTravelBean;
import mrhao.com.aomentravel.bean.MacaoTravelBean2;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel2rimacaoActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class RecyNearAdapter extends RecyclerView.Adapter<RecyNearAdapter.MyHolder> {

    Context context;
    List<MacaoTravelBean2.AttractionsBean> list_near;

    public RecyNearAdapter(Context context, List<MacaoTravelBean2.AttractionsBean> list_near) {

        this.context = context;
        this.list_near = list_near;
    }

    @NonNull
    @Override
    public RecyNearAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recy_near, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyNearAdapter.MyHolder h, final int i) {
        GlideApp.with(context).load(list_near.get(i).getImage_url()).override(400,180).format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(h.im);
        Glide.get(context).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(context).clearDiskCache();
            }
        }.start();
        h.name.setText(list_near.get(i).getName_zh_cn());
        BigDecimal b = new BigDecimal(list_near.get(i).getDistance());
        double ff = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        h.distance.setText(ff + " Km");
        h.fralay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putInt("jingdianId", list_near.get(i).getId());
                b.putString("jingdianurl","http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=" + list_near.get(i).getId());
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_near.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView name;
        TextView distance;
        FrameLayout fralay;
        public MyHolder(View v) {
            super(v);
            im = v.findViewById(R.id.near_im);
            name = v.findViewById(R.id.near_name);
            distance = v.findViewById(R.id.near_distance);
            fralay = v.findViewById(R.id.fra_near);

        }
    }
}
