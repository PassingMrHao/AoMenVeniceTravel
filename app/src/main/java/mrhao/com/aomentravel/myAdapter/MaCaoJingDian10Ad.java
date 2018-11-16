package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel2rimacaoActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;
import mrhao.com.aomentravel.utils.GlideApp;

public class MaCaoJingDian10Ad extends RecyclerView.Adapter<MaCaoJingDian10Ad.MyHolder> {
    Context context;
    List<String> list_name;
    List<String> list_tupian;
    List<Integer> list_picnum;
    List<Integer> list_youjinum;
    List<Integer> list_travelId;

    public MaCaoJingDian10Ad(Context context, List<String> list_name, List<String> list_tupian, List<Integer> list_picnum, List<Integer> list_youjinum,List<Integer> list_travelId) {

        this.context = context;
        this.list_name = list_name;
        this.list_tupian = list_tupian;
        this.list_picnum = list_picnum;
        this.list_youjinum = list_youjinum;
        this.list_travelId = list_travelId;

    }

    @Override
    public MaCaoJingDian10Ad.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvv = LayoutInflater.from(context).inflate(R.layout.recy_macaojingdian10, parent, false);
        return new MyHolder(vvv);
    }

    @Override
    public void onBindViewHolder(MaCaoJingDian10Ad.MyHolder h, final int i) {
        h.name.setText(list_name.get(i));
        h.picnum.setText(list_picnum.get(i) + "");
        h.youjinum.setText(list_youjinum.get(i) + "");
        GlideApp.with(context).load(list_tupian.get(i)).format(DecodeFormat.PREFER_RGB_565).override(800,480).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(h.pic);
//        Glide.get(context).clearMemory();
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                Glide.get(context).clearDiskCache();
//            }
//        }.start();

        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl","http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=" + list_travelId.get(i));
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list_name.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView name, picnum, youjinum;
        LinearLayout lay;

        public MyHolder(View v) {
            super(v);
            pic = v.findViewById(R.id.tenjd_im);
            name = v.findViewById(R.id.tenjd_title);
            picnum = v.findViewById(R.id.tenjd_pic);
            youjinum = v.findViewById(R.id.tenjd_youji);
            lay = v.findViewById(R.id.tenjd_linlay);
        }
    }
}
