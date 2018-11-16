package mrhao.com.aomentravel.myActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
import mrhao.com.aomentravel.bean.MacaoTravelBean;
import mrhao.com.aomentravel.bean.MacaoTravelBean2;
import mrhao.com.aomentravel.myActivity.CollectActivity.NoTravelYoujiAct;
import mrhao.com.aomentravel.myActivity.CollectActivity.TravelXiangceAct;
import mrhao.com.aomentravel.myActivity.CollectActivity.TravelYoujiAct;
import mrhao.com.aomentravel.myAdapter.MyGridJingDianAdapter;
import mrhao.com.aomentravel.myAdapter.RecyJingDianAdapter;
import mrhao.com.aomentravel.myAdapter.RecyNearAdapter;
import mrhao.com.aomentravel.utils.BaseDialogUtil;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.MyGridView2;

public class MacaoTravelDetailsActivity extends BaseActivity {

    @BindView(R.id.im_back)
    ImageView imBack;
    @BindView(R.id.tv_collectTitle)
    TextView tvCollectTitle;
    @BindView(R.id.img_collect)
    ImageView imgCollect;

    MacaoTravelBean bean;
    MacaoTravelBean2 bean2;
    int aaa = 0;
    @BindView(R.id.travelde_im)
    ImageView traveldeIm;
    @BindView(R.id.jingdian_cnName)
    TextView jingdianCnName;
    @BindView(R.id.jingdian_enName)
    TextView jingdianEnName;
    @BindView(R.id.relay_click_collect)
    RelativeLayout relayClickCollect;
    @BindView(R.id.travelde_picnum)
    TextView traveldePicnum;
    @BindView(R.id.travelde_youjinum)
    TextView traveldeYoujinum;
    @BindView(R.id.travel_jianjietv)
    TextView travelJianjietv;
    @BindView(R.id.travel_jianjietv2)
    TextView travelJianjietv2;


    RecyJingDianAdapter recyad;
    List<MacaoTravelBean2.AttractionTripTagsBean> list = new ArrayList<>();
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    @BindView(R.id.yinxiang_nocon)
    RelativeLayout yinxiangNocon;


    @BindView(R.id.num_near)
    TextView numNear;
    @BindView(R.id.recy_near)
    RecyclerView recyNear;
    List<MacaoTravelBean2.AttractionsBean> list_near = new ArrayList<>();
    RecyNearAdapter adnear;
    @BindView(R.id.lin_notips)
    LinearLayout linNotips;
    @BindView(R.id.travel_xiangce)
    LinearLayout travelXiangce;
    @BindView(R.id.travel_youji)
    LinearLayout travelYouji;

    int travelId = 0;
    int camecounts = 0;
    int tripcounts = 0;

    String jingdianname = "";
    SharedPreferences sp;
    Bundle b;
    @BindView(R.id.myrecyview_jingdian)
    RecyclerView myrecyviewJingdian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macao_travel_details);
        ButterKnife.bind(this);
