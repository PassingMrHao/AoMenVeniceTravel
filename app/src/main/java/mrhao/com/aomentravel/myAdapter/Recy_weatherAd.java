package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.HuiLv_Weather_PhoneBean;

public class Recy_weatherAd extends RecyclerView.Adapter<Recy_weatherAd.MyHolder> {
    Context context;
    List<HuiLv_Weather_PhoneBean.DataBean.WeathersBean> list;

    public Recy_weatherAd(Context context, List<HuiLv_Weather_PhoneBean.DataBean.WeathersBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Recy_weatherAd.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recy_weather, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recy_weatherAd.MyHolder h, int i) {
        h.tv1.setText(list.get(i).getWeek());
        h.tv2.setText(list.get(i).getTemperature());
        h.tv3.setText(list.get(i).getDesc());
        h.tv4.setText(list.get(i).getDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2, tv3, tv4;

        public MyHolder(View v) {
            super(v);
            tv1 = v.findViewById(R.id.tv_week);
            tv2 = v.findViewById(R.id.tv_temperature);
            tv3 = v.findViewById(R.id.tv_desc);
            tv4 = v.findViewById(R.id.tv_date);
        }
    }
}
