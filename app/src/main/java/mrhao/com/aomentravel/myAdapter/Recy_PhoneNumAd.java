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

public class Recy_PhoneNumAd extends RecyclerView.Adapter<Recy_PhoneNumAd.MyHolder> {

    Context context;
    List<HuiLv_Weather_PhoneBean.DataBean.UsefulNumbersBean> list;

    public Recy_PhoneNumAd(Context context, List<HuiLv_Weather_PhoneBean.DataBean.UsefulNumbersBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Recy_PhoneNumAd.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.recy_phonenum,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recy_PhoneNumAd.MyHolder h, int i) {

        h.tv1.setText("\u3000"+list.get(i).getTitle());
        h.tv2.setText("\u3000"+list.get(i).getTelephone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2;
        public MyHolder(View v) {
            super(v);
            tv1=v.findViewById(R.id.tv_dizhi);
            tv2=v.findViewById(R.id.tv_phone_num);

        }
    }
}
