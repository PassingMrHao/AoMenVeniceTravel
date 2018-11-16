package mrhao.com.aomentravel.myActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
import mrhao.com.aomentravel.bean.HuiLv_Weather_PhoneBean;
import mrhao.com.aomentravel.myAdapter.Recy_weatherAd;

public class TianQiActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.recy_weather)
    RecyclerView recyWeather;
    HuiLv_Weather_PhoneBean bean;
    List<HuiLv_Weather_PhoneBean.DataBean.WeathersBean> list = new ArrayList<>();
    Recy_weatherAd ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_qi);
        ButterKnife.bind(this);
        recyWeather.setNestedScrollingEnabled(false);
        setBaseData();
    }

    private void setBaseData() {
        titleText.setText("天气变化");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.post().url("https://api.koudaihk.com:4432/api/info/public/v1/toolbox?toolType=8").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        bean = gs.fromJson(response, HuiLv_Weather_PhoneBean.class);
                        for (int i = 0; i < bean.getData().getWeathers().size(); i++) {
                            list.add(bean.getData().getWeathers().get(i));
                        }

                        recyWeather.setLayoutManager(new LinearLayoutManager(TianQiActivity.this));
                        ad=new Recy_weatherAd(TianQiActivity.this,list);
                        recyWeather.setAdapter(ad);
                        ad.notifyDataSetChanged();

                    }
                });


    }
}
