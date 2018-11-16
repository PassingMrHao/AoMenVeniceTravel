package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MaCaoYouJiBean;
import mrhao.com.aomentravel.myActivity.MaCaoYjDetilesAct;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.ScreenUtils;

public class MyGridview_YjAd extends BaseAdapter {

    Context context;
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list;
    List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list2=new ArrayList<>();
    DisplayMetrics dm ;
    public MyGridview_YjAd(Context context, List<MaCaoYouJiBean.DataBean.UserActivitiesBean> list) {
        this.context = context;
        this.list = list;
        this.dm =  context.getResources().getDisplayMetrics();

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

        v = LayoutInflater.from(context).inflate(R.layout.mygridview_macaoyouji, viewGroup, false);
        ImageView im = v.findViewById(R.id.mcyj_jdpic);
        ImageView userpic = v.findViewById(R.id.mcyj_userpic);
        TextView username = v.findViewById(R.id.mcyj_username);
        TextView title = v.findViewById(R.id.mcyj_title);
        TextView tag = v.findViewById(R.id.mcyj_tag);
        FrameLayout lay = v.findViewById(R.id.mcyj_fralay);

        //图片压缩处理

        GlideApp.with(context).load(list.get(i).getContents().get(0).getPhoto_url()).placeholder(R.mipmap.pic_jzz).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.NONE).override(900,540).into(im);
        GlideApp.with(context).load(list.get(i).getUser().getPhoto_url()).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.NONE) .override(88,88).transform(new CircleTransform(context)).into(userpic);
        Glide.get(context).clearMemory();
        new Thread(){
            @Override
            public void run() {
                super.run();
                Glide.get(context).clearDiskCache();
            }
        }.start();
        username.setText(list.get(i).getUser().getName());
        title.setText(list.get(i).getTopic());
        String str = "";
        if (list.get(i).getCategories().size() == 0) {
            tag.setText(" 无 " );
        } else {
            for (int j = 0; j < list.get(i).getCategories().size(); j++) {
                str += "  "+list.get(i).getCategories().get(j).getName();
            }
            tag.setText(str);
        }



        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list2.clear();
                list2.add(list.get(i));
                Intent intent = new Intent(context, MaCaoYjDetilesAct.class);
                intent.putExtra("macaoyj", (Serializable)list2);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });



        return v;

    }


}
