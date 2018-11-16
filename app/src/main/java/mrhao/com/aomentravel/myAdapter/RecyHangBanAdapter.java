package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.HangBanMsgBean;

public class RecyHangBanAdapter extends RecyclerView.Adapter<RecyHangBanAdapter.MyHolder> {

    Context context;
    List<HangBanMsgBean.ResultBean> list;


    public RecyHangBanAdapter(Context context, List<HangBanMsgBean.ResultBean> list) {

        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vvv = LayoutInflater.from(context).inflate(R.layout.recy_hangbanmsg, parent, false);
        return new MyHolder(vvv);
    }

    @Override
    public void onBindViewHolder(MyHolder h, int i) {

        h.hbChufa.setText(list.get(i).getPlanTime());
        h.hbChufajichang.setText(list.get(i).getFrom());
        h.hbHaoshi.setText(list.get(i).getFlightTime());
        h.hbDaoda.setText(list.get(i).getPlanArriveTime());
        h.hbDaodajichang.setText(list.get(i).getTo());
        h.hbHkgs.setText(list.get(i).getAirLines());
        h.hbZhundian.setText(list.get(i).getFlightRate());
        h.hbWeek.setText(list.get(i).getWeek());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView hbChufa;
        TextView hbChufajichang;
        TextView hbHaoshi;
        TextView hbDaoda;
        TextView hbDaodajichang;
        TextView hbHkgs;
        TextView hbZhundian;
        TextView hbWeek;

        public MyHolder(View v) {
            super(v);

            hbChufa = v.findViewById(R.id.recyhb_chufa);
            hbChufajichang = v.findViewById(R.id.recyhb_chufajichang);
            hbHaoshi = v.findViewById(R.id.recyhb_haoshi);
            hbDaoda = v.findViewById(R.id.recyhb_daoda);
            hbDaodajichang = v.findViewById(R.id.recyhb_daodajichang);
            hbHkgs = v.findViewById(R.id.recyhb_hkgs);
            hbZhundian = v.findViewById(R.id.recyhb_zhundian);
            hbWeek = v.findViewById(R.id.recyhb_week);

        }
    }
}
