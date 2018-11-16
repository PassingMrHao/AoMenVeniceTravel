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
import mrhao.com.aomentravel.myAdapter.Recy_PhoneNumAd;
import mrhao.com.aomentravel.myAdapter.Recy_weatherAd;

public class PhoneNumberActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.recy_phone)
    RecyclerView recyPhone;
    HuiLv_Weather_PhoneBean bean;
    Recy_PhoneNumAd ad;
    List<HuiLv_Weather_PhoneBean.DataBean.UsefulNumbersBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        titleText.setText("备忘电话");
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
                            list.add(bean.getData().getUsefulNumbers().get(i));
                        }

                        recyPhone.setLayoutManager(new LinearLayoutManager(PhoneNumberActivity.this));
                        ad=new Recy_PhoneNumAd(PhoneNumberActivity.this,list);
                        recyPhone.setAdapter(ad);
                        ad.notifyDataSetChanged();
                    }
                });



    }
}
