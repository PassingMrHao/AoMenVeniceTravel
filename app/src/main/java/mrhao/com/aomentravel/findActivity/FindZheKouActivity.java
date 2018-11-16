package mrhao.com.aomentravel.findActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import mrhao.com.aomentravel.bean.FindZheKouBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.FindZheKouAd;

public class FindZheKouActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.recy_findzhekou)
    RecyclerView recyFindzhekou;

    FindZheKouBean bean;
    FindZheKouAd ad;
    List<FindZheKouBean.DataBean.DiscountsBean> list = new ArrayList<>();
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_zhe_kou);
        ButterKnife.bind(this);

        getBaseDate();
    }

    private void getBaseDate() {

        titleText.setText("优惠折扣");

        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Map<String, String> map = new HashMap<>();
        map.put("", "");

        OkHttpUtils.post().url("https://api.koudaihk.com:4432/api/info/public/v1/discounts/?appId=2&categoryId=0&busiZoneId=0&pageIndex=1").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        bean = gs.fromJson(response, FindZheKouBean.class);
                        for (int i = 0; i < bean.getData().getDiscounts().size(); i++) {
                            list.add(bean.getData().getDiscounts().get(i));
                        }
                        recyFindzhekou.setLayoutManager(new LinearLayoutManager(FindZheKouActivity.this));
                        ad = new FindZheKouAd(FindZheKouActivity.this, list);
                        recyFindzhekou.setAdapter(ad);
                        ad.notifyDataSetChanged();
                        relayLoad.setVisibility(View.GONE);
                    }
                });


    }
}
