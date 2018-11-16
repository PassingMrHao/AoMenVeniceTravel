package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MarketBean;
import mrhao.com.aomentravel.findActivity.MarketDetailsActivity;
import mrhao.com.aomentravel.myActivity.TravelDetailsActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class Grid_MarKetAd extends BaseAdapter {
    Context context;

    List<MarketBean.DataBean.MallsBean> list;

    public Grid_MarKetAd(Context context, List<MarketBean.DataBean.MallsBean> list) {
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
        v = LayoutInflater.from(context).inflate(R.layout.marketlist, viewGroup, false);
        ImageView im = v.findViewById(R.id.img_market);
        TextView title = v.findViewById(R.id.tv_market_title);
        TextView tag = v.findViewById(R.id.tv_market_tag);
        RelativeLayout lay = v.findViewById(R.id.relay_market);
        GlideApp.with(context).load(list.get(i).getCoverImage()).override(300,300).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.NONE).into(im);
        title.setText(list.get(i).getTitle());
        tag.setText(list.get(i).getCategories().get(0).getCategoryName());

        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, MarketDetailsActivity.class);
                Bundle b=new Bundle();
                b.putString("bt",list.get(i).getTitle());
                b.putInt("market_objectId",list.get(i).getObjectId());
                b.putString("type","购物商场");
                b.putString("title",list.get(i).getTitle());
                b.putString("image",list.get(i).getCoverImage());
                b.putString("tag",list.get(i).getCategories().get(0).getCategoryName());
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });

        return v;
    }
}
