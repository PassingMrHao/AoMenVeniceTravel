package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TravelJingDianBean;
import mrhao.com.aomentravel.myActivity.BannerWebActivity;
import mrhao.com.aomentravel.myActivity.TravelDetailsActivity;

public class Grid_travelAd extends BaseAdapter {
    ImageView im;
    TextView tvname, tvtype;
    FrameLayout lay;
    Context context;
    List<TravelJingDianBean.DataBean.ScenicSpotsBean> list;

    public Grid_travelAd(Context context, List<TravelJingDianBean.DataBean.ScenicSpotsBean> list) {
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
    public View getView(final int i, View v, ViewGroup parent) {

        v = LayoutInflater.from(context).inflate(R.layout.recy_travel, parent, false);
        im = v.findViewById(R.id.img_jingdian);
        tvname = v.findViewById(R.id.tv_jdname);
        tvtype = v.findViewById(R.id.tv_jdtype);
        lay = v.findViewById(R.id.fralay);
        Glide.with(context).load(list.get(i).getCoverImage()).into(im);
        tvname.setText(list.get(i).getTitle());
        tvtype.setText(list.get(i).getCategories().get(0).getCategoryName());
        lay.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
//                Intent hao=new Intent(context, TravelDetailsActivity.class);
//                Bundle b= new Bundle();
//                b.putString("travel_title",list.get(i).getTitle());
//                b.putInt("travel_objectId",list.get(i).getObjectId());
//                hao.putExtras(b);
//                context.startActivity(hao,b);

                Intent hao = new Intent(context, TravelDetailsActivity.class);
                Bundle b=new Bundle();
                b.putString("bt",list.get(i).getTitle());
                b.putInt("travel_objectId",list.get(i).getObjectId());
                b.putString("type","旅游景点");
                b.putString("title",list.get(i).getTitle());
                b.putString("image",list.get(i).getCoverImage());
                b.putString("tag",list.get(i).getCategories().get(0).getCategoryName());
//                b.putString("weburl","https://api.koudaihk.com:4432/api/info/shareDetailsMC.html?objectId=" + list.get(i).getObjectId() + "&channelId=1206");
                //  https://api.koudaihk.com:4432/api/info/shareDetailsMC.html?objectId=95&amp;channelId=1206
               //   https://api.koudaihk.com:4432/api/info/shareDetailsMC.html?objectId=95&channelId=1206
                //  https://api.koudaihk.com:4432/api/info/shareDetailsMC.html?objectId=94&amp;channelId=1206
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });


        return v;
    }
}


