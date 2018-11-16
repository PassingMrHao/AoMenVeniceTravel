package mrhao.com.aomentravel.myFragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhengsr.viewpagerlib.anim.MzTransformer;
import com.zhengsr.viewpagerlib.bean.PageBean;
import com.zhengsr.viewpagerlib.callback.PageHelperListener;
import com.zhengsr.viewpagerlib.indicator.TransIndicator;
import com.zhengsr.viewpagerlib.view.ArcImageView;
import com.zhengsr.viewpagerlib.view.BannerViewPager;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mrhao.com.aomentravel.R;
import mrhao.com.aomentravel.bean.BannerDateBean;
import mrhao.com.aomentravel.bean.FindFoodBean;
import mrhao.com.aomentravel.bean.LoopBean;
import mrhao.com.aomentravel.bean.PlayBean;
import mrhao.com.aomentravel.bean.TravelNewsBean;
import mrhao.com.aomentravel.findActivity.FindFoodActivity;
import mrhao.com.aomentravel.findActivity.FindMarketActivity;
import mrhao.com.aomentravel.findActivity.FindPlayActivity;
import mrhao.com.aomentravel.findActivity.FindZheKouActivity;
import mrhao.com.aomentravel.findActivity.MacaoActivity;
import mrhao.com.aomentravel.findActivity.MoreGongLueActivity;
import mrhao.com.aomentravel.myActivity.BannerWebActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel1ribwgActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel1ricityActivity;
import mrhao.com.aomentravel.myActivity.CollectActivity.Travel2rimacaoActivity;
import mrhao.com.aomentravel.myActivity.GongGongJiaoTongActivity;
import mrhao.com.aomentravel.myActivity.HuiLvActivity;
import mrhao.com.aomentravel.myActivity.PhoneNumberActivity;
import mrhao.com.aomentravel.myActivity.TianQiActivity;
import mrhao.com.aomentravel.myActivity.TravelPreActivity;
import mrhao.com.aomentravel.myAdapter.FindFoodAd;
import mrhao.com.aomentravel.myAdapter.Grid_PlayAd;
import mrhao.com.aomentravel.myAdapter.TravelNewsAdapter;
import mrhao.com.aomentravel.utils.GlideApp;
import mrhao.com.aomentravel.utils.GlideManagerUtil;
import mrhao.com.aomentravel.utils.MyGridView;


public class TravelNewsFrg extends Fragment {
    @BindView(R.id.huxing_banner)
    BannerViewPager huxingBanner;
    @BindView(R.id.huxing_idt)
    TransIndicator huxingIdt;
    Unbinder unbinder;
    BannerDateBean bannerbean;
    List<String> weburl_list = new ArrayList<>();
    List<String> tiaozhuan_url = new ArrayList<>();
    List<String> bannertitle = new ArrayList<>();
    @BindView(R.id.travel_news)
    RecyclerView travelNews;
    TravelNewsBean bean;
    TravelNewsAdapter ad;
    List<TravelNewsBean.DataBean.StrategiesBean> list = new ArrayList<>();

    String news1 = "https://api.koudaihk.com:4432/api/info/public/v1/strategies/?appId=2&categoryId=0&sortId=0&pageIndex=1";
    @BindView(R.id.lay_dixian)
    LinearLayout layDixian;
    @BindView(R.id.lay_huilv)
    LinearLayout layHuilv;
    @BindView(R.id.lay_gongjiao)
    LinearLayout layGongjiao;
    @BindView(R.id.lay_weather)
    LinearLayout layWeather;
    @BindView(R.id.lay_phone)
    LinearLayout layPhone;
    @BindView(R.id.lay_praper)
    LinearLayout layPraper;
    @BindView(R.id.relay_load)
    RelativeLayout relayLoad;
    @BindView(R.id.lay_knowmacao)
    LinearLayout layKnowmacao;
    @BindView(R.id.lay_discount)
    LinearLayout layDiscount;
    @BindView(R.id.lay_shangchang)
    LinearLayout layShangchang;
    MyGridView gridFoods, girdPlay;
    FindFoodBean food_bean;
    FindFoodAd food_ad;
    List<FindFoodBean.DataBean.RestaurantsBean> food_list = new ArrayList<>();
    String api1 = "https://api.koudaihk.com:4432/api/info/public/v1/restaurants/?categoryId=0&sortId=0&pageIndex=1&appId=2";

    Grid_PlayAd play_ad;
    List<PlayBean.DataBean.AmusementsBean> play_list = new ArrayList<>();
    PlayBean play_bean;
    String apiplay = "https://api.koudaihk.com:4432/api/info/public/v1/amusements/?appId=2&categoryId=0&sortId=0&pageIndex=1";

    @BindView(R.id.lookmore_gonglue)
    LinearLayout lookmoreGonglue;
    @BindView(R.id.lookmore_food)
    LinearLayout lookmoreFood;
    @BindView(R.id.lookmore_yule)
    LinearLayout lookmoreYule;

