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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.AllJingDianDateBean;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel2rimacaoActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class Gv_AllJdAdapter extends BaseAdapter {
    Context context;
    List<AllJingDianDateBean> list;

    public Gv_AllJdAdapter(Context context, List<AllJingDianDateBean> list) {

        this.context = context;
        this.list = list;
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
    public View getView(final int i, View v, ViewGroup viewGroup) {

        v = LayoutInflater.from(context).inflate(R.layout.gv_alljingdian, viewGroup, false);
        ImageView im = v.findViewById(R.id.alljd_im);
        TextView nameCn = v.findViewById(R.id.alljd_titleCn);
        TextView nameEn = v.findViewById(R.id.alljd_titleEn);
        TextView desc = v.findViewById(R.id.alljd_desc);
        LinearLayout lay=v.findViewById(R.id.alljd_linlay);
        GlideApp.with(context).load(list.get(i).getImage_url()).format(DecodeFormat.PREFER_RGB_565).override(400,240).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im);
        nameCn.setText(list.get(i).getName());
        nameEn.setText(list.get(i).getName_en());
        desc.setText("\u3000\u3000"+list.get(i).getDescription());
        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl","http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=" + list.get(i).getId());
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });
        return v;
    }
}
