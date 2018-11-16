package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import mrhao.com.aomentravel.bean.MarketBean;
import mrhao.com.aomentravel.bean.PlayBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.Grid_MarKetAd;
import mrhao.com.aomentravel.myAdapter.Grid_PlayAd;
import mrhao.com.aomentravel.utils.MyGridView;

public class FindPlayActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    MyGridView girdPlay;
    Grid_PlayAd ad;
    List<PlayBean.DataBean.AmusementsBean> list = new ArrayList<>();
    PlayBean bean;

    String api1="https://api.koudaihk.com:4432/api/info/public/v1/amusements/?appId=2&categoryId=0&sortId=0&pageIndex=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_play);
        girdPlay = findViewById(R.id.gird_play);
        ButterKnife.bind(this);
        setBaseDate();
    }


    private void setBaseDate() {
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        titleText.setText("休闲娱乐");
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.post().url(api1).params(map).build().
                execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, PlayBean.class);
                        for (int i = 0; i < bean.getData().getAmusements().size(); i++) {
                            list.add(bean.getData().getAmusements().get(i));
                        }
                        ad = new Grid_PlayAd(FindPlayActivity.this, list);
                        girdPlay.setAdapter(ad);
                        relayLoad.setVisibility(View.GONE);
                    }
                });

    }

}
