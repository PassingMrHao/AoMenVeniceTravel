package mrhao.com.aomentravel.myActivity.CollectActivity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
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
import mrhao.com.aomentravel.bean.TravelXiangCeBean;
import mrhao.com.aomentravel.myActivity.BaseActivity;
import mrhao.com.aomentravel.myAdapter.Recy_XiangCeAd;

public class TravelXiangceAct extends BaseActivity {

    int travelId = 0;
    int camecounts = 0;
    int currpage = 1;
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;

    ArrayList<TravelXiangCeBean> bean = new ArrayList<>();
    @BindView(R.id.recy_xiangce)
    RecyclerView recyXiangce;
    Recy_XiangCeAd ad;
    List<TravelXiangCeBean> list = new ArrayList<>();
    @BindView(R.id.relay_noxiangce)
    RelativeLayout relayNoxiangce;
    @BindView(R.id.pullrefresh)
    PullToRefreshLayout pullrefresh;

    String api = "";
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        travelId = b.getInt("travelId");

        camecounts = b.getInt("camecounts");
        setContentView(R.layout.activity_travel_xiangce);
        ButterKnife.bind(this);
        setBaseDate();
    }

    private void setBaseDate() {
        //刷新和加载更多

        pullrefresh.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                list.clear();
                currpage=1;
                AddDateInList("http://jk.kingtrunk.com/index.php/Home/Index/getPic/id/"+travelId+"/p/1");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //结束刷新
                        pullrefresh.setCanLoadMore(true);
                        Toast.makeText(TravelXiangceAct.this,"刷新成功",Toast.LENGTH_SHORT).show();
                        ad.notifyDataSetChanged();
                        pullrefresh.finishRefresh();
                    }
                }, 1000);
            }

            @Override
            public void loadMore() {
                if (currpage * 10 < camecounts) {
                    currpage += 1;
                    api = "http://jk.kingtrunk.com/index.php/Home/Index/getPic/id/"+travelId+"/p/" + currpage;
                    AddDateInList(api);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //结束加载更多
                            pullrefresh.setCanLoadMore(true);
                            ad.notifyDataSetChanged();
                            pullrefresh.finishLoadMore();
                        }
                    }, 500);

                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //结束加载更多
                            pullrefresh.setCanLoadMore(false);
                            pullrefresh.finishLoadMore();
                        }
                    }, 500);
                }


            }
        });


        titleText.setText("观光相册 ("+camecounts+")");
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.get(TravelXiangceAct.this).clearMemory();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        Glide.get(TravelXiangceAct.this).clearDiskCache();
                    }
                }.start();
                finish();
            }
        });

        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url("http://jk.kingtrunk.com/index.php/Home/Index/getPic/id/"+travelId+"/p/1").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        Type lity = new TypeToken<List<TravelXiangCeBean>>() {
                        }.getType();
                        bean = gs.fromJson(response, lity);

                        if (bean.size() == 0) {
                            relayNoxiangce.setVisibility(View.VISIBLE);
                        } else {
                            relayNoxiangce.setVisibility(View.GONE);
                            for (int i = 0; i < bean.size(); i++) {
                                list.add(bean.get(i));
                            }

                        }

                        StaggeredGridLayoutManager mlay = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                        mlay.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
                        recyXiangce.setLayoutManager(mlay);

                        ad = new Recy_XiangCeAd(TravelXiangceAct.this, list);
                        recyXiangce.setAdapter(ad);
                        relayLoad.setVisibility(View.GONE);
                    }
                });


    }

    public void AddDateInList(String api) {
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url(api).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();

                        bean = new ArrayList<>();
                        Type listType = new TypeToken<List<TravelXiangCeBean>>() {
                        }.getType();
                        bean = gs.fromJson(response, listType);

                        for (int i = 0; i < bean.size(); i++) {
                            list.add(bean.get(i));
                        }
                    }
                });
    }

}
