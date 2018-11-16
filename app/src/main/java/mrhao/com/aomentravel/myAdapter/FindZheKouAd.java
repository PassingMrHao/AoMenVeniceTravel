package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.FindZheKouBean;
import mrhao.com.aomentravel.myActivity.ZheKouWebActivity;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;


public class FindZheKouAd extends RecyclerView.Adapter<FindZheKouAd.MyHolder> {

    Context context;
    List<FindZheKouBean.DataBean.DiscountsBean> list;

    public FindZheKouAd(Context context, List<FindZheKouBean.DataBean.DiscountsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FindZheKouAd.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recy_zhekou, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FindZheKouAd.MyHolder h, final int i) {

        h.tle.setText(list.get(i).getSubtitle());
        h.pinpai.setText(list.get(i).getTitle());
        h.tag.setText(list.get(i).getCategories().get(0).getCategoryName());
        GlideApp.with(context).load(list.get(i).getCoverImage()).transform(new CircleTransform(context)).into(h.im);

        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, ZheKouWebActivity.class);
                Bundle b=new Bundle();
                b.putString("bt","惊喜折扣详情");
                b.putString("type","折扣");
                b.putString("title",list.get(i).getSubtitle());
                b.putString("image",list.get(i).getCoverImage());
                b.putString("tag",list.get(i).getCategories().get(0).getCategoryName());
                b.putString("weburl",list.get(i).getDetailUrl());
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tle, pinpai, tag;
        ImageView im;
        LinearLayout lay;

        public MyHolder(View v) {
            super(v);
            tle = v.findViewById(R.id.tv_subtle);
            pinpai = v.findViewById(R.id.tv_pinpai);
            tag = v.findViewById(R.id.tv_tag);
            im = v.findViewById(R.id.img_zhekou);
            lay = v.findViewById(R.id.linlay_zhekoua);
        }
    }
}
