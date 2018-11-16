package mrhao.com.aomentravel.findActivity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.TrainsMsgBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.Recy_TrainsAdapter;


public class FindMoreTransAct extends BaseActivity {
    int type = 0;
    Bundle b;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.train_etchufa)
    EditText trainEtchufa;
    @BindView(R.id.train_etdaoda)
    EditText trainEtdaoda;
    @BindView(R.id.train_btnquery)
    Button trainBtnquery;
    TextView tvnum;
    @BindView(R.id.moretrain_nores)
    LinearLayout moretrainNores;
    @BindView(R.id.moretrain_res)
    LinearLayout moretrainRes;
    @BindView(R.id.recy_trains)
    RecyclerView recyTrains;
    TrainsMsgBean bean;

    Recy_TrainsAdapter ad;
    List<TrainsMsgBean.ResultBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_more_trans);
        tvnum = findViewById(R.id.moretrain__num);
        b = getIntent().getExtras();
        type = b.getInt("type");
        ButterKnife.bind(this);
        setBaseDate();

    }

    private void setBaseDate() {
        recyTrains.setLayoutManager(new LinearLayoutManager(FindMoreTransAct.this));
        ad = new Recy_TrainsAdapter(FindMoreTransAct.this, list);
        recyTrains.setAdapter(ad);
        //火车票查询
        trainBtnquery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String et1 = trainEtchufa.getText().toString().trim();
                String et2 = trainEtdaoda.getText().toString().trim();

                Map<String, String> map = new HashMap<>();
                map.put("key", "258ea60e36fdf");
                map.put("start", et1);
                map.put("end", et2);
                OkHttpUtils.get().url("http://apicloud.mob.com/train/tickets/queryByStationToStation").params(map).build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Request request, Exception e) {

                            }

                            @Override
                            public void onResponse(String response) {

                                Gson gs = new Gson();
                                bean = gs.fromJson(response, TrainsMsgBean.class);

                                if (bean.getMsg().equals("没有相关数据!")) {

                                    moretrainNores.setVisibility(View.VISIBLE);
                                    moretrainRes.setVisibility(View.GONE);

                                } else {

                                    tvnum.setText(bean.getResult().size() + "");
                                    moretrainNores.setVisibility(View.GONE);
                                    moretrainRes.setVisibility(View.VISIBLE);
                                    list.clear();
                                    for (int i = 0; i < bean.getResult().size(); i++) {
                                        list.add(bean.getResult().get(i));
                                    }
                                    ad.notifyDataSetChanged();

                                }
                            }
                        });
            }
        });

    }

}
