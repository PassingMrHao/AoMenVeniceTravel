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
import android.widget.Toast;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.FindFoodBean;
import mrhao.com.aomentravel.findActivity.FoodsDetailsActivity;
import mrhao.com.aomentravel.findActivity.MarketDetailsActivity;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;

public class FindFoodAd extends BaseAdapter {
    Context context;
    List<FindFoodBean.DataBean.RestaurantsBean> list;

    public FindFoodAd(Context context, List<FindFoodBean.DataBean.RestaurantsBean> list) {
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

        v = LayoutInflater.from(context).inflate(R.layout.find_foods, viewGroup, false);
        ImageView im = v.findViewById(R.id.img_foods);
        TextView tiktle = v.findViewById(R.id.tv_food_title);
        TextView tag = v.findViewById(R.id.tv_foods_tag);
        LinearLayout lay = v.findViewById(R.id.linlay_foods);
        tiktle.setText(list.get(i).getTitle());
        String str = "";
        for (int j = 0; j < list.get(i).getCategories().size(); j++) {
            str += list.get(i).getCategories().get(j).getCategoryName() + "\u3000";
        }
        tag.setText(str);

        GlideApp.with(context).load(list.get(i).getCoverImage()).format(DecodeFormat.PREFER_RGB_565).override(400,240).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).transform(new CircleTransform(context)).into(im);
        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, FoodsDetailsActivity.class);
                Bundle b=new Bundle();
                b.putString("bt",list.get(i).getTitle());
                b.putInt("food_objectId",list.get(i).getObjectId());
                b.putString("type","美食餐饮");
                b.putString("title",list.get(i).getTitle());
                b.putString("image",list.get(i).getCoverImage());
                String str="";
                for (int i = 0; i < list.get(i).getCategories().size(); i++) {
                    str+=list.get(i).getCategories().get(i).getCategoryName()+"\u3000";
                }
                b.putString("tag",str);
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });

        return v;
    }



}
