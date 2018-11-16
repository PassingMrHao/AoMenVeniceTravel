package mrhao.com.aomentravel.myActivity.CollectActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.MyMaCaoYouJiBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.GvYouJiAdapter;
import mrhao.com.aomentravel.utils.MyGridView;

public class YouJiDetailsActivity extends BaseActivity {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.jd_pullrefresh)
    PullToRefreshLayout youjiPullrefresh;
    int travelId = 0;
    int tripcounts = 0;
    int currpage = 1;

    List<MyMaCaoYouJiBean> list = new ArrayList<>();
    Gson gs = new Gson();
    Type listtype = new TypeToken<List<MyMaCaoYouJiBean>>() {
    }.getType();
    ArrayList<MyMaCaoYouJiBean> bean = new ArrayList<>();
    GvYouJiAdapter ad;
    @BindView(R.id.mygv_youji)
    MyGridView mygvYouji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_ji_details);
        ButterKnife.bind(this);
        Bundle b = getIntent().getExtras();
        travelId = b.getInt("travelId");
        tripcounts = b.getInt("tripcounts");
        titleText.setText(b.getString("name") + "游记 (" + tripcounts + ")");

        setBaseDate();
//        AddDateInList(2);
        ShuaXinAndLoadMore();
    }

    private void AddDateInList(final int aa) {
        String api = "http://jk.kingtrunk.com/index.php/Home/Index/getYJ/id/" + travelId + "/p/";
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url(api + aa).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {

                        bean = gs.fromJson(response, listtype);
                        for (int i = 0; i < bean.size(); i++) {
                            list.add(bean.get(0));
                        }
                        ad.notifyDataSetChanged();
                    }

                });
    }

    private void ShuaXinAndLoadMore() {

    }

    private void setBaseDate() {

        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//
//        Map<String, String> map = new HashMap<>();
//        map.put("", "");
//        OkHttpUtils.get().url("http://jk.kingtrunk.com/index.php/Home/Index/getYJ/id/" + travelId + "/p/1").params(map).build()
//                .execute(new StringCallback() {
//                    @Override
//                    public void onError(Request request, Exception e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response) {
//
//                        bean = gs.fromJson(response, listtype);
//                        for (int i = 0; i < bean.size(); i++) {
//                            list.add(bean.get(0));
//                        }
//                        ad = new GvYouJiAdapter(YouJiDetailsActivity.this, list);
//                        mygvYouji.setAdapter(ad);
//
//                    }
//                });

        ad = new GvYouJiAdapter(YouJiDetailsActivity.this, list);
        mygvYouji.setAdapter(ad);
        AddDateInList(1);
//        AddDateInList(2);
//        AddDateInList(3);
//        AddDateInList(4);
//        AddDateInList(5);
//        AddDateInList(3);
//        AddDateInList(4);


    }
}