//        myrecyviewJingdian.setNestedScrollingEnabled(false);
        sp = getSharedPreferences("mobuser", 0);

        getBaseDate();
        setTitleClickEvent();

    }

    private void setCollectEvent() {
        imgCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseDialogUtil.normalDialog(MacaoTravelDetailsActivity.this, "收藏", "喜欢就加入收藏吧，可在『我的』—『个人收藏』中查看", new BaseDialogUtil.ShowDialogListener() {
                    @Override
                    public void Positive() {
                        if (sp.getString("username", "").equals("")) {
                            Toast.makeText(MacaoTravelDetailsActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MacaoTravelDetailsActivity.this, MobLoginActivity.class));
                        } else {
                            Map<String, String> map = new HashMap<>();
                            map.put("userid", sp.getString("username", ""));
                            map.put("type", "旅游景点");
                            map.put("title", jingdianname);
                            map.put("image", bean.getImage_url());
                            map.put("tag", "旅游景点");
                            map.put("weburl", getIntent().getExtras().getString("jingdianurl"));
                            OkHttpUtils.post().url("http://jk.kingtrunk.com/index.php/Home/show/collect").params(map).build()
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onError(Request request, Exception e) {
                                        }

                                        @Override
                                        public void onResponse(String response) {
                                            if (response.contains("\"code\":300")) {
                                                Toast.makeText(MacaoTravelDetailsActivity.this, "亲，已经收藏过了", Toast.LENGTH_SHORT).show();
                                            } else if (response.contains("\"code\":200")) {
                                                Toast.makeText(MacaoTravelDetailsActivity.this, "收藏成功！", Toast.LENGTH_SHORT).show();
                                            } else if (response.contains("\"code\":400")) {
                                                Toast.makeText(MacaoTravelDetailsActivity.this, "收藏失败！", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                    }

                    @Override
                    public void Negative() {

                    }
                });


            }
        });
    }

    private void setTitleClickEvent() {

        //观光相册
        travelXiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent hao = new Intent(MacaoTravelDetailsActivity.this, TravelXiangceAct.class);
                Bundle b = new Bundle();
                b.putInt("travelId", travelId);
                b.putInt("camecounts", camecounts);
                hao.putExtras(b);
                startActivity(hao);
            }
        });


        traveldeIm.setFocusable(true);
        traveldeIm.setFocusableInTouchMode(true);
        traveldeIm.requestFocus();
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        relayClickCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hhh = new Intent(MacaoTravelDetailsActivity.this, PopWindowAct.class);
                startActivity(hhh);
            }
        });
    }


    private void setBaseMessage() {
        numNear.setText(bean.getAttractions().size() + "");
        tvCollectTitle.setText(bean.getName_zh_cn());
        jingdianname = bean.getName_zh_cn();
        jingdianCnName.setText(bean.getName_zh_cn());
        jingdianEnName.setText(bean.getName_en());
        traveldePicnum.setText("" + bean.getPhotos_count());
        traveldeYoujinum.setText("" + bean.getAttraction_trips_count());
        travelJianjietv.setText("\u3000\u3000" + bean.getDescription());
        if (TextUtils.isEmpty(bean.getTips_html())) {
            linNotips.setVisibility(View.VISIBLE);

            travelJianjietv2.setVisibility(View.GONE);
        } else {
            linNotips.setVisibility(View.GONE);
            travelJianjietv2.setVisibility(View.VISIBLE);
            travelJianjietv2.setText(Html.fromHtml("" + bean.getTips_html()));
        }

        GlideApp.with(MacaoTravelDetailsActivity.this).load(bean.getImage_url()).priority(Priority.IMMEDIATE).format(DecodeFormat.PREFER_RGB_565).thumbnail(0.1f).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).override(800, 480).into(traveldeIm);
        Glide.get(MacaoTravelDetailsActivity.this).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(MacaoTravelDetailsActivity.this).clearDiskCache();
            }
        }.start();
        relayLoad.setVisibility(View.GONE);
    }


    private void getBaseDate() {

        Map<String, String> map = new HashMap<>();
        map.put("", "");

        OkHttpUtils.post().url(getIntent().getExtras().getString("jingdianurl")).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {

                        Gson gs = new Gson();
                        bean = gs.fromJson(response, MacaoTravelBean.class);
                        bean2 = gs.fromJson(response, MacaoTravelBean2.class);

                        travelId = bean2.getId();
                        camecounts = bean2.getPhotos_count();
                        tripcounts = bean2.getAttraction_trips_count();
                        list.clear();
                        if (bean2.getAttraction_trip_tags().size() > 0) {

                            myrecyviewJingdian.setVisibility(View.VISIBLE);

                            yinxiangNocon.setVisibility(View.GONE);
                            for (int i = 0; i < bean2.getAttraction_trip_tags().size(); i++) {
                                list.add(bean2.getAttraction_trip_tags().get(i));

                            }

                            myrecyviewJingdian.setLayoutManager(new LinearLayoutManager(MacaoTravelDetailsActivity.this));
                            recyad = new RecyJingDianAdapter(MacaoTravelDetailsActivity.this, list);
                            myrecyviewJingdian.setAdapter(recyad);

                        } else {

                            myrecyviewJingdian.setVisibility(View.GONE);
                            yinxiangNocon.setVisibility(View.VISIBLE);
                        }
                        LinearLayoutManager hhhh = new LinearLayoutManager(MacaoTravelDetailsActivity.this);
                        hhhh.setOrientation(LinearLayoutManager.HORIZONTAL);
                        recyNear.setLayoutManager(hhhh);
                        list_near.clear();
                        for (int i = 0; i < bean2.getAttractions().size(); i++) {
                            list_near.add(bean2.getAttractions().get(i));
                        }
                        adnear = new RecyNearAdapter(MacaoTravelDetailsActivity.this, list_near);
                        recyNear.setAdapter(adnear);
                        setBaseMessage();
                        setCollectEvent();

                        if (bean2.getAttraction_trips_count() == 0) {
                            travelYouji.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent hao = new Intent(MacaoTravelDetailsActivity.this, NoTravelYoujiAct.class);
                                    Bundle b = new Bundle();
                                    b.putString("name", jingdianname);
                                    hao.putExtras(b);
                                    startActivity(hao);

                                }
                            });
                        } else {
                            travelYouji.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent hao = new Intent(MacaoTravelDetailsActivity.this, TravelYoujiAct.class);
                                    Bundle b = new Bundle();
                                    b.putInt("travelId", travelId);
                                    b.putInt("tripcounts", tripcounts);
                                    b.putString("name", jingdianname);
                                    hao.putExtras(b);
                                    startActivity(hao);
                                }
                            });
                        }

                    }
                });


    }

    @Override
    protected void onResume() {
        super.onResume();
        sp = getSharedPreferences("mobuser", 0);
    }
}
