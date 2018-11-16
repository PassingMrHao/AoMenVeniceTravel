package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TrainsMsgBean;

public class Recy_TrainsAdapter extends RecyclerView.Adapter<Recy_TrainsAdapter.MyHolder> {
    Context context;
    List<TrainsMsgBean.ResultBean> list;

    public Recy_TrainsAdapter(Context context, List<TrainsMsgBean.ResultBean> list) {

        this.context = context;
        this.list = list;

    }

    @Override
    public Recy_TrainsAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View vvv = LayoutInflater.from(context).inflate(R.layout.recy_trains,parent,false);
        return new MyHolder(vvv);

    }

    @Override
    public void onBindViewHolder(Recy_TrainsAdapter.MyHolder h, int i) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(View v) {
            super(v);
        }
    }
}
