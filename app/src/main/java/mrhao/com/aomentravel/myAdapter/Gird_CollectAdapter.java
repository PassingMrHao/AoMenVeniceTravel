package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.CollectListBean;
import mrhao.com.aomentravel.myActivity.BannerWebActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;
import mrhao.com.aomentravel.myActivity.TravelDetailsActivity;
import mrhao.com.aomentravel.myActivity.ZheKouWebActivity;
import mrhao.com.aomentravel.utils.BaseDialogUtil;
import mrhao.com.aomentravel.utils.GlideApp;

public class Gird_CollectAdapter extends BaseAdapter {
    Context context;
    List<CollectListBean.DataBean> list;
    Cancle cancle;

    public Gird_CollectAdapter(Context context, List<CollectListBean.DataBean> list, Cancle cancle) {

        this.context = context;
        this.list = list;
        this.cancle = cancle;
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

        v = LayoutInflater.from(context).inflate(R.layout.grid_collect, viewGroup, false);
        ImageView im = v.findViewById(R.id.im_collect_img);
        RelativeLayout im_quxiao = v.findViewById(R.id.im_collect_quxiao);
        TextView title = v.findViewById(R.id.tv_collect_title);
        TextView tag = v.findViewById(R.id.tv_collect_tag);
        LinearLayout lay = v.findViewById(R.id.linlay_collect);
        title.setText("\u3000 "+list.get(i).getTitle());
        tag.setText(list.get(i).getTag());
        GlideApp.with(context).load(list.get(i).getImage()).override(300,180).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.NONE) .into(im);
        im_quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancle.quxiao(list.get(i).getTitle());
            }
        });

        lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(i).getType().equals("资讯攻略")){
                    Intent hao = new Intent(context, BannerWebActivity.class);
                    Bundle b=new Bundle();

                    b.putString("title",list.get(i).getTitle());
                    b.putString("img",list.get(i).getImage());
                    b.putString("tag",list.get(i).getTag());
                    b.putString("bannerweb", list.get(i).getWeburl());
                    hao.putExtras(b);
                    context.startActivity(hao);
                }else if(list.get(i).getType().equals("旅游景点")){
                    Intent hao = new Intent(context, MacaoTravelDetailsActivity.class);
                    Bundle b=new Bundle();
                    String str=list.get(i).getWeburl();
                    b.putString("jingdianurl",str);
                    hao.putExtras(b);
                    context.startActivity(hao);

                }
                else if(list.get(i).getType().equals("折扣")){
                    Intent hao = new Intent(context, ZheKouWebActivity.class);
                    Bundle b=new Bundle();
                    b.putString("bt","惊喜折扣详情");
                    b.putString("type","折扣");
                    b.putString("title",list.get(i).getTitle());
                    b.putString("image",list.get(i).getImage());
                    b.putString("tag",list.get(i).getTag());
                    b.putString("weburl",list.get(i).getWeburl());
                    hao.putExtras(b);
                    context.startActivity(hao);
                }
                else if(list.get(i).getType().equals("购物商场")){

                    Intent hao = new Intent(context, ZheKouWebActivity.class);
                    Bundle b=new Bundle();
                    b.putString("bt",list.get(i).getTitle());
                    b.putString("type","购物商场");
                    b.putString("title",list.get(i).getTitle());
                    b.putString("image",list.get(i).getImage());
                    b.putString("tag",list.get(i).getTag());
                    String str=list.get(i).getWeburl();
                    b.putString("weburl",str);
                    hao.putExtras(b);
                    context.startActivity(hao);

                }
                else if(list.get(i).getType().equals("娱乐场所")){
                    Intent hao = new Intent(context, ZheKouWebActivity.class);
                    Bundle b=new Bundle();
                    b.putString("bt",list.get(i).getTitle());
                    b.putString("type","娱乐场所");
                    b.putString("title",list.get(i).getTitle());
                    b.putString("image",list.get(i).getImage());
                    b.putString("tag",list.get(i).getTag());
                    b.putString("weburl",list.get(i).getWeburl());
                    hao.putExtras(b);
                    context.startActivity(hao);

                }
                else if(list.get(i).getType().equals("美食餐饮")){
                    Intent hao = new Intent(context, ZheKouWebActivity.class);
                    Bundle b=new Bundle();
                    b.putString("bt",list.get(i).getTitle());
                    b.putString("type","美食餐饮");
                    b.putString("title",list.get(i).getTitle());
                    b.putString("image",list.get(i).getImage());
                    b.putString("tag",list.get(i).getTag());
                    b.putString("weburl",list.get(i).getWeburl());
                    hao.putExtras(b);
                    context.startActivity(hao);
                }

            }
        });

        return v;
    }


    public interface Cancle {
        void quxiao(String title);
    }
}
