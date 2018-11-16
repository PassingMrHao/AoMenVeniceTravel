package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TravelJingDianBean;

public class Recy_travelAd extends RecyclerView.Adapter<Recy_travelAd.MyHplder> {
    Context context;
    List<TravelJingDianBean.DataBean.ScenicSpotsBean> list;

    public Recy_travelAd(Context context, List<TravelJingDianBean.DataBean.ScenicSpotsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Recy_travelAd.MyHplder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recy_travel, parent, false);
        return new MyHplder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recy_travelAd.MyHplder h, int i) {

        Glide.with(context).load(list.get(i).getCoverImage()).into(h.im);
        h.tvname.setText(list.get(i).getTitle());
        h.tvtype.setText(list.get(i).getCategories().get(0).getCategoryName());
        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHplder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tvname, tvtype;
        FrameLayout lay;

        public MyHplder(View v) {
            super(v);

            im = v.findViewById(R.id.img_jingdian);
            tvname = v.findViewById(R.id.tv_jdname);
            tvtype = v.findViewById(R.id.tv_jdtype);
            lay = v.findViewById(R.id.fralay);

        }
    }
}
