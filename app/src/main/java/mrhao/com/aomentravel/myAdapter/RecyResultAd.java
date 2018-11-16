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

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.SearchDateBean;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel2rimacaoActivity;
import mrhao.com.aomentravel.myActivity.MacaoTravelDetailsActivity;

public class RecyResultAd extends RecyclerView.Adapter<RecyResultAd.MyHolder> {

    Context context;
    SearchDateBean searchbean;

    public RecyResultAd(Context context, SearchDateBean searchbean) {
        this.context = context;
        this.searchbean = searchbean;

    }

    @Override
    public RecyResultAd.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvvv = LayoutInflater.from(context).inflate(R.layout.recy_searchresult, parent, false);
        return new MyHolder(vvvv);
    }

    @Override
    public void onBindViewHolder(RecyResultAd.MyHolder h, final int i) {
        h.tv.setText(searchbean.getList().get(i));
        h.desc.setText("\u3000\u3000" + searchbean.getDesclist().get(i));
        Glide.with(context).load(searchbean.getImglist().get(i)).into(h.im);
        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hao = new Intent(context, MacaoTravelDetailsActivity.class);
                Bundle b = new Bundle();
                b.putString("jingdianurl","http://jk.kingtrunk.com/index.php/Home/Index/getInfo?id=" + searchbean.getTravelId().get(i));
                hao.putExtras(b);
                context.startActivity(hao);
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchbean.getImglist().size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv, desc;
        ImageView im;
        LinearLayout lay;

        public MyHolder(View v) {
            super(v);
            tv = v.findViewById(R.id.tb_searchresult);
            desc = v.findViewById(R.id.tb_desc);
            im = v.findViewById(R.id.tb_im);
            lay = v.findViewById(R.id.linlay_searchresult);
        }
    }
}
