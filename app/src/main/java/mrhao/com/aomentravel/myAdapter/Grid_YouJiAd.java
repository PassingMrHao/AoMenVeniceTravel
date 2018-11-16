package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TravelYouJiBean;
import mrhao.com.aomentravel.utils.CircleTransform;
import mrhao.com.aomentravel.utils.GlideApp;

public class Grid_YouJiAd extends BaseAdapter {

    Context context;
    List<TravelYouJiBean.AttractionTripsBean> list;
    ArrayList<TravelYouJiBean.AttractionTripsBean.NotesBean> yjbean = new ArrayList<>();

    public Grid_YouJiAd(Context context, List<TravelYouJiBean.AttractionTripsBean> list) {
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
    public View getView(int i, View v, ViewGroup parent) {
        v = LayoutInflater.from(context).inflate(R.layout.recy_jingdianyouji, parent, false);
        ImageView im = v.findViewById(R.id.youji_pic);
        TextView name = v.findViewById(R.id.youji_name);
        TextView des = v.findViewById(R.id.tv_youji);
        RecyclerView recy = v.findViewById(R.id.recy_youjixiangpian);


        if (list.get(i).getTrip().getUser().getImage().contains("http://a.chanyouji.cn/")) {
            GlideApp.with(context).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538022593894&di=9b4f971ec9f892e2ec243cd7a289b72a&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fa8773912b31bb051d4c455113d7adab44aede023.jpg").transform(new CircleTransform(context)).into(im);
        } else {
            GlideApp.with(context).load(list.get(i).getTrip().getUser().getImage()).transform(new CircleTransform(context)).into(im);
        }

        name.setText(list.get(i).getTrip().getUser().getName());
        if (TextUtils.isEmpty(list.get(i).getComment())) {
            des.setText("");
            des.setVisibility(View.GONE);
        } else {
            des.setVisibility(View.VISIBLE);
            des.setText("\u3000\u3000" + list.get(i).getComment());
        }

        yjbean = (ArrayList<TravelYouJiBean.AttractionTripsBean.NotesBean>) list.get(i).getNotes();
        YouJiXiangPian adad = new YouJiXiangPian(context, yjbean);
        LinearLayoutManager hxlay = new LinearLayoutManager(context);
        hxlay.setOrientation(LinearLayoutManager.HORIZONTAL);
        recy.setLayoutManager(hxlay);
        recy.setAdapter(adad);

        return v;
    }

    public class YouJiXiangPian extends RecyclerView.Adapter<YouJiXiangPian.YJXPHolder> {
        Context ycontext;
        ArrayList<TravelYouJiBean.AttractionTripsBean.NotesBean> yjbean;
        public YouJiXiangPian(Context ycontext, ArrayList<TravelYouJiBean.AttractionTripsBean.NotesBean> yjbean) {
            this.ycontext = ycontext;
            this.yjbean = yjbean;
        }

        @Override
        public YouJiXiangPian.YJXPHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View hyl = LayoutInflater.from(ycontext).inflate(R.layout.youji_xiangpian, parent, false);
            return new YJXPHolder(hyl);
        }

        @Override
        public void onBindViewHolder(YouJiXiangPian.YJXPHolder hh, int p) {

            if (TextUtils.isEmpty(yjbean.get(p).getPhoto_url())) {
                hh.fralay.setVisibility(View.GONE);
                hh.relay.setVisibility(View.VISIBLE);
                hh.nopic.setText("\u3000\u3000" + yjbean.get(p).getDescription());
            } else {
                hh.fralay.setVisibility(View.VISIBLE);
                hh.relay.setVisibility(View.GONE);
                Glide.with(ycontext).load(yjbean.get(p).getPhoto_url()).into(hh.im);
                if(TextUtils.isEmpty(yjbean.get(p).getDescription())){
                    hh.tv.setText("");
                }else {
                    hh.tv.setText("\u3000\u3000" + yjbean.get(p).getDescription());
                }

            }

        }

        @Override
        public int getItemCount() {
            return yjbean.size();
        }


        public class YJXPHolder extends RecyclerView.ViewHolder {
            ImageView im;
            TextView tv, nopic;
            RelativeLayout relay;
            FrameLayout fralay;

            public YJXPHolder(View v) {
                super(v);
                im = v.findViewById(R.id.youjixiangpian_im);
                tv = v.findViewById(R.id.youjixiangpian_tv);
                nopic = v.findViewById(R.id.youjinopic_tv);
                relay = v.findViewById(R.id.relay_notupian);
                fralay = v.findViewById(R.id.fralay_youjitupian);
            }
        }
    }


}