    @BindView(R.id.lin_lay_aomen2ri)
    LinearLayout linLayAomen2ri;
    @BindView(R.id.lin_lay_chengqu1ri)
    LinearLayout linLayChengqu1ri;
    @BindView(R.id.lin_lay_bowuguan1ri)
    LinearLayout linLayBowuguan1ri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_travel_news_frg, container, false);
        unbinder = ButterKnife.bind(this, v);
        gridFoods = v.findViewById(R.id.shouye_grid_foods);
        girdPlay = v.findViewById(R.id.shouye_gird_play);
        travelNews.setNestedScrollingEnabled(false);
        getUrlBannerData();
        GetTravelNewsData();
        GetTravelFoodData();
        setMenuClick();
        return v;

    }

    private void GetTravelFoodData() {

        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.post().url(api1).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        food_bean = gs.fromJson(response, FindFoodBean.class);

                        food_list.add(food_bean.getData().getRestaurants().get(0));
                        food_list.add(food_bean.getData().getRestaurants().get(1));
                        food_list.add(food_bean.getData().getRestaurants().get(2));
                        food_list.add(food_bean.getData().getRestaurants().get(3));

                        food_ad = new FindFoodAd(getActivity(), food_list);
                        gridFoods.setAdapter(food_ad);
                    }
                });

        Map<String, String> mapa = new HashMap<>();
        mapa.put("", "");
        OkHttpUtils.post().url(apiplay).params(mapa).build().
                execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        play_bean = gs.fromJson(response, PlayBean.class);

                        play_list.add(play_bean.getData().getAmusements().get(0));
                        play_list.add(play_bean.getData().getAmusements().get(1));
                        play_list.add(play_bean.getData().getAmusements().get(2));
                        play_list.add(play_bean.getData().getAmusements().get(3));
                        play_list.add(play_bean.getData().getAmusements().get(4));
                        play_list.add(play_bean.getData().getAmusements().get(5));

                        play_ad = new Grid_PlayAd(getActivity(), play_list);
                        girdPlay.setAdapter(play_ad);
                    }
                });


    }

    private void setMenuClick() {

        //初识澳门
        layKnowmacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getActivity(), MacaoActivity.class));
            }
        });

        //汇率
        layHuilv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), HuiLvActivity.class));
            }
        });

        //公共交通
        layGongjiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), GongGongJiaoTongActivity.class));
            }
        });

        //天气
        layWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TianQiActivity.class));
            }
        });

        //电话号码
        layPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PhoneNumberActivity.class));
            }
        });

        //旅行准备
        layPraper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TravelPreActivity.class));
            }
        });


        //特价折扣
        layDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FindZheKouActivity.class));
            }
        });


        //购物商场
        layShangchang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FindMarketActivity.class));

            }
        });


        //查看更多攻略
        lookmoreGonglue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MoreGongLueActivity.class));
            }
        });


        //查看更多美食
        lookmoreFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FindFoodActivity.class));
            }
        });


        //查看更多娱乐
        lookmoreYule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FindPlayActivity.class));
            }
        });


        //澳门经典2日游
        linLayAomen2ri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Travel2rimacaoActivity.class));
            }
        });


        //历史城区一日游
        linLayChengqu1ri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Travel1ricityActivity.class));
            }
        });


        //博物馆一日游
        linLayBowuguan1ri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Travel1ribwgActivity.class));
            }
        });


    }


    private void GetTravelNewsData() {
        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.post().url(news1).params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bean = gs.fromJson(response, TravelNewsBean.class);

                        list.add(bean.getData().getStrategies().get(0));
                        list.add(bean.getData().getStrategies().get(1));
                        list.add(bean.getData().getStrategies().get(2));
                        list.add(bean.getData().getStrategies().get(3));


                        travelNews.setLayoutManager(new LinearLayoutManager(getActivity()));
                        ad = new TravelNewsAdapter(getActivity(), list);
                        travelNews.setAdapter(ad);
                        ad.notifyDataSetChanged();

                    }
                });
    }

    private void getUrlBannerData() {


        Map<String, String> map = new HashMap<>();
        map.put("", "");
        OkHttpUtils.get().url("https://api.koudaihk.com:4432/api/info/public/v1/getHomeData").params(map).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gs = new Gson();
                        bannerbean = gs.fromJson(response, BannerDateBean.class);
                        for (int i = 0; i < bannerbean.getData().getBanners().size(); i++) {
                            weburl_list.add(bannerbean.getData().getBanners().get(i).getCoverImage());
                            tiaozhuan_url.add(bannerbean.getData().getBanners().get(i).getLinkUrl());
                            bannertitle.add(bannerbean.getData().getBanners().get(i).getTitle());
                        }

                        setMeiZuHuXingBanner();
                    }
                });
    }

    private void setMeiZuHuXingBanner() {
        //配置数据
        List<LoopBean> loopBeens = new ArrayList<>();
        for (int i = 0; i < weburl_list.size(); i++) {
            LoopBean bean = new LoopBean();
            bean.url = weburl_list.get(i);
            bean.text = tiaozhuan_url.get(i);
            bean.bannertitle = bannertitle.get(i);
            loopBeens.add(bean);
        }
        //魅族弧形效果Banner
        huxingBanner.setPageTransformer(false, new MzTransformer());
        PageBean arcbean = new PageBean.Builder<LoopBean>()
                .setDataObjects(loopBeens)
                .setIndicator(huxingIdt)
                .builder();
        huxingBanner.setPageListener(arcbean, R.layout.huxing_loop_layout, new PageHelperListener() {
            @Override
            public void getItemView(View view, Object data) {
                ArcImageView im = view.findViewById(R.id.arc_icon);
                final LoopBean bean = (LoopBean) data;
                GlideApp.with(getActivity()).load(bean.url).priority(Priority.IMMEDIATE).override(1000, 480).thumbnail(0.1f).format(DecodeFormat.PREFER_RGB_565).dontAnimate().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(im);
                relayLoad.setVisibility(View.GONE);
                im.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent hao = new Intent(getActivity(), BannerWebActivity.class);
                        hao.putExtra("bannerweb", bean.text);
                        hao.putExtra("title", bean.bannertitle);
                        hao.putExtra("tag", "游玩攻略");
                        hao.putExtra("img", bean.url);
                        startActivity(hao);

                    }
                });
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Glide.get(getActivity()).clearMemory();
        new Thread() {
            @Override
            public void run() {
                super.run();
                Glide.get(getActivity()).clearDiskCache();
            }
        }.start();
        unbinder.unbind();
    }
}
