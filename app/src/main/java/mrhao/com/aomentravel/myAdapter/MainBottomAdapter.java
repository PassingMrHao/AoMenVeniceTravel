package mrhao.com.aomentravel.myAdapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MainBottomData;

public class MainBottomAdapter extends RecyclerView.Adapter<MainBottomAdapter.MainClassifyViewHolder> {
    private Context context;
    private List<MainBottomData> dataList;
    private AdapterView.OnItemClickListener clickListener;

    public void setClickListener(AdapterView.OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public MainBottomAdapter(Context context, List<MainBottomData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MainBottomAdapter.MainClassifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainClassifyViewHolder(LayoutInflater.from(context).inflate(R.layout.main_classify_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MainBottomAdapter.MainClassifyViewHolder holder, final int position) {
        //选中底部菜单时的字体颜色
        if(dataList.get(position).isSelected()){
            holder.img.setImageResource(dataList.get(position).getSelectImg());
            holder.name.setTextColor(Color.parseColor("#1C99ED"));
        }
        //未选中底部菜单时的字体颜色
        else{
            holder.img.setImageResource(dataList.get(position).getImg());
            holder.name.setTextColor(Color.parseColor("#8a8a8a"));
        }
        holder.name.setText(dataList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < dataList.size(); i++) {
                    dataList.get(i).setSelected(false);
                }
                dataList.get(position).setSelected(true);
                notifyDataSetChanged();
                clickListener.onItemClick(null,holder.itemView,position,holder.getItemId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MainClassifyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        public MainClassifyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.main_classify_item_img);
            name = itemView.findViewById(R.id.main_classify_item_name);
        }
    }
}
